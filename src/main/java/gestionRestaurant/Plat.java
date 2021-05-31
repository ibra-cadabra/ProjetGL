package gestionRestaurant;

enum Categorie {Poissons, Viandes}
enum Menu {Adulte, Enfant}

public class Plat{
	
	//Les attrivuts de la classe
	
	private String nom;
	private double prix;
	private int tempsPreparation;
	private int numTable;
	private String categorie;
	private String menu;
	private String serveur;
	private String etat;
	
	
	//Constructeur par defaut de la classe
	
	public Plat() {
		super();
		this.nom = "";
		this.prix = 0;
		this.tempsPreparation = 0;
		this.categorie = "";
		this.menu = "";
		this.serveur = "";
		this.etat = "";
		this.numTable=0;
	}

    //Getters and setters

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
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

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public String getMenu() {
		return menu;
	}

	public void setMenu(String menu) {
		this.menu = menu;
	}
	

	public String getServeur() {
		return serveur;
	}


	public void setServeur(String serveur) {
		this.serveur = serveur;
	}


	public String getEtat() {
		return etat;
	}


	public void setEtat(String etat) {
		this.etat = etat;
	}


	public int getNumTable() {
		return numTable;
	}


	public void setNumTable(int numTable) {
		this.numTable = numTable;
	}


	@Override
	public String toString() {
		return "Plat [nom=" + nom + ", prix=" + prix + ", tempsPreparation=" + tempsPreparation + ", numTable="
				+ numTable + ", categorie=" + categorie + ", menu=" + menu + ", serveur=" + serveur + ", etat=" + etat
				+ "]";
	}
}
