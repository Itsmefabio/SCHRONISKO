package com.schronisko.add;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddToDBServlet
 */
@WebServlet("/AddToDBServlet")
public class AddToDBServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddToDBServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String imie = request.getParameter("imie");
	        String plec = request.getParameter("plec");
	         int wiek=Integer.valueOf(request.getParameter("wiek"));
	         int waga=Integer.valueOf(request.getParameter("wiek"));
	         String opiekun=request.getParameter("opiekun");
	        try {
	        	Class.forName("com.mysql.jdbc.Driver");
				Connection connection2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/schronisko","root","kolor1234");


			System.out.println("ok");
			String stmt=("insert into zwierzeta(imie,plec,wiek,waga,opiekun)values(?,?,?,?,?) ");
			PreparedStatement pst2=connection2.prepareStatement(stmt);
			
			pst2.setString(1,imie);
			pst2.setString(2,plec);
			pst2.setInt(3,wiek);
			pst2.setInt(4,waga);
			pst2.setString(5,opiekun);
			pst2.executeUpdate();
			
			pst2.close();
			connection2.close();
			System.out.println("wpis dodany do bazy");
			
	        } catch (ClassNotFoundException e) {

				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
