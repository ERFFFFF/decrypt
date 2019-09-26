package Controleur;

import java.io.IOException;
import java.sql.ResultSet;

import Model.Decrypt;
import Model.Files;
import decrypt_java.model.Dictionary;
import decrypt_java.service.DictionaryService;

public class CLctrlCrypt {
	private final static String KEY = "key";
	private ResultSet rs;

	public Boolean pcs_decrypter(String source_path, String destination_path) throws IOException {
		DictionaryService  dictionaryService = new DictionaryService();

		
		// lire fichier
		String reponse = Files.getData(source_path);

		// crypte le message
		String message = Decrypt.decrypte(reponse, KEY);
		System.out.println("decrypt : "+ message);
		System.out.println("response : " + reponse);
		
		//Verifie le mot dans le dictionnaire
		
		
		if (!(dictionaryService.findWord(reponse) instanceof Dictionary)) return false;
		
		if (!(dictionaryService.findWord(reponse) instanceof Dictionary)) System.out.println("mot inconnu");

		// Creer le fichier
		Files.setData(destination_path, message);
		
		return true;

	}

}
