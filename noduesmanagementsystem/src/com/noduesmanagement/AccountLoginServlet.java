package com.noduesmanagement;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AccountLoginServlet
 */
@WebServlet("/accountlogin")
public class AccountLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

		protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  
			String uname = request.getParameter("uname");
			String pass = request.getParameter("pass");
			HttpSession session = request.getSession();
			session.setAttribute("uname_account", uname);
			
			if(uname.equalsIgnoreCase("account")&&pass.equals("svce2020"))
			{
				      response.sendRedirect("account_home.html");
				      
				    
			}
			else
			{
				response.sendRedirect("account_login.html");
			}
			
	}

}
