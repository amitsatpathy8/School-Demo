<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous" />
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
	crossorigin="anonymous"></script>

<title>Maintenance</title>
</head>

<script type="text/javascript">
	function home() {
		window.location.href = "http://localhost:8080/";
	}
</script>
<body>
	<div class="container" style="margin-top: 5%;width:60% ;border-style: solid;border-width: 2px;border-radius: 4px;padding: 25px 15px">
		<div class="row">
			<h2 class="col-12 text-center">Under Maintenance... Request
				might take time.</h2>
				<div class="col-12 text-center">
				<button class="btn btn-outline-success" onclick="home()">Move
					to Home Page</button>
			</div>
		</div>
	</div>
</body>
</html>