<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.jamfsoftware.research.macingestor.MACDataType" %>
<%@ page import="com.jamfsoftware.research.macingestor.jaxb.Field" %>
<html>
<head>
<link href="bootstrap/css/bootstrap.css" rel="stylesheet" media="screen">
<style type="text/css">
<%@ include file="bootstrap/css/bootstrap-theme.css" %> 
<%@ include file="bootstrap/css/bootstrap.min.css" %> 
<%@ include file="parsley/parsley.css" %> 
<%@ include file="fileinput/css/fileinput.min.css" %> 

.col-centered{
    float: none;
    margin: 0 auto;
}
</style>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="bootstrap/js/jquery.min.js"></script>
<script src="bootstrap/js/jquery-ui.min.js"></script>
<script src="bootstrap/js/bootstrap.js"></script>
<script src="bootstrap/js/bootstrap-tokenfield.min.js"></script>
<script src="parsley/parsley.min.js"></script>
<script src="bootstrap/js/bootstrap.file-input.js"></script>
<script src="fileinput/js/fileinput.min.js"></script>
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
			
			<!-- <div class="panel panel-default">
				<div class="panel-heading">Test</div>
				<ol class="list-group">
					<li class="list-group-item">Item 1</li>
					<li class="list-group-item">Item 2</li>
				</ol>
			</div> -->
			<ol>
			<li class="lead">Obtain a Managed App Configuration schema file from the application developer</li>
			<li class="lead">Upload the schema file in the form below</li>
			<form role="form" enctype="multipart/form-data" action="/settings" method="post" class="center-block" role="form">
				<input id="input-1" type="file" class="file" name="file" data-show-preview="false" data-show-remove="false" data-upload-Label="Configure">
		</form>
			<li class="lead">Fill out the presented configuration options</li>
			<li class="lead">Download the plist configuration file</li>
			<li class="lead">Upload the plist to your MDM provider to be installed onto the device</li>
		</ol>
		
	</div>
      
	</div>
		
				
		
	
	
	
</body>
</html>
