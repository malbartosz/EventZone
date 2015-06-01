<!-- When creating new .jsp file just copy code at the bottom  -->

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:include page="/resources/head.jsp" />
<!-- cdn for modernizr, if you haven't included it already -->
<script
	src="http://cdn.jsdelivr.net/webshim/1.12.4/extras/modernizr-custom.js"></script>
<!-- polyfiller file to detect and load polyfills -->
<script src="http://cdn.jsdelivr.net/webshim/1.12.4/polyfiller.js"></script>
<script>
	webshims.setOptions('waitReady', false);
	webshims.setOptions('forms-ext', {
		types : 'date'
	});
	webshims.polyfill('forms forms-ext');
</script>
<div class="fixedElement">
	<nav class="navbar navbar-inverse" role="navigation">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-ex1-collapse">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="/EventZone/">EventZone</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse navbar-ex1-collapse">
			<ul class="nav navbar-nav">
				<li><a href="<c:url value="/main" />">Home</a></li>
				<li class="dropdown active"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-expanded="false">Events<span
						class="caret"></span></a>
					<ul class="dropdown-menu" role="menu">
						<li><a href="#">Create an Event</a></li>
						<li><a href="<c:url value="/listForOrganizer/" />">Manage
								my Events</a></li>
						<li class="divider"></li>
						<li><a href="#">Subscribe to an Event</a></li>
						<li><a href="<c:url value="/listForParticipant/" />">Manage
								subscribed Events</a></li>
					</ul></li>
				<li><a href="#">My Tickets</a></li>
				<li class="divider"></li>
				<li><a href="<c:url value="/j_spring_security_logout" />">Logout</a></li>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</nav>
</div>

<div class="Container">

	<div class="top">
		<h2>
			Welcome
			<c:out value="${username}"></c:out>
			! This is a page to create new event!
		</h2>
	</div>

	<c:if test="${not empty createEventFailureMsg}">
		<div style="margin: 30px 50px 0 50px" class="alert alert-danger"
			role="alert">
			<strong>Oh snap!</strong>
			<c:out value="${createEventFailureMsg}" />
		</div>
	</c:if>
	<div class="line_divs">
		<div class="div_block1">
			<form:form modelAttribute="eventForm" action="createEvent"
				method="POST" >
				<div class="form-group">
					<form:label path="name" for="name" class="lead control-label">Event name</form:label>
					<form:input path="name" type="text" class="form-control" id="name"
						name="name" required="true"></form:input>
					<span class="help-block"></span>
				</div>
				<div class="form-group">
					<form:label path="place" for="place" class="lead control-label">Place</form:label>
					<form:input path="place" type="text" class="form-control"
						id="place" name="place" required="true"></form:input>
					<span class="help-block"></span>
				</div>
				<div class="form-group">
					<form:label path="dateOfEvent" for="dateOfEvent"
						class="lead control-label">Date</form:label>
					<form:input path="dateOfEvent" type="text"
						class="form-control" value="YYYY-MM-DD" id="dateOfEvent"
						name="dateOfEvent" required="true"></form:input>
					<span class="help-block"></span>
				</div>
				<div class="form-group">
					<form:label path="timeOfEvent" for="timeOfEvent"
						class="lead control-label">Time</form:label>
					<form:input path="timeOfEvent" type="text" class="form-control"
						id="timeOfEvent" name="timeOfEvent" required="true"></form:input>
					<span class="help-block"></span>
				</div>
				<div class="form-group">
					<form:label path="subtitle" for="subtitle"
						class="lead control-label">Subtitle</form:label>
					<form:input path="subtitle" type="text" class="form-control"
						id="subtitle" name="subtitle"></form:input>
					<span class="help-block"></span>
				</div>
				<div class="form-group">
					<form:label path="description" for="description"
						class="lead control-label">Description</form:label>
					<form:input path="description" type="text" class="form-control"
						id="description" name="description"></form:input>
					<span class="help-block"></span>
				</div>
				<div class="lead control-label">You can choose max three types of tickets</div>
				<div class="form-group">
					<form:label path="ticket1Quantity" for="ticket1Quantity"
						class="lead control-label">Ticket 1: Quantity</form:label>
					<form:input path="ticket1Quantity" type="text" class="form-control"
						id="ticket1Quantity" name="ticket1Quantity"></form:input>
					<span class="help-block"></span>

					<form:label path="ticket1Cost" for="ticket1Cost"
						class="lead control-label">Ticket 1: Cost</form:label>
					<form:input path="ticket1Cost" type="text" class="form-control"
						id="ticket1Cost" name="ticket1Cost"></form:input>
					<span class="help-block"></span>
				</div>
				<div class="form-group">
					<form:label path="ticket2Quantity" for="ticket2Quantity"
						class="lead control-label">Ticket 2: Quantity</form:label>
					<form:input path="ticket2Quantity" type="text" class="form-control"
						id="ticket2Quantity" name="ticket2Quantity"></form:input>
					<span class="help-block"></span>

					<form:label path="ticket2Cost" for="ticket2Cost"
						class="lead control-label">Ticket 2: Cost</form:label>
					<form:input path="ticket2Cost" type="text" class="form-control"
						id="ticket2Cost" name="ticket2Cost"></form:input>
					<span class="help-block"></span>
				</div>
				<div class="form-group">
					<form:label path="ticket3Quantity" for="ticket3Quantity"
						class="lead control-label">Ticket 3: Quantity</form:label>
					<form:input path="ticket3Quantity" type="text" class="form-control"
						id="ticket3Quantity" name="ticket3Quantity"></form:input>
					<span class="help-block"></span>

					<form:label path="ticket3Cost" for="ticket3Cost"
						class="lead control-label">Ticket 3: Cost</form:label>
					<form:input path="ticket3Cost" type="text" class="form-control"
						id="ticket3Cost" name="ticket3Cost"></form:input>
					<span class="help-block"></span>
				</div>
				<div class="form-group">
					<form:label path="picture" for="picture" class="lead control-label">Picture</form:label>
					<form:input path="picture" type="file" id="picture" name="picture"></form:input>
					<span class="help-block"></span>
				</div>
<div class="form-group">
					<form:label path="backgroundFile" for="backgroundFile"
						class="lead control-label">Background for participant list</form:label>
					<form:input path="backgroundFile" type="file" id="backgroundFile"
						name="backgroundFile"></form:input>

					<span class="help-block"></span>
				</div>

				<button id="submit_btn" class="btn btn-lg btn-success btn-block"
					type="submit">Create event</button>
			</form:form>
		</div>
	</div>


	<jsp:include page="/resources/footer.jsp" />