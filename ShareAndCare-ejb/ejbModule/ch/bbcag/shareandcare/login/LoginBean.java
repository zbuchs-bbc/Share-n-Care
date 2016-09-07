package ch.bbcag.shareandcare.login;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ch.bbcag.shareandcare.ejb.PersonJpaController;

@Stateless
public class LoginBean implements LoginBeanLocal {

	@PersistenceContext
	private EntityManager em;

	@Override
	public String checkCustomer(String username, String password) {

		PersonJpaController pController = new PersonJpaController(em);

		pController.login(username, password);
		return null;
	}
}
