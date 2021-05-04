package gestionRestaurant;

public class Plat {
	String NomPlat;
	int prix;
	String Categorie;
	int note;
	public Plat(String nomPlat, int prix, String categorie, int note) {
		super();
		NomPlat = nomPlat;
		this.prix = prix;
		Categorie = categorie;
		this.note = note;
	}
	public String getNomPlat() {
		return NomPlat;
	}
	public void setNomPlat(String nomPlat) {
		NomPlat = nomPlat;
	}
	public int getPrix() {
		return prix;
	}
	public void setPrix(int prix) {
		this.prix = prix;
	}
	public String getCategorie() {
		return Categorie;
	}
	public void setCategorie(String categorie) {
		Categorie = categorie;
	}
	public int getNote() {
		return note;
	}
	public void setNote(int note) {
		this.note = note;
	}
	
	
}
