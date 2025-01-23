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

/**
 * Servlet implementation class BuyNowServlet
 */
public class BuyNowServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession();
        Integer userId = (Integer) session.getAttribute("id");

        if (userId == null) {
            out.println("<h3>User not logged in. Please log in first.</h3>");
            return;
        }

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sportshop", "root", "root");

            PreparedStatement stmt = con.prepareStatement("SELECT pid, qty, price FROM cart WHERE id = ?");

            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();

            double totalAmount = 0;
            int totalQuantity = 0;

           // out.println("<html><head><title>Buy Now</title></head><body>");
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
            		+ "<body class=\"bg-info\">\r\n"
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
            
            out.println("<h2 class= 'text-center' >Order Summary</h2>");
            out.println("<table  class='table' border='1'><tr><th>Product ID</th><th>Quantity</th><th>Price</th><th>Subtotal</th></tr>");
            

            while (rs.next()) {
                int productId = rs.getInt("pid");
                int qty = rs.getInt("qty");
                double price = Double.parseDouble(rs.getString("price"));
                double subtotal = qty * price;

                totalQuantity += qty;
                totalAmount += subtotal;

                out.println("<tr><td>" + productId + "</td><td>" + qty + "</td><td>" + price + "</td><td>" + subtotal + "</td></tr>");
            }

            out.println("</table>");
            out.println("<h3>Total Quantity: " + totalQuantity + "</h3>");
            out.println("<h3>Total Amount: " + totalAmount + "</h3>");

            out.println("<form action='PlaceOrderServlet' method='post'>");
            out.println("<input type='hidden' name='totalAmount' value='" + totalAmount + "'>");
            out.println("<input type='hidden' name='totalQuantity' value='" + totalQuantity + "'>");
            out.println("<button type='submit' class='btn btn-primary'>Place Order</button>");
            out.println("</form>");

            out.println("</body></html>");

            rs.close();
            stmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            out.println("<h3>Error occurred while processing the request.</h3>");
        }
    }
}
