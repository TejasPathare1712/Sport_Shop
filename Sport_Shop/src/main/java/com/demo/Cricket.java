package com.demo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



public class Cricket extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Cricket() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Generate HTML with Bootstrap CDN
        out.println("<!DOCTYPE html>");
        out.println("<html lang='en'>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
        out.println("<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css' rel='stylesheet' integrity='sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH' crossorigin='anonymous'>");
        out.println("<title>Sports Equipment</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1 class=\"text-dark text-center mt-3 bg-danger\">Welcome To Premium Sport shop</h1>\r\n"
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
        out.println("<h1 class='text-center'>Cricket Equipments</h1>");
        out.println("<div class='container'>");
        out.println("<div class='row'>");

        try {
            // Database connection
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sportshop", "root", "root");

            // Query to fetch book details
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM cricket");
            ResultSet rs = pstmt.executeQuery();

            // Loop through the results
            while (rs.next()) {
                int prodId = rs.getInt("pid");
                String prodName = rs.getString("pname");
                String prodInfo = rs.getString("pinfo");
                // String publication = rs.getString("publication");
                //int year = rs.getInt("year");
                int prodPrice = rs.getInt("price");
                String imageUrl = rs.getString("pimage");

                
                if (imageUrl == null || imageUrl.isEmpty()) {
                    imageUrl = "images/eng1.jpg"; 
                }

                
                out.println("<div class='col-4 mb-4'>");
                out.println("<div class='card' style='width: 18rem;'>");
                out.println("<img height='300px' src='" + imageUrl + "' class='card-img-top' alt='Book Image'>");
                out.println("<div class='card-body'>");
                out.println("<h5 class='card-title'>" + prodName + "</h5>");
                out.println("<p class='card-text'><strong>Author:</strong> " + prodInfo + "</p>");
                //out.println("<p class='card-text'><strong>Publication:</strong> " + publication + "</p>");
                //out.println("<p class='card-text'><strong>Year:</strong> " + year + "</p>");
                out.println("<p class='card-text'><strong>Price:</strong> ₹" + prodPrice + "</p>");

                
                String url = "CartServlet?pid=" + prodId;
                out.println("<a href='" + url + "' class='btn btn-primary'>Add to Cart</a>");
                out.println("</div>");
                out.println("</div>");
                out.println("</div>");
            }

            con.close(); // Close connection

        } catch (Exception e) {
            e.printStackTrace();
            out.println("<div class='alert alert-danger' role='alert'>An error occurred: " + e.getMessage() + "</div>");
        }

        out.println("</div>"); 
        out.println("</div>"); 
        out.println("<script src='https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js' integrity='sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz' crossorigin='anonymous'></script>");
        out.println("</body>");
        out.println("</html>");
    }//response.getWriter().append("Served at: ").append(request.getContextPath());
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
