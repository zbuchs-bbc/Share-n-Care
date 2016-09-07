package ch.bbcag.shareandcare.ejb;

import java.io.IOException;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.servlet.http.HttpSession;

import model.Article;
import model.Marked;
import model.User;

public class PersonJpaController {

	private EntityManager em;

	public PersonJpaController(EntityManager em) {
		this.em = em;
	}

	public User findUser(User user) {
		return em.find(User.class, user);
	}

	public void createNewCustomer(User user) {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		try {
			em.persist(user);
		} finally {
			try {
				facesContext.getExternalContext().redirect("login.xhtml");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void uploadProfilePicture(String username, String image) {
		image.toString();
		Query query = em.createQuery("UPDATE User u SET u.image = '" + image
				+ "' WHERE u.username = '" + username + "'");
		query.executeUpdate();
	}

	public void createNewComment(String input) {
		em.persist(input);
	}

	public void login(String email, String passwort) {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) facesContext.getExternalContext()
				.getSession(false);
		List<User> users = em.createNamedQuery("User.findAll", User.class)
				.getResultList();
		for (User user : users) {
			if (user.getEmail().equals(email)) {
				if (user.getPassword().equals(passwort)) {
					session.setAttribute("user", user);
					session.setAttribute("authenticated", true);
					try {
						facesContext.getExternalContext().redirect(
								"aboutus.xhtml");
					} catch (IOException e) {
						e.printStackTrace();
					}
					break;
				}
			}
		}
	}

	public void createNewMarked(Marked marked) {
		if (marked != null) {
			em.persist(marked);
		}
	}

	public void updateExcistingCustomer(String username, String password,
			String confirmpassword) {
		Query query = em.createQuery(
				"UPDATE User u SET u.password = :password WHERE u.username = '"
						+ username + "'").setParameter("password", password);
		query.executeUpdate();
	}

	public Article createAnNewArticle(Article article) {
		em.persist(article);
		em.flush();
		em.refresh(article);
		return article;
	}

	public User getMarkedUser(String username) {
		Query query = em
				.createQuery("SELECT u FROM User u WHERE u.username = '"
						+ username + "'");
		return (User) query.getSingleResult();
	}

}
