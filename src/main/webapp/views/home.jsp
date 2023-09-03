<%@page import="io.micrometer.common.util.StringUtils"%>
<%@page import="com.school.SchoolDemoProject.Dto.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous" />
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
	crossorigin="anonymous"></script>
<title>School</title>
<link rel="stylesheet" href="./css/home.css" />
</head>
<body>
	<%
	if (session.getAttribute("validated") == null || (Boolean) session.getAttribute("validated") == false) {
	%>
	<h1>Session expired</h1>
	<%
	} else {
	%>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container-fluid">
			<a class="navbar-brand" href="/home">School</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="addstudentdetails">Add Student</a></li>
				</ul>
				<div class="d-flex">
					<a class="btn btn-outline-success" href="#"> LOGOUT </a>
				</div>
			</div>
		</div>
	</nav>
	<div class="container container-adj-without-border">
		<%
		try {
			List<Student> students = (List<Student>) session.getAttribute("students");
			if (students.size() < 1) {
		%>
		<h2>No Record Present</h2>
		<hr />
		<%
		} else {
		%>
		<table class="table table-striped table-hover">
			<h2>All Students List</h2>
			<hr />
			<thead>
				<tr class="table-dark">
					<th scope="col">ID</th>
					<th scope="col">Name</th>
					<th scope="col">Gender</th>
					<th scope="col">Class</th>
					<th scope="col">Action</th>
				</tr>
			</thead>
			<tbody>
				<%
				for (Student student : students) {
				%>
				<tr>
					<th scope="row"><%=student.getSid()%></th>
					<td><%=intCap(student.getFirstName()) + " " + intCap(student.getLastName())%></td>
					<td><%=intCap(student.getGender())%></td>
					<td><%=student.getSclass()%></td>
					<td><a href="#" class="btn btn-outline-primary">View
							Details</a></td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
		<%
		}
		} catch (Exception e) {
		e.printStackTrace();
		%>
		<h2>Something Went Wrong</h2>
		<%
		}
		%>
	</div>
</body>
<%
}
%>
<%!private String intCap(String str) {
		if (str.length() == 1) {
			return str.toUpperCase();
		} else {
			return String.valueOf(str.charAt(0)).toUpperCase() + str.substring(1).toLowerCase();
		}
	}%>
}
</html>
