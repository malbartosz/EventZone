<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="fixedElement">
		<nav class="navbar navbar-inverse" role="navigation">
		  <!-- Brand and toggle get grouped for better mobile display -->
		  <div class="navbar-header">
		    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
		      <span class="sr-only">Toggle navigation</span>
		      <span class="icon-bar"></span>
		      <span class="icon-bar"></span>
		      <span class="icon-bar"></span>
		    </button>
		    <a class="navbar-brand" href="/EventZone/">EventZone</a>
		  </div>
		
		  <!-- Collect the nav links, forms, and other content for toggling -->
		  <div class="collapse navbar-collapse navbar-ex1-collapse">
		    <ul class="nav navbar-nav">
		      <li ><a href="<c:url value='/main' />">Home</a></li>
		      <li class="dropdown active">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Events<span class="caret"></span></a>
                <ul class="dropdown-menu" role="menu">
                  <li><a href="<c:url value='/main/event/create'/>">Create an Event</a></li>
                  <li><a href="/EventZone/main/listForOrganizer/">Manage my Events</a></li>
                  <li class="divider"></li>
                  <li><a href="main/event/find">Find an Event</a></li>
                  <li><a href="/EventZone/main/listForParticipant">Manage subscribed Events</a></li>
                </ul>
              </li>
              <li ><a href="#">My Tickets</a></li>
              <li class="divider"></li>
		      <li><a href="<c:url value="/j_spring_security_logout" />">Logout</a></li>
		    </ul>
		  </div><!-- /.navbar-collapse -->
		</nav>
	</div>