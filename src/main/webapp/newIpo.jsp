
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Add New IPO Opening</title>

<link href="${contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${contextPath}/resources/css/common.css" rel="stylesheet">
</head>

<body>

	<div class="container-flex">

		<form:form method="POST" modelAttribute="ipo" class="form-signin">
			<h2 class="form-signin-heading">Register new Ipo</h2>

<div class="form-row">

				<spring:bind path="companyName">
					<div class="form-group col-md-12 ${status.error ? 'has-error' : ''}">
						<form:input type="text" path="companyName"
							class="form-control form-control-lg" placeholder="Company Name"
							autofocus="true"></form:input>
						<form:errors path="companyName"></form:errors>
					</div>
				</spring:bind>

			</div>

			<div class="form-row">

				<spring:bind path="recommendedQuantityToApply">
					<div class="form-group col-lg-12 ${status.error ? 'has-error' : ''}">
						<form:input type="text" path="recommendedQuantityToApply"
							class="form-control form-control-lg" placeholder="Recommended quantity to apply"
							autofocus="true"></form:input>
						<form:errors path="recommendedQuantityToApply"></form:errors>
					</div>
				</spring:bind>
				
			</div>
			
			<div class="form-row">
			<spring:bind path="pricePerKitta">
					<div class="form-group col-lg-6 ${status.error ? 'has-error' : ''}">
						<form:input type="text" path="pricePerKitta"
							class="form-control form-control-lg" placeholder="Per Unit cost"
							autofocus="true"></form:input>
						<form:errors path="pricePerKitta"></form:errors>
					</div>
				</spring:bind>
			
			</div>

			<button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
		</form:form>

	</div>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
