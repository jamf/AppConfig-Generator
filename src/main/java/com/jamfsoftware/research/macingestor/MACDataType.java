package com.jamfsoftware.research.macingestor;

import java.util.List;

import com.jamfsoftware.research.macingestor.jaxb.Options;

public interface MACDataType {

	public String getValidation();
	public List<String> getDefaultValueList();
	public boolean isUserOrDeviceVariable();
	public String getKeyName();
	public String getDefaultPresentationType();
	public Options getOptions();
	
}
