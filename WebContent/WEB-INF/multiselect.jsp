<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.jamfsoftware.research.macingestor.jaxb.Options.Option" %>

<div class="form-group">
  <label>${field.label.getLabel(pageContext.request.locale, defaultLocale) }</label>
  <select class="form-control" id="${field.keyName}" multiple>
    <c:forEach var="option" items="${field.options.option}">
    	<c:set var="option" value="${option}" scope="request"></c:set>
    	<% Option o = (Option)(request.getAttribute("option")); 
    		String selected = o.isSelected() ? "selected" : "";
    	%>
    	<option value="${option.languageForLocale(pageContext.request.locale, defaultLocale)}" <%= selected %>>>${option.value}</option>
    </c:forEach>
  </select>
  <small class="text-muted">${field.description.get(pageContext.request.locale.language)}</small>
</div>
