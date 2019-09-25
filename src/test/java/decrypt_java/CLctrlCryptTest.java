package decrypt_java;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import Controleur.CLctrlCrypt;

public class CLctrlCryptTest {

	@Test
	public void testEcritureLecture() throws IOException {
		CLctrlCrypt.ecrireFichierSimple("C:\\Users\\cedri\\Desktop\\a.txt", "Bonjour a tous. Comment Allez vous?");
		assertEquals("Bonjour a tous. Comment Allez vous?", CLctrlCrypt.lireFichierSimple("C:\\Users\\cedri\\Desktop\\a.txt"));
	}
	
	@Test
	public void testCryptage() throws IOException {
		String mot ="Bonjour a tous. Comment Allez vous?" ;
		String key = "key";
		String motCrypte = CLctrlCrypt.crypter(mot, key);
		assertEquals("Bonjour a tous. Comment Allez vous?", CLctrlCrypt.crypter(motCrypte, key));
	}
}
