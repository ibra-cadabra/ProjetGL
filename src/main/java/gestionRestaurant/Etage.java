package gestionRestaurant;

import java.util.ArrayList;

public class Etage {
	private int numeroEtage;
	private ArrayList<Table> tables;

	public Etage(int numeroEtage) {
		super();
		this.numeroEtage = numeroEtage;
		this.tables = new ArrayList<Table>();
	}
	
	public Etage() {
		super();
	}


	public int getNumeroEtage() {
		return numeroEtage;
	}

	public void setNumeroEtage(int numeroEtage) {
		this.numeroEtage = numeroEtage;
	}

	public ArrayList<Table> getTables() {
		return tables;
	}

	public void setTables(ArrayList<Table> tables) {
		this.tables = tables;
	}
	
	
	
	

}
