package decrypt_java;

public class MainEntry {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//CLcad bdd = new CLcad();
		CLmapTB_LOG obj1 = new CLmapTB_LOG();
				
		
		
		//obj1.m_insert("INSERT INTO log (`id`,`username`,`password`) VALUES ('1','player3','polette')");
		//obj1.m_insert("DELETE FROM `log` WHERE `id` = 1");
		obj1.m_select("select * from log");
	}

}
