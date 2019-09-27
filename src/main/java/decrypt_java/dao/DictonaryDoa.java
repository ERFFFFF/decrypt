package decrypt_java.dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import decrypt_java.model.Dictionary;
import decrypt_java.sqlUtils.SqlUtil;

public class DictonaryDoa extends SqlUtil implements IDictonaryDao {

	private Dictionary newWord;

	private static final String FIND_WORD = "{CALL stored_matchingWord_procedure(?)}";

	public DictonaryDoa() {
		super();

	}

	public Dictionary selectWord(String word) throws SQLException {

		CallableStatement cs = null;

		cs = this.getConnectionToUse().prepareCall(FIND_WORD);

		cs.setString(1, word);

		cs.execute();
		ResultSet rs = cs.executeQuery();
		return createWordFromResulset(rs);

	}

	/**
	 * 
	 * @param rs
	 * @return Dictonary
	 * @throws SQLException
	 */
	public Dictionary createWordFromResulset(ResultSet rs) throws SQLException {

		while (rs.next()) {
			setNewWord(new Dictionary(rs.getInt("id_word"), rs.getString("word")));

		}
		return this.getNewWord();

	}

	/**
	 * @return the newWord
	 */
	public Dictionary getNewWord() {
		return newWord;
	}

	/**
	 * @param newWord
	 *            the newWord to set
	 */
	public void setNewWord(Dictionary newWord) {
		this.newWord = newWord;
	}
}
