<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.jamfsoftware.research.macingestor.MACDataType" %>


<div class="checkbox">
	<% 
		MACDataType data = (MACDataType)request.getAttribute("data");
		String checked = "";
		
		// try catch to catch nullpointer exception below
		try {
			if(data.getDefaultValueList().get(0).equals("true")) checked = "checked";
		} catch (Exception e){
			
		}
	%>
  <label><input type="checkbox" name="${data.keyName}" value="1" <%= checked %> >${field.label.getLabel(pageContext.request.locale, defaultLocale) }</label>
  <input type="hidden" class="form-control" value="0" name="${data.keyName}">
</div>
