package com.noduesmanagement;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ScholorshipLoginServlet
 */
@WebServlet("/scholorshiplogin")
public class ScholorshipLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ScholorshipLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String uname = request.getParameter("uname");
        String pass = request.getParameter("pass");
        HttpSession session = request.getSession();
        session.setAttribute("uname_scholorship", uname);
        
        if(uname.equalsIgnoreCase("scholorship")&&pass.equals("svce2020"))
        {
      	  response.sendRedirect("scholorship_home.html");
      	  
        }
        else
        {
      	  response.sendRedirect("scholorship_login.html");
        }
	
	}

}
