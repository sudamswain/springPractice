<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>home screen</title>
<style>
td{
	border:1px solid green;
}
</style>
</head>
<body>
<h2><a href="empSave.html">INSERT EMPLOYEE</a></h2>
<h2></h2>
<h2>Employee List</h2>
<table style="border: 1px solid black;">
	<tr>
		<th>Emp Num</th>
		<th>Name</th>
		<th>Job</th>
		<th>Manager Id</th>
		<th>Hiredate</th>
		<th>sal</th>
		<th>comm</th>
		<th>dept no</th>
	</tr>
		
	<c:forEach var="emp" items="${map.employees}" >
		<tr>
			<td>${emp.empno}</td>
			<td>${emp.ename}</td>
			<td>${emp.job}</td>
			<td>${emp.mgr}</td>
			<td>${emp.hiredate}</td>
			<td>${emp.sal}</td>
			<td>${emp.comm}</td>
			<td>${emp.deptno}</td>
		</tr>
	</c:forEach>
</table>

</body>
</html>