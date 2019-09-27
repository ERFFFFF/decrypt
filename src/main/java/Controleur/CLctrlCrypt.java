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
	private final static String KEY = "awqpmndf";
	private ResultSet rs;

	/**
	 * Decrypte en cherchant la bonne cle de cryptage et enregiste le mot dans un fichier
	 * @param source_path
	 * @param destination_path
	 * @return
	 * @throws IOException
	 * @throws SQLException
	 */
	public Boolean pcs_decrypter(String source_path, String destination_path) throws IOException, SQLException {
		Boolean boo = false;
		// lire fichier
		String reponse = Files.getData(source_path);	
		System.out.println("response : " + reponse);
		int i = 0;
		
		for (int bytes1=103; bytes1<123; bytes1++)
		{
			for (int bytes2=116; bytes2<123; bytes2++)
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
									System.out.println("succes the key is : " + KEY + (char) bytes1 + (char) bytes2 + (char) bytes3 + (char) bytes4);
									System.out.println("Mot succes : "+ maListeDeMot[i]);
									i++;
									if (i == 2) {
										boo = true;
										System.out.println("Mot succes : "+ maListeDeMot[i]);
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
