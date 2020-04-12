<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />




<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Crystal Games - ${title}</title>

<script>
	window.contextRoot='${contextRoot}';
</script>

<!-- Bootstrap core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">

<!-- Bootstrap theme-->
<link href="${css}/bootstrap-theme.css" rel="stylesheet">

<!-- Bootstrap DataTables-->
<link href="${css}/dataTables.bootstrap.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${css}/myapp.css" rel="stylesheet">

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>

	


</head>

<body>

	<div class="wrapper">

		<!-- Navigation -->
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    		<div class="container">
    			<div class="navebar-header">
					<a class="navbar-brand" href="${contextRoot}/home">Crystal Games</a>
				</div>
			</div>
		</nav>
		<!-- Page Content -->
		<div class="content">
		
		<div class="container">
		<!-- Will be displayed if the credentials are wrong -->
		<c:if test="${not empty message}">
			<div class="col-md-offset-2 col-md-8" align="center">
				<div class="alert alert-danger">${message}</div>
			</div>
		</c:if>
		<!-- Will be displayed if user has logged out -->
		<c:if test="${not empty logout}">
			<div class="col-md-offset-2 col-md-8" align="center">
				<div class="alert alert-success">${logout}</div>
			</div>
		</c:if>
			
			<div class="col-md-offset-2 col-md-8" align="center">
			<div class="panel panel-primary">

				<div class="panel-heading">
					<h4>Login</h4>

				</div>
				<div class="panel-body">
					<!-- Form Elements -->
					<form class="form-horizontal"
						 method="POST"
						id="loginForm"> 
						<div class="form-group">
							<label class="control-label col-md-4" for="username">Enter
								Email : </label>
							<div class="col-md-8">
								<input type="text" name="username" id="username"
									placeholder="Email Id" class="form-control" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="password]">Enter
								Password : </label>
							<div class="col-md-8">
								<input type="password" name="password" id="password"
									placeholder="Password" class="form-control" />
							</div>
						</div>
						
						<div class="form-group">

							<div class=" col-md-offset-4 col-md-8">
								<input type="submit" id="submit" value="Login"
									class="btn btn-primary"/>
								<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
							</div>
						</div>
					</form>
				
				<div class="panel-footer">
					<div class="text-center">
						New User? - <a href="${contextRoot}/register">Register Here</a>
					</div>
				</div>

			</div>
		</div>

	</div>		
			
</div>

		
		</div>
		<!-- Footer -->
		<%@include file="./shared/footer.jsp"%>

		<!-- Bootstrap core JavaScript -->
		<script src="${js}/jquery.min.js"></script>
		<script src="${js}/bootstrap.bundle.min.js"></script>
		<script src="${js}/myapp.js"></script>

	</div>
</body>

</html>
