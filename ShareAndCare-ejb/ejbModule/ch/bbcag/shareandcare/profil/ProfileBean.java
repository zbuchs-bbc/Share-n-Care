package ch.bbcag.shareandcare.profil;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.User;
import ch.bbcag.shareandcare.ejb.PersonJpaController;

@Stateless
public class ProfileBean implements ProfileBeanLocal {

	@PersistenceContext
	private EntityManager em;

	@Override
	public String updateUser(String username, String password,
			String confirmpassword) {

		PersonJpaController pController = new PersonJpaController(em);

		User user = new User();
		user.setPassword(password);

		pController
				.updateExcistingCustomer(username, password, confirmpassword);

		return ("The password has successfully changed!");
	}
}