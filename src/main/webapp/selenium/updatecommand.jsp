<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
  <head>
      <meta charset="utf-8">
      <title>The Selenium Pilot</title>

      <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
      <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
  </head>

  <body>

    <div class="container">

        <form:form method="POST" modelAttribute="batchForm" class="form-signin" accept-charset="utf-8">
        
        
            <h2 class="form-signin-heading">The Selenium Pilot Cocpit*</h2>
            <!-- 
            private static volatile ByType bytype;
    private static volatile boolean executed;
    private static volatile String pathString;
     -->
   
            
            <p>Path String</p>
            <spring:bind path="pathString">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="text" path="pathString" class="form-control" placeholder="pathString"
                                autofocus="true"></form:input>
                     
                    <form:errors path="pathString"></form:errors>
                </div>
            </spring:bind>
            <p> bytype</p>
            <spring:bind path="bytype">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                  
					 <form:select path="bytype" class="form-control">
                     	 <form:options items="${bylist}" />
                     </form:select>
                    <form:errors path="bytype"></form:errors>
                </div>
            </spring:bind>
            
				<p>Already Executed</p>
            <spring:bind path="executed">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                   
                     <form:select path="executed" class="form-control">
                     	 <form:options items="${activel}" />
                     </form:select>
                    <form:errors path="executed"></form:errors>
                </div>
            </spring:bind>
<p>actiontype</p>
            <spring:bind path="actiontype">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                   
                     <form:select path="actiontype" class="form-control">
                     	 <form:options items="${actionList}" />
                     </form:select>
                    <form:errors path="actiontype"></form:errors>
                </div>
            </spring:bind>
            <button class="btn btn-lg btn-primary btn-block" type="submit">Update</button>
             <!-- private static volatile WebElementActions actiontype;
    
    private static volatile String param1;
    private static volatile String param2;
    private static volatile String param3; -->
<p>param1</p>
            <spring:bind path="param1">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                   
                     <form:input type="text" path="param1" class="form-control" placeholder="pathString"
                                autofocus="true"></form:input>
                                
                    <form:errors path="param1"></form:errors>
                </div>
            </spring:bind>
<p>param2</p>
            <spring:bind path="param2">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                   
                     <form:input type="text" path="param2" class="form-control" placeholder="pathString"
                                autofocus="true"></form:input>
                                
                    <form:errors path="param2"></form:errors>
                </div>
            </spring:bind>
<p>param3</p>
            <spring:bind path="param3">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                   
                     <form:input type="text" path="param3" class="form-control" placeholder="pathString"
                                autofocus="true"></form:input>
                                
                    <form:errors path="param3"></form:errors>
                </div>
            </spring:bind>

            

            
        </form:form>

    </div>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="${contextPath}/resources/js/bootstrap.min.js"></script>
  </body>
</html>
