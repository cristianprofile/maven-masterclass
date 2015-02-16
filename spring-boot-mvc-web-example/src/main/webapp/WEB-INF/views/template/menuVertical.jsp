<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<div id="menu">
	<ul class="nav nav-list well">
		<li class="nav-header">
			<spring:url value="/" var="homeUrl" htmlEscape="true" />
			<a href="${homeUrl}"><spring:message code="menu.home"/></a>
		</li>
		<li class="divider"></li>
		<li class="nav-header">
			<spring:url value="/users" var="usersURL" htmlEscape="true" />
			<a href="${usersURL}"><spring:message code="menu.users"/></a>
		</li>
		<li class="divider"></li>
		<li class="nav-header">
			<spring:url value="/userAdd" var="userAddURL" htmlEscape="true" />
			<a href="${userAddURL}"><spring:message code="menu.userAdd"/></a>
		</li>	
	</ul>
</div>