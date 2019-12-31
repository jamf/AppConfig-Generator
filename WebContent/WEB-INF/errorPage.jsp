<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page import="com.jamfsoftware.research.macingestor.MACDataType" %>
<%@ page import="com.jamfsoftware.research.macingestor.jaxb.Field" %>
<html>
<head>
	<title>AppConfig Generator</title>
	<%--<link href="../bootstrap/css/bootstrap.css" rel="stylesheet" media="screen">--%>
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
	<div>
		<h1 class="text-center">AppConfig Generator</h1>
		<br>
		<h1 class="text-center">${errorMsg}</h1>
		<br>
		<h3 class="text-center">For more information on AppConfig visit: <a href="https://appconfig.org/" target="_blank">appconfig.org</a> or view the <a href="https://storage.googleapis.com/appconfig-media/appconfig-content/uploads/2017/01/ManagedAppConfig.pdf" target="_blank">AppConfig Spec Reference</a></h3>
	</div>
</div>

<footer class="footer">
	<div class="container">
		<p class="text-muted text-center center-text-trick">Copyright &copy; 2017 JAMF Software, LLC</p>
	</div>
</footer>
</body>
</html>