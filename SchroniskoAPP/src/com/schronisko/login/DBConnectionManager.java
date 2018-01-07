package com.schronisko.login;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBConnectionManager {

		private Connection connection;
		
		public DBConnectionManager(String dbURL, String user, String pwd) throws ClassNotFoundException, SQLException{
			Class.forName("com.mysql.jdbc.Driver");
			this.connection = DriverManager.getConnection(dbURL, user, pwd);
			
		}
		
		public Connection getConnection(){
			return this.connection;
		}

	
}
