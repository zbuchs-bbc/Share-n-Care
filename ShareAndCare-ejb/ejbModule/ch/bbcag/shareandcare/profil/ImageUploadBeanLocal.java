package ch.bbcag.shareandcare.profil;

import javax.ejb.Local;

@Local
public interface ImageUploadBeanLocal {
	public String uploadImage(String username, String image);
}
