package spring.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import spring.user.domain.User;

public class UserDao {
	
	
	public int setUser(User user) throws ClassNotFoundException , SQLException {
		Connection conn = getConnnection();
		
		PreparedStatement pstmt = conn.prepareStatement(
				"INSERT INTO USERS (ID, PW, NAME) VALUES (? , ? , ?)"
				);
		
		pstmt.setString(1, user.getId());
		pstmt.setString(2, user.getPw());
		pstmt.setString(3, user.getName());
		

		int count = pstmt.executeUpdate();

		pstmt.close();
		conn.close();
		
		return count;
		
	}
	
	
	public User getUser(String userId) throws ClassNotFoundException, SQLException {
		
		Connection conn = getConnnection();
		PreparedStatement pstmt = conn.prepareStatement(
				"SELECT * FROM USERS WHERE ID = ?"
				);
		
		pstmt.setString(1, userId);
		
		ResultSet rs = pstmt.executeQuery();
		
		User user = new User();
		while (rs.next()) {
			user.setId(rs.getString("ID"));
			user.setPw(rs.getString("PW"));
			user.setName(rs.getString("NAME"));
				
		}		
		rs.close();
		pstmt.close();
		conn.close();
		
		return user; 
	}
	

	/**
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	protected Connection getConnnection() throws ClassNotFoundException, SQLException {
		Class.forName("org.mariadb.jdbc.Driver");
		String url = "jdbc:mysql://127.0.0.1/springboard";
		String id = "springboard";
		String pw = "qwer!@34";
		

		Connection conn = DriverManager.getConnection(url, id, pw);		
		
		return conn;
	}
	
}
