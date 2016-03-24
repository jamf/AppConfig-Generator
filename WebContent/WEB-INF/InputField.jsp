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

%>
<div class="form-group">
  <label for="usr">${field.label.get(pageContext.request.locale.language)}</label>
  <input type="text" class="form-control" id="${field.keyName}" <%= attributes %>>
</div>