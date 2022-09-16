<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
  <head>
      <meta charset="utf-8">
      <title>Edit control param</title>

      <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
      <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
  </head>

  <body>

    <div class="container">

        <form:form method="POST" modelAttribute="detailForm" class="form-signin">
            <h2 class="form-signin-heading">Edit control param</h2>
            
           <%--  <spring:bind path="id">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="hidden" path="id" class="form-control" placeholder="pathString"
                                autofocus="true"></form:input>
                     
                    <form:errors path="pathString"></form:errors>
                </div>
            </spring:bind> --%>
            
            <p>Sleep Duration milliseconds</p>
            <spring:bind path="sleepDuraton">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="text" path="sleepDuraton" class="form-control" placeholder="sleepDuraton"
                                autofocus="true"></form:input>
                     
                    <form:errors path="sleepDuraton"></form:errors>
                </div>
            </spring:bind>
<p>Unpause</p>
            <spring:bind path="unpause">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                     <form:select path="unpause" class="form-control">
                     	 <form:options items="${activel}" />
                     </form:select>
                    <form:errors path="unpause"></form:errors>
                </div>
            </spring:bind>
<p>Terminate</p>
            <spring:bind path="terminate">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                   <%--  <form:input type="text" path="bytype" class="form-control"
                                placeholder="Confirm your password"></form:input>
					 --%>
					 <form:select path="terminate" class="form-control">
                     	 <form:options items="${activel}" />
                     </form:select>
                    <form:errors path="terminate"></form:errors>
                </div>
            </spring:bind>

            <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
        </form:form>

    </div>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="${contextPath}/resources/js/bootstrap.min.js"></script>
  </body>
</html>
