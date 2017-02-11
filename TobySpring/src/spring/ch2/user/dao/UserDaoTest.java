package spring.ch2.user.dao;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import spring.ch1.user.dao.SimpleUserDao;
import spring.ch1.user.dao.UserDao;
import spring.ch1.user.domain.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="/spring/ch1/xml/applicationContext.xml")
public class UserDaoTest {
	
	@Autowired
	private ApplicationContext context;
	
	@Before
	public void setUp() { 
		System.out.println(this.context);
		System.out.println(this);
		
	}
	
	@Test
	public void addAndGet() throws SQLException, ClassNotFoundException {
		UserDao usDao = this.context.getBean("UserDao", UserDao.class);

		System.out.println("addAndGet");
		
		usDao.deleteAll();
		
		int count = usDao.getCount();
		
		assertThat(count, is(0));
		

		SimpleUserDao dao = this.context.getBean("simpleUserDao", SimpleUserDao.class);
		User newUser = new User();
	
		newUser.setId("t64");
		newUser.setPw("ttt");
		newUser.setName("이문준");
		
		dao.setUser(newUser);
		
		assertThat(usDao.getCount(), is(1));
		
		User currentUser = dao.getUser(newUser.getId());
		
		assertThat(newUser.getName(), is(currentUser.getName()));
		assertThat(newUser.getPw(), is(currentUser.getPw()));
	}
	
	@Test
	public void deleteAll() throws SQLException, ClassNotFoundException {
		UserDao usDao = this.context.getBean("UserDao", UserDao.class);

		System.out.println("deleteAll");


		
		usDao.deleteAll();
		
		int count = usDao.getCount();
		
		assertThat(count, is(0));
		
	}
	
	
	
}
