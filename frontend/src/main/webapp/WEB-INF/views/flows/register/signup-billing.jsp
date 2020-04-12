<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@include file="../shared/flows-header.jsp" %>

	<div class="container">
			
			<div class="col-md-offset-2 col-md-8" align="center">
			<div class="panel panel-primary">

				<div class="panel-heading">
					<h4>Sign Up - Address</h4><br/>

				</div>
				<div class="panel-body">
					<!-- Form Elements -->
					<sf:form class="form-horizontal"
						 method="POST"
						id="billingForm"
						modelAttribute="billing"> <!-- Links product MV from controller -->

						<div class="form-group">
							<label class="control-label col-md-4" for="addresslineone">Address Line One : </label>
							<div class="col-md-8">
								<sf:input type="text" path="addresslineone" id="addresslineone"
									placeholder="Address Line One" class="form-control" />
									<sf:errors path="addresslineone" cssClass="help-block" element="em"/>
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="addresslinetwo">Address Line Two : </label>
							<div class="col-md-8">
								<sf:input type="text" path="addresslinetwo" id="addresslinetwo"
									placeholder="Address Line Two" class="form-control" />
									<sf:errors path="addresslinetwo" cssClass="help-block" element="em"/>
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-md-4" for="city">Enter
								City : </label>
							<div class="col-md-8">
								<sf:input type="text" path="city" id="city" 
									placeholder="City" class="form-control"/>
									<sf:errors path="city" cssClass="help-block" element="em"/>
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-md-4" for="postalcode">Enter
								Postal Code : </label>
							<div class="col-md-8">
								<sf:input type="text" path="postalcode" id="postalcode" 
									placeholder="Postalcode" class="form-control"/>
									<sf:errors path="postalcode" cssClass="help-block" element="em"/>
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-md-4" for="state">Enter
								State : </label>
							<div class="col-md-8">
								<sf:input type="text" path="state" id="state"
									placeholder="State" class="form-control" />
									<sf:errors path="state" cssClass="help-block" element="em"/>
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-md-4" for="country">Country : </label>
							<div class="col-md-8">
								<sf:input type="text" path="country" id="country"
									placeholder="Country" class="form-control" /> 
							</div>
						</div>
						

						<div class="form-group">

							<div class=" col-md-offset-4 col-md-8">
								<button type="submit" name="_eventId_confirm" id="submit" value="Submit"
									class="btn btn-primary">Next - Confirm</button>
							</div>
							<div class=" col-md-offset-4 col-md-8">
								<button type="submit" name="_eventId_personal" id="submit" value="Submit"
									class="btn btn-primary">Previous - Personal info</button>
							</div>
						</div>


					</sf:form>


				</div>
			</div>

		</div>		
			
	</div>
					
<%@include file="../shared/flows-footer.jsp" %>	