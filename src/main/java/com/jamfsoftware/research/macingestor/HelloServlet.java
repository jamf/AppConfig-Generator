package com.jamfsoftware.research.macingestor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jamfsoftware.research.macingestor.uibean.Field;
import com.jamfsoftware.research.macingestor.uibean.InputField;

@Controller
@RequestMapping("helloWorld")
public class HelloServlet {
	
	@RequestMapping(method = RequestMethod.GET)
	public String hello(ModelMap model) {
		List<Field> fields = new ArrayList<Field>();
		fields.add(generateInputField());
		model.addAttribute("fields", fields);
	
		return "helloWorld";

	}
	
	private Field generateInputField(){
		Map<String, String> label = new HashMap<String, String>();
		label.put("en", "Test Input");
		Map<String, String> description = new HashMap<String, String>();
		description.put("en", "Test input to be used for testing the UI generation");
		InputField field = new InputField("TestInputKey", label, description, "TestDefaultValue", null, null);
		field.setNullable("false");
		
		return field;
	}

}
