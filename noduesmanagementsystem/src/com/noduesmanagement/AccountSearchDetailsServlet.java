package com.noduesmanagement;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.*;
import java.sql.*;
/**
 * Servlet implementation class AccountSearchDetailsServlet
 */
@WebServlet("/accountsearchdetails")
public class AccountSearchDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountSearchDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

		protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        //login check
			HttpSession session = request.getSession();
			 response.setHeader("cache-control", "no-cache,no-store,must-revalidate");
		      if(session.getAttribute("uname_account")==null)
		      {
		    	  response.sendRedirect("account_login.html");
		      }
		
		      //processing start
		      String rollno = request.getParameter("rollno");
			PrintWriter out = response.getWriter();
	  try
		{
		 
		  Class.forName("com.mysql.jdbc.Driver");
			
		  	 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/nodues", "root", "siddharth@123");
		  	 PreparedStatement ps = con.prepareStatement("select * from account where roll_no=?");
		  	 ps.setString(1, rollno);
		  	 ResultSet rs = ps.executeQuery();
		  	 if(rs.next())
		  	 {    
		  		 out.print("<div style=height:10px;width10px;><img src=s.png></div>");
		  		 out.println("<h1 align=center>Account Department Student Due Amount Details : </h1>");
		  		out.println("<br>");
		  		out.println("<center>");
		  		out.println("<h2>Enrollment Number : "+rs.getString(1)+"</h2>");
		  		out.println("<h2>Student Name : "+rs.getString(2)+"</h2>");
		  		out.println("<h2>Semester : "+rs.getInt(3)+"</h2>");
		  		out.println("<h2>Branch : "+rs.getString(4)+"</h2>");
		  		out.println("<h2> Due Amount : "+rs.getInt(5)+" Rs </h2>");
		  		out.println("</center>");
		  		out.println("<br>");
		  		
		  		 out.println("<a href=search_details_account.html><h2 align=center>Search Another Details</h2></a>");
		  		out.println("<a href=account_home.html><h2 align=center>Go to Account Home</h2></a>");
		  	 }
		  	 else
		  	 {
		  		 out.println("<h1>No details found!!</h1>");
		  	 }
		  	 
		  	 
		}
	  catch(Exception e)
	  {
		  out.println(e);
	  }
		}
}
