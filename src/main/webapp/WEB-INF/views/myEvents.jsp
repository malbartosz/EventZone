<!-- When creating new .jsp file just copy code at the bottom  -->

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/resources/head.jsp" />
<jsp:include page="navbar.jsp" />
	
	
	
	<div class="Container">
		
		<div class="top">
	      	<h1>Your subscribed Event's list</h1>
		</div>
		<br><br><br>
		<c:if test="${!empty listEventsForParticipant}">
		<% int i = 1; %>
		<c:forEach items="${listEventsForParticipant}" var="eventInfo">
		  <div class="row featurette row-same-height">	  	
	        <div class="col-md-7 <% if(i % 2 == 0 ){out.println("col-md-push-5");} %> col-xs-height">
	          <h2 class="featurette-heading"><c:out value="${eventInfo.event.name},"/></h2>
	          <h3><span class="text-muted"><br><c:out value="${eventInfo.event.dateOfEvent}, ${eventInfo.event.place}"/></span></h3>
	          <p class="lead"><c:out value="${eventInfo.event.subtitle}"/></p>
	          <p><a class="btn btn-primary" href="<c:url value="/main/event/${eventInfo.event.id}" />" role="button">View details »</a></p>
	        </div>
	        <div class="col-md-5 <% if(i % 2 == 0 ){out.println("col-md-pull-7");} %> col-xs-height">
	          <img class="featurette-image img-responsive center-block" src="<c:url value="/resources/img/events/eventone.jpg" />" data-holder-rendered="true">
	        </div>
	      </div>
	      <hr class="featurette-divider">
	      	  <% i++; %>
	      	</c:forEach>
	      </c:if>
	      
	      <!-- 
		      <div class="row featurette">
		        <div class="col-md-7 col-md-push-5">
		          <h2 class="featurette-heading">Event number two. <span class="text-muted">You need to come.</span></h2>
		          <p class="lead">Donec ullamcorper nulla non metus auctor fringilla. Vestibulum id ligula porta felis euismod semper. Praesent commodo cursus magna, vel scelerisque nisl consectetur. Fusce dapibus, tellus ac cursus commodo.</p>
		        </div>
		        <div class="col-md-5 col-md-pull-7">
		          <img class="featurette-image img-responsive center-block" src="<c:url value="/resources/img/events/eventtwo.jpg"/>"  data-holder-rendered="true">
		        </div>
		      </div>
		      <hr class="featurette-divider">
		      <div class="row featurette">
		        <div class="col-md-7">
		          <h2 class="featurette-heading">Event number three. <span class="text-muted">It's gonna be good.</span></h2>
		          <p class="lead">Donec ullamcorper nulla non metus auctor fringilla. Vestibulum id ligula porta felis euismod semper. Praesent commodo cursus magna, vel scelerisque nisl consectetur. Fusce dapibus, tellus ac cursus commodo.</p>
		        </div>
		        <div class="col-md-5">
		          <img class="featurette-image img-responsive center-block" data-src="holder.js/500x500/auto" alt="500x500" src="<c:url value="/resources/img/events/eventthree.png"/>"  data-holder-rendered="true">
		        </div>
		      </div>
		      <hr class="featurette-divider">
	      -->
	      
	      <!-- organizer part -->
	      <c:if test="${!empty listEventsForOrganizer}">
		<c:forEach items="${listEventsForOrganizer}" var="eventInfo">
		<hr class="featurette-divider">
		  <div class="row featurette">	  	
	        <div class="col-md-7">
	          <h2 class="featurette-heading"><c:out value="${eventInfo.name}"/><span class="text-muted"><c:out value="${eventInfo.subtitle}"/></span></h2>
	          <h2 class="featurette-heading"><c:out value="${eventInfo.event.place}"/><span class="text-muted"><c:out value="${eventInfo.event.dateOfEvent}"/></span></h2>
	          <p class="lead"><c:out value="${eventInfo.description}"/></p>
	        </div>
	        <div class="col-md-5">
	          <img class="featurette-image img-responsive center-block" src="<c:url value="/resources/img/events/eventone.jpg" />" data-holder-rendered="true">
	        </div>
	      </div>
	      	</c:forEach>
	      </c:if>
	</div>
		
		
<jsp:include page="/resources/footer.jsp" />