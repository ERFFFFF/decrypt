package dao.test;

import java.util.ArrayList;

import decrypt_java.model.Dictionary;
import decrypt_java.model.User;

public class DictionaryDaoTest {

	ArrayList<Dictionary> wordList;
	private Dictionary newWord;

	private Dictionary currentWord;

	public DictionaryDaoTest() {

		wordList = new ArrayList<Dictionary>();

	}

	public Dictionary selectWord(String word) {

		for (Dictionary dictionary : wordList) {

			if (dictionary.getWord() == word) {
				
				 this.setCurrentWord(dictionary);
			}
		}

	
		return createWordFromString(word);
	}

	private Dictionary createWordFromString(String word) {

		return new Dictionary(this.wordList.size() + 1, word);

	}

	public ArrayList<Dictionary> getWordList() {
		return wordList;
	}

	public void setWordList(ArrayList<Dictionary> wordList) {
		this.wordList = wordList;
	}

	public Dictionary getCurrentWord() {
		return currentWord;
	}

	public void setCurrentWord(Dictionary dictionary) {
		this.currentWord = dictionary;
	}

}
