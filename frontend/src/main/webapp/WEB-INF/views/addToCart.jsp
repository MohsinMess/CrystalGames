

<div class="container">
	<!-- breadcrumb -->
	<div class="row">

		<div class="col-xs-12">

			<ol class="breadcrumb">
				<li><a href="${contextRoot}/home">Home //</a></li>
				<li><a href="${contextRoot}/show/all/products">Products //</a></li>
				<li class="active">${product.name}</li>
			</ol>


		</div>

	</div>
</div>

<div class="container">
	<table class="table table-borderless">
		<tbody>
			<tr>
				<td class="text-danger">
					<h3>Product Purchased Successfully!</h3>
					<br/>
				</td>
			</tr>
			<tr>
				<td>${product.name}</td>
			</tr>
			<tr>
				<td>${product.brand}</td>
			</tr>
			<tr>
				<td class="row text-white">${note}</td>
			</tr>
		</tbody>
	</table>

</div>



