package spring.user.dao;

import java.sql.SQLException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring.user.connection.BConnectionMaker;
import spring.user.connection.ConnectionMaker;

@Configuration
public class DaoFactory {
	@Bean
	public UserDao getUserDao() throws ClassNotFoundException, SQLException {
		return new UserDao(getConnectionMaker()) {};
	}
	
	@Bean
	public ConnectionMaker getConnectionMaker() throws ClassNotFoundException, SQLException {
		return new BConnectionMaker();
	}
}
