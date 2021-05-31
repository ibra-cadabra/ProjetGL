package gestionRestaurant;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.bson.Document;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;

public class Directeur extends Personnel {

	private static String categorie;

	public Directeur() {
		super();
	}

	public static boolean chercherPlat(String plat, MongoCollection<Document> collection) throws ParseException {

		JSONParser jsonP = new JSONParser();

		BasicDBObject query = new BasicDBObject();
		query.put("nom", new BasicDBObject("$eq", plat));

		for (Document doc : collection.find(query)) {
			JSONObject jo = (JSONObject) jsonP.parse(doc.toJson());
			if (jo.get("nom").toString().equals(plat)) {
				System.out.println(doc.toJson());
				return true;
			}
		}
		return false;
	}

	// gestion de la carte du jour parmi la liste des plats enregistrés dans la base
	// de données
	// cette methode permet au directeur d'enregister un plat dans la collection
	// carte du jour

	public static String saisieNomPlat(Scanner sc, MongoCollection<Document> collection) throws ParseException {

		String nomPlat = "";
		do {
			//nomPlat = "";
			System.out.print("Le nom du plat : ");
			try {
				sc = new Scanner(System.in);
				nomPlat = sc.nextLine();
			} catch (InputMismatchException e) {
				System.out.println("Entrer chaine de caractères");
				saisieNomPlat(sc, collection);
			}
		} while (!chercherPlat(nomPlat, collection));

		return nomPlat;
	}

	public static String saisieCategorie(Scanner sc) {
		String catPlat = "";
		do {
			try {
				sc = new Scanner(System.in);
				System.out.print("La categorie : ");
				catPlat = sc.nextLine();
			} catch (InputMismatchException e) {
				System.out.println("Entrer une chaine de caractères");
				saisieCategorie(sc);
			}
		} while (!categorie.contains(catPlat));

		return catPlat;
	}
	public static double saisiePrix(Scanner scanner) {
		double prix = 0;
		do {
			try {
				scanner = new Scanner(System.in);
				System.out.print("La categorie : ");
				prix = scanner.nextDouble();
			} catch (InputMismatchException e) {
				System.out.println("Entrer une chaine de caractères");
				saisieCategorie(scanner);
			}
		} while ((prix < 0) || prix > 100);

		return prix;
	}

	public static void gestionCarteDuJour(Scanner scanner, MongoCollection<Document> collectionC, MongoCollection<Document> collectionP) throws ParseException {

		String nomPlat = saisieNomPlat(scanner, collectionP);
		String catPlat = saisieCategorie(scanner);
		double prix = saisiePrix(scanner);

		// Formattage pour obtenir la date du jour
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String datef = simpleDateFormat.format(new Date());

		Document doc = new Document();

		doc.append("nom", nomPlat);
		doc.append("prix", prix);
		doc.append("categorie", catPlat);
		doc.append("date", datef);

		// Insertion dans la collection carte du jour
		collectionC.insertOne(doc);
	}

	public void ajouterProduit(Scanner scanner, MongoCollection<Document> collection) {
		String nom = "non";
		String mesuration = "kilo litre";
		int quantite = 0;
		String mesure = "";
		do {
			try {
				System.out.print("\nVeilleur saisir le nom: ");
				scanner = new Scanner(System.in);
				nom = scanner.nextLine();
			} catch (InputMismatchException m) {
				System.out.println("Entrer un caractere");
			}
		} while (!isOnlyString(nom));
		do {
			try {
				System.out.print("\nVeilleur saisir la quantité: ");
				quantite = scanner.nextInt();
			} catch (InputMismatchException m) {
				System.out.println("Entrer un caractere");
			}
		} while ((quantite < 0) || (quantite > 50));
		do {
			try {
				System.out.print("\nVeilleur saisir la mesure : ");
				mesure = scanner.nextLine();
			} catch (InputMismatchException m) {
				System.out.println("Entrer un caractere");
			}
		} while (!mesuration.contains(mesure));

		Document doc = new Document();
		doc.append("nom", nom);
		doc.append("quantite", quantite);
		doc.append("mesure", mesure);

		// Pour inserer dans la collection
		collection.insertOne(doc);
	}

	public static boolean isOnlyString(String mot) {
		int j = 0;
		int i = 0;
		i = mot.length();
		while (j < i) {
			if ("0123456789".contains(mot.substring(j, j + 1)))
				return false;
			j++;
		}
		return true;
	}
}
