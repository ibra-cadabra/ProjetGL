package gestionRestaurant;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.bson.Document;

import com.mongodb.client.MongoCollection;

public class Directeur extends Personnel{

	public Directeur() {
		super();
	}
	
	public static void init(Scanner scanner, MongoCollection<Document> collection) {
		System.out.println("Ajouter un produit");
		ajouterProduit(scanner, collection);
	}
	
	public static void ajouterProduit(Scanner scanner, MongoCollection<Document> collection) {
		String nom = "non";
		String mesuration= "kilo litre";
		int quantite=0;
		String mesure="";
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
				quantite = scanner.nextInt();
			}catch(InputMismatchException m) {
				System.out.println("Entrer un caractere");
			}
		} while ((quantite <0 ) || (quantite > 50 ) );
		do {
			try{
				System.out.print("\nVeilleur saisir la mesure : ");
				mesure = scanner.nextLine();
			}catch(InputMismatchException m) {
				System.out.println("Entrer un caractere");
			}
		} while (!mesuration.contains(mesure) );

		Document doc = new Document();
		doc.append("nom", nom);
		doc.append("quantite", quantite);
		doc.append("mesure", mesure);

		//Pour inserer dans la collection 
		collection.insertOne(doc);
	}

	public static boolean isOnlyString(String mot) {
		int j=0;
		int i=0;
		i = mot.length();
		while(j<i) {
			if("0123456789".contains(mot.substring(j,j+1)))
				return false;
			j++;
		}
		return true;
	}
}
