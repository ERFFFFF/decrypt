package Controleur;

import java.sql.ResultSet;
import java.sql.SQLException;
import Model.AccesDonnees;
import decrypt_java.model.User;
import decrypt_java.service.UserService;

public class CLctrlCmpt {
	private ResultSet rs;

	public boolean authentifier(String login, String mdp) {
	
		UserService userService = new UserService();
	if (userService.login("test", "ttt") instanceof User) {
			
			return true;
		}
		
	
	return false;
		
	}

	public void creerCompte(String login, String mdp) {
		AccesDonnees model = new AccesDonnees();
		model.m_actionRows("INSERT INTO log (`username`,`password`) VALUES ('" + login + "','" + mdp + "')");
	}
}
