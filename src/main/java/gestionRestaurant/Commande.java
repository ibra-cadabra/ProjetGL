package gestionRestaurant;

public class Commande {
	
	private int idCommande;
	private String serveur;
	private double prix;
	private String article;
	private String date;
	
	//Construit la classe commande

	public Commande(int idCommande, String serveur, double prix, String article, String date) {
		super();
		this.serveur = serveur;
		this.prix = prix;
		this.article = article;
		this.date = date;
		this.idCommande = idCommande;
	}

	//Getters and setters de la classe commande
	
	public String getServeur() {
		return serveur;
	}

	public int getIdCommande() {
		return idCommande;
	}

	public void setIdCommande(int idCommande) {
		this.idCommande = idCommande;
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

	@Override
	public String toString() {
		return "Commande [idCommande=" + idCommande + ", serveur=" + serveur + ", prix=" + prix + ", article=" + article
				+ ", date=" + date + "]";
	}

	
	
	
}
