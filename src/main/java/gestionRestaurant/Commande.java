package gestionRestaurant;

public class Commande {
	String etatCommande;
	int nbreArticle;
	String TypeMenu;
	String tempsPréparation;
	int Durée;
	
	public String getEtatCommande() {
		return etatCommande;
	}

	public void setEtatCommande(String etatCommande) {
		this.etatCommande = etatCommande;
	}

	public int getNbreArticle() {
		return nbreArticle;
	}

	public void setNbreArticle(int nbreArticle) {
		this.nbreArticle = nbreArticle;
	}

	public String getTypeMenu() {
		return TypeMenu;
	}

	public void setTypeMenu(String typeMenu) {
		TypeMenu = typeMenu;
	}

	public String getTempsPréparation() {
		return tempsPréparation;
	}

	public void setTempsPréparation(String tempsPréparation) {
		this.tempsPréparation = tempsPréparation;
	}

	public int getDurée() {
		return Durée;
	}

	public void setDurée(int durée) {
		Durée = durée;
	}

	public Commande(String etatCommande, int nbreArticle, String typeMenu, String tempsPréparation, int durée) {
		super();
		this.etatCommande = etatCommande;
		this.nbreArticle = nbreArticle;
		TypeMenu = typeMenu;
		this.tempsPréparation = tempsPréparation;
		Durée = durée;
	}
	
	

}

