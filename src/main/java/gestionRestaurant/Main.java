package gestionRestaurant;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.logging.Logger;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;

public class Main {

	static Logger mongoLogger = Logger.getLogger("org.mongodb.driver");

	
	static Serveur serveur = new Serveur();
	AssistantService assistant;
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
	static MongoCollection<Document> coTables = database.getCollection("tables");
	static MongoCollection<Document> coServeurs = database.getCollection("serveurs");
	static MongoCollection<Document> coUsers = database.getCollection("users");

	final static String[] menu = { "Ajouter un plat", "Ajouter une boisson" };
	
	public static void main(String[] args) throws ParseException {

		connexion();
		//MaitreHotelInterface();
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

		ServeurInterface();

	}

	public static void MaitreHotelInterface() throws ParseException {
		MaitreHotelGestion.affecterServeurToTable();
	}

	public static class MaitreHotelGestion {
		public static boolean saisirNomServeur() throws ParseException {
			String nom="";
			JSONObject jo=new JSONObject();
			do {
				try {
					System.out.print("Nom du serveur: ");
					scanner = new Scanner(System.in);
					nom=scanner.nextLine();					
				}catch(InputMismatchException e) {
					System.out.println("Entre des chaines de caractères");
					saisirNomServeur();
				}	
			}while(nom.length() < 2);
			for(Document doc: coServeurs.find()) {
				jo = (JSONObject) jsonP.parse(doc.toJson());
				if(jo.get("nom").toString().contains(nom))
					return true;
			}
			return false;
		}

		
		public static boolean existServeur(String nom) throws ParseException {
			JSONObject jo=new JSONObject();
			for(Document docu: coServeurs.find()) {
				jo = (JSONObject) jsonP.parse(docu.toJson());
				if(jo.get("nomServeur").toString().contains(nom))
					return true;
			}
			return false;
		}
		public static void affecterServeurToTable() throws ParseException {
			JSONObject jo=new JSONObject();
			new Document();

			
			for(Document doc: coTables.find()) {
				jo = (JSONObject) jsonP.parse(doc.toJson());
				System.out.println(jo.get("numTable"));
				System.out.println(jo.get("numEtage"));
				System.out.println(jo.get("nbPlaces"));
				System.out.println(jo.get("nomServeur"));
				System.out.println(jo.get("nomAssistant"));
				System.out.println(jo.get("couleur"));
				for(Document docu: coServeurs.find()) {
					jo = (JSONObject) jsonP.parse(docu.toJson());

					
				}

			}
		}
	}

	public static void interfaceCuisinier() {

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
			
			for (Table t : serveur.getEtage().getTables()) {
				System.out.println("\nN° Table :" + t.getNumero());
				System.out.println("Couleur Table :" + t.getCouleur());
				System.out.println("---------------------------------------");
			}
			do {
				try {
					System.out.print("Choisir la table : ");
					scanner = new Scanner(System.in);
					choixTable = scanner.nextInt();
				} catch (InputMismatchException e) {
					System.out.println("Entrer un nombre entier");
				}
			} while (choixTable < 1 || choixTable > serveur.getEtage().getTables().size());				
		}
		public static void choixCommande() throws ParseException {
			System.out.println("\nPRISE DE COMMANDE");
			choixCommande=0;
			if (serveur.getEtage().getTables().get(choixTable-1).getCouleur().contains("Vert")) {
				afficherMenu();
				do {
					try {
						//choixCommande=0;
						System.out.print("Choisir l'option : ");
						scanner = new Scanner(System.in);
						choixCommande = scanner.nextInt();
						if(choixCommande==0) {
							if(!commandes.isEmpty())
								serveur.getEtage().getTables().get(choixTable-1).setCouleur("Jaune");
							init();
						}
						if(choixCommande==2) {
							System.out.println("Pas de boissons actuellement !");
							choixCommande();
						}
					}catch(InputMismatchException e) {
						System.out.println("Mettez une valeur entière pour la catégorie");
						choixCommande();
					}
				} while (choixCommande < 0 || choixCommande > 2);
			}


		}
		public static void choixCategorie() throws ParseException {
			System.out.println("\nChoix de la catégorie");
			afficherCategorie();
			do {
				try{
					System.out.print("\nChoisir la catégorie : ");
					scanner = new Scanner(System.in);
					choixCategorie = scanner.nextInt();
					if(choixCategorie==0)
						init();
					if(choixCategorie==2){
						categorieChoisie="Viandes";
						System.out.println("Pas de viandes actuellement");
						choixCategorie();
					}else {
						categorieChoisie="Poissons";
					}
				}catch(InputMismatchException m) {
					System.out.println("Entrer un entier naturel");
					choixCategorie();
				}
			} while (choixCategorie < 0 || choixCategorie > categorie.size());
		}
		public static void choixPlat() throws ParseException {
			int nbPlat = afficherPlat();
			int option=0;
			do {
				try{
					System.out.print("Choisir le plat : ");
					scanner = new Scanner(System.in);
					choixPlat = scanner.nextInt();
					if(choixPlat==0)
						init();
				}catch(InputMismatchException m) {
					System.out.println("Entrer un entier naturel");
					choixPlat();
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
				ajoutArticle();
				continuerCommande();
			}else {
				//Occupation de la table
				serveur.getEtage().getTables().get(choixTable-1).setCouleur("Jaune");
				//validation de la commande
				
				//recommence
				init();
			}
		}
				
		public static void init() throws ParseException {
			choixTables();
			choixCommande();
			choixCategorie();
			choixPlat();
		}
		public static void continuerCommande() throws ParseException {
			choixCommande();
			choixCategorie();
			choixPlat();
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
//			if(p.getMenu().contains("Adulte")) {
//				platsAdulte.add(p);
//			}else
//				platsEnfant.add(p);
			//ajoutArticle(p);
			choixCategorie();
			//CuisinierInterface.init();
		}
		public static void validationCommande() {

		}
		
		public static void majTable(int numTable, int numEtage) {
			DBObject table = new BasicDBObject( "numTable", numTable);
			DBObject etage = new BasicDBObject( "numEtage", numEtage);
			BasicDBList andValues = new BasicDBList();
			andValues.add(table );
			andValues.add(etage );
			Bson query = new BasicDBObject( "$and", andValues );


			//var query1 = new BasicDBObject( "numTable", new BasicDBObject("$eq", numTable) );
			//var query2 = new BasicDBObject( "numEtage", new BasicDBObject("$eq", numEtage) );
			coTables.find(query).forEach((Consumer<Document>) doc -> {
				System.out.println(doc.toJson());

			});
			
			
		}	
		@SuppressWarnings({ "unchecked" })
		public static void serializeUser(Commande com) throws IOException {
			GsonBuilder builder = new GsonBuilder();
			builder.setPrettyPrinting();
			Gson gson = builder.create();
			jaCommande.add(gson.toJson(com));
		}
		public static void ajoutArticle() throws ParseException {
			String pattern = "yyyy-MM-dd";
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
			String datef = simpleDateFormat.format(new Date());
			Commande com = new Commande();
			JSONObject jsonO=new JSONObject();
			int countPlat=0;
			
			for (Document doc : coPlat.find()) {// On affiche la liste des plats
				countPlat++;
				jsonO = (JSONObject) jsonP.parse(doc.toJson());
				if(countPlat==choixPlat) {
					com.setNomPlat(jsonO.get("nom").toString());
					com.setNomServeur(serveur.getNom());
					com.setPrix(Double.parseDouble(jsonO.get("prix").toString()));
					com.setTempsPreparation(Integer.parseInt(jsonO.get("tempsPreparation").toString()));
					com.setDate(datef);
					commandes.add(com);
				}
				System.out.println(countPlat + " : " + jsonO.get("nom") + ", Prix : " + jsonO.get("prix"));
			}
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

	public static void ServeurInterface() throws ParseException {
		categorie.add("Poissons");
		categorie.add("Viandes");
		ServeurGestion.init();
	}

	//Connexion à la 
	public static void connexion() throws ParseException {
		String login="";
		String password="";
		System.out.println("Bienvenue sur l'application - CONNEXION");

		System.out.print("Login: ");
		login=scanner.nextLine();
		System.out.print("Password: ");
		password=scanner.nextLine();
		chercherLogin(login,password);		
	}
	public static void chercherLogin(String login, String password) throws ParseException {

		ArrayList<Document> docs = new ArrayList<Document>();

		FindIterable<Document> query = coUsers.find(and(eq("login", login),
                eq("password", password)));
		System.out.println("me---"+query.toString());

		query.into(docs);

		for (Document doc : docs) {
			JSONObject jo = (JSONObject) jsonP.parse(doc.toJson());

			if(jo.get("fonction").toString().equalsIgnoreCase("serveur")) {
				System.out.println("serveur---");
				ServeurGestion.init();
			}else if(jo.get("fonction").toString().equalsIgnoreCase("directeur")) {
				//DirecteurGestion.init();
			}else if(jo.get("fonction").toString().equalsIgnoreCase("cuisinier")) {
				//CuisinierInterface();
			}else if(jo.get("fonction").toString().equalsIgnoreCase("assistant")) {
				//AssistantInterface();
			}else {
				System.out.println("maitre---");
				MaitreHotelInterface();
			}
		}
	}

}
