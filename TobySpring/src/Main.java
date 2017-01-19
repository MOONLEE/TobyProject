import spring.user.dao.UserDao;
import spring.user.domain.User;

public class Main {

	public static void main(String[] args) {
		try {
			UserDao dao = new UserDao();
			User newUser = new User();
			
			newUser.setId("t2");
			newUser.setPw("ttt");
			newUser.setName("name");
			
			
			dao.setUser(newUser);
			
			User currentUser = dao.getUser(newUser.getId());
			
			System.out.println(currentUser.getId() + currentUser.getPw() + currentUser.getName());
					
						
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
