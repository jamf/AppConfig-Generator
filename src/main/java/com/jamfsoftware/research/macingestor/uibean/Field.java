package com.jamfsoftware.research.macingestor.uibean;

import java.util.List;
import java.util.Map;

public abstract class Field {

	protected String keyName;
	protected Map<String, String> label;
	protected Map<String, String> description;
	protected String defaultValue;
	protected List<String> possibleValues;
	protected String pattern;
	protected String min;
	protected String max;
	protected String nullable;
	
	public Field(String keyName, Map<String, String> label, Map<String, String> description, String defaultValue, List<String> possibleValues, String pattern){
		this.keyName = keyName;
		this.label = label;
		this.description = description;
		this.defaultValue = defaultValue;
		this.possibleValues = possibleValues;
		this.pattern = pattern;
	}
	
	public String getJspPage() {
		return this.getClass().getSimpleName() + ".jsp";
	}
	
	// getters and setters
	public String getKeyName() {
		return keyName;
	}

	public void setKeyName(String keyName) {
		this.keyName = keyName;
	}

	public Map<String, String> getLabel() {
		return label;
	}

	public void setLabel(Map<String, String> label) {
		this.label = label;
	}

	public Map<String, String> getDescription() {
		return description;
	}

	public void setDescription(Map<String, String> description) {
		this.description = description;
	}

	public String getDefaultValue() {
		return defaultValue;
	}

	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}

	public List<String> getPossibleValues() {
		return possibleValues;
	}

	public void setPossibleValues(List<String> possibleValues) {
		this.possibleValues = possibleValues;
	}

	public String getPattern() {
		return pattern;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

	public String getMin() {
		return min;
	}

	public void setMin(String min) {
		this.min = min;
	}

	public String getMax() {
		return max;
	}

	public void setMax(String max) {
		this.max = max;
	}

	public String getNullable() {
		return nullable;
	}

	public void setNullable(String nullable) {
		this.nullable = nullable;
	}
	
}
