<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<nav class="navbar navbar-expand-lg  navbar-dark bg-dark navbar-fixed-top">
	<div class="container" style="font-family:Cursive;"><img class="d-block" src="${images}/cslog.jpg" style="width:30px;height:30px;">
		<a class="navbar-brand" href="${contextRoot}/home">Crystal Games</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarResponsive" aria-controls="navbarResponsive"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarResponsive">
			<ul class="navbar-nav ml-auto">
				<li class="nav-item "><a class="nav-link" href="#">Home
						<span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item"><a class="nav-link"
					href="${contextRoot}/about">About</a></li>
				<li class="nav-item"><a class="nav-link"
					href="${contextRoot}/show/all/products">View Products</a></li>
				<security:authorize access="hasAuthority('ADMIN')">
				<li class="nav-item"><a class="nav-link"
					href="${contextRoot}/manage/products">Manage Products</a></li>
				</security:authorize>
				<li class="nav-item"><a class="nav-link"
					href="${contextRoot}/contact">Contact</a></li>

			</ul>

			<ul class="nav navbar-nav navbar-right">
			
				<security:authorize access="isAnonymous()">
				<li class="nav-item"><a class="nav-link"
					href="${contextRoot}/register">Sign up</a></li>
				<li class="nav-item"><a class="nav-link"
					href="${contextRoot}/login">Login</a></li>
				</security:authorize>
				
				<security:authorize access="isAuthenticated()">	
				<li class="dropdown" id="userModel"><a href="javascript:void(0)"
					class="btn btn-danger dropdown-toggle" id="dropdownMenu1"
					data-toggle="dropdown" aria-haspopup="true" aria-expanded="true"> ${userModel.fulName} <span class="caret"></span>
				</a>
					<ul class="dropdown-menu">
					<security:authorize access="hasAuthority('USER')">
						<%-- <li><a href="${contextRoot}/cart/show"> <span
								class="glyphicon glyphicon-shopping-cart"></span> <span
								class="badge">${userModel.cart.cartlines}</span> - &#8377; ${userModel.cart.grandtotal}</a>
								</li> --%>
						<li class="divider" role="separator"></li>
					</security:authorize>
						<li><a href="${contextRoot}/perform-logout">Logout</a></li>
					</ul>
				</li>
				</security:authorize>
			</ul>
		</div>
	</div>
</nav>
<br>
<br>
