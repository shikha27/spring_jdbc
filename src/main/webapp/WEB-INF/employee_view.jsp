<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>EMPLOYEE LIST</h2>

	<table border="2" width="70%" cellpadding="2">

		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Salary</th>
			<th>Department</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		<c:forEach var="employee" items="${multipleEmployees}">
			<tr>
				<td>${employee.id}</td>
				<td>${employee.name}</td>
				<td>${employee.salary}</td>
				<td>${employee.department}</td>
				<td><a href="update/${employee.id}">Edit</a></td>
				<td><a href="delete/${employee.id}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	</br>
	<a href="add">Add New employees</a>
</body>
</html>