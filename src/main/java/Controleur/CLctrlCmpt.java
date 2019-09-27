package Controleur;

import decrypt_java.model.User;
import decrypt_java.service.UserService;

public class CLctrlCmpt {

	public boolean authentifier(String login, String mdp) {

		UserService userService = new UserService();

		return (userService.login(login, mdp) instanceof User) ? true : false;

	}

	public void creerCompte(String login, String mdp) {

		UserService userService = new UserService();

		userService.createUser(login, mdp);
	}
}
