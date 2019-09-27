package decrypt_java.sqlUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

	private Connection Connectioninstance;


	private static String driver = "com.mysql.cj.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/projet_seminaire?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
	private static String password = "root";
	private static String user = "root";

	private DatabaseConnection() {

		try {
			Class.forName(DatabaseConnection.driver);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			setConnection(DriverManager.getConnection(url, user, password));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
  

	public void setConnection(Connection connection2) {

		this.Connectioninstance = connection2;
	}

	public Connection getConnection() {
		
		return this.Connectioninstance;
	}


	private static DatabaseConnection INSTANCE = new DatabaseConnection();

	


	/**
	 * @return the iNSTANCE
	 */
	public static  DatabaseConnection getINSTANCE() {
		return INSTANCE;
	}



	/**
	 * @param iNSTANCE the iNSTANCE to set
	 */
	public static void setINSTANCE(DatabaseConnection iNSTANCE) {
		INSTANCE = iNSTANCE;
	}

}

