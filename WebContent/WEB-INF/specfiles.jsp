<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
	<link href="bootstrap/css/bootstrap.css" rel="stylesheet" media="screen">
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

	<form action="settings/repository" method="post">
		<select name="file" class="form-control">
			<c:forEach items="${files}" var="item">
				<option value="${item.resourceLocation}">${item.bundleId}/${item.version}</option>
			</c:forEach>
		</select>
		<br>
		<input type="submit" class="btn btn-default">
	</form>

</div>

<footer class="footer">
	<div class="container">
		<p class="text-muted text-center center-text-trick">Copyright &copy; 2017 JAMF Software, LLC</p>
	</div>
</footer>
</body>
</html>