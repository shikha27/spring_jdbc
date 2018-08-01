<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored = "false" %> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update Employee</title>
<style>
input[type=text] {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;         
	box-sizing: border-box;
}
</style>
</head>
<body>
	<h1>UPDATE EMPLOYEE DETAILS</h1>
	<form method="POST" action="/employee_repository/employee/update">
		<label for="id">Id</label> <input type="hidden" value="${singleEmployee.id}" name="id"> <label
			for="name">Name</label> <input type="text" value="${singleEmployee.name}" name="name"> <label
			for="salary">Salary</label> <input type="text" value="${singleEmployee.salary}" name="salary">
		<label for="department">Department</label> <input type="text" value="${singleEmployee.department}"
			name="department"><br> <br> <input type="submit"
			value="Update">

	</form>
</body>
</html>