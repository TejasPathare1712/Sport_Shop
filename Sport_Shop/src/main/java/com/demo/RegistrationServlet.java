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

//@WebServlet("RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public RegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String n = request.getParameter("txtname");
		String a = request.getParameter("txtaddress");
		String c = request.getParameter("txtcity");
		String e = request.getParameter("txtemail");
		String u = request.getParameter("txtusername");
		String p = request.getParameter("txtpassword");
        PrintWriter out=response.getWriter();
		
		try {
			//Step 1  Register the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			//Step 2
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sportshop","root","root");
			// Step 3
			PreparedStatement pstmt = con.prepareStatement("insert into users(name,address,city,email,username,password) values(?,?,?,?,?,?)");
			pstmt.setString(1, n);
			pstmt.setString(2,a);
			pstmt.setString(3,c);
			pstmt.setString(4,e);
			pstmt.setString(5,u);
			pstmt.setString(6,p);
			
			int count =pstmt.executeUpdate();
			if(count>0) {
				//out.println("User Registered Successfully ");
				response.sendRedirect("login.jsp");
				//RequestDispatcher rd = request.getRequestDispatcher("LoginServlet");
				//rd.include(request, response);
			}else {
				response.sendRedirect("register.jsp");
			}
			
			
		}
		catch(Exception ex) {
			System.out.println(ex);
		}
	}

	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
