import spring.user.connection.BConnectionMaker;
import spring.user.connection.ConnectionMaker;
import spring.user.dao.UserDao;
import spring.user.domain.User;

public class Main {

	public static void main(String[] args) {
		try {
			ConnectionMaker conn = new BConnectionMaker();
			
			UserDao dao = new UserDao(conn) {
			};
			User newUser = new User();
			
			newUser.setId("t4");
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
