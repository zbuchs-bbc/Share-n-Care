package ch.bbcag.shareandcare.profil;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.User;
import ch.bbcag.shareandcare.ejb.PersonJpaController;

@Stateless
public class ImageUploadBean implements ImageUploadBeanLocal {

	@PersistenceContext
	private EntityManager em;

	@Override
	public String uploadImage(String username, String image) {

		PersonJpaController pController = new PersonJpaController(em);

		User user = new User();
		user.setImage(image);

		pController.uploadProfilePicture(username, image);

		return ("You have uploaded your profile picture successfully!");
	}

}
