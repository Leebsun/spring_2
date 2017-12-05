package com.iu.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConnector {
<<<<<<< HEAD
	
	
	public static Connection getConnect() throws Exception {
	
	    String user = "user01";
	    String password = "user01";
	    String url = "jdbc:oracle:thin:@localhost:1521:xe";
	    String driver = "oracle.jdbc.driver.OracleDriver";
	
	    Class.forName(driver);
=======
>>>>>>> master

	public static Connection getConnect() throws Exception{
		String user = "user02";
		String password = "user02";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";
		
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, user, password);
		
		return con;
	}
	
	public static void disConnect(Connection con, PreparedStatement st) throws Exception{
		st.close();
		con.close();
	}
	
	public static void disConnect(Connection con, PreparedStatement st, ResultSet rs) throws Exception{
		rs.close();
		DBConnector.disConnect(con, st);
	}
}
