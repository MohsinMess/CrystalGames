<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@include file="../shared/flows-header.jsp" %>

	<div class="container">
			
			<div class="col-md-offset-2 col-md-8" align="center">
			<div class="panel panel-primary">

				<div class="panel-heading">
					<h4>Sign Up</h4>

				</div>
				<div class="panel-body">
					<!-- Form Elements -->
					<sf:form class="form-horizontal"
						 method="POST"
						id="registerForm"
						modelAttribute="user"> <!-- Links product MV from controller -->

						<div class="form-group">
							<label class="control-label col-md-4" for="firstname">Enter
								First Name : </label>
							<div class="col-md-8">
								<sf:input type="text" path="firstname" id="firstname"
									placeholder="First Name" class="form-control" />
									<sf:errors path="firstname" cssClass="help-block" element="em"/>
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="lastname">Enter
								Last Name : </label>
							<div class="col-md-8">
								<sf:input type="text" path="lastname" id="lastname"
									placeholder="Last Name" class="form-control" />
									<sf:errors path="lastname" cssClass="help-block" element="em"/>
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-md-4" for="email">Enter
								Email : </label>
							<div class="col-md-8">
								<sf:input type="email" path="email" id="email" 
									placeholder="Email" class="form-control"/>
									<sf:errors path="email" cssClass="help-block" element="em"/>
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-md-4" for="contactnumber">Enter
								Contact Number : </label>
							<div class="col-md-8">
								<sf:input type="number" path="contactnumber" id="contactnumber"
									placeholder="Contact Number" class="form-control" />
									<sf:errors path="contactnumber" cssClass="help-block" element="em"/>
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-md-4" for="password">Password : </label>
							<div class="col-md-8">
								<sf:input type="password" path="password" id="password"
									placeholder="Password" class="form-control" /> 
							</div>
						</div>
						
						
						<div class="form-group">
							<label class="control-label col-md-4" for="role">Select Role: </label>
							<div class="col-md-8">
								<label class="radio-inline">
								<sf:radiobutton path="role" value="USER" checked="checked"/>User
								</label>
								<label class="radio-inline">
								<sf:radiobutton path="role" value="SUPPLIER"/> Supplier
								</label>
							</div>
						</div>

						<div class="form-group">

							<div class=" col-md-offset-4 col-md-8">
								<button type="submit" name="_eventId_billing" id="submit" value="Submit"
									class="btn btn-primary">Next - Billing</button>
								
							</div>
						</div>


					</sf:form>


				</div>
			</div>

		</div>		
			
	</div>
					
<%@include file="../shared/flows-footer.jsp" %>	