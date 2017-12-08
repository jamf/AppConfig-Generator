<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page import="com.jamfsoftware.research.macingestor.MACDataType" %>
<%@ page import="com.jamfsoftware.research.macingestor.jaxb.Field" %>
<html>
<head>
	<title>AppConfig Generator</title>
	<%--<link href="../bootstrap/css/bootstrap.css" rel="stylesheet" media="screen">--%>
	<style type="text/css">
		<%@ include file="../bootstrap/css/bootstrap-theme.css" %>
		<%@ include file="../bootstrap/css/bootstrap.min.css" %>
		<%@ include file="../parsley/parsley.css" %>
		<%@ include file="../fileinput/css/fileinput.min.css" %>
		<%@ include file="../select2/css/select2.min.css" %>

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
	<script src="../bootstrap/js/jquery.min.js"></script>
	<script src="../bootstrap/js/jquery-ui.min.js"></script>
	<script src="../bootstrap/js/bootstrap.js"></script>
	<script src="../bootstrap/js/bootstrap-tokenfield.min.js"></script>
	<script src="../parsley/parsley.min.js"></script>
	<script src="../bootstrap/js/bootstrap.file-input.js"></script>
	<script src="../fileinput/js/fileinput.min.js"></script>
	<script src="../select2/js/select2.full.min.js"></script>
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
	</div>
</div>

<footer class="footer">
	<div class="container">
		<p class="text-muted text-center center-text-trick">Copyright &copy; 2017 JAMF Software, LLC</p>
	</div>
</footer>
</body>
</html>