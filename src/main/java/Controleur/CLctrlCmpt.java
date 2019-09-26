package Controleur;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Model.AccesDonnees;

public class CLctrlCmpt {
	private ResultSet rs;

	public boolean authentifier(String login, String mdp) throws SQLException {
		Boolean boo = false;
		AccesDonnees model = new AccesDonnees();
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

	public void creerCompte(String login, String mdp) {
		AccesDonnees model = new AccesDonnees();
		model.m_actionRows("INSERT INTO log (`username`,`password`) VALUES ('" + login + "','" + mdp + "')");
	}
}
