package decrypt_java;

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

	public ResultSet m_getRows(String requete) {
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(requete);

			while (rs.next()) {
				System.out.println(
						rs.getString("id") + ", " + rs.getString("username") + ", " + rs.getString("password"));
			}
		} catch (Exception exc) {
			// TODO: handle exception
			exc.printStackTrace();
		}
		return rs;
	}

	public boolean reqIdentification(String login, String mdp) {
		Boolean boo = false;
		try {
			stmt = con.createStatement();
			String sql = "select 1 from log where username='" + login + "' and password='" + mdp + "'";
			System.out.println(sql);
			rs = stmt.executeQuery(sql);
			//System.out.println(rs.getString("username"));
			if (rs.next()) {
				boo = true;
				System.out.println("kokok");
			} 
		} catch (Exception exc) {
			// TODO: handle exception
			exc.printStackTrace();
		}
		return boo;
	}
}
