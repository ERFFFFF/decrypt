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

public class CLctrlCrypt {
	private final static String KEY = "key";
	private ResultSet rs;

	public Boolean pcs_decrypter(String source_path, String destination_path) throws IOException {
		// lire fichier
		String reponse = Files.getData(source_path);

		// crypte le message
		String message = Decrypt.decrypte(reponse, KEY);
		System.out.println("decrypt : "+ message);
		System.out.println("response : " + reponse);
		
		//Verifie le mot dans le dictionnaire
		Boolean boo = false;
		AccesDonnees model = new AccesDonnees();
		rs = model.getRows("select 1 from dictionnaire where mot='" + message + "'");
		try {
			if (rs.next()) {
				boo = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Creer le fichier
		Files.setData(destination_path, message);
		
		return boo;

	}

}
