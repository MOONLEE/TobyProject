import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spring.user.dao.DaoFactory;
import spring.user.dao.UserDao;

public class ContextVsGetUser {
	public static void main(String[] args) {
		
		try {
		
				DaoFactory dao = new DaoFactory();
				
				long startTime = System.currentTimeMillis();
				for (int i=0; i < 500000; i++) {
					UserDao userdao = dao.getUserDao();
//					System.out.println(userdao);
				}
				long endTime = System.currentTimeMillis();
				
				System.out.println("Time Interval [" + (endTime - startTime) + "]");
				
				
				ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);
				startTime = System.currentTimeMillis();
				for (int k = 0; k < 500000; k++) {
					UserDao userdao2 = context.getBean("getUserDao", UserDao.class);
//					System.out.println(userdao2);
				}
				endTime = System.currentTimeMillis();
				
				System.out.println("Time Interval [" + (endTime - startTime) + "]");
				
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
