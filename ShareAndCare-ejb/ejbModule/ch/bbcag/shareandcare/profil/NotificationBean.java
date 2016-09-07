package ch.bbcag.shareandcare.profil;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.Article;
import model.User;

@Stateless
public class NotificationBean implements NotificationBeanLocal {

	@PersistenceContext
	private EntityManager em;

	public List<Article> getAllMarkedArticles(User user) {
		List<Article> articles = new ArrayList<Article>();

		Query query = em
				.createQuery(
						"SELECT a FROM Article a JOIN a.markeds m WHERE m.user.ID_User = :id ORDER BY a.timestamp DESC")
				.setParameter("id", user.getID_User());

		if (query == null) {

		} else {
			articles = query.getResultList();
		}
		return articles;
	}
}
