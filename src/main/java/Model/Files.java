package Model;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Files {

	public static String getData(String source_path) throws IOException {
		FileReader fr = new FileReader(source_path);
		int i;
		String reponse = "";
		while ((i = fr.read()) != -1) {
			reponse += ((char) i);
		}
		return reponse;
	}
	
	public static void setData(String destination_path, String message) throws IOException {
		File fichier = new File(destination_path);
		FileWriter writter = new FileWriter(fichier);
		writter.write(message);
		writter.close();
	}
}
