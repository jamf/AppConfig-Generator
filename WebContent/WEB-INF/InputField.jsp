<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.jamfsoftware.research.macingestor.uibean.*" %>

<% 
	// spot to determine the possible html addition strings
	InputField field = (InputField)request.getAttribute("field");
	String attributes = "";
	
	if(field.getNullable() != null && field.getNullable().equals("false")){
		attributes += "required ";
	}
	
	if(field.getPattern() != null){
		attributes += "pattern=\"" + field.getPattern()+"\" ";
	} else {
		String pattern = ".{";
		if(field.getMin() != null && !field.getMin().equals("")){
			pattern += field.getMin();
		}
		pattern += ",";
		if(field.getMax() != null && !field.getMax().equals("")){
			pattern += field.getMax();
		}
		pattern += "} ";
		
		if(!pattern.equals(".{,} ")){
			attributes += pattern;
		}
	}

%>
<div class="form-group">
  <label for="usr">${field.label.get(pageContext.request.locale.language)}</label>
  <input type="text" class="form-control" id="${field.keyName}" value="${field.defaultValue}" <%= attributes %>>
</div>
