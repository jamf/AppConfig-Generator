package com.jamfsoftware.research.macingestor;

import java.util.List;

public interface MACDataType {

	public String getValidation();
	public List<String> getDefaultValueList();
	public boolean isUserOrDeviceVariable();
	public String getKeyName();
	public String getDefaultPresentationType();
	
}
