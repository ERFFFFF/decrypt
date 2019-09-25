package Controleur;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CLctrlCmpt {
	private String connectionUrl;
	private String login;
	private String psw;
	private Connection con;
	private Statement stmt;
	private ResultSet rs;
	private int rslt;

	public CLctrlCmpt() {
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

	public boolean reqIdentification(String login, String mdp) {
		Boolean boo = false;
		try {
			stmt = con.createStatement();
			String sql = "select 1 from log where username='" + login + "' and password='" + mdp + "'";
			rs = stmt.executeQuery(sql);
			//System.out.println(rs.getString("username"));
			if (rs.next()) {
				boo = true;
			} 
		} catch (Exception exc) {
			// TODO: handle exception
			exc.printStackTrace();
		}
		return boo;
	}
	
	public void m_actionRows(String login, String mdp)
	{
		try {
			stmt = con.createStatement();
			rslt = stmt.executeUpdate("INSERT INTO log (`username`,`password`) VALUES ('"+login+"','"+mdp+"')");
		}
		catch (Exception exc) {
			exc.getMessage();
		}
	}
}
