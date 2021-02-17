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
 * Servlet implementation class LibraryLoginServlet
 */
@WebServlet("/librarylogin")
public class LibraryLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LibraryLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

		protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          
          String uname = request.getParameter("uname");
          String pass = request.getParameter("pass");
          HttpSession session = request.getSession();
          session.setAttribute("uname_library", uname);
          
          if(uname.equalsIgnoreCase("library")&&pass.equals("svce2020"))
          {
        	  response.sendRedirect("library_home.html");
        	  
          }
          else
          {
        	  response.sendRedirect("library_login.html");
          }
	}

}
