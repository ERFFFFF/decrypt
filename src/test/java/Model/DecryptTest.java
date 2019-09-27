package Model;




import junit.framework.TestCase;


public class DecryptTest extends TestCase {

	public void test() {
		String message = "mot";
		String key = "key";
		String messageCrypte = Decrypt.decrypte(message, key);
		assertEquals("mot", Decrypt.decrypte(messageCrypte, key));
	}

}
