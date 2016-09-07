package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the comment database table.
 * 
 */
@Entity
@NamedQuery(name="Comment.findAll", query="SELECT c FROM Comment c")
public class Comment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID_Comment;

	@Lob
	private String description;

	//bi-directional many-to-one association to Article
	@ManyToOne
	@JoinColumn(name="Article_ID")
	private Article article;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="User_ID")
	private User user;

	public Comment() {
	}

	public int getID_Comment() {
		return this.ID_Comment;
	}

	public void setID_Comment(int ID_Comment) {
		this.ID_Comment = ID_Comment;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Article getArticle() {
		return this.article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}