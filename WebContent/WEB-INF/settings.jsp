<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.jamfsoftware.research.macingestor.MACDataType" %>
<%@ page import="com.jamfsoftware.research.macingestor.jaxb.Field" %>
<html>
<head>
<link href="../bootstrap/css/bootstrap.css" rel="stylesheet" media="screen">
<style type="text/css">
<%@include file="../bootstrap/css/bootstrap-theme.css" %> 
<%@include file="../bootstrap/css/bootstrap-tokenfield.min.css" %> 
<%@include file="../parsley/parsley.css" %> 
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
<script src="bootstrap/js/jquery.min.js"></script>
<script src="bootstrap/js/jquery-ui.min.js"></script>
<script src="bootstrap/js/bootstrap.js"></script>
<script src="bootstrap/js/bootstrap-tokenfield.min.js"></script>
<script src="parsley/parsley.min.js"></script>
<script>
</script>
</head>
<body>
	<nav class="navbar navbar-default">
	  <div class="container-fluid">
	    <div class="navbar-header">
	      <a class="navbar-brand" href="/">MAC Ingestor</a>
	    </div>
	  </div>
	</nav>
	
	
	<form role="form" data-parsley-validate action="/submit">
		<c:forEach var="field" items="${mac.presentation.fieldGroupOrField}">
			<c:set var="defaultLocale" value="${mac.presentation.defaultLocale}" scope="request"></c:set>
			<c:choose>
	  			<c:when test="${field['class'].simpleName == 'Field' }">
	  				<c:set var="field" value="${field}" scope="request"></c:set>
	  				<c:set var="data" value="${datas.get(field.keyName)}" scope="request"></c:set>
	  				<jsp:include page="${field.type}.jsp" />
				</c:when>
				<c:otherwise>
					<c:set var="group" value="${field}" scope="request"></c:set>
					<jsp:include page="${group.type}.jsp" />
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<button type="submit" class="btn btn-default">Submit</button>
	</form>
	
	
</body>
</html>