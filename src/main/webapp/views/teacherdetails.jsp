<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="com.school.SchoolDemoProject.IoModel.TeacherIoModel"%>
<%@page import="com.school.SchoolDemoProject.Dto.Student"%>
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
<style type="text/css">
.container-adj {
	margin-top: 3%;
	width: 80%;
	border-style: solid;
	border-color: black;
	padding: 5% 5%;
}

.container-adj-without-border {
	margin-top: 3%;
	width: 80%;
}

.lable-adj {
	font-weight: 700;
}
</style>
</head>
<body>
	<%
	if (session.getAttribute("validated") == null || (Boolean) session.getAttribute("validated") == false) {
	%>
	<h1>Session expired</h1>
	<%
	} else {
	%>
	<script type="text/javascript">
		function home() {
			window.location.href = "http://localhost:8080/home";
		}
		function addstudent() {
			window.location.href = "http://localhost:8080/addstudentdetails";
		}
		function logout() {
			window.location.href = "http://localhost:8080/logout";
		}
		function search() {
			window.location.href = "http://localhost:8080/searchForm";
		}
		function setting() {
			window.location.href = "http://localhost:8080/setting";
		}
	</script>

	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container-fluid">
			<button class="navbar-brand btn" onclick="home()">School</button>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><button class="btn nav-link active"
							aria-current="page" onclick="addstudent()">Add Student</button></li>
					<li class="nav-item"><button class="btn nav-link"
							aria-current="page" onclick="search()">Search</button></li>
				</ul>
				<div class="d-flex">
					<button class="btn btn-outline-success" style="margin-right: 15px"
						onclick="setting()">Settings</button>
					<button class="btn btn-outline-success" onclick="logout()">
						LOGOUT</button>
				</div>
			</div>
		</div>
	</nav>
	<%
	TeacherIoModel teacher = null;
	try {
		teacher = (TeacherIoModel) request.getAttribute("teacher");
	%>
	<div class="container container-adj-without-border"
		style="width: 75%; margin-top: 5%">
		<div class="card">
			<div class="card-header bg-dark"
				style="color: white; font-weight: 700"><%=intCap(teacher.getFirstName()) + " " + intCap(teacher.getLastName())%></div>
			<div class="card-body">
				<div class="row">
					<div class="col-6">
						<h5 class="card-title">
							<span style="font-weight: 700">First Name</span> :
							<%=intCap(teacher.getFirstName())%>
						</h5>
						<h5 class="card-title">
							<span style="font-weight: 700">Last Name</span> :
							<%=intCap(teacher.getLastName())%>
						</h5>
						<h5 class="card-title">
							<span style="font-weight: 700">Email</span> : <span
								id="studentEmail"><%=teacher.getEmail()%></span>
						</h5>
						<h5 class="card-title">
							<span style="font-weight: 700">Gender</span> :
							<%=intCap(teacher.getGender())%>
						</h5>
					</div>
					<div class="col-6">
						<h5 class="card-title">
							<span style="font-weight: 700">DOB</span> :
							<%=teacher.getDob()%>
						</h5>
						<h5 class="card-title">
							<span style="font-weight: 700">Contact</span> :
							<%=teacher.getPhone()%>
						</h5>

						<h5 class="card-title">
							<span style="font-weight: 700">Subject</span> :
							<%=intCap(teacher.getSubject())%>
						</h5>
						<h5 class="card-title">
							<span style="font-weight: 700">Last Login</span> :
							<%=lastLoginString(teacher.getLastLogin())%>
						</h5>
					</div>
				</div>
				<div style="margin-top: 30px">
				<p style="color: gray; font-style: italic; float: right;">New Features are on the way</p>
				</div>
				<!-- <div style="margin-top: 20px">
					<div class="d-flex" style="float: left;">
						<button class="btn btn-success" style="margin-right: 10px"
							onclick="home()">Back</button>
					</div>
					<div class="d-flex" style="float: right;">
						<button onclick="updateButton()" class="btn btn-warning"
							style="margin-right: 10px">Update Details</button>
						<button onclick="deleteData()" class="btn btn-danger">Delete</button>
					</div>
				</div> -->
			</div>
		</div>
	</div>
	<%
	} catch (Exception e) {
	e.printStackTrace();
	}

	}
	%>

	<%!private String intCap(String str) {
		if (str.length() == 1) {
			return str.toUpperCase();
		} else {
			return String.valueOf(str.charAt(0)).toUpperCase() + str.substring(1).toLowerCase();
		}
	}%>
	<%!private String lastLoginString(LocalDateTime last) {
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mm:ss a");

		String dateStr = last.format(dateFormatter);
		String timeStr = last.format(timeFormatter);
		return dateStr + " " + timeStr.toUpperCase();
	}%>
</body>
<script type="text/javascript">
	let id = document.getElementById("studentId").innerHTML;
	let email = document.getElementById("studentEmail").innerHTML;

	function updateButton() {
		window.location.href = "http://localhost:8080/updatestudentform/" + id;
	}

	function deleteData() {
		let res = confirm("Are you sure you want to delete student details having email : "
				+ email + " ? \n\nOnce deleted can't be reversed.");
		if (res == true) {
			window.location.href = "http://localhost:8080/delete/" + id;
		} else {
			alert("Wow! You just save the record by a single click");
		}
	}
</script>

</html>
