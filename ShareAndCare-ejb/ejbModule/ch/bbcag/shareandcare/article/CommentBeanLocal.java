package ch.bbcag.shareandcare.article;

import javax.ejb.Local;

import model.Article;

@Local
public interface CommentBeanLocal {
	public Article getArticle(int userid, int articleid);

	void publishComment(String description, Article article);
}
