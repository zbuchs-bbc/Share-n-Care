package ch.bbcag.shareandcare.web.controller;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import ch.bbcag.shareandcare.login.LoginBeanLocal;

@ManagedBean
@RequestScoped
public class LoginController {

	private String email;
	private String password;

	@EJB
	private LoginBeanLocal loginBeanLocal;

	public String checkCustomer() {
		FacesContext.getCurrentInstance()
				.addMessage(
						"myForm:password",
						new FacesMessage("PASSWORDS_DONT_MATCH",
								"PASSWORDS_DONT_MATCH"));
		loginBeanLocal.checkCustomer(email, password);
		return null;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
