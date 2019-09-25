package decrypt_java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class CLcad {
	private String connectionUrl;
	private String login;
	private String psw;
	private Connection con;
	private Statement stmt;
	private ResultSet rs;
	private int rslt;
	
	public CLcad() throws SQLException, ClassNotFoundException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		this.connectionUrl = "jdbc:mysql://localhost:3306/projet_decrypt?serverTimezone=UTC";
		this.login = "root";
		this.psw = "test123*";
		this.con = DriverManager.getConnection(connectionUrl, login, psw);
	}
	
	public ResultSet m_getRows()
	{
		try {
			CLmapTB_LOG stmtselect = new CLmapTB_LOG();
			
			PreparedStatement user = con.prepareStatement(stmtselect.m_select());
			
			//user.setString(1, "log");
			user.setString(1, "username");
			//user.setString(1, "root");
			user.setString(2, "password");
		//	user.setString(2, "root");
			
			ResultSet rs = user.executeQuery();
			
			while (rs.next()) {
				System.out.println(rs.getString("username") + ", " + rs.getString("password"));
			}
		}
		catch (Exception exc) {
			// TODO: handle exception
			exc.printStackTrace();
		}
		return rs;
	}
	public void m_actionRows(String requete)
	{
		try {
			stmt = con.createStatement();
			rslt = stmt.executeUpdate(requete);
		}
		catch (Exception exc) {
			// TODO: handle exception
			exc.printStackTrace();
		}
	}
}
