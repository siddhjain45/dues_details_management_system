package com.noduesmanagement;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class GoToScholorshipSearchServlet
 */
@WebServlet("/scholorshipsearchdetails")
public class GoToScholorshipSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GoToScholorshipSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

		protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			HttpSession session = request.getSession();
			 response.setHeader("cache-control", "no-cache,no-store,must-revalidate");
		      if(session.getAttribute("uname_scholorship")==null)
		      {
		    	  response.sendRedirect("scholorship_login.html");
		      }
		      else
		  response.sendRedirect("search_details_scholorship.html");
		  
		
		}

}
