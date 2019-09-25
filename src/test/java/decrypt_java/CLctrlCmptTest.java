package decrypt_java;

import org.junit.Test;

import Controleur.CLctrlCmpt;
import junit.framework.TestCase;

public class CLctrlCmptTest extends TestCase {
	@Test
	public void testReqIdentification()
	{
		String mdp = "kek123";
		String login = "gamerz";
		CLctrlCmpt ctrl = new CLctrlCmpt();
		assertTrue(ctrl.reqIdentification(login, mdp));
		
	}
	@Test
	public void test2ReqIdentification()
	{
		String mdp = "kek123";
		String login = "ddd";
		CLctrlCmpt ctrl = new CLctrlCmpt();
		assertFalse(ctrl.reqIdentification(login, mdp));
		
	}
}
