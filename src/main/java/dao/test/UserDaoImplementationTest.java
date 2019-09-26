package dao.test;

import java.util.ArrayList;

import decrypt_java.model.User;

public class UserDaoImplementationTest {

	ArrayList<User> userList;
	User currentUser;

	public User getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}

	public UserDaoImplementationTest() {

		userList = new ArrayList<User>();
	}

	public User selectRow(String username, String password) {

		for (User user : userList) {
			if (user.getLogin() == username && user.getPassword() == password) {
				this.currentUser = user;
			}
		}
		return this.currentUser;
	}

	public User addRow(String unsername, String password) {

		userList.add(createUserFromString(unsername, password));
		return userList.get(userList.size() - 1);
	}

	private User createUserFromString(String login, String password) {

		return new User(login, password);
	}

}
