package dao;

import dao.test.UserDaoImplementationTest;
import junit.framework.TestCase;

public class UserDaoImplementationTestTest extends TestCase {

	UserDaoImplementationTest userDao;

	protected void setUp() throws Exception {
		super.setUp();

		this.userDao = new UserDaoImplementationTest();

		this.userDao.addRow("test1", "password");

	}

	/**
	 * if user is not registered expect null
	 */
	public void testSelectRowFail() {

		assertEquals(null, this.userDao.selectRow("tes", "password"));

	}

	/**
	 * if user 
	 */
	public void testSelectRow() {

		assertEquals("test1", this.userDao.selectRow("test1", "password").getLogin());

		assertEquals(1, (userDao.getUserList().size()));
	}

	public void testAddRow() {

		assertEquals(1, (this.userDao.getUserList().size()));

		assertEquals("toto", this.userDao.addRow("toto", "titi").getLogin());
		assertEquals("password", this.userDao.addRow("chevre", "password").getPassword());
		assertEquals(3, (this.userDao.getUserList().size()));

	}

}
