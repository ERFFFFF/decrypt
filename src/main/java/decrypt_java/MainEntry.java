package decrypt_java;

import decrypt_java.model.Dictionary;
import decrypt_java.model.User;
import decrypt_java.service.DictionaryService;
import decrypt_java.service.UserService;

public class MainEntry {

	public static void main(String[] args) {
	

		UserService userService = new UserService();
		
		DictionaryService  dictionaryService = new DictionaryService();

		if (userService.login("test", "ttt") instanceof User) {
			
			System.out.println("conncté");
		}
		
		
		if (dictionaryService.findWord("pilote") instanceof Dictionary) {
			System.out.println("bon mot");
		}
	}

}
