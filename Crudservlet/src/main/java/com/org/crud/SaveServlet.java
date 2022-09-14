package com.org.crud;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SaveServlet extends HttpServlet {
@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		String name=req.getParameter("name");
		String passwor=req.getParameter("password");
		String country=req.getParameter("country");
		String email=req.getParameter("email");
		
		
		Emp e=new Emp();
		e.setName(name);
		e.setEmail(email);
		e.setPassword(passwor);
		e.setCountry(country);
		System.out.println("data has saved");
		
		  int status=Dao.save(e);  
	        if(status>0){  
	            out.print("<p>Record saved successfully!</p>");  
	            req.getRequestDispatcher("index.html").include(req, resp);  
	        }else{  
	            out.println("Sorry! unable to save record");  
	        }  
            out.close();
	}

}
