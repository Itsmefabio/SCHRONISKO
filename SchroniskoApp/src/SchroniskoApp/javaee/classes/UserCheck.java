package SchroniskoApp.javaee.classes;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class UserCheck {
public static boolean credentialsCheck(String email, String pass) {
	

	boolean st=false;

		 try {
			Class.forName("com.mysql.jdbc.Driver");
			
			
			      //creating connection with the database
			
			          Connection connection=DriverManager.getConnection

			                         ("jdbc:mysql://localhost:3306/database","Damian Migus","kolor1234");

			PreparedStatement stmt= connection.prepareStatement("select * from UsersList where email=? and pass=?");
			stmt.setString(1, email);
			stmt.setString(2, pass);
			ResultSet rs =stmt.executeQuery();
			st = rs.next();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	

	return st;

}	
}
