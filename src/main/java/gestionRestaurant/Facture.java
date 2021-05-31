package gestionRestaurant;

<<<<<<< HEAD

public class Facture {
	int idFacture;
	double montant;
	//date
	int idCommande;
	
	
}
	
=======
import java.util.Date;

public class Facture {
	
	//Les attributs de la classe
	
	private int idFacture;
	private double montant;
	private Date date;
	private Commande cmde;
	
	//Constructeur de la classe
	
	public Facture(int idFacture, double montant, Date date, Commande cmde) {
		super();
		this.idFacture = idFacture;
		this.montant = montant;
		this.date = date;
		this.cmde = cmde;
	}
	
	//Getters and setters

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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Commande getCmde() {
		return cmde;
	}

	public void setCmde(Commande cmde) {
		this.cmde = cmde;
	}

	@Override
	public String toString() {
		return "Facture [idFacture=" + idFacture + ", montant=" + montant + ", date=" + date + ", cmde=" + cmde + "]";
	}
	
	
}
>>>>>>> 7f844e9d4235101ad4b24bc430c37a64fb48d24c
