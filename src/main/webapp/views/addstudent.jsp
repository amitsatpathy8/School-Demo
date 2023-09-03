<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="student"
	uri="http://www.springframework.org/tags/form"%>
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
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container-fluid">
			<a class="navbar-brand" href="home">School</a>
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
	<div class="container container-adj">
		<student:form action="saveStudent" method="post"
			modelAttribute="studentDetails">
			<div class="mb-3">
				<%
				if ((Boolean) session.getAttribute("invalidDetails") == true) {
				%>
				<h2 style="color: red;">Fill Details Carefully</h2>
				<%
				} else {
				%>
				<h2>Add Student Details</h2>
				<%
				}
				%>
				<hr />
			</div>
			<div class="row">
				<div class="mb-3 col-6">
					<label class="form-label lable-adj">First Name</label>
					<student:input type="text" path="firstName" class="form-control"
						placeholder="Enter Student's Firstname" required="required" />
				</div>
				<div class="mb-3 col-6">
					<label class="form-label lable-adj">Last Name</label>
					<student:input type="text" path="lastName" class="form-control"
						placeholder="Enter Student's Lastname" required="required" />
				</div>
			</div>

			<div class="row">
				<div class="mb-3 col-6">
					<label class="form-label lable-adj">Email Address</label>
					<student:input type="email" path="email" class="form-control"
						placeholder="Enter Student Email" required="required" />
				</div>
				<div class="mb-3 col-6">
					<label class="form-label lable-adj">Contact Number</label>
					<student:input type="number" path="phone" class="form-control"
						placeholder="Enter Parent Contact Number" required="required" />
				</div>
			</div>

			<div class="row">
				<div class="mb-3 col-6">
					<label class="form-label lable-adj">Class</label>
					<student:select path="sclass" class="form-control"
						name="class_standard" required="required">
						<student:option value="none">--select class--</student:option>
						<student:option value="1">1st</student:option>
						<student:option value="2">2nd</student:option>
						<student:option value="3">3rd</student:option>
						<student:option value="4">4th</student:option>
						<student:option value="5">5th</student:option>
						<student:option value="6">6th</student:option>
						<student:option value="7">7th</student:option>
						<student:option value="8">8th</student:option>
						<student:option value="9">9th</student:option>
						<student:option value="10">10th</student:option>
					</student:select>
				</div>
				<div class="mb-3 col-6">
					<label class="form-label lable-adj" style="margin-right: 10px">Gender</label>
					<div class="form-control"
						style="border-style: none; padding-left: 0px">
						<student:radiobutton path="gender" name="gender" value="MALE"
							checked="checked" required="required" />
						Male
						<student:radiobutton path="gender" name="gender" value="FEMALE"
							required="required" />
						Female
						<student:radiobutton path="gender" name="gender" value="OTHER"
							required="required" />
						Other
					</div>
				</div>
			</div>

			<div class="row">
				<div class="mb-3 col-6">
					<label class="form-label lable-adj">City Name</label>
					<student:input type="text" path="city" class="form-control"
						placeholder="Enter Student's Permanent City Name"
						required="required" />
				</div>
				<div class="mb-3 col-6">
					<label class="form-label lable-adj">State Name</label>
					<student:input type="text" path="state" class="form-control"
						placeholder="Enter Student's Permanent State Name"
						required="required" />
				</div>
			</div>
			<div class="row">
				<div class="mb-3 col-6">
					<label class="form-label lable-adj">Country Name</label>
					<student:input type="text" path="country" class="form-control"
						placeholder="Enter Student's Permanent Country Name"
						required="required" />
				</div>
				<div class="col-6">
					<div class="form-label">DOB</div>
					<student:input type="date" path="dob" class="form-control"
						required="required" />
				</div>
			</div>
			<div class="row">
				<div class="col-6">
					<student:button type="submit" class="btn btn-success">Add Student</student:button>
				</div>
			</div>
		</student:form>
	</div>
</body>
</html>
