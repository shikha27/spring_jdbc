<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Department Here</title>
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
<h1>ADD DEPARTMENT DETAILS</h1>
	<form method="POST" action="add">
		<label for="id">Id</label> <input type="text" name="id"> <label
			for="name">Name</label> <input type="text" name="name"> <label
			for="location">Location</label> <input type="text" name="location">
		<label for="bonus">Bonus</label> <input type="text"
			name="bonus">
			<br> <br> <input type="submit"
			value="Submit">

	</form>
</body>
</html>