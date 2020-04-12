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

	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	
	

</head>

<body>
		<div class="wrapper"  style="background-color:#0E0D0D">
			<!-- Navigation -->
			
			<%@include file="./shared/navbar.jsp"%>
			
		<!-- Page Content -->
		<div class="content">
			<c:if test="${userclickhome==true}">
				<%@include file="home.jsp"%>
			</c:if>

			<c:if test="${userclickabout==true}">
				<%@include file="about.jsp"%>
			</c:if>

			<c:if test="${userclickcontact==true}">
				<%@include file="contact.jsp"%>
			</c:if>
			
			<c:if test="${userclickallproducts==true or userclickcategoryproducts==true}">
				<%@include file="listproducts.jsp"%>
			</c:if>
			
			<c:if test="${userclickshowproduct == true}">
			<%@include file="singleproduct.jsp" %>
			</c:if>	
			
			<c:if test="${userclickmanageproduct== true}">
			<%@include file="manageProducts.jsp"%>
			</c:if>
			
			<c:if test="${userClickShowCart== true}">
			<%@include file="cart.jsp"%>
			</c:if>
			
			<c:if test="${userclickaddtocart== true}">
			<%@include file="addToCart.jsp"%>
			</c:if>
		
		</div>
		<!-- Footer -->
		<%@include file="./shared/footer.jsp"%>

		<!-- Bootstrap core JavaScript -->
		<script src="${js}/jquery.min.js"></script>
		<script src="${js}/bootstrap.bundle.min.js"></script>
		<!-- DataTable Bootstrap Script -->
		<script src="${js}/dataTables.bootstrap.js"></script>
		<!-- DataTable Plugin -->
		<script src="${js}/jquery.dataTables.js"></script>
		
		
		<script src="${js}/myapp.js"></script>

	</div>
</body>

</html>
