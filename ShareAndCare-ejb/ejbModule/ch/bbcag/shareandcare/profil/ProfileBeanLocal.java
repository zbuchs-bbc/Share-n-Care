package ch.bbcag.shareandcare.profil;

import javax.ejb.Local;

@Local
public interface ProfileBeanLocal {
	public String updateUser(String username, String password,
			String confirmpassword);
}
