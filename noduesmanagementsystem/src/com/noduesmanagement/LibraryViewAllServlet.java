package com.noduesmanagement;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LibraryViewAllServlet
 */
@WebServlet("/libraryviewall")
public class LibraryViewAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LibraryViewAllServlet() {
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
		
	      //processing start
		PrintWriter out = response.getWriter();
		 try
			{
			  Class.forName("com.mysql.jdbc.Driver");
				
			  	 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/nodues", "root", "siddharth@123");
			  	 PreparedStatement ps = con.prepareStatement("select * from library");
			  	 
			  	 ResultSet rs = ps.executeQuery();
			  	 if(rs.next())
			  	 {    
			  		out.print("<div style=height:10px;width10px;><img src=s.png></div>");
			  		 out.println("<h1 align=center>Library Department Students Due Amount Details : </h1>");
			  		 out.println("<table border=3 align=center>");
			  		 out.println("<tr>");
			  		out.println("<td>Enrollment Number</td>");
			  		out.println("<td>Student Name</td>");
			  		out.println("<td>Semester</td>");
			  		out.println("<td>Branch</td>");
			  		out.println("<td>Due Amount</td>");
			  		 out.println("</tr>");
			  		 do
			  		 {
			  			out.println("<tr>");
			  			out.println("<td>"+rs.getString(1)+"</td>");
			  			out.println("<td>"+rs.getString(2)+"</td>");
			  			out.println("<td>"+rs.getInt(3)+"</td>");
			  			out.println("<td>"+rs.getString(4)+"</td>");
			  			out.println("<td>"+rs.getInt(5)+"</td>");
			  			out.println("</tr>");
			  		 }while(rs.next());
			  		 out.println("</table>");
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
