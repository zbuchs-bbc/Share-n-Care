package ch.bbcag.shareandcare.article;

import javax.ejb.Stateless;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.http.HttpSession;

import model.Article;
import model.Comment;
import model.User;

@Stateless
public class CommentBean implements CommentBeanLocal {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Article getArticle(int userid, int articleid) {

		Query query = em
				.createQuery(
						"SELECT a FROM Article a JOIN a.markeds m WHERE (a.user.ID_User = :uid OR m.user.ID_User = :uid) AND a.ID_Article = :aid ORDER BY a.timestamp DESC")
				.setParameter("uid", userid).setParameter("aid", articleid);
		try {
			if (query.getSingleResult() == null) {
				System.out.println("leer");
				return null;
			} else {
				System.out.println("article was here");
				return (Article) query.getSingleResult();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void publishComment(String description, Article article) {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) facesContext.getExternalContext()
				.getSession(false);
		Comment comment = new Comment();
		System.out.println(article.getID_Article());
		comment.setDescription(description);
		comment.setUser((User) session.getAttribute("user"));
		comment.setArticle(article);
		em.persist(comment);
	}

}
