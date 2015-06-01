<!-- When creating new .jsp file just copy code at the bottom  -->

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/resources/head.jsp" />
<jsp:include page="../navbar.jsp" />
	
	
	
	<div class="Container">
		
		
		<div class="row featurette">	  	
	        <div class="col-md-7 ">
	          <h2 class="featurette-heading">Name: <c:out value="${event.name}"/></h2>
	          <h3><span class="text-muted">Place: <c:out value="${event.place}"/></span></h3>
	          <h3><span class="text-muted">Date: <c:out value="${event.dateOfEvent}"/></span></h3>
	           <h3><span class="text-muted">Organizer: <c:out value="${event.organizer}"/></span></h3>
	          <p class="lead"></p>
	          
	        </div>
	        <div class="col-md-5 ">
	          <img class="featurette-image img-responsive center-block" src="<c:url value="/resources/img/events/eventone.jpg" />" data-holder-rendered="true">
	        </div>
	      </div>
	      <div class="description">
	      	<h3>Event description</h3>
	      	<span class="lead"><c:out value="${event.description}"/></span>
	      	<div id="eventID" hidden="hidden"><c:out value="${event.id}"/></div>
	      	<div id="sucDiv" class="alert alert-success" role="alert" hidden="hidden">
		      <strong>Well done!</strong> You have been subscribed.
		    </div>
		    <div id="errorMSG" class="alert alert-danger" role="alert" hidden="hidden">
		      <strong>Oh snap!</strong> Something went wrong. Try again later!
		    </div>
	      	<div id="paymentForm" hidden="hidden">
	      	<br><br><br>
	      		<div>
	      			<label>Payment</label><br>
	      			<select id="paymentTrue">
	      				<option value=1>Yes</option>
	      				<option value=0>No</option>
	      			</select>
	      		</div>
	      		 <button id="subscribeToEvent" class="btn btn-lg btn-success right" role="button">Click to subscribe</button>
	      	</div>
	      	<c:if test="${!subscribed}">
	        	 <button id="subscribeButton" class="btn btn-lg btn-success right" role="button">Click to subscribe</button>
	      	</c:if>
	      </div>
	</div>
		
		
<jsp:include page="/resources/footer.jsp" />