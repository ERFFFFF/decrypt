package Controleur;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.AccesDonnees;
import Model.Decrypt;
import Model.Files;
import decrypt_java.model.Dictionary;
import decrypt_java.service.DictionaryService;

public class CLctrlCrypt {
	private final static String KEY = "awqpmndf";
	private ResultSet rs;

	public boolean pcs_decrypter(String source_path, String destination_path) throws IOException, SQLException {
		Boolean boo = false;
		// lire fichier
		String reponse = Files.getData(source_path);	
		System.out.println("response : " + reponse);
		int i = 0;
		
		for (int bytes1=97; bytes1<123; bytes1++)
		{
			for (int bytes2=97; bytes2<123; bytes2++)
			{
				for (int bytes3=97; bytes3<123; bytes3++)
				{
					for (int bytes4=97; bytes4<123; bytes4++)
					{
						if (boo == false)
						{

							// crypte le message
							String message = Decrypt.decrypte(reponse, KEY + (char) bytes1 + (char) bytes2 + (char) bytes3 + (char) bytes4);
							String[] maListeDeMot= message.split(" ");

							
							System.out.println("message decrypté : "+ message);			
							System.out.println("avec la clé : "+KEY + (char) bytes1 + (char) bytes2 + (char) bytes3 + (char) bytes4);
							//Verifie le mot dans le dictionnaire
							AccesDonnees model = AccesDonnees.getInstance();
							System.out.println("mot testé av la bdd : "+maListeDeMot[i]);
						
							rs = model.getRows("select 1 from dictionnaire where mot='" + maListeDeMot[i].replaceAll("'","''") + "'");
							try {
								if (rs.next()) {
									
									i++;
									if (i == 2) {
										boo = true;
									}
									
								}
								
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
					
							// Creer le fichier
							Files.setData(destination_path, message);							
						}

					}
				}
			}

		}
		return boo;
		

	}

}
