<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Spring 3 MVC Series - Pizza example</title>
</head>
<body>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pizza example</title>
<link type="text/css"
	href="<%=request.getContextPath()%>/resources/css/bootstrap.css"
	rel="stylesheet" />
</head>
<body>


	<div class="container" style="padding-top: 1em;">
		<h1>New Base view</h1>
		<form:form method="post" action="addBase" modelAttribute="base"
			role="form">
			<div class="form-group">

				<form:label for="name" path="name">Base</form:label>
				<font color='red'><form:errors path='name' /></font>
				<form:input class="form-control" path="name"
					placeholder="Enter name" />

			</div>

			<button type="submit" class="btn btn-success btn-large">Submit</button>
		</form:form>
	</div>

</body>
</html>