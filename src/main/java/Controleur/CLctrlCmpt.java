package Controleur;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Model.AccesDonnees;

public class CLctrlCmpt {
	private ResultSet rs;

	/**
	 * comparaison des identifiants en entrée avec les identifiants dans la BDD
	 * @param login
	 * @param mdp
	 * @return
	 * @throws SQLException
	 */
	public boolean authentifier(String login, String mdp) throws SQLException {
		Boolean boo = false;
		AccesDonnees model = AccesDonnees.getInstance();
		rs = model.getRows("select 1 from log where username='" + login + "' and password='" + mdp + "'");
		try {
			if (rs.next()) {
				boo = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return boo;
	}

	/**
	 * Ajoute les identifiants en entrée dans la BDD
	 * @param login
	 * @param mdp
	 * @throws SQLException
	 */
	public void creerCompte(String login, String mdp) throws SQLException {
		AccesDonnees model = AccesDonnees.getInstance();
		model.m_actionRows("INSERT INTO log (`username`,`password`) VALUES ('" + login + "','" + mdp + "')");
	}
}
