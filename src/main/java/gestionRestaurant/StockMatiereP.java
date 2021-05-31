package gestionRestaurant;


public class StockMatiereP {
	String nom;
	int quantite;
	String mesure;
	
	//Getters and setters
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	
	
	@Override
	public String toString() {
		return "StockMatiereP [nom=" + nom + ", quantite=" + quantite
				+"]";
	}	
}