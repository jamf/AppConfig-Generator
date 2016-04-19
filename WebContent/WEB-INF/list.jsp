<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.jamfsoftware.research.macingestor.MACDataType" %>
<%@ page import="com.jamfsoftware.research.macingestor.jaxb.Field" %>

<script>
// replace button with unique keyname id for button
$(document).ready( function(){
	
	var nextField = 1;
	
	
	$('#${data.keyName.replaceAll(" ", "")}-add').click(function(){
	    // Add new form fields
	    addSelectionToList('');
	});
	
	function addSelectionToList(value){
		 var additionInput = '<div class="input-group" id="${data.keyName.replaceAll(" ", "")}-div-' + nextField.toString() + '">\
			 	<input type="text" class="form-control" id="${data.keyName}-input-'+ nextField.toString() + '" name="${data.keyName}" value="' + value + '" ${data.validation } data-parsley-trigger="change" >\
			  	<span class="input-group-btn">\
			  		<button class = "btn btn-default" type = "button" id="${data.keyName.replaceAll(" ", "")}-remove-'+ nextField.toString() + '"><span class="glyphicon glyphicon-remove"></span></button>\
			  	</span>\
		  	</div>';
		 $('#${data.keyName.replaceAll(" ", "")}-dynamic-input').append(additionInput);
		 
		 $("[id^=${data.keyName.replaceAll(' ', '')}-remove-]").click(function(event){
				$('#' + this.id.replace("remove", "div") ).remove();
			});
		 
		 nextField = nextField + 1;
	}
	
	
	// add in the default values by hand
	<c:forEach var="val" items="${data.defaultValueList}" varStatus="status">
		addSelectionToList("${val}");
	</c:forEach>
	
	
});

</script>


<div class="form-group">
  <label>${field.label.getLabel(pageContext.request.locale, defaultLocale) }</label>
  <span class="glyphicon glyphicon-plus" id="${data.keyName.replaceAll(' ', '')}-add"></span>
  <div id="${data.keyName.replaceAll(' ', '')}-dynamic-input">
  </div>
  <small class="text-muted">${field.description.getDescription(pageContext.request.locale, defaultLocale) }</small>
</div>
