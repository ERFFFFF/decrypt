package Model;

import static org.junit.Assert.*;

import org.junit.Test;

public class DecryptTest {

	@Test
	public void test() {
		String message = "mot";
		String key = "key";
		String messageCrypte = Decrypt.decrypte(message, key);
		assertEquals("mot", Decrypt.decrypte(messageCrypte, key));
	}

}
