package ch.bbcag.shareandcare.login;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.User;
import ch.bbcag.shareandcare.ejb.PersonJpaController;

/**
 * Session Bean implementation class RegisterBean
 */
@Stateless
public class RegisterBean implements RegisterBeanLocal {

	@PersistenceContext
	private EntityManager em;

	public RegisterBean() {
	}

	@Override
	public String registerUser(String username, String firstname,
			String secondname, String email, String password) {

		PersonJpaController pController = new PersonJpaController(em);

		User user = new User();
		user.setUsername(username);
		user.setFirstname(firstname);
		user.setSecondname(secondname);
		user.setEmail(email);
		user.setPassword(password);

		pController.createNewCustomer(user);

		return ("Registriert: " + email + " / " + password);
	}
}
