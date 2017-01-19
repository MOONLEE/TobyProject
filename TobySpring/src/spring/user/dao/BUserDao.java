package spring.user.dao;

import java.sql.Connection;
import java.sql.SQLException;

public class BUserDao extends UserDao {

	@Override
	protected Connection getConnnection() throws ClassNotFoundException, SQLException {
		return super.getConnnection();
	}
	
}
