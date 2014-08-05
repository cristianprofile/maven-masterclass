<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>



<html>


<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cristian Romero Example</title>
<link type="text/css"
	href="<%=request.getContextPath()%>/resources/css/bootstrap.css"
	rel="stylesheet" />
</head>
<body>


	<div class="container" style="padding-top: 1em;">
		<h1>Base repository</h1>
		<c:if test="${! empty findAllBases}">
			<table class="table table-striped table-bordered table-condensed"
				width="647">
				<thead>
					<tr>
						<th>Id</th>
						<th>Name</th>
					</tr>
				</thead>
				<tbody>


					<c:forEach var="base" items="${findAllBases}">
						<tr>
							<td><c:out value="${base.id}"></c:out></td>
							<td><c:out value="${base.name}"></c:out></td>
						</tr>

					</c:forEach>

				</tbody>
			</table>
		</c:if>
		<c:if test="${empty findAllBases}">
			Empty repository, ....
		</c:if>
		<a role="button" class="btn btn-success btn-large"
			href="<c:url value="/addBase"/>">Add new base of pizza</a>
	</div>

</body>
</html>

