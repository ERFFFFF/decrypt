package Controleur;


import java.io.IOException;

import Model.Decrypt;
import Model.Files;
import junit.framework.TestCase;

public class CLctrlCryptTest extends TestCase {

	public void test() throws IOException {
		CLctrlCrypt ctrl = new CLctrlCrypt();
		String messageCrypte = Decrypt.decrypte("mot", "key");
		Files.setData("./myFile.txt",messageCrypte);
		assertEquals(true, ctrl.pcs_decrypter("./myFile.txt", "./myFileDecrypt.txt"));
	}

	public void expectedFailure() throws IOException {
		CLctrlCrypt ctrl = new CLctrlCrypt();
		String messageCrypte = Decrypt.decrypte("chevre", "key");
		Files.setData("./myFile.txt",messageCrypte);
		assertEquals(false, ctrl.pcs_decrypter("./myFile.txt", "./myFileDecrypt.txt"));
	}

}
