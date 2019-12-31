<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page import="com.jamfsoftware.research.macingestor.MACDataType" %>
<%@ page import="com.jamfsoftware.research.macingestor.jaxb.Field" %>
<html>
<head>
<title>AppConfig Generator</title>
<link href="../bootstrap/dist/css/bootstrap.css" rel="stylesheet" media="screen">
<style type="text/css">
<%@ include file="../bootstrap/dist/css/bootstrap-theme.css" %>
<%@ include file="../bootstrap/dist/css/bootstrap.min.css" %>
<%@ include file="../resources/parsley.css" %>
<%@ include file="../bootstrap-fileinput/css/fileinput.min.css" %>
<%@ include file="../select2/dist/css/select2.min.css" %>
<%@ include file="style.css"%>
</style>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<script src="../jquery/dist/jquery.min.js"></script>
	<script src="../jquery-ui-dist/jquery-ui.min.js"></script>
	<script src="../bootstrap/dist/js/bootstrap.js"></script>
	<script src="../parsleyjs/dist/parsley.min.js"></script>
	<script src="../bootstrap-fileinput/js/fileinput.min.js"></script>
	<script src="../select2/dist/js/select2.full.min.js"></script>
<script>
    $(document).ready(function() {
        $('.select-specfile').select2({
            placeholder: "Select a specfile"
		});
    });
</script>
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
	<div><h1 class="text-center">AppConfig Generator</h1> <br>
		<p class="lead">The AppConfig Generator is a tool which assists in the generation of configuration plist for a mobile app on a device enrolled in an MDM solution.</p>
		<p class="lead">For more information on AppConfig visit: <a href="https://appconfig.org/" target="_blank">appconfig.org</a> or view the <a href="https://storage.googleapis.com/appconfig-media/appconfig-content/uploads/2017/01/ManagedAppConfig.pdf" target="_blank">AppConfig Spec Reference</a></p>
		<p class="lead">Follow the steps below to get started:</p>
		<ol>
			<li class="lead">Obtain a Managed App Configuration specfile from the application developer<br>and upload the specfile in the form below</li>

			<form role="form" enctype="multipart/form-data" action="settings" method="post" class="center-block" role="form">
				<input id="input-1" type="file" accept=".xml,application/xml,text/xml" class="file" name="file" data-show-preview="false" data-show-remove="false" data-upload-Label="Configure">
			</form>

			<p class="lead">or select a specfile from the repository</p>
			<form action="settings/repository" method="post">
				<select name="file" class="select-specfile form-control" style="width: auto;">
					<option></option>
					<c:forEach items="${files}" var="item">
						<option value="${fn:escapeXml(item.resourceLocation)}">${fn:escapeXml(item.bundleId)}/${fn:escapeXml(item.version)}</option>
					</c:forEach>
				</select>
				<input type="submit" value="Select" class="btn btn-default">
			</form>

			<li class="lead">Fill out the presented configuration options</li>
			<li class="lead">Download the plist configuration file</li>
			<li class="lead">Upload the plist to your MDM provider to be installed onto the device</li>

		</ol>
	</div>
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
