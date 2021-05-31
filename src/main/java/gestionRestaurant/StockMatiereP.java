package gestionRestaurant;


public class StockMatiereP {
	String nom;
	double quantite;
	String mesure;
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public double getQuantite() {
		return quantite;
	}
	public void setQuantite(double quantite) {
		this.quantite = quantite;
	}
	public String getMesure() {
		return mesure;
	}
	public void setMesure(String mesure) {
		this.mesure = mesure;
	}
	@Override
	public String toString() {
		return "StockMatiereP [nom=" + nom + ", quantite=" + quantite + ", mesure=" + mesure + "]";
	}
}
