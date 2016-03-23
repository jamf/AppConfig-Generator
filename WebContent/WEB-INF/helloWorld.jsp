<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<style type="text/css">
<%@include file ="bootstrap/css/bootstrap.css" %> 
<%@include file="bootstrap/css/bootstrap-theme.css" %> 
	body {
		margin-right: 40px;
		margin-left: 40px;
		padding-top: 60px;
	}

	@media ( max-width : 980px) {
		body {
			padding-top: 0;
		}
	}
</style>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="bootstrap/js/jquery.js"></script>
<script src="bootstrap/js/bootstrap.js"></script>
</head>
<body>
	<form role="form">
		<c:forEach var="field" items="${fields}">
			<c:set var="field" value="${field}" scope="request"></c:set>
			<jsp:include page="${field.jspPage}"></jsp:include>
		</c:forEach>
		<button type="submit" class="btn btn-default">Submit</button>
	</form>
</body>
</html>