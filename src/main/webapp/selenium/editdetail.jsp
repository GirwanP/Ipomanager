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

        <form:form method="POST" modelAttribute="detailForm" class="form-signin">
        
        
            <h2 class="form-signin-heading">Create your account</h2>
            <spring:bind path="pathString">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="text" path="pathString" class="form-control" placeholder="pathString"
                                autofocus="true"></form:input>
                     
                    <form:errors path="pathString"></form:errors>
                </div>
            </spring:bind>
            
            <spring:bind path="id">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="hidden" path="id" class="form-control" placeholder="pathString"
                                autofocus="true"></form:input>
                     
                    <form:errors path="pathString"></form:errors>
                </div>
            </spring:bind>

            <spring:bind path="active">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                   <%--  <form:input type="text" path="active" class="form-control" placeholder="active"></form:input>
                    --%>
                     <form:select path="active" class="form-control">
                     	 <form:options items="${activel}" />
                     </form:select>
                    <form:errors path="active"></form:errors>
                </div>
            </spring:bind>

            <spring:bind path="bytype">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                   <%--  <form:input type="text" path="bytype" class="form-control"
                                placeholder="Confirm your password"></form:input>
					 --%>
					 <form:select path="bytype" class="form-control">
                     	 <form:options items="${bylist}" />
                     </form:select>
                    <form:errors path="bytype"></form:errors>
                </div>
            </spring:bind>

            <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
        </form:form>

    </div>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="${contextPath}/resources/js/bootstrap.min.js"></script>
  </body>
</html>
