package Model;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class FilesTest {

	@Test
	public void test() throws IOException {		
		Files.setData("./myFile.txt", "Bonjour");
		assertEquals("Bonjour", Files.getData("./myFile.txt"));
	}

}
