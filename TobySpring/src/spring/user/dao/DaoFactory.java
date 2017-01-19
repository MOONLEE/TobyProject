package spring.user.dao;

import java.sql.SQLException;

import spring.user.connection.BConnectionMaker;
import spring.user.connection.ConnectionMaker;

public class DaoFactory {
	public UserDao getUserDao() throws ClassNotFoundException, SQLException {
		return new UserDao(getConnectionMaker()) {};
	}
	
	public ConnectionMaker getConnectionMaker() throws ClassNotFoundException, SQLException {
		return new BConnectionMaker();
	}
}
