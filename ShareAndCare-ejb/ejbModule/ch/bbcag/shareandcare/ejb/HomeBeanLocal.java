package ch.bbcag.shareandcare.ejb;

import java.util.List;

import javax.ejb.Local;

import model.Article;
import model.User;

@Local
public interface HomeBeanLocal {
	public List<Article> getAll(User user);
}
