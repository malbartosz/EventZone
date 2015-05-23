<!-- When creating new .jsp file just copy code at the bottom  -->

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/resources/head.jsp" />
<jsp:include page="../navbar.jsp" />
	
	
	<div class="Container">
		
		<div class="top">
	      	<h2>Welcome <c:out value="${username}"></c:out>!
	      		This is a page to create new event!
	      	</h2>
		</div>
	</div>
		
		
<jsp:include page="/resources/footer.jsp" />