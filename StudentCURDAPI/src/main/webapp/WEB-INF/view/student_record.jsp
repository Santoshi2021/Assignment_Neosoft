<%@ page isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:choose>
	<c:when test="${!empty student}">
		<h1 style="color: blue; text-align: center">Student Details</h1>

		<table border="0" bgcolor="cyan" align="center">
			<tr>
				<td>Student ID ::</td>
				<td>${student.id}</td>
			</tr>
			<tr>
				<td>First Name ::</td>
				<td>${student.fname}</td>
			</tr>
			<tr>
				<td>Last Name ::</td>
				<td>${student.lname}</td>
			</tr>
			<tr>
				<td>Mobile Number ::</td>
				<td>${student.mobile}</td>
			</tr>
			<tr>
				<td>Email Id ::</td>
				<td>${student.email}</td>
			</tr>
			<tr>
				<td>Project Name ::</td>
				<td>${student.project.pname}</td>
			</tr>
			<tr>
				<td>Duration ::</td>
				<td>${student.project.duration}</td>
			</tr>
		</table>
	</c:when>
	<c:otherwise>
		<h1 style="color: red; text-align: center">Records not found</h1>
	</c:otherwise>
</c:choose>
<br>
<h1 style="text-align: center">
	<a href="./">Home </a>
</h1>