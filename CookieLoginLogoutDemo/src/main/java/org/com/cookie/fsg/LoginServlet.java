package org.com.cookie.fsg;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	public void doget(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException,IOException {
		PrintWriter out=resp.getWriter();
		req.getRequestDispatcher("link.html").include(req, resp);
		 String username=req.getParameter("username");
		 String password=req.getParameter("pwd");
		 if(password.equals("admin")) {
			 out.print("Login Success");
			 Cookie ck=new Cookie("name", username);
			 resp.addCookie(ck);
		 }
		 else {
			 out.print("Sorry invalid username or password");
			 req.getRequestDispatcher("login.html").include(req, resp);
		 }
		
	}

}