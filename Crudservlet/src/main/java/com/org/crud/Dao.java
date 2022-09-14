package com.org.crud;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Dao {
public static Connection getConnection() {
	Connection con=null;
	try {
		Class.forName("org.postgresql.Driver");
		con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/ravidatabase",
		            "postgres", "postgres");
	}
	catch (Exception e) {
	System.out.println(e);
	}
	return con;
}
public static int save(Emp e) {
	int status=0;
	try {
		Connection con=Dao.getConnection();
		PreparedStatement ps=
	con.prepareStatement("insert into user (name,password,email,country)values(?,?,?,?,)");
		ps.setString(1, e.getName());
		ps.setString(2, e.getPassword());
	    ps.setString(4, e.getCountry());
		ps.setString(3, e.getEmail());
		status=ps.executeUpdate();
		con.close();
	}
	catch (Exception ex) {
		ex.printStackTrace();
	}
	return status;
	}
public static int upadte(Emp e) {
	int status=0;
	Connection con=Dao.getConnection();
	try {
		PreparedStatement ps=
		con.prepareStatement("update user set name=?,password=?,country=?,email=?,where id=?");
		ps.setString(1, e.getName());
		ps.setString(2, e.getPassword());
		ps.setString(4, e.getCountry());
		ps.setString(3, e.getEmail());
		ps.setInt(5, e.getId());
		  status=ps.executeUpdate(); 
		  con.close();
		  
	} catch (Exception ex) {
		
		ex.printStackTrace();
	}
	return status;
	
}
public static int delete(int id) {
	int status=0;
	Connection con=Dao.getConnection();
	try {
		PreparedStatement ps=con.prepareStatement("select * from user where id=?");
		ps.setInt(1, id);
		status=ps.executeUpdate();
		con.close();
	} catch (Exception e) {
		
		e.printStackTrace();
	} 
	return status;
	
}
public static Emp getEmployeeByID(int id) {
	Emp e=new Emp();
	  Connection con=Dao.getConnection();  
      try {
		PreparedStatement ps=con.prepareStatement("select * from user where id=?");
		ps.setInt(1, id);
		ResultSet rs=ps.executeQuery();
		if(rs.next()) {
			e.setId(rs.getInt(1));
			e.setName(rs.getString(2));
			e.setPassword(rs.getString(3));
			e.setEmail(rs.getString(4));
			e.setCountry(rs.getString(5));
		}
		con.close();
	} catch (SQLException ex) {
	
		ex.printStackTrace();
	}  
	return e;
	
}
	public static List<Emp> getAllEmployees(){
		List<Emp>list=new ArrayList<Emp>();
		try {
			 Connection con=Dao.getConnection();  
			  PreparedStatement ps = con.prepareStatement("select * from user");
			  ResultSet rs=ps.executeQuery();
			  while(rs.next()){  
	                Emp e=new Emp();  
	                e.setId(rs.getInt(1));  
	                e.setName(rs.getString(2));  
	                e.setPassword(rs.getString(3));  
	                e.setEmail(rs.getString(4));  
	                e.setCountry(rs.getString(5));  
	                list.add(e); 
			  }
			    con.close();  

		} catch (SQLException e) {
	
			e.printStackTrace();
		}  
        return list;
		
	}
	}


