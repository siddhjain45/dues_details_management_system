package com.noduesmanagement;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AccountLogoutServlet
 */
@WebServlet("/AccountLogoutServlet")
public class AccountLogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public AccountLogoutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 HttpSession session = request.getSession();
		 session.removeAttribute("uname_account");
		   session.invalidate();
		   response.sendRedirect("home.html");
	}

}
