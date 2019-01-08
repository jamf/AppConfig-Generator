<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.jamfsoftware.research.macingestor.MACDataType" %>
<%@ page import="com.jamfsoftware.research.macingestor.jaxb.Field" %>
<html>
<head>
<title>AppConfig Generator</title>
<link href="bootstrap/css/bootstrap.css" rel="stylesheet" media="screen">
<style type="text/css">
<%@ include file="../bootstrap/css/bootstrap-theme.css" %>
<%@ include file="../bootstrap/css/bootstrap-tokenfield.min.css" %>
<%@ include file="../parsley/parsley.css" %>
<%@ include file="style.css"%>
</style>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="bootstrap/js/jquery.min.js"></script>
<script src="bootstrap/js/jquery-ui.min.js"></script>
<script src="bootstrap/js/bootstrap.js"></script>
<script src="bootstrap/js/bootstrap-tokenfield.min.js"></script>
<script src="parsley/parsley.min.js"></script>
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

		<script>
			function copyText() {
				var copyText = document.getElementById("plist");
				var text = copyText.value;

				// break the textblock into an array of lines
				var lines = text.split('\n');
				// remove 3 lines, starting at the first position
				lines.splice(0,3);
				lines.splice(lines.length-1,1);
				// join the array back into a single string
				var newtext = lines.join('\n');
				copyText.value = newtext;

				copyText.select();
				document.execCommand("copy");

				copyText.value = text;

				document.getElementById("clipboard-alert").style.setProperty("display", "block");
				setTimeout(function () {
            document.getElementById("clipboard-alert").style.setProperty("display", "none");
        }, 5000)
			}
		</script>


		<form role="form" action="submit/download">

			<div class="form-group">
				<label for="plist">Generated Plist:</label>
				<textarea readonly class="form-control" rows="10" id="plist" name="plist">${plist}</textarea>
			</div>

			<c:forEach var="par" items="${paramValues}">
				<c:forEach var='value' items='${par.value}'>
					<input readonly type="hidden" name="${par.key}" value="${value}">
				</c:forEach>
			</c:forEach>

			<div class="btn-group">
				<button type="submit" class="btn btn-default">Download Plist</button>
				<button type="button" class="btn btn-default" onclick="copyText()">Copy Dictionary</button>
			</div>
		</form>

		<div id="clipboard-alert" style="display: none;" class="alert alert-success" role="alert">
			Dictionary copied to clipboard.
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