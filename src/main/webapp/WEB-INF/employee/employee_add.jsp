<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Employee</title>
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
	<h1>ADD EMPLOYEE DETAILS</h1>
	<form method="POST" action="add">
		<label for="id">Id</label> <input type="text" name="id"> <label
			for="name">Name</label> <input type="text" name="name"> <label
			for="salary">Salary</label> <input type="text" name="salary">
		<label for="department">Department</label> <input type="text"
			name="department"><label for="departmentid">Department Id</label> <input type="text"
			name="departmentid">
			<br> <br> <input type="submit"
			value="Submit">

	</form>
</body>
</html>