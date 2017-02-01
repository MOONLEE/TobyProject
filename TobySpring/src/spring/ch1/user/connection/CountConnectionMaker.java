package spring.ch1.user.connection;

import java.sql.Connection;
import java.sql.SQLException;

public class CountConnectionMaker implements ConnectionMaker {
	
	int counter = 0;
	private ConnectionMaker realConnectionMaker;
	
	
	public CountConnectionMaker(ConnectionMaker realConnectionMaker) {
		this.realConnectionMaker = realConnectionMaker;
	}
	
	@Override
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		this.counter++;
		System.out.println(this + " count [" + this.counter + "]");
		return realConnectionMaker.getConnection();
	}
	
	public int getCount() {
		return this.counter;
	}
	
	

}
