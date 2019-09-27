package Controleur;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

public class CLctrlCmptTest {

	@Test
	public void testReqIdentification() throws SQLException
	{
		String mdp = "kek123";
		String login = "gamerz";
		CLctrlCmpt ctrl = new CLctrlCmpt();
		assertTrue(ctrl.authentifier(login, mdp));
		
	}
	@Test
	public void test2ReqIdentification() throws SQLException
	{
		String mdp = "kek123";
		String login = "ddd";
		CLctrlCmpt ctrl = new CLctrlCmpt();
		assertFalse(ctrl.authentifier(login, mdp));
		
	}

}
