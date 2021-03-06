package com.noduesmanagement;

import java.io.IOException;
import java.io.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LibrarySearchDetailsServlet
 */
@WebServlet("/librarysearch")
public class LibrarySearchDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LibrarySearchDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

		protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      //check login 
			HttpSession session = request.getSession();
			 response.setHeader("cache-control", "no-cache,no-store,must-revalidate");
		      if(session.getAttribute("uname_library")==null)
		      {
		    	  response.sendRedirect("library_login.html");
		      }
			
			//processing starrt
			PrintWriter out = response.getWriter();
	      String rollno = request.getParameter("rollno");
	      try
			{
			 
			  Class.forName("com.mysql.jdbc.Driver");
				
			  	 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/nodues", "root", "siddharth@123");
			  	 PreparedStatement ps = con.prepareStatement("select * from library where roll_no=?");
			  	 ps.setString(1, rollno);
			  	 ResultSet rs = ps.executeQuery();
			  	 if(rs.next())
			  	 {    
			  		 out.print("<div style=height:10px;width10px;><img src=s.png></div>");
			  		 out.println("<h1 align=center>Library Department Student Due Amount Details : </h1>");
			  		out.println("<br>");
			  		out.println("<center>");
			  		out.println("<h2>Enrollment Number : "+rs.getString(1)+"</h2>");
			  		out.println("<h2>Student Name : "+rs.getString(2)+"</h2>");
			  		out.println("<h2>Semester : "+rs.getInt(3)+"</h2>");
			  		out.println("<h2>Branch : "+rs.getString(4)+"</h2>");
			  		out.println("<h2> Due Amount : "+rs.getInt(5)+" Rs </h2>");
			  		out.println("</center>");
			  		out.println("<br>");
			  		
			  		 out.println("<a href=search_details_library.html><h2 align=center>Search Another Details</h2></a>");
			  		out.println("<a href=library_home.html><h2 align=center>Go to Library Home</h2></a>");
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
