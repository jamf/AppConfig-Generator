package com.jamfsoftware.research.macingestor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jamfsoftware.research.macingestor.jaxb.Field;
import com.jamfsoftware.research.macingestor.jaxb.FieldGroup;
import com.jamfsoftware.research.macingestor.jaxb.Label;
import com.jamfsoftware.research.macingestor.jaxb.Language;
import com.jamfsoftware.research.macingestor.jaxb.ManagedAppConfiguration;

@Controller
@RequestMapping("/settings")
public class SettingsServlet {
	
	@RequestMapping(method = RequestMethod.GET)
	public String hello(ModelMap model, HttpServletRequest request) {
		
		JAXBReader<ManagedAppConfiguration> reader = new JAXBReader<ManagedAppConfiguration>(ManagedAppConfiguration.class);
		ManagedAppConfiguration mac = reader.read(this.getClass().getClassLoader().getResourceAsStream("mac.xml"));
		prepareSchemaData(mac, model);
		
		request.getSession().setAttribute("mac", mac);
		
		return "settings";

	}
	
	
	private void prepareSchemaData(ManagedAppConfiguration mac, ModelMap model){
		// Make HashMap of ID's to MACDataTypes
		Map<String, MACDataType> datas = new HashMap<String, MACDataType>();
		
		List<Object> dict = mac.getDict().getStringOrStringArrayOrInteger();
		for(Object o : dict){
        	MACDataType data = (MACDataType)o;
        	datas.put(data.getKeyName(), data);
        }
		

		// Verify all MACDataTypes have a presentation Field entry
		// also correct to hide default values
		for(String s : datas.keySet()){
			Field f = findField(mac.getPresentation().getFieldGroupOrField(), s);
			if(f == null){
				f = new Field();
				f.setType(datas.get(s).getDefaultPresentationType());
				
				Language lang = new Language();
				lang.setValueAttribute("en");
				lang.setValue(s);
				Label l = new Label();
				l.getLanguage().add(lang);
				f.setLabel(l);
				f.setKeyName(s);
				f.setOptions(datas.get(s).getOptions());
				
				mac.getPresentation().getFieldGroupOrField().add(f);
			} else {
				if(datas.get(s).isUserOrDeviceVariable()){
					f.setType("hidden");
				}
			}
		}
		
		model.addAttribute("mac", mac);
		model.addAttribute("datas", datas);	
	}
	
	
	private Field findField(List<Object> fields, String keyname){
		for(Object o : fields){
			try{
				Field f = (Field)o;
				if(f.getKeyName().equals(keyname)) return f;
			} catch(Exception e){
				FieldGroup fg = (FieldGroup)o;
				Field f = findField((List<Object>)(Object)fg.getField(), keyname);
				if(f != null) return f;
			}
		}
		return null;
	}

}
