package com.jamfsoftware.research.macingestor.uibean;

import java.util.List;
import java.util.Map;

public class SelectField extends Field {
	
	int selectedIndex = -1;

	public SelectField(String keyName, Map<String, String> label, Map<String, String> description, String defaultValue, List<String> possibleValues, String pattern) {
		super(keyName, label, description, defaultValue, possibleValues, pattern);
	}

	public int getSelectedIndex() {
		return selectedIndex;
	}

	public void setSelectedIndex(int selectedIndex) {
		this.selectedIndex = selectedIndex;
	}
	
}
