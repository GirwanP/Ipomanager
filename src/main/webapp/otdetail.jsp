<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spr" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />



<spr:candidate header1="List Associate">


	<div class="container-main">
		<h1 class="h3 mb-0 text-gray-800">Operation Template Detail</h1>


		<!-- Large modal -->
		<div class="w-100 ">

			<button type="button" class="btn btn-primary  pull-right float-right"
				data-toggle="modal" data-target=".bd-example-modal-lg">add
				new Action Parameter</button>

		</div>
		<br>
		<hr>
		<div class="modal fade bd-example-modal-lg" tabindex="-1"
			role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
			<div class="modal-dialog modal-lg" role="document">
				<div class="modal-content">

					<div class="card">
						<div class="card-body">

							<form:form method="POST" action="addactionparams?templateid=${template.id }"
								modelAttribute="actionparam" class="form-signin">
								<h2 class="form-signin-heading">Add new Action Param</h2>

								<div class="form-row">
									
								</div>

								<div class="form-row">
									<spring:bind path="actiontype">
										<div
											class="form-group col-md-12 ${status.error ? 'has-error' : ''}">
											<form:select path="bytype">
												<form:option value="NONE" disabled="disabled"
													selected="selected"> --SELECT By Type--</form:option>

												<c:forEach items="${byList}" var="qt">
													<form:option value="${qt }">${qt}</form:option>
												</c:forEach>

											</form:select>

											<form:errors path="bytype"></form:errors>
										</div>
									</spring:bind>
								</div>

								<div class="form-row">
									<spring:bind path="pathStringHead">
										<div
											class="form-group col-md-12 ${status.error ? 'has-error' : ''}">
											<form:input type="text" path="pathStringHead"
												class="form-control form-control-lg"
												placeholder="Path String Head" autofocus="true"></form:input>
											<form:errors path="pathStringHead"></form:errors>
										</div>
									</spring:bind>
								</div>
								<div class="form-row">
									<spring:bind path="pathParam">
										<div
											class="form-group col-md-12 ${status.error ? 'has-error' : ''}">
											<form:input type="text" path="pathParam"
												class="form-control form-control-lg"
												placeholder="Path Param" autofocus="true"></form:input>
											<form:errors path="pathParam"></form:errors>
										</div>
									</spring:bind>
								</div>

								<div class="form-row">
									<spring:bind path="pathStringTail">
										<div
											class="form-group col-md-12 ${status.error ? 'has-error' : ''}">
											<form:input type="text" path="pathStringTail"
												class="form-control form-control-lg"
												placeholder="Path String tail"></form:input>
											<form:errors path="pathStringTail"></form:errors>
										</div>
									</spring:bind>
								</div>

								<div class="form-row">
									<spring:bind path="pathParamType">
										<div
											class="form-group col-md-12 ${status.error ? 'has-error' : ''}">
											<form:select path="pathParamType">
												<form:option value="NONE" disabled="disabled"
													selected="selected"> --SELECT Path Parm Type--</form:option>

												<c:forEach items="${pathParamType}" var="qt">
													<form:option value="${qt }">${qt}</form:option>
												</c:forEach>

											</form:select>

											<form:errors path="pathParamType"></form:errors>
										</div>
									</spring:bind>
								</div>
								<div class="form-row">
									<spring:bind path="xpParamName">
										<div
											class="form-group col-md-12 ${status.error ? 'has-error' : ''}">
											<form:input type="text" path="xpParamName"
												class="form-control form-control-lg"
												placeholder="Path Parameter Name"></form:input>
											<form:errors path="xpParamName"></form:errors>
										</div>
									</spring:bind>
								</div>
								<div class="form-row">
									<spring:bind path="actiontype">
										<div
											class="form-group col-md-12 ${status.error ? 'has-error' : ''}">
											<form:select path="actiontype">
												<form:option value="NONE" disabled="disabled"
													selected="selected"> --SELECT Action Type--</form:option>

												<c:forEach items="${actions}" var="qt">
													<form:option value="${qt }">${qt}</form:option>
												</c:forEach>

											</form:select>

											<form:errors path="actiontype"></form:errors>
										</div>
									</spring:bind>
								</div>

								<div class="form-row">
									<spring:bind path="actionOrder">
										<div
											class="form-group col-md-12 ${status.error ? 'has-error' : ''}">
											<form:input type="number" step="1" path="actionOrder"
												class="form-control form-control-lg"
												placeholder="Order of actions"></form:input>
											<form:errors path="actionOrder"></form:errors>
										</div>
									</spring:bind>
								</div>
								<div class="form-row">
									<spring:bind path="ipParamName">
										<div
											class="form-group col-md-12 ${status.error ? 'has-error' : ''}">
											<form:input type="text" path="ipParamName"
												class="form-control form-control-lg"
												placeholder="Input Field Parameter Name"></form:input>
											<form:errors path="ipParamName"></form:errors>
										</div>
									</spring:bind>
								</div>




								<%-- <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
 --%>
								<button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
							</form:form>




						</div>
					</div>
				</div>
			</div>
		</div>

		<!-- model box end  -->


		<div class="card">

			<div class="card-header bg-primary text-dark">
				<!-- <h4 class="card-title ">Regular header</h4>
         -->
				<h1 class="h3 mb-0 text-gray-800">${template.operationTemplateName}</h1>
				<p class="category">Category subtitle</p>
			</div>
			<div class="card-body">

			


				<div class="hscroll">
					<table class="table table-striped">
						<thead>
							<tr>
								<th scope="col">Id</th>
								<th scope="col">By Type</th>
								<th scope="col">Path String Head</th>
								<th scope="col">Path Param</th>
								<th scope="col">Path String tail</th>
								<th scope="col">Path Param type</th>
								<th scope="col">xPath Param Name</th>
								<th scope="col">Action Type</th>

								<th scope="col">Action Order</th>
								<th scope="col">Input Param Name</th>
							</tr>
						</thead>
						<tbody>


							<c:forEach items="${tactions}" var="q">
							
								<tr>
								
									<th scope="row">${q.id}</th>
									<td>${q.bytype}</td>
									<td>${q.pathStringHead}</td>
									<td>${q.pathParam}</td>
									<td>${q.pathStringTail}</td>
									<td>${q.pathParamType}</td>
									<td>${q.xpParamName}</td>
									<td>${q.actiontype}</td>
									<td>${q.actionOrder}</td>
									<td>${q.ipParamName}</td>

									 <td>
									<a href="editactionparams?paramId=${q.id}&&templateid=${template.id}">Edit</a>
								</td>
								
								</tr>


							</c:forEach>
						</tbody>
					</table>
				</div>

			</div>
		</div>

	</div>



	<style>
.hscroll {
	overflow-x: auto; /* Horizontal */
}
</style>

</spr:candidate>