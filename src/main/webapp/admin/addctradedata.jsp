<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spr" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>



<spr:admin header1="List Associate">

		
 <div class="container-main">
		<h1 class="h3 mb-0 text-gray-800">Add new Ctrade data</h1>


		<!-- Large modal -->
		<div class="w-100 ">
		
		
		</div>
		<br>
		<hr>

		<div class="card">

			<div class="card-header bg-primary text-dark">
				<!-- <h4 class="card-title ">Regular header</h4>
         -->
				<%-- <h1 class="h3 mb-0 text-gray-800">${sp.spName}</h1>
					<p class="category">Category subtitle</p> --%>
			</div>
			<div class="card-body">
				<div class="hscroll">
				
					
						
    
							
					<form action="addtradedata" method="post">
						<div class="form-row">
							<div class="form-group col-md-6">
								<label for="inputEmail4">Script Symbol</label> <input type="text"
									class="form-control" id="name" name="symbol">
							</div>
							<div class="form-group col-md-6">
								<label for="inputPassword4">Day max price </label> <input
									type="number" class="form-control" id="fieldOfStudy" name="dayMaxBuyPrice">
							</div>
						</div>
						
						<div class="form-row">
							<div class="form-group col-md-8">
								<label >Day trade target(Max quantity to buy)</label> 
									<input
									type="number" class="form-control" id="fieldOfStudy" name="dayToTradeQuantity">
									
							</div>
							
						</div>
						
						
						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
						
						<button type="submit" class="btn btn-primary">Add C-Trade data</button>
						
					</form>




			</div>
			</div>
		</div>



	</div>










	<style>
.hscroll {
  overflow-x: auto; /* Horizontal */
}
</style>	

</spr:admin>