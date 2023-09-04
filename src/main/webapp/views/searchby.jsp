<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<style>
.visibility {
	visibility: hidden;
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
					<li class="nav-item"><button class="btn nav-link"
							aria-current="page" onclick="addstudent()">Add Student</button></li>
					<li class="nav-item"><button class="btn nav-link"
							aria-current="page" onclick="search()">Search</button></li>
				</ul>
				<div class="d-flex">
					<button class="btn btn-outline-success" onclick="logout()">
						LOGOUT</button>
				</div>
			</div>
		</div>
	</nav>

	<div class="container container-adj-without-border">
		<div class="row">
			<div class="mb-3 col-6">
				<label class="form-label lable-adj">Select Seach Type</label> <select
					name="searchBy" class="form-control" id="searchType">
					<option value="select" selected>--select search type--</option>
					<option value="sclass">Search By Class</option>
					<option value="name">Search By Name</option>
					<option value="email">Search By Email</option>
					<option value="gender">Search By Gender</option>
					<!-- <option value="contact">Search By Phone</option> -->
					<option value="city">Search By City</option>
					<option value="state">Search By State</option>
					<option value="country">Search By Country</option>
				</select>
			</div>
		</div>
		<div class="row visibility" id="keywordField">
			<div class="mb-3 col-6">
				<input type="text" name="keyword" id="keyword" class="form-control"
					placeholder="Search Keyword" />
			</div>
			<div class="col-6">
				<button onclick="findData()" class="btn btn-primary">Search</button>
			</div>
		</div>
	</div>
</body>
<script>
	let searchType = document.getElementById("searchType");
	let keywordField = document.getElementById("keywordField");

	searchType.addEventListener("change", function() {
		console.log("Working", searchType.value);
		if (searchType.value == "select") {
			if (!(keywordField.classList.contains("visibility") == true))
				keywordField.classList.add("visibility");
		} else {
			keywordField.classList.remove("visibility");
		}
	});

	function findData() {
		let keyword = document.getElementById("keyword").value;
		window.location.href = "http://localhost:8080/result/"
				+ searchType.value + "/" + keyword;
	}
</script>
<%
}
%>
</html>
