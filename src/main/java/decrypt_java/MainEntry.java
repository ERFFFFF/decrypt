package decrypt_java;

import java.sql.SQLException;

public class MainEntry {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		//CLcad bdd = new CLcad();
		CLmapTB_LOG obj1 = new CLmapTB_LOG();
		
		CLcad ob = new CLcad();
		ob.m_getRows();
		
		obj1.m_select();
		//CLcad select = new CLcad();
		//select.m_getRows(requete);
		
		//obj1.getRq_sql();
		
		//obj1.m_insert("INSERT INTO log (`id`,`username`,`password`) VALUES ('1','player3','polette')");
		//obj1.m_insert("DELETE FROM `log` WHERE `id` = 1");
		//obj1.m_select("select * from log");
	}

}
