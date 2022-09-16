<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spr" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />



<spr:candidate header1="List Associate">


	<div class="container-main">

		<div class="card">

				<div class="card-header bg-primary text-dark"><h2 class="form-signin-heading">Edit Dmat Information</h2></div>
				<div class="card-body">

					<form action="editdmat?applicantId=${applicantId}" method="post" class="form-signin">

						<%-- <input type="hidden" class="form-control" id="applicantId"
							name="applicantId" value="${applicant.id}"> 
							 --%>
							<input type="hidden" class="form-control" id="id"
							name="id" value="${dmat.id}">
							<input type="hidden" class="form-control" id="id"
							name="applicantId" value="${applicantId}">
						<div class="form-row">

							<div class="form-group col-md-4">
								<label for="inputEmail4">Dp Name</label> <input type="text" value="${dmat.dPName}"
									class="form-control" id="dPName" name="dPName">
							</div>
							

						</div>
						<div class="form-row">

							
							<div class="form-group col-md-4">
								<label for="inputPassword4">DP Id</label> <input type="text" value="${dmat.dpId }"
									class="form-control" id="dpId" name="dpId">
							</div>

						</div>

						<div class="form-row">

							<div class="form-group col-md-4">
								<label for="inputEmail4">Meroshare userId</label> <input type="text" value="${dmat.meroshareUserId }"
									class="form-control" id="meroshareUserId" name="meroshareUserId">
							</div>
							
							

						</div>
						<div class="form-row">
						<div class="form-group col-md-4">
								<label for="inputEmail4">Meroshare Password</label> <input type="text" value="${dmat.merosharePassword }"
									class="form-control" id="merosharePassword" name="merosharePassword">
							</div>
							

						</div>

						<div class="form-row">
						
						<div class="form-group col-md-4">
								<label for="inputEmail4">Meroshare Pin</label> <input type="text" value="${dmat.merosharePin }"
									class="form-control" id="merosharePin" name="merosharePin">
							</div>
							

						</div>
						<div class="form-row">
						
						<div class="form-group col-md-4">
								<label for="inputEmail4">CRN No</label> <input type="text" value="${dmat.crnNo }"
									class="form-control" id="crnNo" name="crnNo">
							</div>
							

						</div>
						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

						<button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
						</form>
			</div>
				</div>

	</div>



	<style>
.hscroll {
	overflow-x: auto; /* Horizontal */
}
</style>

</spr:candidate>