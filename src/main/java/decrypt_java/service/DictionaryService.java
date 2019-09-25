package decrypt_java.service;

import java.sql.SQLException;

import decrypt_java.dao.DictonaryDoa;
import decrypt_java.model.Dictionary;

public class DictionaryService {

	DictonaryDoa dictionaryDao;
	Dictionary dictionary;
	
	Dictionary returnedWord;
	
	
	public  DictionaryService() {
		dictionary = new Dictionary();
		dictionaryDao = new DictonaryDoa();
	}
	
	
	public Dictionary findWord(String word)  {
		
		
		try {
			this.setReturnedWord( dictionaryDao.selectWord(word));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return this.getReturnedWord();

	}


	public Dictionary getReturnedWord() {
		return returnedWord;
	}


	public void setReturnedWord(Dictionary returnedWord) {
		this.returnedWord = returnedWord;
	}
	
	
//	
//	public Dictionary addWord(String word) {
//		return this.dictionaryDao.;
//		
//	}
}
