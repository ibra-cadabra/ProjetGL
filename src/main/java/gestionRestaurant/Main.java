package gestionRestaurant;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.bson.Document;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;


public class Main {

	static Serveur serveur = new Serveur();
	AssstantService assistant;
	MaitreHotel maitreHotel;
	Directeur directeur;
	Cuisinier cuisinier;
	
	private static ArrayList<Plat> platsEnfantsPrets=new ArrayList<Plat>();
	private static ArrayList<Plat> platsAldultesPrets=new ArrayList<Plat>();
	private static ArrayList<String> categorie = new ArrayList<String>();
	private static ArrayList<Plat> platsAdulte = new ArrayList<Plat>();
	private static ArrayList<Plat> platsEnfant = new ArrayList<Plat>();
	private static ArrayList<Commande> commandes = new ArrayList<Commande>();

	static int choixTable;
	static int choixCategorie=0;
	static int choixPlat=0;
	static int choixCommande=0;
	
	static Scanner scanner = new Scanner(System.in);

	private static JSONParser jsonP = new JSONParser();

	static MongoClient mongoClient = MongoClients.create();
	static MongoDatabase database = mongoClient.getDatabase("restaurant");
	static MongoCollection<Document> coPlat = database.getCollection("plat");
	static MongoCollection<Document> coCmd = database.getCollection("commandes");

	final static String[] menu = { "Ajouter un plat", "Ajouter une boisson" };

	public static void main(String[] args) throws ParseException {

		Etage rdc = new Etage(1);
		serveur.setEtage(rdc);
		Table table1 = new Table(1, 4, 1, "Vert");
		Table table2 = new Table(2, 5, 1, "Vert");
		Table table3 = new Table(3, 5, 1, "Vert");
		Table table4 = new Table(4, 5, 1, "Vert");

		ArrayList<Table> tables = new ArrayList<Table>();
		tables.add(table1);
		tables.add(table2);
		tables.add(table3);
		tables.add(table4);

		rdc.setTables(tables);

		interfaceServeur();

	}

	public static void interfaceServeur() throws ParseException {
		categorie.add("Poissons");
		categorie.add("Viandes");
		ServeurGestion.init();
		//CuisinierInterface.init();

		/*
		 * for (Table table : serveur.getEtage().tables) { if (choixTable ==
		 * table.getNumero() && table.getCouleur().contains("Vert")) {
		 * table.setCouleur("Jaune"); System.out.println("La table " + table.getNumero()
		 * + " est occupée à présent"); System.out.println("\nPRISE DE COMMANDE"); int i
		 * = 0; for (String m : menu) { i++; System.out.println(i + ": " + m); } do {
		 * System.out.print("Choisir l'option : "); //option =
		 * scChoixCommande.nextInt(); } while (option < 1 || option > menu.length);
		 * 
		 * //ajout plat do { if (option == 1) { System.out.println("\nAJOUT D'UN PLAT");
		 * numCategorie = 0; for (String cat : categorie) { numCategorie++;
		 * System.out.println(numCategorie + " : " + cat); } do { try (Scanner
		 * scChoixCategorie = new Scanner(System.in)) {
		 * System.out.print("\nChoisir la catégorie : "); choixCategorie =
		 * scChoixCategorie.nextInt(); } } while (choixCategorie < 1 || choixCategorie >
		 * categorie.size());
		 * 
		 * if (choixCategorie == 1) { query.put("categorie", new BasicDBObject("$eq",
		 * "Poissons")); countPlat = 0; for (Document doc : coPlat.find(query)) {
		 * countPlat++; jo = (JSONObject) jsonP.parse(doc.toJson());
		 * System.out.println(countPlat + " : " + jo.get("nom") + ", Prix : " +
		 * jo.get("prix")); } if (jo.isEmpty())
		 * System.out.print("Ce plat n'est pas dans la basede données");
		 * 
		 * do { try (Scanner scChoixPlat = new Scanner(System.in)) {
		 * System.out.print("Choisir le plat : "); choixPlat = scChoixPlat.nextInt(); }
		 * } while (choixPlat < 1 || choixPlat > countPlat);
		 * 
		 * // System.out.println(choixPlat); } else { query.put("categorie", new
		 * BasicDBObject("$eq", "Viandes")); countPlat = 0; for (Document doc :
		 * coPlat.find(query)) { countPlat++; jo = (JSONObject)
		 * jsonP.parse(doc.toJson()); System.out.println(countPlat + " : " +
		 * jo.get("nom") + ", Prix : " + jo.get("prix")); } if (jo.isEmpty()) {
		 * System.out.println("Absent de la base de données"); } else { do { try
		 * (Scanner scChoixPlat = new Scanner(System.in)) {
		 * System.out.println("Choisir le plat : "); choixPlat = scChoixPlat.nextInt();
		 * } } while (choixPlat < 1 || choixPlat > countPlat); } } } } while
		 * (jo.isEmpty()); } }
		 */

	}

	public void interfaceAssistantService() {

	}

	public void interfaceMaitreHotel() {

	}

	public void interfaceCuisinier() {

	}

	public void interfaceDirecteur() {

	}
	public class DirecteurInterface{

	}

	public static class CuisinierGestion{
		private static int choixTerminer;

		public static void init() throws ParseException {
			if(!platsEnfant.isEmpty())
				initEnfant();
			else
				initAdulte();
		}
		public static void initEnfant() throws ParseException {
			int k=0;
			int l=0;
			System.out.println("\n-------------------Cuisine--------------------");
			for (Plat plat : platsEnfant) {
				k++;
				System.out.println(k + " : "+plat.getNom());	
			}
			do {
				try {	
					System.out.print("Plat fini : ");
					choixTerminer = scanner.nextInt();
				}catch(InputMismatchException e) {
					System.out.println("Mettez une valeur entière");
				}
			} while (choixTerminer < 1 || choixTerminer > platsEnfant.size());

			Plat platDelete=new Plat();
			for (Plat plat : platsEnfant) {
				l++;
				if(choixTerminer==l) {
					platDelete = plat;
					plat.setEtat("Pret");
					platsEnfantsPrets.add(plat);
				}
			}
			platsEnfant.remove(platDelete);
		}

		public static void initAdulte() throws ParseException {
			int k=0;
			int l=0;
			System.out.println("\n-------------------CuisineAdultes--------------------");
			for (Plat plat : platsAdulte) {
				k++;
				System.out.println(k + " : "+plat.getNom());	
			}
			do {
				try {	
					System.out.print("Plat fini : ");
					choixTerminer = scanner.nextInt();
				}catch(InputMismatchException e) {
					System.out.println("Mettez une valeur entière");
				}
			} while (choixTerminer < 1 || choixTerminer > platsAdulte.size());

			Plat platDelete=new Plat();
			for (Plat plat : platsAdulte) {
				l++;
				if(choixTerminer==l) {
					platDelete = plat;
					plat.setEtat("Pret");
					platsAldultesPrets.add(plat);
				}
			}
			platsAdulte.remove(platDelete);
		}

	}
	public static class ServeurGestion{
		static JSONArray jaCommande = new JSONArray();
		static String categorieChoisie;
		
		public static void choixTables() {
			System.out.println("\nEtage " + serveur.getEtage().getNumeroEtage()+"\n");
//			//On affiche les plats prêts des enfants
//			if(!platsEnfantsPrets.isEmpty()) {
//				System.out.println("COMMANDES ENFANTS PRETES");
//				for (Plat p : platsEnfantsPrets) 
//					System.out.println(p.getNom() + " " + p.getEtat() + " Table: "+p.getNumTable());
//			//On affiche les plats prêts des adultes
//			}else if(!platsAldultesPrets.isEmpty()) {
//				System.out.println("COMMANDES ADULTES PRETES");
//				for (Plat p : platsAldultesPrets)
//					System.out.println(p.getNom() + " " + p.getEtat() + " Table: "+p.getNumTable());
//			}
//			
//			for (Commande c : commandes) {
//				System.out.println("Article: "+c.getArticle() + "Prix: "+c.getPrix() + "table: "+choixTable);
//			}
//		
			
			for (Table t : serveur.getEtage().getTables()) {
				System.out.println("\nN° Table :" + t.getNumero());
				System.out.println("Couleur Table :" + t.getCouleur());
				System.out.println("---------------------------------------");
			}
			do {
				System.out.print("Choisir la table : ");
				try {
					choixTable = scanner.nextInt();
				} catch (InputMismatchException e) {
					System.out.println("Entrer un nombre entier");
				}
			} while (choixTable < 0 || choixTable > serveur.getEtage().getTables().size());				
		}
		public static void choixCommande() throws ParseException {
			//choixTables();
			System.out.println("\nPRISE DE COMMANDE");
			choixCommande=0;
			if (serveur.getEtage().getTables().get(choixTable-1).getCouleur().contains("Vert")) {
				afficherMenu();
				do {
					try {	
						System.out.print("\nChoisir l'option : ");
						choixCommande = scanner.nextInt();
					}catch(InputMismatchException e) {
						System.out.println("Mettez une valeur entière");
					}
				} while (choixCommande < 0 || choixCommande > menu.length);
			}
			if(choixCommande==0) {
				if(!commandes.isEmpty())
					serveur.getEtage().getTables().get(choixTable-1).setCouleur("Jaune");
				init();
			}
			if(choixCommande==2) {
				System.out.println("Pas de boissons actuellement !");
				choixCommande();
			}
		}
		public static void choixCategorie() throws ParseException {
			System.out.println("\nChoix de la catégorie");
			afficherCategorie();
			do {
				try{
					System.out.print("\nChoisir la catégorie : ");
					choixCategorie = scanner.nextInt();
					if(choixCategorie==0)
						init();
					else if(choixCategorie==2){
						categorieChoisie="Viandes";
						System.out.println("Pas de viandes actuellement");
						choixCategorie();
					}else {
						categorieChoisie="Poissons";
					}
				}catch(InputMismatchException m) {
					System.out.println("Entrer un entier naturel");
				}
			} while (choixCategorie < 0 || choixCategorie > categorie.size());
		}
		public static void init() throws ParseException {
			choixTables();
			choixCommande();
			choixCategorie();
			choixPlat();
		}

		public static void continuerCommande() throws ParseException {
			//choixTables();
			choixCommande();
			choixCategorie();
			choixPlat();
		}
		public static void choixPlat() throws ParseException {
			int nbPlat = afficherPlat();
			int option=0;
			do {
				try{
					System.out.print("Choisir le plat : ");
					choixPlat = scanner.nextInt();
					if(choixPlat==0)
						init();
				}catch(InputMismatchException m) {
					System.out.println("Entrer un entier naturel");
				}
			} while (choixPlat < 0 || choixPlat > nbPlat);
			do {
				try{
					System.out.print("\n1:Continuer / 2:Terminer : ");
					option = scanner.nextInt();
				}catch(InputMismatchException m) {
					System.out.println("Entrer un entier naturel");
				}
			} while (option < 0 || option > nbPlat);
			if(option==1) {
				continuerCommande();
			}else {
				serveur.getEtage().getTables().get(choixTable-1).setCouleur("Jaune");
				init();
			}
		}
		public static void enregistrementPlat() throws ParseException {
			int j=0;
			Plat p = new Plat();
			BasicDBObject query = new BasicDBObject();			
			query.put("categorie", new BasicDBObject("$eq", categorieChoisie));
			for (Document doc : coPlat.find(query)) {
				j++;
				if(j==choixPlat) {
					JSONObject jo = (JSONObject) jsonP.parse(doc.toJson());
					p.setNom(jo.get("nom").toString());
					p.setPrix(Integer.parseInt(jo.get("prix").toString()));
					p.setTempsPreparation(Integer.parseInt(jo.get("tempsPreparation").toString()));
					p.setCategorie(jo.get("categorie").toString());
					p.setMenu(jo.get("menu").toString());
					p.setServeur(serveur.getNom());
					p.setNumTable(choixTable);
					System.out.println(p.toString());
				}
			}
			//serveur.getEtage().tables.get(choixTable-1).setCouleur("Jaune");
			if(p.getMenu().contains("Adulte")) {
				platsAdulte.add(p);
			}else
				platsEnfant.add(p);
			ajoutArticle(p);
			choixCategorie();
			//CuisinierInterface.init();
		}
		public static void validationCommande() {
			
		}
	
		@SuppressWarnings({ "unchecked", "unused" })
		private static void serializeUser(Commande com) throws IOException {
			GsonBuilder builder = new GsonBuilder();
			builder.setPrettyPrinting();
			Gson gson = builder.create();
			jaCommande.add(gson.toJson(com));
		}
		
		public static void ajoutArticle(Plat p) {

			String pattern = "yyyy-MM-dd";
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
			String datef = simpleDateFormat.format(new Date());
			Commande com = new Commande(serveur.getNom(), p.getPrix(), p.getNom(), datef);
			commandes.add(com);
		}
		public static void afficherMenu() {
			int i = 0;
			for (String m : menu) {
				i++;
				System.out.println(i + ": " + m);
			}
			System.out.println(0 + ": TERMINER");
		}
		public static int afficherPlat() throws ParseException {
			int countPlat=0;
			BasicDBObject query = new BasicDBObject();			
			query.put("categorie", new BasicDBObject("$eq", categorieChoisie));
			JSONObject jsonO=new JSONObject();
			for (Document doc : coPlat.find(query)) {// On affiche la liste des plats
				countPlat++;
				jsonO = (JSONObject) jsonP.parse(doc.toJson());
				System.out.println(countPlat + " : " + jsonO.get("nom") + ", Prix : " + jsonO.get("prix"));
			}
			System.out.println("0 : TERMINER");
			if (jsonO.isEmpty()) {
				System.out.println("Il n'y a aucun plat de cette catégorie");
				init();
			}
			return countPlat;
		}

		public static void afficherCategorie() {
			int numCategorie = 0;
			for (String cat : categorie) {
				numCategorie++;
				System.out.println(numCategorie + " : " + cat);
			}
			System.out.println(0 + " : QUITTER");
		}
	}
}
