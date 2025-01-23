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
import java.sql.Timestamp;

public class PlaceOrderServlet extends HttpServlet {
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

        double totalAmount = Double.parseDouble(request.getParameter("totalAmount"));
        int totalQuantity = Integer.parseInt(request.getParameter("totalQuantity"));

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sportshop", "root", "root");

            PreparedStatement orderStmt = con.prepareStatement("INSERT INTO orders (id, totalAmount, totalQuantity, orderDate) VALUES (?, ?, ?, ?)");
            orderStmt.setInt(1, userId);
            orderStmt.setDouble(2, totalAmount);
            orderStmt.setInt(3, totalQuantity);
            orderStmt.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
            orderStmt.executeUpdate();

            PreparedStatement cartStmt = con.prepareStatement("DELETE FROM cart WHERE id = ?");
            cartStmt.setInt(1, userId);
            cartStmt.executeUpdate();

            out.println("<h3>Order placed successfully!</h3>");
            out.println("<p>Total Amount: " + totalAmount + "</p>");
            out.println("<p>Total Quantity: " + totalQuantity + "</p>");

            orderStmt.close();
            cartStmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            out.println("<h3>Error occurred while placing the order.</h3>");
        }
    }
}
