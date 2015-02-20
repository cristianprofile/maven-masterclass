<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<div id="content">
	<p>
		<spring:url value="/info" var="pizzasURL" htmlEscape="true" />
		<a href="${pizzasURL}"><spring:message code="home.text" /></a>
	</p>
</div>
