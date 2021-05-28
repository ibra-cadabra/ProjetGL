package gestionRestaurant;

public class LigneCommande {
	
	//Les attributs
	
	private Plat plat;
	private Commande commande;
	private double prix;
	
	
	//Construit la classe 
	
	public LigneCommande(Plat plat, Commande commande, double prix) {
		super();
		this.plat = plat;
		this.commande = commande;
		this.prix = prix;
	}

	//Getters and setters
	
	public Plat getPlat() {
		return plat;
	}
	public void setPlat(Plat plat) {
		this.plat = plat;
	}
	public Commande getCommande() {
		return commande;
	}
	public void setCommande(Commande commande) {
		this.commande = commande;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}

	@Override
	public String toString() {
		return "LigneCommande [plat=" + plat + ", commande=" + commande + ", prix=" + prix + "]";
	}
	
}
