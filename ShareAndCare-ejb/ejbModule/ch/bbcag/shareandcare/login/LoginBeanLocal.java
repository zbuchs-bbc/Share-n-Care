package ch.bbcag.shareandcare.login;

import javax.ejb.Local;

@Local
public interface LoginBeanLocal {
	public String checkCustomer(String username, String password);
}
