<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<div id="content">
	<legend><spring:message code="users.legend"/></legend>
	<table
		class="table table-bordered table-striped table-hover table-condensed">
		<tr>
			<th><spring:message code="users.table.name"/></th>
			<th>Email</th>
			<th><spring:message code="users.table.role"/></th>
		</tr>
		<c:forEach items="${users}" var="user">
			<tr>
				<td><c:out value="${user.name}" /></td>
				<td><c:out value="${user.email}" /></td> 
				<td><c:out value="${user.role.name}" /></td>
			</tr>
		</c:forEach>
	</table>
</div>
