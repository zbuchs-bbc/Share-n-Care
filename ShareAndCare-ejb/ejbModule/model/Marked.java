package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the marked database table.
 * 
 */
@Entity
@NamedQuery(name="Marked.findAll", query="SELECT m FROM Marked m")
public class Marked implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID_Marked;

	//bi-directional many-to-one association to Article
	@ManyToOne
	@JoinColumn(name="Article_ID")
	private Article article;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="User_ID")
	private User user;

	public Marked() {
	}

	public int getID_Marked() {
		return this.ID_Marked;
	}

	public void setID_Marked(int ID_Marked) {
		this.ID_Marked = ID_Marked;
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