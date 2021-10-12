package model;

public class Commentaire {
	private int id;
	private String commentaire;
	private String auteur;
	private int article_id;
	private String created_at;
	
	public Commentaire() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Commentaire(String commentaire, String auteur, int article_id, String created_at) {
		super();
		this.commentaire = commentaire;
		this.auteur = auteur;
		this.article_id = article_id;
		this.created_at = created_at;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public int getArticle_id() {
		return article_id;
	}

	public void setArticle_id(int article_id) {
		this.article_id = article_id;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	
}
