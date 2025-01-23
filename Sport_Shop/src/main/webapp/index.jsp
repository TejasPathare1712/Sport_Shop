<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home Page</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <style>
        .carousel-item {
            height: 600px; /* Set a fixed height for the carousel items */
        }
        .carousel-item img {
            object-fit: contain; /* Ensure the images are fully visible within the carousel area */
            height: 100%; /* Make the images take the full height of the carousel items */
            width: 100%; /* Make the images take the full width of the carousel items */
        }
        .custom-card {
            width: 18rem;
            
        }
    </style>
    
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
      <div id="carouselExampleAutoplaying" class="carousel slide" data-bs-ride="carousel">
        <div class="carousel-inner">
          <div class="carousel-item active">
            <img src="tennis.jpg" class="d-block w-100" alt="Tennis">
          </div>
          <div class="carousel-item">
            <img src="Table Tennis.jpg" class="d-block w-100" alt="Table Tennis">
          </div>
          <div class="carousel-item">
            <img src="badminton.jpg" class="d-block w-100" alt="Badminton">
          </div>
        </div>
        <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleAutoplaying" data-bs-slide="prev">
          <span class="carousel-control-prev-icon" aria-hidden="true"></span>
          <span class="visually-hidden">Previous</span>
        </button>
        <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleAutoplaying" data-bs-slide="next">
          <span class="carousel-control-next-icon" aria-hidden="true"></span>
          <span class="visually-hidden">Next</span>
        </button>
      </div>
      <div class="container">
        <div class="row">
             <div class="col-md-3 mt-5">
                    <div class="card custom-card" >
                        <img src="cricket1.jpg" alt="" class="card-img-top">
                        <div class="card-body">
                            <h5 class="card-title">Cricket</h5>
                            <p class="card-text">Premium cricket equipments</p>
                            <a href="Cricket" class="btn btn-primary">Show More</a>
                        </div>
                    </div>
                </div>

            <div class="col-md-3 mt-5">
                <div class="card custom-card" >
                    <img src="Badminton1.jpg" alt="" class="card-img-top">
                    <div class="card-body">
                        <h5 class="card-title">Badminton</h5>
                        <p class="card-text">Premium quality Tennis material</p>
                        <a href="#" class="btn btn-primary">Show More</a>
                    </div>
                </div>
            </div>
                <div class="col-md-3 mt-5">
                    <div class="card custom-card" >
                        <img src="Table Tennis.jpg" alt="" class="card-img-top">
                        <div class="card-body">
                            <h5 class="card-title">Table Tennis</h5>
                            <p class="card-text">Premium Table Tennis Material</p>
                            <a href="#" class="btn btn-primary">Show More</a>
                        </div>
                    </div>
                </div>
                <div class="col-md-3 mt-5">
                    <div class="card custom-card" >
                        <img src="football.jpg" alt="" class="card-img-top">
                        <div class="card-body">
                            <h5 class="card-title">Football</h5>
                            <p class="card-text">Premium Football Material</p>
                            <a href="#" class="btn btn-primary">Show More</a>
                        </div>
                    </div>
                </div>
            </div>
        
      
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>
    