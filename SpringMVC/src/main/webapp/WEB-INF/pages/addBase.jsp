<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Spring 3 MVC Series - Contact Manager</title>
</head>
<body>
<h2>Contact Manager</h2>
<form:form method="post" action="addBase" modelAttribute="base">
 
    <table>
   
    <tr>
        <td><form:label path="name">name</form:label></td>
        <td><form:input path="name" /></td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit" value="Add Base"/>
        </td>
    </tr>
</table>  
     
</form:form>
</body>
</html>