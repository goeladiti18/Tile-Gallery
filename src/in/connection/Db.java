package in.connection;

import java.sql.*;

public class Db {
	Connection con =null;

	public Connection getConnection() throws SQLException {

	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con=DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe","upgrade_user_12","password");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}



	 return con;



	}



}
