package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class AccesDonnees {
	private String connectionUrl;
	private String login;
	private String psw;
	private Connection con;
	private Statement stmt;
	private ResultSet rs;
	private int rslt;

	public AccesDonnees() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projet_decrypt?serverTimezone=UTC", "root",
					"test123*");
		} catch (Exception exc) {
			// TODO: handle exception
			exc.printStackTrace();
		}
	}

	public ResultSet getRows(String req) {
		try {
			stmt = con.createStatement();
			String sql = req;
			rs = stmt.executeQuery(sql);
		} catch (Exception exc) {
			// TODO: handle exception
			exc.printStackTrace();
		}
		return rs;
	}
	
	public void m_actionRows(String req)
	{
		try {
			stmt = con.createStatement();
			rslt = stmt.executeUpdate(req);
		}
		catch (Exception exc) {
			exc.getMessage();
		}
	}

}
