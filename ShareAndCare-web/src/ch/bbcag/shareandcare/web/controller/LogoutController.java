package ch.bbcag.shareandcare.web.controller;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@RequestScoped
public class LogoutController {

	public String logout() {
		FacesContext.getCurrentInstance().getExternalContext()
				.invalidateSession();
		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("login.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
