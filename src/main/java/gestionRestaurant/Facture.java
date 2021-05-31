package gestionRestaurant;

public class Facture {
	
	//Les attributs de la classe
	
	private int idFacture;
	private double montant;
	private String date;
	private Commande[] cmde;
	
	//Constructeur de la classe
	public Facture(int idFacture, double montant, String date, Commande[] cmde) {
		super();
		this.idFacture = idFacture;
		this.montant = montant;
		this.date = date;
		this.cmde = cmde;
	}

	public int getIdFacture() {
		return idFacture;
	}

	public void setIdFacture(int idFacture) {
		this.idFacture = idFacture;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Commande[] getCmde() {
		return cmde;
	}

	public void setCmde(Commande[] cmde) {
		this.cmde = cmde;
	}
}