package decrypt_java;
import java.sql.*;

public class bdd
{	
	public static void bdd()
	{
		try {
			Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/projet_decrypt?serverTimezone=UTC", "root", "test123*");
			Statement myStmt = connect.createStatement();
			ResultSet myRequest = myStmt.executeQuery("select * from log");
			
			while (myRequest.next()) {
				System.out.println(myRequest.getString("id") + ", " + myRequest.getString("username") + ", " + myRequest.getString("password"));
			}
		}
		catch (Exception exc) {
			// TODO: handle exception
			exc.printStackTrace();
		}
	}
}
