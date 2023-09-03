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
      crossorigin="anonymous"
    />
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
      crossorigin="anonymous"
    ></script>
    <title>School</title>
    <link rel="stylesheet" href="./css/home.css" />
  </head>
  <body>
  <%System.out.println(session.getAttribute("validated")); if (session.getAttribute("validated")==null || (Boolean)session.getAttribute("validated")== false){ %>
      <h1>Session expired</h1>
      <%} else{%>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
      <div class="container-fluid">
        <a class="navbar-brand" href="/home">School</a>
        <button
          class="navbar-toggler"
          type="button"
          data-bs-toggle="collapse"
          data-bs-target="#navbarSupportedContent"
          aria-controls="navbarSupportedContent"
          aria-expanded="false"
          aria-label="Toggle navigation"
        >
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
          <ul class="navbar-nav me-auto mb-2 mb-lg-0">
            <li class="nav-item">
              <a
                class="nav-link active"
                aria-current="page"
                href="addstudentdetails"
                >Add Student</a
              >
            </li>
          </ul>
          <div class="d-flex">
            <a class="btn btn-outline-success" href="#"> LOGOUT </a>
          </div>
        </div>
      </div>
    </nav>
    <div class="container container-adj-without-border">
      <h2>No Record Present</h2>
      <hr />
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
          <tr>
            <th scope="row">1</th>
            <td>Mark</td>
            <td>Otto</td>
            <td>@mdo</td>
            <td>
              <a href="viewdetails.html" class="btn btn-outline-primary"
                >View Details</a
              >
            </td>
          </tr>
          <tr>
            <th scope="row">2</th>
            <td>Jacob</td>
            <td>Thornton</td>
            <td>@fat</td>
            <td>
              <a type="submit" class="btn btn-outline-primary">View Details</a>
            </td>
          </tr>
          <tr>
            <th scope="row">3</th>
            <td>Larry the Bird</td>
            <td>Larry the Bird</td>
            <td>@twitter</td>
            <td>
              <a type="submit" class="btn btn-outline-primary">View Details</a>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
  </body>
  <%} %>
</html>
