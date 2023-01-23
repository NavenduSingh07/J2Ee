package org.jspiders.jdbc_App;
import java.sql.*;
public class jdbcDemo {

	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		String qry ="delete from btm.student where name='rohit'";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver class Loaded & Register");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
			System.out.println("connection establish with database server");
			stmt = con.createStatement();
			System.out.println("Platform created");
			stmt.executeUpdate(qry);
			System.out.println("data deleted!!!");
			}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(stmt!=null)
			{
				try {
					stmt.close();
				}catch(SQLException e ) {e.printStackTrace();}
			}
			if(con!=null)
			{
				try {
					con.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
			System.out.println("closed all costly resources");
		}

	}

}
