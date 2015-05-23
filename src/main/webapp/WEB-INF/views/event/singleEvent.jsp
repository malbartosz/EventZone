<!-- When creating new .jsp file just copy code at the bottom  -->

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/resources/head.jsp" />
<jsp:include page="../navbar.jsp" />
	
	
	
	<div class="Container">
		
		<div class="top">
	      	<h2>Welcome <c:out value="${username}"></c:out>!
	      		This is a single event page!
	      		Event Name: <c:out value="${event.name}"></c:out>
	      	</h2>
	      	<br>Description: "${event.description}"
	      	<br>Place: "${event.place}"
	      	<br>Name: "${event.name}"
		</div>
	</div>
		
		
<jsp:include page="/resources/footer.jsp" />