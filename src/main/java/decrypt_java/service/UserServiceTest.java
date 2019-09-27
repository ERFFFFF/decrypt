package decrypt_java.service;

import dao.test.UserDaoImplementationTest;
import decrypt_java.model.User;

public class UserServiceTest {
UserDaoImplementationTest userDaoTest; 
User userTest;


	public UserServiceTest() {

		  userTest =  new User();
		 
		  userDaoTest = new UserDaoImplementationTest();
	}
	
	
	public User login(String username, String password) {
		
		return this.userDaoTest.selectRow(username, password);
	//	return this.userDao.selectRow(username, password);
	}
	
	
	public User createUser(String unsername, String password) {
		
		return this.userDaoTest.addRow(unsername, password);
	}
}
