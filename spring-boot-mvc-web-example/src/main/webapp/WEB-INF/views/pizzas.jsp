<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<div id="content">
	<legend><spring:message code="pizzas.legend"/></legend>
	<table
		class="table table-bordered table-striped table-hover table-condensed">
		<tr>
			<th><spring:message code="pizzas.table.id"/></th>
			<th><spring:message code="pizzas.table.name"/></th>
		</tr>
		<c:forEach items="${pizzas}" var="pizza">
			<tr>
				<td><c:out value="${pizza.name}" /></td>
				<td><c:out value="${pizza.email}" /></td> 
			</tr>
		</c:forEach>
	</table>
</div>
