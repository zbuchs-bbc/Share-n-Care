package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID_User;

	private String email;

	private String firstname;

	private String image;

	private String password;

	private String secondname;

	private String username;

	//bi-directional many-to-one association to Article
	@OneToMany(mappedBy="user")
	private List<Article> articles;

	//bi-directional many-to-one association to Comment
	@OneToMany(mappedBy="user")
	private List<Comment> comments;

	//bi-directional many-to-one association to Marked
	@OneToMany(mappedBy="user")
	private List<Marked> markeds;

	public User() {
	}

	public int getID_User() {
		return this.ID_User;
	}

	public void setID_User(int ID_User) {
		this.ID_User = ID_User;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSecondname() {
		return this.secondname;
	}

	public void setSecondname(String secondname) {
		this.secondname = secondname;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Article> getArticles() {
		return this.articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	public Article addArticle(Article article) {
		getArticles().add(article);
		article.setUser(this);

		return article;
	}

	public Article removeArticle(Article article) {
		getArticles().remove(article);
		article.setUser(null);

		return article;
	}

	public List<Comment> getComments() {
		return this.comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public Comment addComment(Comment comment) {
		getComments().add(comment);
		comment.setUser(this);

		return comment;
	}

	public Comment removeComment(Comment comment) {
		getComments().remove(comment);
		comment.setUser(null);

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
		marked.setUser(this);

		return marked;
	}

	public Marked removeMarked(Marked marked) {
		getMarkeds().remove(marked);
		marked.setUser(null);

		return marked;
	}

}