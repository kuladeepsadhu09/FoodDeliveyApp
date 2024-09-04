package mock;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbcmock {
	private static Connection con;
	private static Statement stmt;
	private static ResultSet res;
	private static ResultSetMetaData meta;

	public static void main(String[] args) {
		String url="jdbc:mysql://localhost:3306/jdbcpar";
		String username="root";
		String password="Swamy@5033";
		String q= "select * from bank";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url,username,password);
			stmt=con.createStatement();
			res=stmt.executeQuery(q);
			meta=res.getMetaData();
			System.out.println(meta.getColumnName(1)+ " " + meta.getColumnName(2)+" " + meta.getColumnName(3) );
			while(res.next()) {
				System.out.println(res.getInt("usid") +" " + res.getString("usname")+" " + res.getString("money"));
			}
			System.out.println("connection created");
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}
