package dao;

import dao.test.DictionaryDaoTest;
import decrypt_java.model.Dictionary;
import decrypt_java.service.DictionaryServiceTest;
import junit.framework.TestCase;

public class DictionaryDaoTestTest extends TestCase {

	private DictionaryDaoTest dao;

	protected void setUp() throws Exception {
		super.setUp();
		
		this.dao = new DictionaryDaoTest();

		dao.getWordList().add(new Dictionary(this.dao.getWordList().size() + 1, "mock"));

	}

	public void testSelectWord() {

		DictionaryServiceTest dico = new DictionaryServiceTest();

		assertEquals("mock", dico.findWord("mock").getWord());
	
		
	}

}
