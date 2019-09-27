package decrypt_java.model;

public class Dictionary  {

	private int id_word;
	private String word;
	
	
	public Dictionary() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Dictionary(int id, String word) {
		
		this.id_word = id;
		this.setWord(word);
	}
	
	
	/**
	 * @return the id_word
	 */
	public int getId_word() {
		return id_word;
	}
	/**
	 * @param id_word the id_word to set
	 */
	public void setId_word(int id_word) {
		this.id_word = id_word;
	}


	/**
	 * @return the word
	 */
	public String getWord() {
		return word;
	}


	/**
	 * @param word the word to set
	 */
	public void setWord(String word) {
		this.word = word;
	}

	
	
}
