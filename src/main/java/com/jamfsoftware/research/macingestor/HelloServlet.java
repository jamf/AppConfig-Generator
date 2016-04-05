package com.jamfsoftware.research.macingestor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
@RequestMapping("helloWorld")
public class HelloServlet {
	
	@RequestMapping(method = RequestMethod.GET)
	public String hello(ModelMap model) {
//		List<Field> fields = new ArrayList<Field>();
//		fields.add(generateInputField());
//		fields.add(generateSelectField());
//		model.addAttribute("fields", fields);
		
		JAXBReader<ManagedAppConfiguration> reader = new JAXBReader<ManagedAppConfiguration>(ManagedAppConfiguration.class);
		ManagedAppConfiguration mac = reader.read(this.getClass().getClassLoader().getResourceAsStream("mac.xml"));
		prepareSchemaData(mac, model);
		
		return "helloWorld";

	}
	
//	private Field generateInputField(){
//		Map<String, String> label = new HashMap<String, String>();
//		label.put("en", "Test Input");
//		Map<String, String> description = new HashMap<String, String>();
//		description.put("en", "Test input to be used for testing the UI generation");
//		TextField field = new TextField("TestInputKey", label, description, "TestDefaultValue", null, null);
//		field.setNullable("false");
//		field.setMin("3");
//		
//		return field;
//	}
//	
//	private Field generateSelectField(){
//		Map<String, String> label = new HashMap<String, String>();
//		label.put("en", "Test Select Field");
//		Map<String, String> description = new HashMap<String, String>();
//		description.put("en", "Test select field to be used for testing the UI generation");
//		List<String> possibleValues = new ArrayList<String>();
//		possibleValues.add("Value1");
//		possibleValues.add("Value2");
//		possibleValues.add("Value3");
//		SelectField field = new SelectField("TestSelectKey", label, description, "TestSelectValue", null, null);
//		
//		return field;
//	}
	
	
	private void prepareSchemaData(ManagedAppConfiguration mac, ModelMap model){
		// Make HashMap of ID's to MACDataTypes
		Map<String, MACDataType> datas = new HashMap<String, MACDataType>();
		
		List<Object> dict = mac.getDict().getStringOrStringArrayOrInteger();
		for(Object o : dict){
        	MACDataType data = (MACDataType)o;
        	datas.put(data.getKeyName(), data);
        }
		
		// TODO: Check for device/user variables
			// for now, set defaultValue to be JSS processing variables
		
		
		// Verify all MACDataTypes have a presentation Field entry
		for(String s : datas.keySet()){
			if(!keynameExists(mac.getPresentation().getFieldGroupOrField(), s)){
				Field f = new Field();
				f.setType(datas.get(s).getDefaultPresentationType());
				
				Language lang = new Language();
				lang.setValueAttribute("en");
				lang.setValue(s);
				Label l = new Label();
				l.getLanguage().add(lang);
				f.setLabel(l);
				f.setKeyName(s);
				
				mac.getPresentation().getFieldGroupOrField().add(f);
			}
		}
		
		model.addAttribute("mac", mac);
		model.addAttribute("datas", datas);
		
	}
	
	private boolean keynameExists(List<Object> fields, String keyname){
		for(Object o : fields){
			try{
				Field f = (Field)o;
				if(f.getKeyName().equals(keyname)) return true;
			} catch(Exception e){
				FieldGroup fg = (FieldGroup)o;
				if(keynameExists((List<Object>)(Object)fg.getField(), keyname)) return true;
			}
		}
		return false;
	}

}
