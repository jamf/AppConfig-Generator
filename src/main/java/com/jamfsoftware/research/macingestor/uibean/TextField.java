package com.jamfsoftware.research.macingestor.uibean;

import java.util.List;
import java.util.Map;

public class TextField extends Field {

	
	public TextField(String keyName, Map<String, String> label, Map<String, String> description, String defaultValue, List<String> possibleValues, String pattern){
		super(keyName, label, description, defaultValue, possibleValues, pattern);
	}
	
}
