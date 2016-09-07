package ch.bbcag.shareandcare.web.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import model.Article;
import model.User;
import ch.bbcag.shareandcare.ejb.HomeBeanLocal;

@ManagedBean
@RequestScoped
public class HomeController {

	FacesContext facesContext = FacesContext.getCurrentInstance();
	HttpSession session = (HttpSession) facesContext.getExternalContext()
			.getSession(false);

	@EJB
	private HomeBeanLocal homeBeanLocal;

	private List<Article> articles;

	@PostConstruct
	public void init() {
		User user = (User) session.getAttribute("user");
		articles = homeBeanLocal.getAll(user);
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

}
