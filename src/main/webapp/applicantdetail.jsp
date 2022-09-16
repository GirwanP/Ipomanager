<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spr" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />



<spr:candidate header1="List Associate">


	<div class="container-main">

		<c:if test="${dmat eq null }">




			<div class="card">

				<div class="card-header bg-primary text-dark"><h2 class="form-signin-heading">Add Dmat Information</h2></div>
				<div class="card-body">

					<form action="adddmat" method="post" class="form-signin">

						<input type="hidden" class="form-control" id="applicantId"
							name="applicantId" value="${applicant.id}"> <label
							for="inputCity">Name:</label>

						<div class="form-row">

							<div class="form-group col-md-4">
								<label for="inputEmail4">Dp Name</label> <input type="text"
									class="form-control" id="dPName" name="dPName">
							</div>
							

						</div>
						<div class="form-row">

							
							<div class="form-group col-md-4">
								<label for="inputPassword4">DP Id</label> <input type="text"
									class="form-control" id="dpId" name="dpId">
							</div>

						</div>

						<div class="form-row">

							<div class="form-group col-md-4">
								<label for="inputEmail4">Meroshare userId</label> <input type="text"
									class="form-control" id="meroshareUserId" name="meroshareUserId">
							</div>
							
							

						</div>
						<div class="form-row">
						<div class="form-group col-md-4">
								<label for="inputEmail4">Meroshare Password</label> <input type="text"
									class="form-control" id="merosharePassword" name="merosharePassword">
							</div>
							

						</div>

						<div class="form-row">
						
						<div class="form-group col-md-4">
								<label for="inputEmail4">Meroshare Pin</label> <input type="text"
									class="form-control" id="merosharePin" name="merosharePin">
							</div>
							

						</div>
						<div class="form-row">
						
						<div class="form-group col-md-4">
								<label for="inputEmail4">CRN No</label> <input type="text"
									class="form-control" id="crnNo" name="crnNo">
							</div>
							

						</div>
						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

						<button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
						</form>
			</div>
				</div>
		</c:if>
		<c:if test="${dmat ne null }">
	<h1 class="h3 mb-0 text-gray-800">Applicant Detail</h1>
			<div class="card">

				<div class="card-header bg-primary text-dark">
				${applicant.id}:${applicant.applicantName}
				</div>
				<div class="card-body">

					<div class="row">
						<div class="col">Meroshare userid</div>
						<div class="col">${dmat.meroshareUserId }</div>

					</div>
					<div class="row">
						<div class="col">Meroshare Password</div>
						<div class="col">${dmat.merosharePassword}</div>

					</div>
					<div class="row">
						<div class="col">Meroshare Pin</div>
						<div class="col">${dmat.merosharePin }</div>

					</div>
					<div class="row">
						<div class="col">DP Id</div>
						<div class="col">${dmat.dpId }</div>

					</div>
					<div class="row">
						<div class="col">Dp Name</div>
						<div class="col">${dmat.dPName}</div>

					</div>
					<div class="row">
						<div class="col">Phone</div>
						<div class="col">${dmat.dPNumber}</div>

					</div>


					<div class="row">
						<div class="col">
							<a href="editdmat?applicantId=${applicant.id}">Edit Information</a>
						</div>

					</div>




				</div>
			</div>
		</c:if>


	</div>



	<style>
.hscroll {
	overflow-x: auto; /* Horizontal */
}
</style>

</spr:candidate>