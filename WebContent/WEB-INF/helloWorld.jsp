<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.jamfsoftware.research.macingestor.MACDataType" %>
<%@ page import="com.jamfsoftware.research.macingestor.jaxb.Field" %>
<html>
<head>
<style type="text/css">
<%@include file ="bootstrap/css/bootstrap.css" %> 
<%@include file="bootstrap/css/bootstrap-theme.css" %> 
	form {
		margin-right: 40px;
		margin-left: 80px;
	}

	@media ( max-width : 980px) {
		body {
			padding-top: 0;
		}
	}
	
	legend.scheduler-border {
    	width:inherit; /* Or auto */
    	padding:0 10px; /* To give a bit of padding on the left and right */
    	border-bottom:none;
	}
</style>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="bootstrap/js/jquery.js"></script>
<script src="bootstrap/js/bootstrap.js"></script>
<script src="parsley.min.js"></script>
<script>
$("#register_form").parsley({
    successClass: "has-success",
    errorClass: "has-error",
    classHandler: function(el) {
        return el.$element.closest(".form-group");
    },
    errorsWrapper: "<span class='help-block'></span>",
    errorTemplate: "<span></span>"
});
</script>
</head>
<body>
	<nav class="navbar navbar-default">
	  <div class="container-fluid">
	    <div class="navbar-header">
	      <a class="navbar-brand" href="#">MAC Ingestor</a>
	      <ul class="nav navbar-nav">
		      <li><a href="#">Feel</a></li>
		      <li><a href="#">The</a></li> 
		      <li><a href="#">Bern</a></li> 
    </ul>
	    </div>
	  </div>
	</nav>
	
	
	<form role="form">
		<c:forEach var="field" items="${mac.presentation.fieldGroupOrField}">
			<c:set var="defaultLocale" value="${mac.presentation.defaultLocale}" scope="request"></c:set>
			<c:choose>
	  			<c:when test="${field['class'].simpleName == 'Field' }">
	  				<c:set var="field" value="${field}" scope="request"></c:set>
	  				<c:set var="data" value="${datas.get(field.keyName)}" scope="request"></c:set>
	  				<% 
	  				Field f = (Field)request.getAttribute("field");
	  				System.out.println("field type is: " + f.getType()); %>
	  				<jsp:include page="${field.type}.jsp" />
				</c:when>
				<c:otherwise>
					<% System.out.println("field group"); %>
					<c:set var="group" value="${field}" scope="request"></c:set>
					<jsp:include page="${group.type}.jsp" />
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<button type="submit" class="btn btn-default">Submit</button>
	</form>
	
	
</body>
</html>