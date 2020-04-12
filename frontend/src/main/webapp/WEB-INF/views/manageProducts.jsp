<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%> <!-- To fetch data from backend through spring -->

<div class="container">
	<div class="row">
	
	
	<c:if test="${not empty message}">
	<div class="col-xs-12">
	<div class="alert alert-success alert-dismissible">
	
	<button type="button" class="close" data-dismiss="alert">&times;</button>
		${message}
	</div>
	
	</div>
	</c:if>
	

		<div class="col-md-offset-2 col-md-8" align="center">
			<div class="panel panel-primary">

				<div class="panel-heading">
					<h4>Product Management</h4>

				</div>
				<div class="panel-body">
					<!-- Form Elements -->
					<sf:form class="form-horizontal" modelAttribute="product"
						action="${contextRoot}/manage/products" method="POST"
						enctype="multipart/form-data"> <!-- Links product MV from controller -->

						<div class="form-group">
							<label class="control-label col-md-4" for="name">Enter
								Product Name : </label>
							<div class="col-md-8">
								<sf:input type="text" path="name" id="name"
									placeholder="Product Name" class="form-control" />
									<sf:errors path="name" cssClass="help-block" element="em"/>
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="brand">Enter
								Brand Name : </label>
							<div class="col-md-8">
								<sf:input type="text" path="brand" id="brand"
									placeholder="Brand Name" class="form-control" />
									<sf:errors path="brand" cssClass="help-block" element="em"/>
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-md-4" for="description">Enter
								Description : </label>
							<div class="col-md-8">
								<sf:textarea path="description" id="description" rows="4"
									placeholder="Description" class="form-control"></sf:textarea> 
									<sf:errors path="description" cssClass="help-block" element="em"/>
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-md-4" for="unitprice">Enter
								Unit Price : </label>
							<div class="col-md-8">
								<sf:input type="number" path="unit_price" id="unitprice"
									placeholder="Unit Price" class="form-control" />
									<sf:errors path="unit_price" cssClass="help-block" element="em"/>
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-md-4" for="unitprice">Quantity Available : </label>
							<div class="col-md-8">
								<sf:input type="number" path="quantity" id="quantity"
									placeholder="Quantity" class="form-control" /> 
							</div>
						</div>
						
						
						<div class="form-group">
							<label class="control-label col-md-4" for="file"> Select an image: </label>
							<div class="col-md-8">
								<sf:input type="file" path="file" id="file"
									 class="form-control" />
									 <sf:errors path="file" cssClass="help-block" element="em"/> 
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-md-4" for="categoryid">Select Category: </label>
							<div class="col-md-8">
								<sf:select class="form-control" id="categoryID" path="categoryID"
								items="${categories}" itemLabel="name" itemValue="id"
								/>
								<c:if test="${product.id==0}">
								<br/>
								<div class="text-right">
								<button type="button" data-toggle="modal" data-target="#myCategoryModal" class="btn btn-warning btn-xs">
									Add Category</button>
									</div>
								</c:if>
								
							</div>
						</div>

						<div class="form-group">

							<div class=" col-md-offset-4 col-md-8">
								<input type="submit" name="submit" id="submit" value="Submit"
									class="btn btn-primary" />
									
									<sf:hidden path="id"/>
									<sf:hidden path="code"/>
									<sf:hidden path="supplierID"/>
									<sf:hidden path="active"/>
									<sf:hidden path="purchases"/>
									<sf:hidden path="views"/>
							</div>
						</div>


					</sf:form>


				</div>
			</div>

		</div>

	</div>

	<div class="modal fade" id="myCategoryModal" role="dialog" tabindex="-1">
		<div class="modal-dialog" role="document" >
			<div class="modal-content">
			<!-- Modal Header -->
				<div class="modal-header"><button type="button" class="close" data-dismiss="modal">
					<span>&times;</span></button>
					<h4 class="modal-title">Add New Category</h4>
				</div>
				<div class="modal-body">
					<!-- Category Form -->
					<sf:form modelAttribute="category" action="${contextRoot}/manage/category" method="POST" class="form-horizontal">
					<div class="form-group">
						<label for="category_name" class="control-label col-md-4">Category Name : </label>
						<div class="col-md-8" >
						<sf:input type="text" path="name" id="category_name" class="form-control"/>
						</div>
					</div>
					
					<div class="form-group">
						<label for="category_description" class="control-label col-md-4">Category Description : </label>
						<div class="col-md-8" >
						<sf:textarea cols="" rows="5" path="description" id="category_description" class="form-control"/>
						</div>
					</div>
					
					<div class="form-group">
						
						<div class="col-md-4 col-md-8" >
							<input type="submit" value="Add Category" class="btn btn-primary"/>
						</div>
					</div>
					
					</sf:form>
				</div>
			</div>
		</div>
	</div>


</div>