/**
 * 
 */
package decrypt_java.dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import decrypt_java.model.User;
import decrypt_java.sqlUtils.SqlUtil;

/**
 * @author ivann VVV CESI Toulouse 24 sept. 2019
 *
 */
public class UserDaoImplementation extends SqlUtil implements IUserDao {

	
	User ConnectedUser;
	
	public UserDaoImplementation() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see decrypt_java.UserDao#createUser(java.lang.String, java.lang.String)
	 */
	public User addRow(String login, String password) {
		
		CallableStatement cs = null;
		try {
			cs = this.getConnectionToUse().prepareCall("{call stored_login_procedure(?,?)}");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			cs.setString(1, login);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			cs.setString(2, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			
			int rs = cs.executeUpdate();
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		return createUserFromString(login, password);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see decrypt_java.UserDao#deleteUser(int)
	 */
	public void deleteRow(int id) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see decrypt_java.UserDao#loginUser(java.lang.String, java.lang.String)
	 */
	public User selectRow(String login, String password) {

		CallableStatement cs = null;
		try {
			cs = this.getConnectionToUse().prepareCall("{call stored_login_procedure(?,?)}");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			cs.setString(1, login);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			cs.setString(2, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			cs.execute();
			ResultSet rs = cs.executeQuery();
			
			this.createUserFromResulset(rs);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this.getConnectedUser();
	}

	private User createUserFromResulset(ResultSet rs) throws SQLException {

		while (rs.next()) {
			User p = new User();
			p.setId(rs.getInt("id_user"));
			p.setLogin((rs.getString("username")));

			this.setConnectedUser(p);
		}
		return this.getConnectedUser();

	}
	
	
	private User createUserFromString(String login, String password) {
		
		return new User(login,password);
	}
	
	
	public User getConnectedUser() {
		return ConnectedUser;
	}

	public void setConnectedUser(User connectedUser) {
		ConnectedUser = connectedUser;
	}
}
