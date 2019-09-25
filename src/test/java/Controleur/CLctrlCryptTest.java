package Controleur;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import Model.Decrypt;
import Model.Files;

public class CLctrlCryptTest {

	@Test
	public void test() throws IOException {
		CLctrlCrypt ctrl = new CLctrlCrypt();
		String messageCrypte = Decrypt.decrypte("mot", "key");
		Files.setData("./myFile.txt",messageCrypte);
		assertTrue(ctrl.pcs_decrypter("./myFile.txt", "./myFileDecrypt.txt"));
	}

}
