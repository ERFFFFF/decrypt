package dao;

import junit.framework.TestCase;
import dao.test.DictionaryDaoTest;
import decrypt_java.model.Dictionary;
import decrypt_java.service.DictionaryServiceTest;

public class DictionaryServiceTestTest extends TestCase {

	private DictionaryDaoTest dao;

	public void setUp() throws Exception {
		this.dao = new DictionaryDaoTest();

		dao.getWordList().add(new Dictionary(this.dao.getWordList().size() + 1, "mock"));

	}

	public void testFindWordGetWord() {

		DictionaryServiceTest dico = new DictionaryServiceTest();

		assertEquals("mock", dico.findWord("mock").getWord());
	}

	public void testFindWordGetId() {

		DictionaryServiceTest dico = new DictionaryServiceTest();

		assertEquals(1, dico.findWord("mock").getId_word());
	}

}