package decrypt_java;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SqlUtil {

	
	DatabaseConnection connectionToUse;
	private CallableStatement query;
	
	
	public SqlUtil() {
		
		connectionToUse = DatabaseConnection.getINSTANCE();
	}
	
	
public ResultSet executeQuery (String literal){
		
		try {
			query = connectionToUse.getConnection().prepareCall( literal);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			query.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResultSet result = null;
		try {
			result = query.getResultSet();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			result.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
		

	}

	public Connection getConnectionToUse() {
		return connectionToUse.getConnection();
	}

	public void setConnectionToUse(DatabaseConnection connectionToUse) {
		this.connectionToUse = connectionToUse;
	}
	
	
	
}
