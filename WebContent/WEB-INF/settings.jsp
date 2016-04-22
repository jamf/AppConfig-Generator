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

html {
  position: relative;
  min-height: 100%;
}
body {
  /* Margin bottom by footer height */
  margin-bottom: 60px;
}
.footer {
  position: absolute;
  bottom: 0;
  width: 100%;
  /* Set the fixed height of the footer here */
  height: 60px;
  background-color: #f5f5f5;
}

.vertical-center {
  min-height: 100%;  /* Fallback for browsers do NOT support vh unit */
  min-height: 100vh; /* These two lines are counted as one :-)       */

  display: flex;
  align-items: center;
}

.center-text-trick {
  height: 50px;
  line-height: 60px;
  white-space: nowrap;
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
	
	<div class="container">
	<h1 class="text-center">Managed Application Configuration Ingestor</h1> <br>
		<p class="lead">The Managed App Configuration Ingestor is a tool which assists in the generation of configuration plist for a mobile app on a device
			enrolled in an MDM solution. Follow the steps below to get started:</p>
			<ol>
			<li class="lead">Obtain a Managed App Configuration schema file from the application developer</li>
			<li class="lead">Upload the schema file in the form below</li>
				<li class="lead">Fill out the presented configuration options</li>
			<li class="lead">Download the plist configuration file</li>
			<li class="lead">Upload the plist to your MDM provider to be installed onto the device</li>
		</ol>
		
		<br>
	
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
		<button type="submit" class="btn btn-default">Download Plist</button>
	</form>
	
	</div>
	
	<footer class="footer">
      <div class="container">
        <p class="text-muted text-center center-text-trick">Copyright &copy; JAMF Research</p>
      </div>
    </footer>	
</body>
</html>