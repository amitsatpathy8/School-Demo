<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>School</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous" />
<link rel="stylesheet" href="./css/home.css" />
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
	crossorigin="anonymous"></script>
<style>
.container {
	margin-top: 10%;
	border-style: solid;
	border-width: 5px;
	padding: 10px 10px;
	border-radius: 10px;
}

.form-div {
	padding: 50px 50px;
	border-style: none;
}
</style>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-6">
				<img src="./assets/first.jpg" class="img-fluid" />
			</div>
			<div class="col-6 form-div">
				<h2>Welcome</h2>
				<hr />
				<form action="loginValidation" method="post">
					<div class="mb-3">
						<label class="form-label lable-adj">Email
							address</label> <input type="email" name="email" class="form-control" />
						<div id="emailHelp" class="form-text">We never share your
							email with anyone else.</div>
					</div>
					<div class="mb-3">
						<label class="form-label lable-adj">Password</label>
						<input type="password" name="pass" class="form-control"
						 />
					</div>

					<button type="submit" class="btn btn-primary">Login</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
