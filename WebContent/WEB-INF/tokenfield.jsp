<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.jamfsoftware.research.macingestor.MACDataType" %>
<%@ page import="com.jamfsoftware.research.macingestor.jaxb.Field" %>

<script>
// replace button with unique keyname id for button
$(document).ready( function(){
	 $('#${data.keyName.replaceAll(" ","")}-tokenfield').tokenfield(); 
});

</script>


<div class="form-group">
  <label>${field.label.getLabel(pageContext.request.locale, defaultLocale) }</label>
  <input type="text" class="form-control" id="${data.keyName.replaceAll(' ', '')}-tokenfield" value="blue" data-parsley-pattern="justin.*" name="${data.keyName}" ${data.validation } placeholder="type something and hit enter..."/>
  <small class="text-muted">${field.description.getDescription(pageContext.request.locale, defaultLocale) }</small>
</div>
