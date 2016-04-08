<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.jamfsoftware.research.macingestor.MACDataType" %>
<%@ page import="com.jamfsoftware.research.macingestor.jaxb.Field" %>

<script>
// replace button with unique keyname id for button
$(document).ready( function(){
	$('#${data.keyName.replaceAll(" ", "")}-add').click(function(){
	    // Add new form fields
	    $('#${data.keyName.replaceAll(" ", "")}-dynamic-input').append('<input type="text" class="form-control" id="${data.keyName}" name="${data.keyName}" value="${data.defaultValueList.get(0)}" ${data.validation } data-parsley-trigger="change" >');
	});
});

</script>


<div class="form-group">
  <label>${field.label.getLabel(pageContext.request.locale, defaultLocale) }</label>
                <span class="glyphicon glyphicon-plus" id="${data.keyName.replaceAll(' ', '')}-add"></span>
  <!-- <button id="${data.keyName.replaceAll(' ', '')}-button" type="button" class="btn btn-default" >Add another</button> -->
  <div id="${data.keyName.replaceAll(' ', '')}-dynamic-input">

  			<div class="input-group">
			 	<input type="text" class="form-control" id="${data.keyName}" name="${data.keyName}" value="${data.defaultValueList.get(0)}" ${data.validation } data-parsley-trigger="change" >
			  	<span class="input-group-btn">
			  		<button class = "btn btn-default" type = "button"><span class="glyphicon glyphicon-remove"></span></button>
			  	</span>
		  	</div>
  </div>
  <small class="text-muted">${field.description.getDescription(pageContext.request.locale, defaultLocale) }</small>
</div>
