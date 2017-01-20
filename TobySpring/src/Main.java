import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spring.user.dao.DaoFactory;
import spring.user.dao.UserDao;
import spring.user.domain.User;

public class Main {

	public static void main(String[] args) {
		try {
			
			
			ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);
			UserDao dao = context.getBean("getUserDao", UserDao.class);
			
			User newUser = new User();
			
			newUser.setId("t6");
			newUser.setPw("ttt");
			newUser.setName("name");
			
			
			dao.setUser(newUser);
			
			User currentUser = dao.getUser(newUser.getId());
			
			System.out.println(currentUser.getId() + "|" + currentUser.getPw() + "|" + currentUser.getName());
					
						
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
