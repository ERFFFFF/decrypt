package Controleur;


import junit.framework.TestCase;

public class CLctrlCmptTest extends TestCase {

	public void testReqIdentification()
	{
		String login = "test";
		String mdp = "ttt";
		CLctrlCmpt ctrl = new CLctrlCmpt();
		assertTrue(ctrl.authentifier(login, mdp));
		
	}

	public void test2ReqIdentification()
	{
		String mdp = "kek123";
		String login = "ddd";
		CLctrlCmpt ctrl = new CLctrlCmpt();
		assertFalse(ctrl.authentifier(login, mdp));
		
	}

}
