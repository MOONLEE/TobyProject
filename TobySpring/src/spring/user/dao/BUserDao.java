package spring.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BUserDao extends UserDao {

	@Override
	protected Connection getConnnection() throws ClassNotFoundException, SQLException {
		Class.forName("org.mariadb.jdbc.Driver");
		String url = "jdbc:mysql://127.0.0.1/springboard";
		String id = "springboard";
		String pw = "qwer!@34";
		

		Connection conn = DriverManager.getConnection(url, id, pw);		
		
		return conn;
	}
	
}
