package spring.user.connection;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionMaker {
	public Connection getConnection() throws ClassNotFoundException, SQLException;
}
