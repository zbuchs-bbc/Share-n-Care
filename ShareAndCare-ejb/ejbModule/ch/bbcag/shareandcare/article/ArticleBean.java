package ch.bbcag.shareandcare.article;

import javax.ejb.Stateless;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpSession;

import model.Article;
import model.Marked;
import model.User;
import ch.bbcag.shareandcare.ejb.PersonJpaController;

@Stateless
public class ArticleBean implements ArticleBeanLocal {

	@PersistenceContext
	private EntityManager em;

	Article article = new Article();
	Marked marked = new Marked();

	@Override
	public String addArticle(String input, String shared) {

		PersonJpaController pController = new PersonJpaController(em);

		article.setInput(input);
		article.getTimestamp();
		HttpSession s = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		article.setUser((User) s.getAttribute("user"));

		article = pController.createAnNewArticle(article);

		if (shared != null) {
			String[] tokens = shared.replace("@", "").split(" ");

			for (String username : tokens) {
				User markedUser = pController.getMarkedUser(username);
				marked.setUser(markedUser);
				marked.setArticle(article);
				pController.createNewMarked(marked);
			}
		}
		return ("Article was successfully published !");
	}

}
