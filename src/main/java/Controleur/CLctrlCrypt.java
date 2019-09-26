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

	public boolean pcs_decrypter(String source_path, String destination_path) throws IOException {
		DictionaryService dictionaryService = new DictionaryService();

		// lire fichier
		String reponse = Files.getData(source_path);

		// crypte le message
		String message = Decrypt.decrypte(reponse, KEY);
		System.out.println("decrypt : " + message);
		System.out.println("response : " + reponse);

		// Verifie le mot dans le dictionnaire

		// Creer le fichier
		if ((dictionaryService.findWord(message) instanceof Dictionary)) Files.setData(destination_path, message);

		return (dictionaryService.findWord(message) instanceof Dictionary) ? true : false;

	}

}
