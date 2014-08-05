<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Spring 3 MVC Series - Pizza example</title>
</head>
<body>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cristian Romero Example</title>
<link type="text/css"
	href="<%=request.getContextPath()%>/resources/css/bootstrap.css"
	rel="stylesheet" />
</head>
<body>


	<div class="container">
		<h1>New Base view</h1>
		<form:form method="post" action="addBase" modelAttribute="base"
			role="form" class="form-horizontal">
			<div class="form-group">

				<form:label for="name" path="name">Base</form:label>


				<form:input path="name" placeholder="Enter name" />
				<font color='red'><form:errors path='name' /></font>

			</div>

			<div class="form-group">
				<button type="submit" class="btn btn-success btn-large">Submit</button>
			</div>


		</form:form>
	</div>

</body>
</html>