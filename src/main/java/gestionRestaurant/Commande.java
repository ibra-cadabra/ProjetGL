package gestionRestaurant;

public class Commande {
	private String serveur;
	private double prix;
	private String article;
	private String date;

	public Commande(String serveur, double prix, String article, String date) {
		super();
		this.serveur = serveur;
		this.prix = prix;
		this.article = article;
		this.date = date;
	}

	public String getServeur() {
		return serveur;
	}

	public void setServeur(String serveur) {
		this.serveur = serveur;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getArticle() {
		return article;
	}

	public void setArticle(String article) {
		this.article = article;
	}
	
	
	
}
