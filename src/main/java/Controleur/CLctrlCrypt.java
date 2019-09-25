package Controleur;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.AccesDonnees;
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
		
		
		if (!(dictionaryService.findWord("pilote") instanceof Dictionary)) return false;
		

		// Creer le fichier
		Files.setData(destination_path, message);
		
		return true;

	}

}
