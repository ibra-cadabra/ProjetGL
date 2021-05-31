package gestionRestaurant;

public class Serveur extends Personnel {
	
	Etage etage;

	public Serveur(Etage etage) {
		super();
		this.etage = etage;
	}

	public Serveur() {
		super();
		this.etage = new Etage();
	}


	public Etage getEtage() {
		return etage;
	}

	public void setEtage(Etage etage) {
		this.etage = etage;
	}
	
}
