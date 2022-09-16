<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spr" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>



<spr:admin header1="List Associate">

		
  <div class="container-main">
  <h1 class="h3 mb-0 text-gray-800">Element search details </h1>
  
  		
		<!-- Large modal -->
		
		<br>
		<hr>
		
  
  
  
  
    <div class="card">
      <div class="card-header bg-primary text-dark">
        <!-- <h4 class="card-title ">Regular header</h4>
         -->
         <h1 class="h3 mb-0 text-gray-800"> </h1>
        <p class="category"></p>
      </div>
      <div class="card-body">
       	
       	<table class="table">
  <thead>
     <tr>
      <th scope="col">S.N.</th>
      <th scope="col">d</th>
      <th scope="col">Path/string</th>
      <th scope="col">By type</th>
      <th scope="col">Status</th>
      <th scope="col">Actions</th>
      
      
      
    </tr> 
  </thead>
 <tbody>
    <c:forEach items="${list}" var="sp">
  
    <tr>
      <th scope="row">${loop.index+1}</th>
      <td>${sp.id }</td>
      
      <td>${sp.pathString }</td>
      <td>${sp.bytype }</td>
      <td>${sp.active}
      </td>
      <td>
      	<c:if test="${sp.active}">
									<a href="deactivateparam?detailid=${sp.id}">Deactivate</a>
								</c:if>
								<c:if test="${not sp.active}">
									<a href="activateparam?detailid=${sp.id}">Activate</a>

								</c:if>
									<a href="editSearchStrings?detailid=${sp.id}">Edit</a>
								 
      </td>
      
      
    </tr>
       </c:forEach>
    
   
    
  </tbody>
</table>
       	
      </div>
    </div>
    
    
  </div>



		

</spr:admin>