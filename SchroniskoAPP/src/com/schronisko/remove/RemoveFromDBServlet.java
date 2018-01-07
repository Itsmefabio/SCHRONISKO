package com.schronisko.remove;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/RemoveFromDBServlet")
public class RemoveFromDBServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
         int id=Integer.valueOf(request.getParameter("id"));
         ;
        try {
        	Class.forName("com.mysql.jdbc.Driver");
			Connection connection2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/schronisko","root","kolor1234");


		System.out.println("ok");
		String stmt=("remove (*) from zwierzeta where id=? ");
		PreparedStatement pst2=connection2.prepareStatement(stmt);
		
		pst2.setInt(1,id);
		
		pst2.close();
		connection2.close();
		System.out.println("wpis usuniety z bazy");
		
        } catch (ClassNotFoundException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}


	}


