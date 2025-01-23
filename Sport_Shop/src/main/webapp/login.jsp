<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Login Page</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <style>
      body {
        background-color: #f4f4f9;
      }
      .navbar {
        background-color: #ffc107; /* Yellow color */
      }
      .navbar-brand {
        font-weight: bold;
        color: black !important;
      }
      .navbar-nav .nav-link {
        color: black !important;
      }
      .navbar-nav .nav-link:hover {
        color: #fff !important;
      }
      .container {
        max-width: 500px;
        margin-top: 50px;
      }
      .card {
        background-color: #333333; /* Black background */
        padding: 20px;
        border-radius: 8px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        color: white;
      }
      .btn-primary {
        background-color: #ffc107; /* Yellow color */
        border: none;
      }
      .btn-primary:hover {
        background-color: #e0a800; /* Darker yellow */
      }
      .btn-warning {
        background-color: #ffc107;
        border: none;
      }
      .btn-warning:hover {
        background-color: #e0a800;
      }
      .form-label {
        color: #fff;
      }
      .form-control {
        background-color: #444444; /* Dark grey for inputs */
        border: 1px solid #ccc;
        color: white;
      }
      .form-control:focus {
        background-color: #555555; /* Slightly lighter grey */
        border-color: #ffc107;
        color: white;
      }
    </style>
  </head>
  <body>

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
    <!-- Login Form -->
    <div class="container">
      <div class="text-end">
        <a class="btn btn-warning btn-lg" href="register.html">New User? Register Here</a>
      </div>

      <div class="card mt-4">
        <h3 class="text-center mb-4">Login to Your Account</h3>
        <form method="post" action="LoginServlet">
          <div class="mb-3">
            <label for="txtusername" class="form-label">User Name</label>
            <input type="text" name="txtusername" class="form-control" id="txtusername" placeholder="Enter User Name">
          </div>
          <div class="mb-3">
            <label for="txtpassword" class="form-label">Password</label>
            <input type="password" name="txtpassword" class="form-control" id="txtpassword" placeholder="Enter Password">
          </div>
          <div class="text-center">
            <button type="submit" class="btn btn-primary btn-lg">Login</button>
          </div>
        </form>
      </div>
    </div>

    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
  </body>
</html>
