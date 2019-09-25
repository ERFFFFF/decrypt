package decrypt_java.dao;

import java.sql.SQLException;

import decrypt_java.model.Dictionary;

public interface IDictonaryDao {

	public Dictionary selectWord(String word) throws SQLException;
}
