package ch.bbcag.shareandcare.web.controller;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import model.User;
import ch.bbcag.shareandcare.profil.ProfileBeanLocal;

@ManagedBean
@RequestScoped
public class ProfileController {

	private String username;
	private String password;
	private String confirmpassword;

	@EJB
	private ProfileBeanLocal profileBeanLocal;

	public String updateUser() {
		if (!getPassword().equals(getConfirmpassword())) {
			FacesContext.getCurrentInstance().addMessage(
					"profileForm",
					new FacesMessage("PASSWORDS_DONT_MATCH",
							"PASSWORDS_DONT_MATCH"));
			return null;
		} else {
			HttpSession s = (HttpSession) FacesContext.getCurrentInstance()
					.getExternalContext().getSession(false);
			User u = (User) s.getAttribute("user");
			if (u != null && u.getUsername() != null
					&& !u.getUsername().isEmpty()) {
				profileBeanLocal.updateUser(u.getUsername(), password,
						confirmpassword);

			}
			return "login.xhtml";
		}
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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
