package Controleur;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.Test;

import Model.Decrypt;
import Model.Files;

public class CLctrlCryptTest {

	@Test
	public void test() throws IOException, SQLException {
		CLctrlCrypt ctrl = new CLctrlCrypt();
		String messageCrypte = Decrypt.decrypte("mot le bonjour", "awqpmndfgtab");
		Files.setData("./myFile.txt",messageCrypte);
		assertTrue(ctrl.pcs_decrypter("./myFile.txt", "./myFileDecrypt.txt"));
	}

}
