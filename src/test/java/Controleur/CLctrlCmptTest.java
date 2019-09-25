package Controleur;

import static org.junit.Assert.*;

import org.junit.Test;

public class CLctrlCmptTest {

	@Test
	public void testReqIdentification()
	{
		String mdp = "kek123";
		String login = "gamerz";
		CLctrlCmpt ctrl = new CLctrlCmpt();
		assertTrue(ctrl.authentifier(login, mdp));
		
	}
	@Test
	public void test2ReqIdentification()
	{
		String mdp = "kek123";
		String login = "ddd";
		CLctrlCmpt ctrl = new CLctrlCmpt();
		assertFalse(ctrl.authentifier(login, mdp));
		
	}

}
