package Model;

import java.io.IOException;



import junit.framework.TestCase;


public class FilesTest extends TestCase{

	public void test() throws IOException {		
		Files.setData("./myFile.txt", "Bonjour");
		assertEquals("Bonjour", Files.getData("./myFile.txt"));
	}

}
