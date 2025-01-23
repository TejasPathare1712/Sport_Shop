<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Page</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body class="bg-success">
    <h1 class="text-dark text-center mt-3 bg-danger">Welcome To Premium Sport shop</h1>
    <nav class="navbar navbar-expand-lg bg-primary mt-3">
        <div class="container-fluid">
          <a class="navbar-brand" href="#">Sports Shop</a>
          <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>
          <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
              <li class="nav-item">
                <a class="nav-link active" aria-current="page" href="index.jsp">Aboutus</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="contact.jsp">Contact</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="login.jsp">Login</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="register.jsp">Register</a>
              </li>
              <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                  Dropdown
                </a>
                <ul class="dropdown-menu">
                  <li><a class="dropdown-item" href="#">cricket</a></li>
                  <li><a class="dropdown-item" href="#">Badminton</a></li>
                  <li><hr class="dropdown-divider"></li>
                  <li><a class="dropdown-item" href="#">Table Tennis</a></li>
                </ul>
              </li>
              
            </ul>
            <form class="d-flex" role="search">
              <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
              <button class="btn btn-outline-success" type="submit">Search</button>
            </form>
          </div>
        </div>
      </nav>
      <!-- Registration form -->
    <div class="container">
        <p class="display-3 text-center">Registration Form </p>
        <form class="row g-3" method="post" action="RegistrationServlet">
            <div class="col-md-6">
                <label for="txtname" name="txtname" class="form-label">Name</label>
                <input type="text" class="form-control" name="txtname" id="txtname">
            </div>
            <div class="col-12">
                <label for="inputAddress" class="form-label">Address</label>
                <input type="text" class="form-control" id=txtaddress" name="txtaddress" placeholder="1234 Main St">
            </div>
            
            <div class="col-md-6">
                <label for="inputCity" class="form-label">City</label>
                <input type="text" class="form-control" id="txtcity" name="txtcity">
            </div>
            <div class="col-md-6">
            <label for="txtemail" name="txtemail" class="form-label">Email</label>
            <input type="email" class="form-control" id="txtemail" name="txtemail">
            </div>
            <div class="col-md-6">
            <label for="txtusername" name="txtusername" class="form-label">UserName</label>
            <input type="text" class="form-control" id="txtusername" name="txtusername">
            </div>
            <div class="col-md-6">
            <label for="inputPassword4" class="form-label">Password</label>
            <input type="password" class="form-control" id="txtpassword" name="txtpassword">
            </div>

            <div class="col-12 text-center">
            <button type="submit" class="btn btn-primary">Register</button>
            </div>
        </form>
    </div>
</body>
</html>