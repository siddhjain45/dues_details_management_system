package com.noduesmanagement;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LibraryAddDetailsServlet
 */
@WebServlet("/libraryadddetails")
public class LibraryAddDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LibraryAddDetailsServlet() {
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
		      //starting process
			PrintWriter out = response.getWriter();
		      String rollno = request.getParameter("rollno");
		      String name = request.getParameter("name");
		      int sem = Integer.parseInt(request.getParameter("sem"));
		      String branch = request.getParameter("branch");
		      int amount = Integer.parseInt(request.getParameter("amount"));
		 try
		 {
			 Class.forName("com.mysql.jdbc.Driver");
				
		  	 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/nodues", "root", "siddharth@123");
		  	 PreparedStatement ps = con.prepareStatement("insert into library value(?,?,?,?,?)");
		  	 ps.setString(1, rollno);
		  	 ps.setString(2, name);
		  	 ps.setInt(3, sem);
		  	 ps.setString(4, branch);
		  	 ps.setInt(5, amount);
		  	 
		  	 int i=0;
		  	 i=ps.executeUpdate();
		  	 
		  	 if(i!=0)
		  	 {
		  		out.print("<div style=height:10px;width10px;><img src=s.png></div>");
		  	out.println("<center>");
		  		out.println("<h1>Details added succesfully</h1>");
		  		 out.println("<a href=add_details_library.html><h2>Add another details</h2></a>");
		  		 out.println("<a href=library_home.html><h2>Go to Library Home</h2></a>");
		  		 out.println("</center>");
		  	 }
		  	 else
		  	 {
		  		 response.sendRedirect("add_details_account.html");
		  		 
		  	 }
		  	 
		 
		 }
		catch(Exception e)
		{
          out.println(e);			
		}

			
	}

}
