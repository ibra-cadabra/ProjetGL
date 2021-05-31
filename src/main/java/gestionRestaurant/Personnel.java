package gestionRestaurant;

import java.util.Date;

public class Personnel {
	public enum Fonction {
	    SERVEUR,
	    DIRECTEUR,
	    MAITREHOTEL,
	    ASSISTANTSERVICE,
	    CUISINIER	    		
	}

	String nom;
	String prenom;
	Date dateNaiss;
	String adresse;
	Fonction fonction;
	
	public Personnel() {
		super();
		this.nom = "";
		this.prenom = "";
		this.dateNaiss = new Date();
		this.adresse = "";
		this.fonction = Fonction.SERVEUR;
	}

	public Personnel(String nom, String prenom, Date dateNaiss, String adresse) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaiss = dateNaiss;
		this.adresse = adresse;
		this.fonction = Fonction.SERVEUR;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Date getDateNaiss() {
		return dateNaiss;
	}

	public void setDateNaiss(Date dateNaiss) {
		this.dateNaiss = dateNaiss;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	
	
	
}
