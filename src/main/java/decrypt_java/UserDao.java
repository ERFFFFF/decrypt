package decrypt_java;

public interface UserDao {

	public void createUser(String login, String password);
	public void deleteUser(int id);
	public void loginUser(String login, String password);
	
	
}
