package spring.ch1.user.dao;

import java.sql.SQLException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring.ch1.user.connection.BConnectionMaker;
import spring.ch1.user.connection.ConnectionMaker;
import spring.ch1.user.connection.CountConnectionMaker;
@Configuration
public class CountDaoFactory {
	
	@Bean
	public UserDao getUserDao() throws ClassNotFoundException, SQLException { 
		UserDao userDao = new UserDao();
		userDao.setConnectionMaker(getConnectionMaker());		
		return userDao;
	}
	
	@Bean
	public ConnectionMaker getConnectionMaker() throws ClassNotFoundException, SQLException {
		return new CountConnectionMaker(getRealConnectionMaker());
	}

	@Bean
	public ConnectionMaker getRealConnectionMaker() throws ClassNotFoundException, SQLException {
		return new BConnectionMaker();
	}

}
