package com.org.crud;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditServlet2 extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html");
		    PrintWriter out=resp.getWriter();  
	          
	        String sid=req.getParameter("id");  
	        int id=Integer.parseInt(sid);  
	        String name=req.getParameter("name");  
	        String password=req.getParameter("password");  
	        String country=req.getParameter("country");  
	        String email=req.getParameter("email"); 
	      
	        Emp e=new Emp();  
	        e.setId(id);  
	        e.setName(name);  
	        e.setPassword(password);  
	        e.setEmail(email);  
	        e.setCountry(country);  
	          
	        int status=Dao.upadte(e);  
	        if(status>0){  
	            resp.sendRedirect("ViewServlet");  
	        }else{  
	            out.println("Sorry! unable to update record");  
	        }  
	          
	        out.close();  
	}

}
