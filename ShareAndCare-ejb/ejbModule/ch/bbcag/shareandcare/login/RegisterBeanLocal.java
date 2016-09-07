package ch.bbcag.shareandcare.login;

import javax.ejb.Local;

@Local
public interface RegisterBeanLocal {
	public String registerUser(String username, String firstname,
			String secondname, String email, String password);

}
