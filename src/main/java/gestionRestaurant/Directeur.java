package gestionRestaurant;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Directeur extends Personnel{


	public Directeur() {
		super();
	}
	public void gestionPersonnel() {

	}	
	public void gestionCarteDuJour() {

	}	
	public void analyseVente() {

	}
	public void gestionMatPrem(Scanner scanner) {
		String nom = "non";
		do { 
				
			try{

				System.out.print("\nVeilleur saisir le nom: ");
				scanner = new Scanner(System.in);
				nom = scanner.nextLine();

			}catch(InputMismatchException m) {
				System.out.println("Entrer un caractere");
			}
		} while (!isOnlyString(nom));

		do {
			
				
			try{

				System.out.print("\nVeilleur saisir la quantité: ");
				int quantite = scanner.nextInt();

			}catch(InputMismatchException m) {
				System.out.println("Entrer un caractere");
			}
		} while ((quantite <0 ) || (quantite > 50 ) );


		
		do {

			try{
				System.out.print("\nVeilleur saisir la mesure : ");
				String mesure = scanner.next();

			}catch(InputMismatchException m) {
				System.out.println("Entrer un caractere");
			}
		} while (!mesure.contains(mesure) );

		Document doc = new Document();

		doc.append("nom", nom);
		doc.append("quantite", quantite);
		doc.append("mesure", mesure);

		//Pour inserer dans la collection 

		matpremiere.insertOne(doc);
	}

	public static boolean isOnlyString(String mot) {
		int j=0;
		int i=0;
		i = mot.length();
		while(j<i) {
			if("0123456789".contains(mot.substring(j,j+1))) {			
				return false;
			}
			j++;
		}
		return true;
	}
}
