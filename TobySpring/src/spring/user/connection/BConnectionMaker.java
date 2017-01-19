package spring.user.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BConnectionMaker implements ConnectionMaker {

	@Override
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("org.mariadb.jdbc.Driver");
		String url = "jdbc:mysql://127.0.0.1/springboard";
		String id = "springboard";
		String pw = "qwer!@34";
		

		Connection conn = DriverManager.getConnection(url, id, pw);		
		
		return conn;
	}
	
}
