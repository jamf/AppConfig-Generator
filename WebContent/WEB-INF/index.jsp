<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.jamfsoftware.research.macingestor.MACDataType" %>
<%@ page import="com.jamfsoftware.research.macingestor.jaxb.Field" %>
<html>
<head>
<%--<link href="../bootstrap/css/bootstrap.css" rel="stylesheet" media="screen">--%>
<style type="text/css">
<%@ include file="../bootstrap/css/bootstrap-theme.css" %>
<%@ include file="../bootstrap/css/bootstrap.min.css" %>
<%@ include file="../parsley/parsley.css" %>
<%@ include file="../fileinput/css/fileinput.min.css" %>

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
	<div><h1 class="text-center">Managed Application Configuration Ingestor</h1> <br>
		<p class="lead">The Managed App Configuration Ingestor is a tool which assists in the generation of configuration plist for a mobile app on a device
			enrolled in an MDM solution. Follow the steps below to get started:</p>
		<ol>
			<li class="lead">Obtain a Managed App Configuration schema file from the application developer</li>
			<li class="lead">Upload the schema file in the form below</li>
				<li class="lead">Fill out the presented configuration options</li>
			<li class="lead">Download the plist configuration file</li>
			<li class="lead">Upload the plist to your MDM provider to be installed onto the device</li>

			<form role="form" enctype="multipart/form-data" action="settings" method="post" class="center-block" role="form">
				<input id="input-1" type="file" class="file" name="file" data-show-preview="false" data-show-remove="false" data-upload-Label="Configure">
			</form>

			<li class="lead">Or select a specfile from the repository</li>
			<div class="row">
				<form action="settings/repository" method="post">
					<select name="file" class="form-control col col-lg" style="width: auto;"> <!--// todo: select2-->
						<c:forEach items="${files}" var="item">
							<option value="${item.resourceLocation}">${item.bundleId}/${item.version}</option>
						</c:forEach>
					</select>
					<input type="submit" value="Select" class="btn btn-default col col-sm">
				</form>
			</div>

		</ol>
	</div>
	</div>
	
	<footer class="footer">
      <div class="container">
		  <%-- todo: update this--%>
        <p class="text-muted text-center center-text-trick">Copyright &copy; 2016 JAMF Software, LLC</p>
      </div>
    </footer>	
</body>
</html>
