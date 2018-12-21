package com.jamfsoftware.research.macingestor;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.xml.sax.SAXException;

import com.jamfsoftware.research.macingestor.jaxb.Field;
import com.jamfsoftware.research.macingestor.jaxb.FieldGroup;
import com.jamfsoftware.research.macingestor.jaxb.Label;
import com.jamfsoftware.research.macingestor.jaxb.Language;
import com.jamfsoftware.research.macingestor.jaxb.ManagedAppConfiguration;
import com.jamfsoftware.research.macingestor.jaxb.Presentation;

@Controller
@RequestMapping("/settings")
public class SettingsServlet {

	@Value("${repository.url}")
	private String repositoryURL;
	
	@RequestMapping(method = RequestMethod.POST)
	public String prepareSettings(ModelMap model, HttpServletRequest request, HttpServletResponse response, @RequestParam("file") MultipartFile file) {
		
		JAXBReader<ManagedAppConfiguration> reader = new JAXBReader<>(ManagedAppConfiguration.class);
		try {
			ManagedAppConfiguration mac = reader.read(file.getInputStream());
			prepareSchemaData(mac, model);
			request.getSession().setAttribute("mac", mac);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return "settings";
	}

	@RequestMapping(value = "/repository", method = RequestMethod.POST)
	public String prepareSettingsFromRepository(ModelMap model, HttpServletRequest request, HttpServletResponse response, @RequestParam("file") String specfileURL) {

		SpecfileRepository repository = new SpecfileRepository(repositoryURL);
		if (repository.validSpecfile(specfileURL)) {

			JAXBReader<ManagedAppConfiguration> reader = new JAXBReader<>(ManagedAppConfiguration.class);
			try {
				InputStream fileInputStream = new URL(specfileURL).openStream();

				ManagedAppConfiguration mac = reader.read(fileInputStream);
				prepareSchemaData(mac, model);
				request.getSession().setAttribute("mac", mac);

				fileInputStream.close();

				request.setAttribute("specfile", mac.getBundleId() + "/" + mac.getVersion());
			} catch(IOException e) {
				e.printStackTrace();
			}
		}

		request.setAttribute("repository", "../");
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
		
		// ensure the Presentation field exists
		if(mac.getPresentation() == null){
			mac.setPresentation(new Presentation());
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

	@ResponseStatus(value = HttpStatus.UNSUPPORTED_MEDIA_TYPE)
	@ExceptionHandler({ // 3 main exceptions thrown when file uploaded isn't in a valid format
			JAXBException.class, // xml isn't formatted correctly
			SAXException.class,
			NullPointerException.class // file is not xml
	})
	public ModelAndView badSpecfile() {
		ModelAndView errorPage = new ModelAndView("errorPage");

		String errorMsg = "Invalid Specfile Format";

		errorPage.addObject("errorMsg", errorMsg);
		return errorPage;
	}
}
