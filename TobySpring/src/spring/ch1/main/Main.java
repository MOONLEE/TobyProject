package spring.ch1.main;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import spring.ch1.user.connection.CountConnectionMaker;
import spring.ch1.user.dao.CountDaoFactory;
import spring.ch1.user.dao.SimpleUserDao;
import spring.ch1.user.dao.UserDao;
import spring.ch1.user.domain.User;

public class Main {

	public static void main(String[] args) {
		try {
//			ApplicationContext context = new AnnotationConfigApplicationContext(CountDaoFactory.class);
			ApplicationContext context = new GenericXmlApplicationContext("spring/ch1/xml/dataSourceContext.xml");
//			CountConnectionMaker ccm = context.getBean("getConnectionMaker", CountConnectionMaker.class);
			SimpleUserDao dao = context.getBean("simpleUserDao", SimpleUserDao.class);
			User newUser = new User();
		
			System.out.println(dao);
			System.out.println(context.getBean("simpleUserDao", SimpleUserDao.class));
			newUser.setId("t62");
			newUser.setPw("ttt");
			newUser.setName("name");
			
			
			dao.setUser(newUser);
			
			User currentUser = dao.getUser(newUser.getId());
			
			System.out.println(currentUser.getId() + "|" + currentUser.getPw() + "|" + currentUser.getName());
			
//			System.out.println(ccm + " count [" + ccm.getCount() + "]");
				
			
//			System.out.println(context.getBean("getConnectionMaker", CountConnectionMaker.class));

//			System.out.println(context.getBean("getConnectionMaker", CountConnectionMaker.class));
						
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
