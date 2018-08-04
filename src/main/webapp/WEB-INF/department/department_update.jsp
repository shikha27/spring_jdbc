<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored = "false" %> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update Department</title>
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
	<h1 style="background-color: LightGray;">UPDATE DEPARTMENT DETAILS</h1>
	<form method="POST" action="/employee_repository/department/update">
		<label for="id">Id</label> <input type="hidden" value="${singleDepartment.id}" name="id"> <label
			for="name">Name</label> <input type="text" value="${singleDepartment.name}" name="name"> <label
			for="salary">Location</label> <input type="text" value="${singleDepartment.location}" name="location">
		<label for="department">Bonus</label> <input type="text" value="${singleDepartment.bonus}"
			name="bonus">
			
			<br> <br> <input type="submit"
			value="Update">

	</form>
</body>
</html>