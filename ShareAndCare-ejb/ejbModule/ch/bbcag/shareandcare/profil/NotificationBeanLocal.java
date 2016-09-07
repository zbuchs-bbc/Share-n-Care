package ch.bbcag.shareandcare.profil;

import java.util.List;

import javax.ejb.Local;

import model.Article;
import model.User;

@Local
public interface NotificationBeanLocal {
	public List<Article> getAllMarkedArticles(User user);
}
