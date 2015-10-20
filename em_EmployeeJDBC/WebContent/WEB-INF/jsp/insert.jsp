<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Insert Employee</h1>
	<form action="empSave.html" method="post" style="border:5px solid green;background-color: lemonchiffon;font-weight: bolder; color:maroon;">
	<pre>
	Emp No    * :<input type="text" name="empno" />
	
	Emp name  * :<input type="text" name="ename" />
	
	Job       * :<select name="job" style="width:173px">
				<c:forEach var="job" items="${map.jobs}">
					<option value="${job}" >${job}</option>
				</c:forEach>
			    </select>
			    
	Manager     :<select name="mgr" style="width:173px;allign:center">
			   <option value="select" selected>select</option>
				<c:forEach var="mgr" items="${map.mgrs}">
					<option value="${mgr.empno}" >${mgr.ename}</option>
				</c:forEach>
			   </select>
			   
	HireDate    :<input type="text" name="hiredate" />
	
	Salary    * :<input type="text" name="sal" />
	
	Commission  :<input type="text" name="comm" />
	
	Dept no   * :<select name="deptno" style="width:173px;allign:center">
				<c:forEach var="deptno" items="${map.depts}">
					<option value="${deptno}" >${deptno}</option>
				</c:forEach>
			   </select>
			   
			<input type="submit" value="save employee" />
	</pre>
	</form>
</body>
</html>