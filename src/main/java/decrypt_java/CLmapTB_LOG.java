package decrypt_java;

public class CLmapTB_LOG {
	private int id;
	private String username;
	private String password;
	private String rq_sql;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRq_sql() {
		return rq_sql;
	}

	public void setRq_sql(String rq_sql) {
		this.rq_sql = rq_sql;
	}
	
	public String m_select(String requete)
	{
		return requete;
	}
	
	public void m_insert(String requete)
	{
		CLcad insert = new CLcad();
		insert.m_actionRows(requete);
	}
}
