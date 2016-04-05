<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.jamfsoftware.research.macingestor.MACDataType" %>
<%@ page import="com.jamfsoftware.research.macingestor.jaxb.Field" %>


<div class="form-group">
  <label>${field.label.getLabel(pageContext.request.locale, defaultLocale) }</label>
  <input type="text" class="form-control" id="${data.keyName}" value="${data.defaultValueList.get(0)}" >
  <small class="text-muted">${field.description.getDescription(pageContext.request.locale, defaultLocale) }</small>
</div>
