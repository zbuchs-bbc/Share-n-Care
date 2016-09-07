package ch.bbcag.shareandcare.web.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import model.Article;
import model.Marked;
import model.User;
import ch.bbcag.shareandcare.profil.NotificationBeanLocal;

@ManagedBean
@RequestScoped
public class NotificationController {

	FacesContext facesContext = FacesContext.getCurrentInstance();
	HttpSession session = (HttpSession) facesContext.getExternalContext()
			.getSession(false);

	@EJB
	private NotificationBeanLocal notificationBeanLocal;

	private List<Article> articles;
	private List<Marked> markedArticles;

	@PostConstruct
	public void init() {
		User user = (User) session.getAttribute("user");
		articles = notificationBeanLocal.getAllMarkedArticles(user);
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	public List<Marked> getMarkedArticles() {
		return markedArticles;
	}

	public void setMarkedArticles(List<Marked> markedArticles) {
		this.markedArticles = markedArticles;
	}

}
