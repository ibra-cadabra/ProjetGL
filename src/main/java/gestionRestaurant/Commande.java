package gestionRestaurant;

public class Commande {
	String etatCommande;
	int nbreArticle;
	String TypeMenu;
	String tempsPr�paration;
	int Dur�e;
	
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

	public String getTempsPr�paration() {
		return tempsPr�paration;
	}

	public void setTempsPr�paration(String tempsPr�paration) {
		this.tempsPr�paration = tempsPr�paration;
	}

	public int getDur�e() {
		return Dur�e;
	}

	public void setDur�e(int dur�e) {
		Dur�e = dur�e;
	}

	public Commande(String etatCommande, int nbreArticle, String typeMenu, String tempsPr�paration, int dur�e) {
		super();
		this.etatCommande = etatCommande;
		this.nbreArticle = nbreArticle;
		TypeMenu = typeMenu;
		this.tempsPr�paration = tempsPr�paration;
		Dur�e = dur�e;
	}
	
	

}

