package ch.bbcag.shareandcare.article;

import javax.ejb.Local;

@Local
public interface ArticleBeanLocal {
	public String addArticle(String input, String shared);
}
