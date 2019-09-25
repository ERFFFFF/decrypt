package Controleur;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class CLctrlCrypt {

	public static void ecrireFichierSimple(String chemin, String texte) throws IOException {
		File fichier = new File(chemin);
		FileWriter writter = new FileWriter(fichier);
	    writter.write (texte);
	    writter.close();	
	}

	public static String lireFichierSimple(String chemin) throws IOException {
		FileReader fr = new FileReader(chemin); 	  
		int i; 
		String reponse = "";
		while ((i=fr.read()) != -1) {
		    reponse += ((char) i); 
		} 
		return reponse;
	}

	public static String crypter(String inputString, String key) {
		StringBuilder sb1;
		char c1;
		char c2;
		char c3;
		int i;
		int ii = 0;
		sb1 = new StringBuilder();
		for(i=0;i < inputString.length();i++) {
			c1=inputString.charAt(i);
			c2 = key.charAt(ii);
			c3=(char)(c1^c2);
			sb1.append(c3);
			ii++;
			if(ii== key.length()) {
				ii=0;
			}
		}
		return sb1.toString();
		
	}
}
