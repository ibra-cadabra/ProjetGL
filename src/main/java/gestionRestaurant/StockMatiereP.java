package gestionRestaurant;

public class StockMatiereP {
	
	private int idMatPremiere;
	private String nom;
	private int quantite;
	private TypeQuantite typeQuantite;
	
	//Getters and setters
	
	public int getIdMatPremiere() {
		return idMatPremiere;
	}
	public void setIdMatPremiere(int idMatPremiere) {
		this.idMatPremiere = idMatPremiere;
	}
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
	public TypeQuantite getTypeQuantite() {
		return typeQuantite;
	}
	public void setTypeQuantite(TypeQuantite typeQuantite) {
		this.typeQuantite = typeQuantite;
	}
	
	
	@Override
	public String toString() {
		return "StockMatiereP [idMatPremiere=" + idMatPremiere + ", nom=" + nom + ", quantite=" + quantite
				+ ", typeQuantite=" + typeQuantite + "]";
	}
	
	
	
}