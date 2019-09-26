package decrypt_java.service;

import java.sql.SQLException;

import dao.test.UserDaoImplementationTest;
import decrypt_java.model.Dictionary;
import decrypt_java.model.User;

public class DictionaryServiceTest {

	private dao.test.DictionaryDaoTest DictionaryDaoTest;

	private Dictionary dictionary;
	private Dictionary returnedWord;
	
	public DictionaryServiceTest() {
		setDictionaryDaoTest(new dao.test.DictionaryDaoTest());

		setDictionary(new Dictionary());

	}
	
	
public Dictionary findWord(String word)  {
		
		
		this.setReturnedWord( this.getDictionaryDaoTest().selectWord(word));
		// TODO Auto-generated method stub
		return this.getReturnedWord();

	}



	public Dictionary getDictionary() {
		return dictionary;
	}

	public void setDictionary(Dictionary dictionary) {
		this.dictionary = dictionary;
	}


	/**
	 * @return the dictionaryDaoTest
	 */
	public dao.test.DictionaryDaoTest getDictionaryDaoTest() {
		return DictionaryDaoTest;
	}


	/**
	 * @param dictionaryDaoTest2 the dictionaryDaoTest to set
	 */
	public void setDictionaryDaoTest(dao.test.DictionaryDaoTest dictionaryDaoTest2) {
		DictionaryDaoTest = dictionaryDaoTest2;
	}


	/**
	 * @return the returnedWord
	 */
	public Dictionary getReturnedWord() {
		return returnedWord;
	}


	/**
	 * @param returnedWord the returnedWord to set
	 */
	public void setReturnedWord(Dictionary returnedWord) {
		this.returnedWord = returnedWord;
	}

}