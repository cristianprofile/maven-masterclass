<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<div id="menu">
	<ul class="nav nav-list well">
		<li class="nav-header">
			<spring:url value="/info" var="infoUrl" htmlEscape="true" />
			<a href="${infoUrl}"><spring:message code="menu.home"/></a>
		</li>
		<li class="divider"></li>
		<li class="nav-header">
			<spring:url value="/pizzas" var="pizzas" htmlEscape="true" />
			<a href="${pizzas}"><spring:message code="menu.pizzas"/></a>
		</li>
		
	</ul>
</div>