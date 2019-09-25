package Controleur;

import decrypt_java.model.User;
import decrypt_java.service.UserService;

public class CLctrlCmpt {

	public boolean authentifier(String login, String mdp) {

		UserService userService = new UserService();
		if (userService.login("test", "ttt") instanceof User) {

			return true;
		}

		return false;

	}

	public void creerCompte(String login, String mdp) {

		UserService userService = new UserService();
		
		userService.createUser(login, mdp);
	}
}
