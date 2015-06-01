<!-- When creating new .jsp file just copy code at the bottom  -->

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/resources/head.jsp" />
<jsp:include page="navbar.jsp" />
	
	
	
	<div class="Container">
		
		<div class="top">
			<c:if test="${!empty listEventsForParticipant}">
	      		<h1>Your subscribed Event's list</h1>
	      	</c:if>
	      	<c:if test="${!empty listEventsForOrganizer}">
	      		<h1>Your Event's list</h1>
	      	</c:if>
		</div>
		<br><br><br>
		<c:if test="${!empty listEventsForParticipant}">
		<% int i = 1; %>
		<c:forEach items="${listEventsForParticipant}" var="eventInfo">
		  <div class="row featurette same-height-container">	  	
	        <div class="col-md-7 <% if(i % 2 == 0 ){out.println("col-md-push-5");} %> same-height-inContainer">
	          <h2 class="featurette-heading"><c:out value="${eventInfo.event.name},"/></h2>
	          <h3><span class="text-muted"><br><c:out value="${eventInfo.event.dateOfEvent}, ${eventInfo.event.place}"/></span></h3>
	          <p class="lead"><c:out value="${eventInfo.event.subtitle}"/></p>
	          <p class="float-to-bottom"><a class="btn btn-primary" href="<c:url value="/main/event/getEvent/${eventInfo.event.id}" />" role="button">View details »</a></p>
	        </div>
	        <div class="col-md-5 <% if(i % 2 == 0 ){out.println("col-md-pull-7");} %> right">
	          <img class="featurette-image img-responsive center-block" src="<c:url value="/resources/img/events/eventone.jpg" />" data-holder-rendered="true">
	        </div>
	      </div>
	      <hr class="featurette-divider">
	      	  <% i++; %>
	      	</c:forEach>
	      </c:if>
	      
	      <!-- organizer part -->
	      <c:if test="${!empty listEventsForOrganizer}">
	      <% int i = 1; %>
		  <c:forEach items="${listEventsForOrganizer}" var="eventInfo">
			<div class="row featurette same-height-container">	  	
	        <div class="col-md-7 <% if(i % 2 == 0 ){out.println("col-md-push-5");} %> same-height-inContainer">
	          <h2 class="featurette-heading"><c:out value="${eventInfo.name},"/></h2>
	          <h3><span class="text-muted"><br><c:out value="${eventInfo.dateOfEvent}, ${eventInfo.place}"/></span></h3>
	          <p class="lead"><c:out value="${eventInfo.subtitle}"/></p>
	          <p class="float-to-bottom"><a class="btn btn-primary" href="<c:url value="/main/event/getEvent/${eventInfo.id}" />" role="button">View details »</a></p>
	        </div>
	        <div class="col-md-5 <% if(i % 2 == 0 ){out.println("col-md-pull-7");} %> right">
	          <img class="featurette-image img-responsive center-block" src="<c:url value="/resources/img/events/eventone.jpg" />" data-holder-rendered="true">
	        </div>
	      </div>
	      <hr class="featurette-divider">
	      	  <% i++; %>
	      	</c:forEach>
	      </c:if>
	</div>
		
		
<jsp:include page="/resources/footer.jsp" />