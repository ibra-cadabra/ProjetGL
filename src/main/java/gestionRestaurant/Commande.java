package gestionRestaurant;

public class Commande {
	private String nomServeur;	
	private double prix;
	private String nomPlat;
	private int tempsPreparation;
	private String date;

	//Construit la classe commande

	public Commande(String nomServeur, double prix, String nomPlat, String date) {
		super();
		this.nomServeur = nomServeur;
		this.prix = prix;
		this.nomPlat=nomPlat;
		this.date = date;
	}

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

	public void setNomServeur(String nomServeur) {
		this.nomServeur = nomServeur;
	}
	
}