package decrypt_java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

	private DatabaseConnection instance;
	private Connection Connectioninstance;

	private Connection connection;

	private static String driver = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/projet_seminaire";
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


//	public  DatabaseConnection getConnectionInstance() {
//
//		if (this.instance == null) {
//
//			if (this.instance == null) {
//				this.Connectioninstance = this.getConnection();
//			}
//
//		}
//
//		return this.instance;
//	}

	
	private void setInstance(DatabaseConnection instance) {

		this.instance = instance;

	}



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

