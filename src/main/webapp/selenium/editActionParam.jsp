<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
  <head>
      <meta charset="utf-8">
      <title>Create an account</title>

      <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
      <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
  </head>

  <body>

    <div class="container">

        <div class="card">
						<div class="card-body">

							<form:form method="POST" action="editactionparams?templateid=${templateid}"
								modelAttribute="actionparam" class="form-signin">
								<h2 class="form-signin-heading">Edit Action Param</h2>

								<div class="form-row">
									
								</div>
								
								<div class="form-row">
									<spring:bind path="id">
										<div
											class="form-group col-md-12 ${status.error ? 'has-error' : ''}">
											<form:hidden  path="id"
												class="form-control form-control-lg"
												placeholder="Path String Head" autofocus="true"></form:hidden>
											<form:errors path="pathStringHead"></form:errors>
										</div>
									</spring:bind>
								</div>

								<div class="form-row">
									<spring:bind path="actiontype">
										<div
											class="form-group col-md-12 ${status.error ? 'has-error' : ''}">
											<form:select path="bytype">
												
													<option disabled="disabled">--SELECT By Type--</option>

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
												
													<option disabled="disabled">--SELECT Path Parm Type--</option>

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
												
													<option disabled="disabled">--SELECT Action Type--</option>
													

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

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="${contextPath}/resources/js/bootstrap.min.js"></script>
  </body>
</html>
