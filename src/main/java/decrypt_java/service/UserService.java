package decrypt_java.service;

import decrypt_java.dao.UserDaoImplementation;
import decrypt_java.model.User;

public class UserService {

	UserDaoImplementation userDao;
	User 	user;
	
	
	
	public UserService() {
		
		user = new User();
		userDao = new UserDaoImplementation();
	}
	
	
	public User login(String username, String password) {
		
		return this.userDao.selectRow(username, password);
	}
	
	
	public User createUser(String unsername, String password) {
		
		return this.userDao.addRow(unsername, password);
	}
	
}
