package com.org.crud;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteServlet extends HttpServlet {
	 
        @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
	
		String sid=req.getParameter("id");  
        int id=Integer.parseInt(sid);  
        Dao.delete(id);  
        resp.sendRedirect("ViewServlet");  
}
}
