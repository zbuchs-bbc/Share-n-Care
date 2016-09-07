package ch.bbcag.shareandcare.test;

import static org.junit.Assert.assertEquals;
import model.User;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class UserTest {

	private static User u;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		UserTest.u = new User();
	}

	@AfterClass
	public static void teatDownAfterClass() throws Exception {
		UserTest.u = null;
	}

	@Test
	public void testRegisterUser_Success() {
		final String username = "Mia";
		final String firstname = "Mia";
		final String secondname = "Stein";
		final String email = "mia@hotmail.com";
		final String password = "123456";
		u.setUsername(username);
		u.setFirstname(firstname);
		u.setSecondname(secondname);
		u.setEmail(email);
		u.setPassword(password);
		assertEquals(u.getUsername(), username);
		assertEquals(u.getFirstname(), firstname);
		assertEquals(u.getSecondname(), secondname);
		assertEquals(u.getEmail(), email);
		assertEquals(u.getPassword(), password);
	}

	@Test
	public void testRegisterUser_Fail() {
		final String passwordCorrect = "123456";
		final String passwordIncorrect = "12345";
		u.setPassword(passwordCorrect);
		u.setPassword(passwordIncorrect);
		assertEquals(u.getPassword(), passwordCorrect);
		assertEquals(u.getPassword(), passwordIncorrect);
	}

}
