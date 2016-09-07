package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the article database table.
 * 
 */
@Entity
@NamedQuery(name="Article.findAll", query="SELECT a FROM Article a")
public class Article implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID_Article;

	@Lob
	private String input;

	private Timestamp timestamp;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="User_ID")
	private User user;

	//bi-directional many-to-one association to Comment
	@OneToMany(mappedBy="article")
	private List<Comment> comments;

	//bi-directional many-to-one association to Marked
	@OneToMany(mappedBy="article")
	private List<Marked> markeds;

	public Article() {
	}

	public int getID_Article() {
		return this.ID_Article;
	}

	public void setID_Article(int ID_Article) {
		this.ID_Article = ID_Article;
	}

	public String getInput() {
		return this.input;
	}

	public void setInput(String input) {
		this.input = input;
	}

	public Timestamp getTimestamp() {
		return this.timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Comment> getComments() {
		return this.comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public Comment addComment(Comment comment) {
		getComments().add(comment);
		comment.setArticle(this);

		return comment;
	}

	public Comment removeComment(Comment comment) {
		getComments().remove(comment);
		comment.setArticle(null);

		return comment;
	}

	public List<Marked> getMarkeds() {
		return this.markeds;
	}

	public void setMarkeds(List<Marked> markeds) {
		this.markeds = markeds;
	}

	public Marked addMarked(Marked marked) {
		getMarkeds().add(marked);
		marked.setArticle(this);

		return marked;
	}

	public Marked removeMarked(Marked marked) {
		getMarkeds().remove(marked);
		marked.setArticle(null);

		return marked;
	}

}