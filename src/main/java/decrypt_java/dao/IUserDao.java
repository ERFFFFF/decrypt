package decrypt_java.dao;

import decrypt_java.model.User;

public interface IUserDao {

	public User addRow(String login, String password);
	public void deleteRow(int id);
	public User selectRow(String login, String password);
	
	
}
