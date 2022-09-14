package org.com.cookie.fsg;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProfileServlet extends HttpServlet {
	public void doget(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException,IOException {
		PrintWriter out=resp.getWriter();
		req.getRequestDispatcher("link.html").include(req, resp);
		Cookie ck[]=req.getCookies();
		if(ck!=null) {
			String name=ck[0].getValue();
			if(!name.equals("")||name!=null) {
				out.print("<b>Welcome to profile</b>");
				out.print("<b>Welcome to profile="+name);
			}
		}
		else {
			out.print("Login First");
			req.getRequestDispatcher("login.html").include(req, resp);
			
		}
}
}
