package com.wct.testdb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

/**
 * 
 * 
 * @Author Kamala Sekar Rose
 * 
 * This class is used to Test the DB Connection
 * 
 */
@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Setup Connection Variable
		
		String user="springstudent";
		String password="springstudent";
		String jdbcUrl="jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false";
		String driver="com.mysql.jdbc.Driver";
		
		
		//Get Connection to database
		
		try{
			
			PrintWriter out = response.getWriter();
			
			out.println("Connecting to database: "+ jdbcUrl);
			
			Class.forName(driver);
			
			Connection myConn= DriverManager.getConnection(jdbcUrl,user,password);
			
			System.getProperty("line.separator");
			
			out.println("Connecting Succesfull");
			
			myConn.close();
		}
		catch(Exception e){
			System.out.println("Error: "+e.getMessage());
		}
		
		
		
		
	}

}
