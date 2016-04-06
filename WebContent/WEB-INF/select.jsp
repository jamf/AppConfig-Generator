<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.jamfsoftware.research.macingestor.jaxb.Options.Option" %>
<%@ page import="com.jamfsoftware.research.macingestor.MACDataType" %>

<%
	

%>

<div class="form-group">
  <label>${field.label.getLabel(pageContext.request.locale, defaultLocale) }</label>
  <select class="form-control" id="${field.keyName}">
    <c:forEach var="option" items="${field.options.option}">
    	<c:set var="option" value="${option}" scope="request"></c:set>
    	<% Option o = (Option)(request.getAttribute("option")); 
    		MACDataType data = (MACDataType)request.getAttribute("data");
    		String selected = "";
    		if(o.getValue().equals(data.getDefaultValueList().get(0))){
    			selected = "selected";
    		}
    	%>
    	<option value="${option.value}" <%= selected %>>${option.getLanguageForLocale(pageContext.request.locale, defaultLocale)}</option>
    </c:forEach>
  </select>
  <small class="text-muted">${field.description.getDescription(pageContext.request.locale, defaultLocale) }</small>
</div>
