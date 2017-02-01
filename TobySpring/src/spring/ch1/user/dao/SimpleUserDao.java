package spring.ch1.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import spring.ch1.user.domain.User;

public class SimpleUserDao {
	private DataSource dataSource;

	public SimpleUserDao() {
		
	}
	
	public SimpleUserDao(DataSource dataSource) {
		this.dataSource = dataSource;
		
	}
	
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}


	public int setUser(User user) throws ClassNotFoundException , SQLException {
		Connection conn = dataSource.getConnection();
		
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
		Connection conn = dataSource.getConnection();
		
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
	
}
