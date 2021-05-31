package gestionRestaurant;

public class Commande {
<<<<<<< HEAD
	private String nomServeur;
=======
	
	private int idCommande;
	private String serveur;
>>>>>>> 7f844e9d4235101ad4b24bc430c37a64fb48d24c
	private double prix;
	private String nomPlat;
	private int tempsPreparation;
	private String date;
	
<<<<<<< HEAD
	public Commande(String nomServeur, double prix, String nomPlat, String date) {
=======
	//Construit la classe commande

	public Commande(int idCommande, String serveur, double prix, String article, String date) {
>>>>>>> 7f844e9d4235101ad4b24bc430c37a64fb48d24c
		super();
		this.nomServeur = nomServeur;
		this.prix = prix;
		this.nomPlat=nomPlat;
		this.date = date;
		this.idCommande = idCommande;
	}

<<<<<<< HEAD
	public Commande() {
		super();
		this.nomServeur = "";
		this.prix = 0;
		this.nomPlat="";
		this.date = "";
	}

	public String getNomPlat() {
		return nomPlat;
	}

	public void setNomPlat(String nomPlat) {
		this.nomPlat = nomPlat;
	}

	public String getNomServeur() {
		return nomServeur;
	}

	public void setNomServeur(String nomServeur) {
		this.nomServeur = nomServeur;
=======
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
>>>>>>> 7f844e9d4235101ad4b24bc430c37a64fb48d24c
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public int getTempsPreparation() {
		return tempsPreparation;
	}

	public void setTempsPreparation(int tempsPreparation) {
		this.tempsPreparation = tempsPreparation;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
<<<<<<< HEAD
		
}
=======

	@Override
	public String toString() {
		return "Commande [idCommande=" + idCommande + ", serveur=" + serveur + ", prix=" + prix + ", article=" + article
				+ ", date=" + date + "]";
	}

	
	
	
}
>>>>>>> 7f844e9d4235101ad4b24bc430c37a64fb48d24c
