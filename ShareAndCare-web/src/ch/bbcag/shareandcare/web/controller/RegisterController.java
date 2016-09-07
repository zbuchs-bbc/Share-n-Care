package ch.bbcag.shareandcare.web.controller;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;

import ch.bbcag.shareandcare.login.RegisterBeanLocal;

@ManagedBean
@RequestScoped
public class RegisterController {

	private String username;
	private String firstname;
	private String secondname;
	private String email;
	private String password;
	private String confirmpassword;

	@EJB
	private RegisterBeanLocal registerBeanLocal;

	public String registerUser() {
		registerBeanLocal.registerUser(username, firstname, secondname, email,
				password);
		return null;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getSecondname() {
		return secondname;
	}

	public void setSecondname(String secondname) {
		this.secondname = secondname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmpassword() {
		return confirmpassword;
	}

	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}

}
