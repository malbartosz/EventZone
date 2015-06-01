<!-- When creating new .jsp file just copy code at the bottom  -->

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/resources/head.jsp" />


<div class="Container container">

	<div class="jumbotron">
		<h1>
			Welcome
			<c:out value="${username}"></c:out>
			!
		</h1>
		<p class="lead">It's great to have you here! Scroll down to dive
			in to the world of events! Welcome to EventZone!</p>
	</div>
	<div class="row marketing">
		<div class="col-lg-6">
			<h4>
				<a href="<c:url value="/main/event/create" />">Create an event</a>
			</h4>
			<p>Click here to create an event.</p>

			<h4>
				<a href="<c:url value="" />">Subscribe to an Event</a>
			</h4>
			<p>If you would like to take part in some event, click here.</p>

			<h4>
				<a href="<c:url value="" />">My tickets</a>
			</h4>
			<p>Click to see and download your tickets.</p>
		</div>

		<div class="col-lg-6">
			<h4>
				<a href="<c:url value="/main/listForOrganizer" />">Manage
					created Events</a>
			</h4>
			<p>Click to see list of events you organize.</p>

			<h4>
				<a href="<c:url value="/main/listForParticipant" />">Manage
					subscribed events</a>
			</h4>
			<p>Click to see your subscribed events list.</p>

			<h4>
				<a href="<c:url value="/j_spring_security_logout" />">Logout</a>
			</h4>
			<p>Click to logout. We sure will miss you!</p>
		</div>
	</div>
	<div style="margin: 50px 0 30px 0">
		<h1>Top Events Now</h1>
	</div>

	<c:if test="${!empty events}">
		<% int i = 1; %>
		<c:forEach items="${events}" var="event">
			<div class="row featurette">
				<div
					class="col-md-7 <% if(i % 2 == 0 ){out.println("col-md-push-5");} %>">
					<h2 class="featurette-heading">
						<c:out value="${event.name}, ${event.dateOfEvent}" />
						<span class="text-muted"><c:out value=" ${event.place}" /></span>
					</h2>
					<p class="lead">
						<c:out value="${event.subtitle}" />
					</p>
					<p>
						<a class="btn btn-primary"
							href="<c:url value="/main/event/${event.id}" />" role="button">View
							details »</a>
					</p>
				</div>
				<div
					class="col-md-5 <% if(i % 2 == 0 ){out.println("col-md-pull-7");} %>">
					<img class="featurette-image img-responsive center-block"
						src="<c:url value="/resources/img/events/eventone.jpg" />"
						data-holder-rendered="true">
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
</div>


<jsp:include page="/resources/footer.jsp" />