package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AccesDonnees {
	private Connection con;
	private Statement stmt;
	private ResultSet rs;
	private int rslt;
	private static AccesDonnees instance;
	
	public static AccesDonnees getInstance() throws SQLException {
		if (instance == null) {
			setInstance(new AccesDonnees());
		}
		return instance;
	}

	private static void setInstance (final AccesDonnees instance) {
		AccesDonnees.instance = instance;
	}
	
	/**
	 * Connection à la BDD
	 * @throws SQLException
	 */
	private AccesDonnees() throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projet_decrypt?serverTimezone=UTC", "root",
					"test123*");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 *  execute une requete interrogative à la base de donnée
	 * @param req
	 * @return
	 * @throws SQLException
	 */
	public ResultSet getRows(String req) throws SQLException {
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
	
	/**
	 * execute une requete de mise à jour à la base de donnée
	 * @param req
	 */
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
