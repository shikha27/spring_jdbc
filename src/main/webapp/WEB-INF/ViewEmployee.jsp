<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored = "false" %> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Employee List</h2>

<form method="POST" action="/employee_repository/ViewEmployee">
   <table border="2" width="70%" cellpadding="2">
   
    <tr><th>Id</th><th>Name</th><th>Salary</th><th>Department</th><th>Edit</th><th>Delete</th></tr>  
   <c:forEach var="emp" items="${list123}">   
   <tr>  
   <td>${emp.id}</td>  
   <td>${emp.name}</td>  
   <td>${emp.salary}</td>  
   <td>${emp.department}</td>  
    <td><a href="Update/${emp.id}">Edit</a></td>  
   <td><a href="deleteemp/${emp.id}">Delete</a></td>
   </tr>  
   </c:forEach>
</table> 
</br>
<a href="AddEmployee">Add New Employees</a>
</form> 
</body>
</html>