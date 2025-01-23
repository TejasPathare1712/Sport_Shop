package com.demo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CartServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		int productId = Integer.parseInt(request.getParameter("pid")); // Fetch book ID from request

		HttpSession session = request.getSession();
		Integer userId = (Integer) session.getAttribute("id"); // Fetch user ID from session
		
		out.println("<!DOCTYPE html>");
        out.println("<html lang='en'>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");

     
        out.println("<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css' rel='stylesheet' integrity='sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH' crossorigin='anonymous'>");
        out.println("<script src='https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js' integrity='sha384-sF7hBtEq0qK+AcFzT0PBGpc6a3YtUCAUP0XmXXZnYuyjDPh4KWhp7PI17NTR57+q' crossorigin='anonymous'></script>");

        out.println("<title>Bootstrap in Servlet</title>");
        out.println("</head>");
        out.println("<body>");

		if (userId == null) {
			out.println("<!DOCTYPE html>\r\n"
					+ "<html lang=\"en\">\r\n"
					+ "<head>\r\n"
					+ "    <meta charset=\"UTF-8\">\r\n"
					+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
					+ "    <title>Home Page</title>\r\n"
					+ "    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH\" crossorigin=\"anonymous\">\r\n"
					+ "    <style>\r\n"
					+ "        .carousel-item {\r\n"
					+ "            height: 600px; /* Set a fixed height for the carousel items */\r\n"
					+ "        }\r\n"
					+ "        .carousel-item img {\r\n"
					+ "            object-fit: contain; /* Ensure the images are fully visible within the carousel area */\r\n"
					+ "            height: 100%; /* Make the images take the full height of the carousel items */\r\n"
					+ "            width: 100%; /* Make the images take the full width of the carousel items */\r\n"
					+ "        }\r\n"
					+ "        .custom-card {\r\n"
					+ "            width: 18rem;\r\n"
					+ "            \r\n"
					+ "        }\r\n"
					+ "    </style>\r\n"
					+ "    \r\n"
					+ "</head>\r\n"
					+ "<body class=\"bg-success\">\r\n"
					+ "    <h1 class=\"text-dark text-center mt-3 bg-danger\">Welcome To Premium Sport shop</h1>\r\n"
					+ "    <nav class=\"navbar navbar-expand-lg bg-primary mt-3\">\r\n"
					+ "        <div class=\"container-fluid\">\r\n"
					+ "          <a class=\"navbar-brand\" href=\"#\">Sports Shop</a>\r\n"
					+ "          <button class=\"navbar-toggler\" type=\"button\" data-bs-toggle=\"collapse\" data-bs-target=\"#navbarSupportedContent\" aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\r\n"
					+ "            <span class=\"navbar-toggler-icon\"></span>\r\n"
					+ "          </button>\r\n"
					+ "          <div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">\r\n"
					+ "            <ul class=\"navbar-nav me-auto mb-2 mb-lg-0\">\r\n"
					+ "              <li class=\"nav-item\">\r\n"
					+ "                <a class=\"nav-link active\" aria-current=\"page\" href=\"index.jsp\">Aboutus</a>\r\n"
					+ "              </li>\r\n"
					+ "              <li class=\"nav-item\">\r\n"
					+ "                <a class=\"nav-link\" href=\"contact.jsp\">Contact</a>\r\n"
					+ "              </li>\r\n"
					+ "              <li class=\"nav-item\">\r\n"
					+ "                <a class=\"nav-link\" href=\"login.jsp\">Login</a>\r\n"
					+ "              </li>\r\n"
					+ "              <li class=\"nav-item\">\r\n"
					+ "                <a class=\"nav-link\" href=\"register.jsp\">Register</a>\r\n"
					+ "              </li>\r\n"
					+ "              <li class=\"nav-item dropdown\">\r\n"
					+ "                <a class=\"nav-link dropdown-toggle\" href=\"#\" role=\"button\" data-bs-toggle=\"dropdown\" aria-expanded=\"false\">\r\n"
					+ "                  Dropdown\r\n"
					+ "                </a>\r\n"
					+ "                <ul class=\"dropdown-menu\">\r\n"
					+ "                  <li><a class=\"dropdown-item\" href=\"#\">cricket</a></li>\r\n"
					+ "                  <li><a class=\"dropdown-item\" href=\"#\">Badminton</a></li>\r\n"
					+ "                  <li><hr class=\"dropdown-divider\"></li>\r\n"
					+ "                  <li><a class=\"dropdown-item\" href=\"#\">Table Tennis</a></li>\r\n"
					+ "                </ul>\r\n"
					+ "              </li>\r\n"
					+ "              \r\n"
					+ "            </ul>\r\n"
					+ "            <form class=\"d-flex\" role=\"search\">\r\n"
					+ "              <input class=\"form-control me-2\" type=\"search\" placeholder=\"Search\" aria-label=\"Search\">\r\n"
					+ "              <button class=\"btn btn-outline-success\" type=\"submit\">Search</button>\r\n"
					+ "            </form>\r\n"
					+ "          </div>\r\n"
					+ "        </div>\r\n"
					+ "      </nav>");
			out.println("<h1>User not logged in. Please log in first.</h1>");
			out.println("</body></html>");
		
			return;
		}

		// Variables to store book details
		String prodName = "", prodInfo = "", prodPrice = "";
		//int year = 0;
		int quantity = 1; // Default quantity is 1

		try {
			// Establish connection to the database
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sportshop", "root", "root");

			// Fetch book details
			PreparedStatement prodStmt = con.prepareStatement("SELECT pid, pname,pinfo, price FROM cricket WHERE pid = ?");
			prodStmt.setInt(1, productId);
			ResultSet prs = prodStmt.executeQuery();

			if (prs.next()) {
				prodName = prs.getString("pname");
				prodInfo = prs.getString("pinfo");
				//year = bookRs.getInt("year");
				prodPrice = prs.getString("price");

				// Insert book into cart
				PreparedStatement cartStmt = con.prepareStatement("INSERT INTO cart (id, pid, qty, price, pdate) VALUES (?, ?, ?, ?, ?)");
				cartStmt.setInt(1, userId); // User ID
				cartStmt.setInt(2, productId); // Book ID
				cartStmt.setInt(3, quantity); // Quantity
				cartStmt.setString(4, prodPrice); // Price
				cartStmt.setTimestamp(5, new Timestamp(System.currentTimeMillis())); // Purchase date
				cartStmt.executeUpdate();
				
				
				out.println("<!DOCTYPE html>\r\n"
						+ "<html lang=\"en\">\r\n"
						+ "<head>\r\n"
						+ "    <meta charset=\"UTF-8\">\r\n"
						+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
						+ "    <title>Home Page</title>\r\n"
						+ "    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH\" crossorigin=\"anonymous\">\r\n"
						+ "    <style>\r\n"
						+ "        .carousel-item {\r\n"
						+ "            height: 600px; /* Set a fixed height for the carousel items */\r\n"
						+ "        }\r\n"
						+ "        .carousel-item img {\r\n"
						+ "            object-fit: contain; /* Ensure the images are fully visible within the carousel area */\r\n"
						+ "            height: 100%; /* Make the images take the full height of the carousel items */\r\n"
						+ "            width: 100%; /* Make the images take the full width of the carousel items */\r\n"
						+ "        }\r\n"
						+ "        .custom-card {\r\n"
						+ "            width: 18rem;\r\n"
						+ "            \r\n"
						+ "        }\r\n"
						+ "    </style>\r\n"
						+ "    \r\n"
						+ "</head>\r\n"
						+ "<body class=\"bg-success\">\r\n"
						+ "    <h1 class=\"text-dark text-center mt-3 bg-danger\">Welcome To Premium Sport shop</h1>\r\n"
						+ "    <nav class=\"navbar navbar-expand-lg bg-primary mt-3\">\r\n"
						+ "        <div class=\"container-fluid\">\r\n"
						+ "          <a class=\"navbar-brand\" href=\"#\">Sports Shop</a>\r\n"
						+ "          <button class=\"navbar-toggler\" type=\"button\" data-bs-toggle=\"collapse\" data-bs-target=\"#navbarSupportedContent\" aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\r\n"
						+ "            <span class=\"navbar-toggler-icon\"></span>\r\n"
						+ "          </button>\r\n"
						+ "          <div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">\r\n"
						+ "            <ul class=\"navbar-nav me-auto mb-2 mb-lg-0\">\r\n"
						+ "              <li class=\"nav-item\">\r\n"
						+ "                <a class=\"nav-link active\" aria-current=\"page\" href=\"index.jsp\">Aboutus</a>\r\n"
						+ "              </li>\r\n"
						+ "              <li class=\"nav-item\">\r\n"
						+ "                <a class=\"nav-link\" href=\"contact.jsp\">Contact</a>\r\n"
						+ "              </li>\r\n"
						+ "              <li class=\"nav-item\">\r\n"
						+ "                <a class=\"nav-link\" href=\"login.jsp\">Login</a>\r\n"
						+ "              </li>\r\n"
						+ "              <li class=\"nav-item\">\r\n"
						+ "                <a class=\"nav-link\" href=\"register.jsp\">Register</a>\r\n"
						+ "              </li>\r\n"
						+ "              <li class=\"nav-item dropdown\">\r\n"
						+ "                <a class=\"nav-link dropdown-toggle\" href=\"#\" role=\"button\" data-bs-toggle=\"dropdown\" aria-expanded=\"false\">\r\n"
						+ "                  Dropdown\r\n"
						+ "                </a>\r\n"
						+ "                <ul class=\"dropdown-menu\">\r\n"
						+ "                  <li><a class=\"dropdown-item\" href=\"#\">cricket</a></li>\r\n"
						+ "                  <li><a class=\"dropdown-item\" href=\"#\">Badminton</a></li>\r\n"
						+ "                  <li><hr class=\"dropdown-divider\"></li>\r\n"
						+ "                  <li><a class=\"dropdown-item\" href=\"#\">Table Tennis</a></li>\r\n"
						+ "                </ul>\r\n"
						+ "              </li>\r\n"
						+ "              \r\n"
						+ "            </ul>\r\n"
						+ "            <form class=\"d-flex\" role=\"search\">\r\n"
						+ "              <input class=\"form-control me-2\" type=\"search\" placeholder=\"Search\" aria-label=\"Search\">\r\n"
						+ "              <button class=\"btn btn-outline-success\" type=\"submit\">Search</button>\r\n"
						+ "            </form>\r\n"
						+ "          </div>\r\n"
						+ "        </div>\r\n"
						+ "      </nav>");
				out.println("<h3>Product added to cart successfully!</h3>");
				out.println("<p>Prod Name: " + prodName + "</p>");
				out.println("<p>Info: " + prodInfo + "</p>");
				out.println("<p>Quantity: " + quantity + "</p>");
				out.println("<p>Price: " + prodPrice + "</p>");
				
			} else {
				out.println("<h3> Prouduct  not found!</h3>");
			}

			prs.close();
			prodStmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
			out.println("<h3>Error occurred while adding the book to the cart!</h3>");
		}
		out.println("<form action='BuyNowServlet' method='post'>");
		out.println("<button type='submit' class='btn btn-danger'>Buy Now</button>");
		out.println("</form>");
		out.println("</body>");
	    out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
