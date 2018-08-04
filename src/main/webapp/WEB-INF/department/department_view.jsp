<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2 style="background-color: LightGray;">DEPARTMENT LIST</h2>

	<table border="2" width="70%" cellpadding="2">

		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Location</th>
			<th>Bonus</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		<c:forEach var="department" items="${multipleDepartments}">
			<tr>
				<td>${department.id}</td>
				<td>${department.name}</td>
				<td>${department.location}</td>
				<td>${department.bonus}</td>
				<td><a href="update/${department.id}">Edit</a></td>
				<td><a href="delete/${department.id}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	</br>
	<a href="add">Add New Department</a></br><br>
	<a href="/employee_repository/index.jsp">HOME</a>
</body>
</html>