package gestionRestaurant;

public class Table {
	private int numero;
	private int etage;
	private int nbPlace;
	private String couleur;
	
	public Table(int numero, int etage, int nbPlace, String couleur) {
		super();
		this.numero = numero;
		this.nbPlace = nbPlace;
		this.etage = etage;
		this.couleur = couleur;
	}

	public Table() {
		super();
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getNbPlace() {
		return nbPlace;
	}

	public void setNbPlace(int nbPlace) {
		this.nbPlace = nbPlace;
	}

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	public int getEtage() {
		return etage;
	}

	public void setEtage(int etage) {
		this.etage = etage;
	}
}
