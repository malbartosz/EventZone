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
	         <a class="btn btn-lg btn-success" href="<c:url value="/main/event/subscribe/${event.id}" />" role="button">Click to subscribe</a>
	      </div>
	</div>
		
		
<jsp:include page="/resources/footer.jsp" />