import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spring.user.connection.CountConnectionMaker;
import spring.user.dao.CountDaoFactory;
import spring.user.dao.UserDao;
import spring.user.domain.User;

public class Main {

	public static void main(String[] args) {
		try {
			ApplicationContext context = new AnnotationConfigApplicationContext(CountDaoFactory.class);
			CountConnectionMaker ccm = context.getBean("getConnectionMaker", CountConnectionMaker.class);
			UserDao dao = context.getBean("getUserDao", UserDao.class);
			User newUser = new User();
		
			System.out.println(UserDao.class);
					
			newUser.setId("t55");
			newUser.setPw("ttt");
			newUser.setName("name");
			
			
			dao.setUser(newUser);
			
			User currentUser = dao.getUser(newUser.getId());
			
			System.out.println(currentUser.getId() + "|" + currentUser.getPw() + "|" + currentUser.getName());
			
			System.out.println(ccm + " count [" + ccm.getCount() + "]");
				
			
			System.out.println(context.getBean("getConnectionMaker", CountConnectionMaker.class));

			System.out.println(context.getBean("getConnectionMaker", CountConnectionMaker.class));
						
			
			dao = context.getBean("getUserDao", UserDao.class);
			newUser = new User();
		
			System.out.println(UserDao.class);
					
			newUser.setId("t66");
			newUser.setPw("ttt");
			newUser.setName("name");
			
			
			dao.setUser(newUser);
			
			currentUser = dao.getUser(newUser.getId());
			
			System.out.println(currentUser.getId() + "|" + currentUser.getPw() + "|" + currentUser.getName());
			
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
