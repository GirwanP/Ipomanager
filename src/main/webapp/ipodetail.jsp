<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spr" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />



<spr:candidate header1="List Associate">


	<div class="container-main">
		<h1 class="h3 mb-0 text-gray-800">Currently Open IPOs</h1>


		<!-- Large modal -->
		<div class="w-100 ">
		
		<button type="button" class="btn btn-primary  pull-right float-right" data-toggle="modal"
			data-target=".bd-example-modal-lg">add new IPO</button>
		
		</div>
		<br>
		<hr>
		<div class="modal fade bd-example-modal-lg" tabindex="-1"
			role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
			<div class="modal-dialog modal-lg" role="document">
				<div class="modal-content">
					
					<div class="card">
					<div class="card-body">
							
					<form action="addtomql" method="post">
						<div class="form-row">
							<div class="form-group col-md-8">
								<label >Add Qualification </label> 
									
									<select class="form-control" id="type" name="qid">
									<option disabled="disabled" selected="selected">select qualification </option>
									<c:forEach items="${allqlist }" var="qt">
										<option  value="${qt.id }">${qt.name}</option>
									</c:forEach>
									</select>
							</div>
							<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

            
						</div>
						
						<button type="submit" class="btn btn-primary">Add Qualifications </button>
						
						<button type="button" class="btn btn-primary  pull-right float-right" data-toggle="modal"
								data-target=".bd-example-modal-lg">Close</button>
					</form>

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
							<th scope="col">Company Name</th>
							<th scope="col">Recommended Quantity</th>
							<th scope="col">Per unit price</th>
						</tr>
					</thead>
					<tbody>


						<c:forEach items="${ipos}" var="q">
							<tr>
								<th scope="row">${q.id}</th>
								<td>${q.companyName}</td>
								<td>${q.recommendedQuantityToApply}</td>
								<td>${q.pricePerKitta}</td>
								
								<%-- <td>
									<a href="rmfrmql?qid=${q.id}">Remove</a>
									
								</td> --%>

							</tr>


						</c:forEach>
					</tbody>
				</table>
				</div>



			</div>
		</div>



	</div>


	

<!-- for future use -->
		<div class="w-100 ">
		
		<!-- <button type="button" class="btn btn-primary  pull-right float-right" data-toggle="modal"
			data-target=".bd-example-modal-lg">Add ...</button>
		 -->
		</div>
		<br>
		<hr>
		<div class="modal fade bd-example-modal-lg" tabindex="-1"
			role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
			<div class="modal-dialog modal-lg" role="document">
				<div class="modal-content">
					
					<div class="card">
					<div class="card-body">
					
					
							
					<form action="" method="post">
						<div class="form-row">
							<div class="form-group col-md-6">
								<label for="inputEmail4">Name</label> <input type="text"
									class="form-control" id="name">
							</div>
							<div class="form-group col-md-6">
								<label for="inputPassword4">Field </label> <input
									type="text" class="form-control" id="fieldOfStudy">
							</div>
						</div>
						
						<div class="form-row">
							<div class="form-group col-md-8">
								<label >Qualification Type</label> 
									
									<select class="form-control" id="type" placeholder="fsdf">
									<option disabled="disabled" selected="selected">---select qualification type</option>
									<c:forEach items="${qtlist }" var="qt">
										<option  value="${qt.id }">${qt.name}</option>
									</c:forEach>
											
									
									
									</select>
							</div>
							
						</div>
						
						<div class="form-row">
						<label for="inputCity">Duration</label>
							<div class="form-group col-md-3">
								<label for="inputCity">Years</label> <input type="number"
									class="form-control" id="years">
							</div><div class="form-group col-md-3">
								<label for="inputCity">Month</label> <input type="number"
									class="form-control" id="months">
							</div><div class="form-group col-md-3">
								<label for="inputCity">Days</label> <input type="number"
									class="form-control" id="days">
							</div>
						</div>
						
						<button type="submit" class="btn btn-primary">Add Qualifications </button>
						
						<button type="button" class="btn btn-primary  pull-right float-right" data-toggle="modal"
			data-target=".bd-example-modal-lg">Close</button>
					</form>

					</div>
					</div>
				</div>
			</div>
		</div>
		
		<!-- model box end  -->






<style>
.hscroll {
  overflow-x: auto; /* Horizontal */
}
</style>

</spr:candidate>