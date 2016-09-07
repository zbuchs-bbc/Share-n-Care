package ch.bbcag.shareandcare.web.controller;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import model.Article;
import model.Comment;
import model.User;
import ch.bbcag.shareandcare.article.CommentBeanLocal;


@RequestScoped
@ManagedBean
public class CommentController {

	FacesContext facesContext = FacesContext.getCurrentInstance();
	HttpSession session = (HttpSession) facesContext.getExternalContext()
			.getSession(false);

	@EJB
	private CommentBeanLocal commentBeanLocal;

	private Article article;
	private Comment comment = new Comment();
	private String description;

	@ManagedProperty(value="#{param.id}")
	private int id;

	@PostConstruct
	public void init() {
		System.out.println(id);
		User user = (User) session.getAttribute("user");
		setArticle(commentBeanLocal.getArticle(user.getID_User(), id));
	}

	public void save() {
		System.out.println("save");
		commentBeanLocal.publishComment(description, article);

	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
