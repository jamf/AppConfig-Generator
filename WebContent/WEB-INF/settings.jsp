<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.jamfsoftware.research.macingestor.MACDataType" %>
<%@ page import="com.jamfsoftware.research.macingestor.jaxb.Field" %>
<html>
<head>
<title>AppConfig Generator</title>
<link href="${repository}bootstrap/css/bootstrap.css" rel="stylesheet" media="screen">
<style type="text/css">
<%@ include file="../bootstrap/css/bootstrap-theme.css" %>
<%@ include file="../bootstrap/css/bootstrap-tokenfield.min.css" %>
<%@ include file="../parsley/parsley.css" %>
<%@ include file="style.css"%>
</style>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="${repository}bootstrap/js/jquery.min.js"></script>
<script src="${repository}bootstrap/js/jquery-ui.min.js"></script>
<script src="${repository}bootstrap/js/bootstrap.js"></script>
<script src="${repository}bootstrap/js/bootstrap-tokenfield.min.js"></script>
<script src="${repository}parsley/parsley.min.js"></script>
</head>
<body>
	<nav class="navbar navbar-default">
	  <div class="container-fluid">
	    <div class="navbar-header">
	      <a class="navbar-brand" href="/">AppConfig Generator</a>
	    </div>
	  </div>
	</nav>
	
	<div class="container">
	<h1 class="text-center">AppConfig Generator</h1>
		<br>
		<p class="lead">The AppConfig Generator is a tool which assists in the generation of configuration plist for a mobile app on a device enrolled in an MDM solution.</p>
		<p class="lead">For more information on AppConfig visit: <a href="https://appconfig.org/" target="_blank">appconfig.org</a> or view the <a href="https://storage.googleapis.com/appconfig-media/appconfig-content/uploads/2017/01/ManagedAppConfig.pdf" target="_blank">AppConfig Spec Reference</a></p>
		<p class="lead">Follow the steps below to get started:</p>
		<ol>
			<li class="lead">Fill out the presented configuration options</li>
			<li class="lead">Download the plist configuration file</li>
			<li class="lead">Upload the plist to your MDM provider to be installed onto the device</li>
		</ol>

		<br>
	
		<form role="form" data-parsley-validate action="${repository}submit">
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
	</div>
	
	<footer class="footer">
      <div class="container">
        <p class="text-muted text-center center-text-trick">Copyright &copy; 2017 JAMF Software, LLC</p>
      </div>
    </footer>
	<!-- Global Site Tag (gtag.js) - Google Analytics -->
	<script async src="https://www.googletagmanager.com/gtag/js?id=UA-81003953-3"></script>
	<script>
      window.dataLayer = window.dataLayer || [];
      function gtag(){dataLayer.push(arguments);}
      gtag('js', new Date());

      gtag('config', 'UA-81003953-3');
	</script>
</body>
</html>