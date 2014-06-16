<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>



<html>
<body>
	<h1>PIZZA BASES</h1>
		
	<table border="1">
		<c:if test="${! empty findAllBases}">
			<c:forEach var="base" items="${findAllBases}">
			<tr>
			    <td><c:out value="${base.name}"></c:out></td>
			</tr>
			</c:forEach>
		</c:if>
		
		<c:if test="${empty findAllBases}">
		  <tr>
			    <td><c:out value="EMPTY!!!"></c:out></td>
			</tr>
		</c:if>
	</table>

	<br>

	
	<a href="<c:url value="/addBase"/>">Add new base of pizza</a>
	
</body>
</html>