<div class="container">
	<div class="row">
		<!-- To display siderbar -->
		<div class="col-md-3">

			<%@include file="./shared/sidebar.jsp"%>
		</div>
		<!-- To display actual product -->
		<div class="col-md-9">
			<!-- breadcrumb -->
			<div class="row">

				<div class="col-lg-12">
					<c:if test="${userclickallproducts==true}">

						<script>
							window.categoryid = '';
						</script>

						<ol class="breadcrumb">
							<li><a href="${contextRoot}/home">Home /</a></li>
							<li>/ All Products</li>
						</ol>
					</c:if>
					<c:if test="${userclickcategoryproducts==true}">

						<script>
							window.categoryid = '${category.id}';
						</script>

						<ol class="breadcrumb">
							<li><a href="${contextRoot}/home">Home /</a></li>
							<li>/ Category /</li>
							<li>/ ${category.name}</li>
						</ol>
					</c:if>
				</div>

			</div>

			<div class="row">
				<div class="col-lg-12">
					<table id="productListTable"
						class="table table-dark table-striped table-bordered">
						<thead>
							<tr>
								<th></th>
								<th>Name</th>
								<th>Brand</th>
								<th>Price</th>
								<th>Qauntity Available</th>
								<th></th>
								
							</tr>
						</thead>

					</table>

				</div>
			</div>

		</div>
	</div>
</div>