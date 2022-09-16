<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spr" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />



<spr:candidate header1="List Associate">


	<div class="container-main">
		<h1 class="h3 mb-0 text-gray-800">Applicant List</h1>


		<!-- Large modal -->
		<div class="w-100 ">

			<button type="button" class="btn btn-primary  pull-right float-right"
				data-toggle="modal" data-target=".bd-example-modal-lg">add
				new Applicant</button>

		</div>
		<br>
		<hr>
		<div class="modal fade bd-example-modal-lg" tabindex="-1"
			role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
			<div class="modal-dialog modal-lg" role="document">
				<div class="modal-content">

					<div class="card">
						<div class="card-body">

							<form:form method="POST" action="addnewapplicant" modelAttribute="applicant" class="form-signin">
								<h2 class="form-signin-heading">Add new Applicant</h2>

								<div class="form-row">

									<spring:bind path="applicantName">
										<div
											class="form-group col-md-12 ${status.error ? 'has-error' : ''}">
											<form:input type="text" path="applicantName"
												class="form-control form-control-lg"
												placeholder="Applicant Name" autofocus="true"></form:input>
											<form:errors path="applicantName"></form:errors>
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
				<%-- <h1 class="h3 mb-0 text-gray-800">${sp.spName}</h1>
					<p class="category">Category subtitle</p> --%>
			</div>
			<div class="card-body">

				<div class="hscroll">
					<table class="table table-striped">
						<thead>
							<tr>
								<th scope="col">Id</th>
								<th scope="col">Applicant Name</th>
								<th scope="col">Nick Name</th>
								<th scope="col">Actions</th>
							</tr>
						</thead>
						<tbody>

							<c:forEach items="${applicants}" var="q">
								<tr>
									<th scope="row">${q.id}</th>
									<td>${q.applicantName}</td>
									<td>xxx</td>
									<td><a href="getapplicant?applicantId=${q.id}">Detail</a>
									<br>
									<a href="disableapplicant?applicantId=${q.id}">Disable</a>
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