package ch.bbcag.shareandcare.web.controller;

import java.io.IOException;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import ch.bbcag.shareandcare.article.ArticleBeanLocal;

@ManagedBean
@RequestScoped
public class ArticleController {

	private String input;
	private String shared;

	@EJB
	private ArticleBeanLocal articleBeanLocal;

	public void addArticle() {
		articleBeanLocal.addArticle(input, shared);
		System.out.println(shared);

		try {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.getExternalContext().redirect("home.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}

	public String getShared() {
		return shared;
	}

	public void setShared(String shared) {
		this.shared = shared;
	}
}
