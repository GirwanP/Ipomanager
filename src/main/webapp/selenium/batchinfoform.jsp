<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spr" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />



<spr:candidate header1="List Associate">


	<div class="container-main">
		<h1 class="h3 mb-0 text-gray-800">Add new Batch Operation</h1>

		<div class="card">

			<div class="card-header bg-primary text-dark">
				<!-- <h4 class="card-title ">Regular header</h4>
         -->
				<%-- <h1 class="h3 mb-0 text-gray-800">${sp.spName}</h1>
					<p class="category">Category subtitle</p> --%>
			</div>
			<div class="card-body">

				<form:form method="POST" action="batchapplicationsconf"
					modelAttribute="batchForm" class="form-signin">
					<h2 class="form-signin-heading">Add New Batch</h2>


					<div class="form-row">

						<spring:bind path="ipoId">
							<div
								class="form-group col-md-12 ${status.error ? 'has-error' : ''}">
								<label>IPo </label>
								<form:select path="ipoId">
									<form:option value="0" disabled="disabled" selected="selected"> --SELECT Issue--</form:option>

									<c:forEach items="${activeipos}" var="qt">
										<form:option value="${qt.id }">${qt.companyName}</form:option>
									</c:forEach>

								</form:select>

								<form:errors path="ipoId"></form:errors>
							</div>
						</spring:bind>

					</div>
					<div class="form-row">

						<label>operation Template </label>
						<spring:bind path="operationTemplateId">
							<div
								class="form-group col-md-6 ${status.error ? 'has-error' : ''}">
								<form:select path="operationTemplateId">
									<form:option value="0" disabled="disabled" selected="selected">Choose operation Template</form:option>

									<c:forEach items="${templates}" var="qt">
										<form:option value="${qt.id }">${qt.operationTemplateName}</form:option>
									</c:forEach>

								</form:select>

								<form:errors path="operationTemplateId"></form:errors>
							</div>
						</spring:bind>

						<spring:bind path="useDefaultQuantity">
							<div
								class="form-group col-md-6 ${status.error ? 'has-error' : ''}">
								<label>Use of Default quantity </label>
								<form:select path="useDefaultQuantity">
									<form:option value="false" disabled="disabled"
										selected="selected">Use Default Quantity</form:option>

									<c:forEach items="${tfl}" var="qt">
										<form:option value="${qt }">${qt}</form:option>
									</c:forEach>

								</form:select>

								<form:errors path="useDefaultQuantity"></form:errors>
							</div>
						</spring:bind>
					</div>


					<div class="form-row">

						<spring:bind path="defaultQuantity">

							<div
								class="form-group col-md-3 ${status.error ? 'has-error' : ''}">
								<label>Default Quantity </label>
								<form:input type="number" path="defaultQuantity"
									class="form-control form-control-lg"
									placeholder="Default quantity" autofocus="true"></form:input>
								<form:errors path="defaultQuantity"></form:errors>
							</div>
						</spring:bind>

					</div>

					<table>
						<thead>
							<tr>
								<th>Applicant Name</th>
								<th>Kitta To apply</th>

							</tr>
						</thead>
						<tbody>
							<c:forEach items="${applicants}" var="ap" varStatus="iterindex">


								<tr>
									<td>${ap.applicantName }</td>
									<td><input class="form-group col-md-4" type="hidden"
										name="quantities[${iterindex.count-1}].applicantId"
										value="${ap.id}" /> </td>
										<td>
										 <input type="number"
										name="quantities[${iterindex.count-1}].kittaToApply"></td>

									<td><form:select path="quantities[${iterindex.count-1}].apply">
											<form:option value="false" disabled="disabled"
												selected="selected">Apply this time</form:option>

											<c:forEach items="${tfl}" var="qt">
												<form:option value="${qt }">${qt}</form:option>
											</c:forEach>

										</form:select></td>

								</tr>




							</c:forEach>
						</tbody>


					</table>






					<input class="form-group col-md-4" type="hidden"
						name="${_csrf.parameterName}" value="${_csrf.token}" />

					<button class="btn btn-lg btn-primary btn-block col-md-4"
						type="submit">Submit</button>
				</form:form>



			</div>
		</div>



	</div>



	<style>
.hscroll {
	overflow-x: auto; /* Horizontal */
}
</style>

</spr:candidate>