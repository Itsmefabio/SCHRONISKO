package com.schronisko.login;

 
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
 
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
	}
	protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd;
	
        // read form fields
        String username = request.getParameter("username");
        String password = request.getParameter("password");
         
       
	
        try {
        	Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/schronisko","root","kolor1234");


		System.out.println("ok");
		String stmt=("select count(*)as valid from users where 'user'=? 'password'=? ");
		PreparedStatement pst=connection.prepareStatement(stmt);
		pst.setString(1,username);
		pst.setString(2,password);
		ResultSet rs1=pst.executeQuery();
		rs1.next();
		if( rs1.getInt("valid")==1) {
			System.out.println("is valid");
			response.sendRedirect("http://localhost:8080/SchroniskoAPP/index.jsp");	
		}
		else {
			response.sendRedirect("http://localhost:8080/SchroniskoAPP/login.jsp");
			System.out.println("is not valid");
		}
		
		pst.close();
		connection.close();
        } catch (ClassNotFoundException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	//rd=RequestDispatcher.forward("http://localhost:8080/SchroniskoAPP/MenuServlet");
	//jdbc:mysql://localhost:3306/s
	
	
	
	}
	
	}