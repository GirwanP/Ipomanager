<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spr" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>



<spr:admin header1="List Associate">

		
  <div class="container-main">
  <h1 class="h3 mb-0 text-gray-800">Selection Processess </h1>
  
  		
		<!-- Large modal -->
		<div class="w-100 ">
		
		<button type="button" class="btn btn-primary  pull-right float-right" data-toggle="modal"
			data-target=".bd-example-modal-lg">Register New Selection Process</button>
		
		</div>
		<br>
		<hr>
		<div class="modal fade bd-example-modal-lg" tabindex="-1"
			role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
			<div class="modal-dialog modal-lg" role="document">
				<div class="modal-content">
					
					<div class="card">
								<h4>New Selection Process</h4>
					*inactive feature
					<div class="card-body">
					
					
							
					<form action="" method="post">
						<div class="form-row">
							<div class="form-group col-md-6">
								<label for="inputEmail4">Name</label> <input type="text"
									class="form-control" id="name" name="name">
							</div>
							
						</div>
						
						<div class="form-row">
							<div class="form-group col-md-6">
								<label for="inputPassword4">Open Date </label> <input
									type="date" class="form-control" id="fieldOfStudy" name="">
							</div>
							<div class="form-group col-md-6">
								<label for="inputPassword4">Closing Date </label> <input
									type="date" class="form-control" id="fieldOfStudy" name="">
							</div>
							
						</div>
						
						
						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
						
						<button type="submit" class="btn btn-primary" disabled>Add New Selection Process </button>
						
						<button type="button" class="btn btn-primary  pull-right float-right" data-toggle="modal"
			data-target=".bd-example-modal-lg">Close</button>
					</form>

					</div>
					</div>
				</div>
			</div>
		</div>
  
  
  
  
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
      <th scope="col">SP id</th>
      <th scope="col">Name</th>
      <th scope="col">Identifier</th>
      <th scope="col">Total Candidates</th>
      <th scope="col">Open date</th>
      <th scope="col">Closing date</th>
       <th scope="col">Actions</th>
      
      
    </tr> 
  </thead>
 <tbody>
    <c:forEach items="${splist }" var="sp">
  
    <tr>
      <th scope="row">${loop.index+1}</th>
      <td>${sp.id }</td>
      
      <td>${sp.name }</td>
      <td>${sp.uniqueId }</td>
      <td>${sp.totalCandidateCount}</td>
      <td>${sp.openDate }</td>
      <td>${sp.closingDate }</td>
      <td>Edit delete details</td>
      
      
      
    </tr>
       </c:forEach>
    
   
    
  </tbody>
</table>
       	
      </div>
    </div>
    
    
  </div>


<!-- 
<div class="card  bg-light mb-3" style="max-width: 18rem;">
  <div class="card-header bg-primary text-dark">Header</div>
  <div class="card-body ">
    <h5 class="card-title ">Primary card title</h5>
    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
  </div>
</div> -->










		

</spr:admin>