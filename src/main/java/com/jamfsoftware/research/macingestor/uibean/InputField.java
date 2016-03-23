package com.jamfsoftware.research.macingestor.uibean;

import java.util.List;
import java.util.Map;

public class InputField extends Field {

	
	public InputField(String keyName, Map<String, String> label, Map<String, String> description, String defaultValue, List<String> possibleValues, String pattern){
		super(keyName, label, description, defaultValue, possibleValues, pattern);
	}
	
	@Override
	public String getJspPage() {
		return "InputField.jsp";
	}
}
