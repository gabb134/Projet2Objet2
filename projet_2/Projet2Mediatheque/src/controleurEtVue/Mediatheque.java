package controleurEtVue;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;
import modele.Catalogue;
import modele.DVD;
import modele.Document;
import modele.Livre;
import modele.Periodique;

public class Mediatheque extends Application {
	private TableView<Document> tableCatalogue = new TableView<Document>();
	private TableView<Livre> tableLivre = new TableView<Livre>();
	private TableView<DVD> tableDVD = new TableView<DVD>();
	private TableView<Periodique> tablePeriodique = new TableView<Periodique>();

	private ObservableList<Document> donneesCatalogue;
	private ObservableList<Livre> donneesLivre;
	private ObservableList<DVD> donneesDVD;
	private ObservableList<Periodique> donneesPeriodique;
	private Font fontText;

	@Override
	public void start(Stage primaryStage) {
		// TODO Auto-generated method stub

		try {
			BorderPane root = new BorderPane();
			BorderPane bPaneConnexion = new BorderPane();
			BorderPane bPaneEsthetique = new BorderPane();
			
			TabPane tabPane = new TabPane();

			// Pour la connexion
			
			Stage stageCatalogue = new Stage();
			stageCatalogue.setTitle("Médiathèque");
			stageCatalogue.getIcons().add(new Image("iconMediatheque.PNG"));
			Scene sceneCatalogue = new Scene(root);
			Scene sceneConnexion = new Scene(bPaneConnexion, 600, 300);
			stageCatalogue.setScene(sceneCatalogue);
			stageCatalogue.setResizable(false);
			Button btnConnecterAdherent = new Button("Connexion");
			Button btnConnecterAdmin = new Button("Connexion");
			Button btnConnecterEmploye= new Button("Connexion");
	
			Button btnConsulterCatalogue = new Button("Consulter le catalogue");
		
			TilePane   tilePaneAdherent = new TilePane(Orientation.VERTICAL); 
			TilePane   tilePaneEmploye = new TilePane(Orientation.VERTICAL); 
			TilePane   tilePaneAdmin = new TilePane(Orientation.VERTICAL); 
			
			HBox hBoxAdherent1 = new HBox(20);
			HBox hBoxAdherent2 = new HBox(20);
			HBox hBoxPrepose1 = new HBox(20);
			HBox hBoxPrepose2 = new HBox(20);
			HBox hBoxAdmin1 = new HBox(20);
			HBox hBoxAdmin2 = new HBox(20);
			
			TextField txtFNom = new TextField();
			TextField txtFPrenom = new TextField();
			TextField txtFTelephone = new TextField();
			
			TextField txtFNoPrepose = new TextField();
			TextField txtFMotDePassePrepose= new TextField();
			
			
			
			TextField txtFNoAdmin = new TextField();
			TextField txtFMotDePasseAdmin= new TextField();
			
			Text txtNom = new Text("Nom:    ");
			Text txtPrenom = new Text("Prénom:");
			Text txtTelephone = new Text("Téléphone:");
			
			Text txtNoPrepose = new Text("Numéro de l'employé:");
			Text txtMotDePassePrepose= new Text("           Mot de passe:");
			
			
			
			Text txtNoAdmin = new Text("Numéro de l'admin:");
			Text txtMotDePasseAdmin= new Text("   Mot de passe:");
			
			
			
		
			
			

			btnConsulterCatalogue.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					// TODO Auto-generated method stub
					stageCatalogue.show();
					primaryStage.close();

				}
			});
		
			
			
			TabPane tabPaneConnexion = new TabPane();
			
			// Premier onglet (Adherent)
			Tab tabConnexionAdherent = new Tab();
			tabConnexionAdherent.setClosable(false);
			tabConnexionAdherent.setText("Adhérent");
			tabConnexionAdherent.setContent(tilePaneAdherent);
			
			tilePaneAdherent.setPadding(new Insets(60));
			tilePaneAdherent.setVgap(10);
			hBoxAdherent1.getChildren().addAll(txtPrenom,txtFPrenom);
			hBoxAdherent2.getChildren().addAll(txtNom,txtFNom);
			tilePaneAdherent.getChildren().addAll(hBoxAdherent1,hBoxAdherent2,btnConnecterAdherent,btnConsulterCatalogue);
			

			// Deuxieme onglet (Prepose)
			Tab tabConnexionEmploye = new Tab();
			tabConnexionEmploye.setClosable(false);
			tabConnexionEmploye.setText("Employé");
			tabConnexionEmploye.setContent(tilePaneEmploye);
			
			tilePaneEmploye.setPadding(new Insets(60));
			tilePaneEmploye.setVgap(10);
			hBoxPrepose1.getChildren().addAll(txtNoPrepose,txtFNoPrepose);
			hBoxPrepose2.getChildren().addAll(txtMotDePassePrepose,txtFMotDePassePrepose);
			tilePaneEmploye.getChildren().addAll(hBoxPrepose1,hBoxPrepose2,btnConnecterEmploye);

			// troisieme onglet (Administrateur)
			Tab tabConnexionAdmin = new Tab();
			tabConnexionAdmin.setClosable(false);
			tabConnexionAdmin.setText("Administrateur");
			tabConnexionAdmin.setContent(tilePaneAdmin);
			
			tilePaneAdmin.setPadding(new Insets(60));
			tilePaneAdmin.setVgap(10);
			hBoxAdmin1.getChildren().addAll(txtNoAdmin,txtFNoAdmin);
			hBoxAdmin2.getChildren().addAll(txtMotDePasseAdmin,txtFMotDePasseAdmin);
			tilePaneAdmin.getChildren().addAll(hBoxAdmin1,hBoxAdmin2,btnConnecterAdmin);
			
			
			// Ajout des onglets de connexion
			tabPaneConnexion.getTabs().addAll(tabConnexionAdherent, tabConnexionEmploye, tabConnexionAdmin);
			
			bPaneConnexion.setRight(tabPaneConnexion);
			bPaneConnexion.setLeft(bPaneEsthetique);
			
			
			//Partie esthetique de la connexion
			Font fontText1 = Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 10);
			Font fontText2 = Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 15);
			Text txtExplication = new Text("Veuillez choisir un des trois onglet pour accéder à notre médiathèque.");
			txtExplication.setFont(fontText1);
			bPaneConnexion.setTop(txtExplication);
			bPaneConnexion.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, new CornerRadii(10), new Insets(0))));
			Text TtxtBienvenue =new Text("      BIENVENUE \nÀ LA MÉDIATHÈQUE");
			ImageView image = new ImageView("iconMediatheque.PNG");
			image.setFitHeight(70);
			image.setFitWidth(70);
			
			TtxtBienvenue.setFont(fontText2);
			bPaneEsthetique.setTop(TtxtBienvenue);
			bPaneEsthetique.setAlignment(TtxtBienvenue, Pos.CENTER);
			bPaneEsthetique.setMargin(TtxtBienvenue, new Insets(15,5,5,15));
			bPaneEsthetique.setCenter(image);
			
			// premier onglet (Catalogue)
			Tab tabCatalogue = new Tab();
			tabCatalogue.setClosable(false);
			tabCatalogue.setText("Catalogue");
			tabCatalogue.setGraphic(new ImageView(new Image("icon-collection.png")));

			// deuxieme onglet (Livres)
			Tab tabLivres = new Tab();
			tabLivres.setClosable(false);
			tabLivres.setText("Livres");
			tabLivres.setGraphic(new ImageView(new Image("icon-livre.png")));

			// troisieme onglet (DVD)
			Tab tabDVD = new Tab();
			tabDVD.setClosable(false);
			tabDVD.setText("DVD");
			tabDVD.setGraphic(new ImageView(new Image("icon-dvd.png")));

			// Quatrieme onglet (Periodique)
			Tab tabPeriodique = new Tab();
			tabPeriodique.setClosable(false);
			tabPeriodique.setText("Périodiques");
			tabPeriodique.setGraphic(new ImageView(new Image("icon-periodique.png")));

			// Dans l'oglet Catalogue

			// Node qui va avoir les tablesColumn
			Group grCatalogue = new Group();

			// Pour aller cherche l'objet catalogue serializer
			SerializationCatalogue();
			Catalogue catalogue = DeserialisationCatalogue();
			// Catalogue catalogue = Catalogue.getInstance("Livres.txt", "Periodiques.txt",
			// "DVD.txt");
			donneesCatalogue = FXCollections.observableArrayList(catalogue.getLstDocuments()); // ***Demander au prof

			// System.out.println(catalogue.getLstDocuments());
			// Creation des colonnes dans l'onglet catalogue

			donneesLivre = FXCollections.observableArrayList(catalogue.getLstLivres());
			TableColumn<Document, String> colonneNumDocCatalogue = new TableColumn<Document, String>("Numéro Document");
			TableColumn<Document, String> colonneTitreCatalogue = new TableColumn<Document, String>("Titre");
			TableColumn<Document, LocalDate> colonneDatePubCatalogue = new TableColumn<Document, LocalDate>(
					"Date de publication");
			TableColumn<Document, String> colonneDispoCatalogue = new TableColumn<Document, String>("Disponible");

			colonneNumDocCatalogue.setPrefWidth(120);
			colonneTitreCatalogue.setPrefWidth(120);
			colonneDatePubCatalogue.setPrefWidth(120);
			colonneDispoCatalogue.setPrefWidth(270);

			colonneNumDocCatalogue.setMaxWidth(Double.MAX_VALUE);
			colonneTitreCatalogue.setMaxWidth(Double.MAX_VALUE);
			colonneDatePubCatalogue.setMaxWidth(Double.MAX_VALUE);
			colonneDispoCatalogue.setMaxWidth(Double.MAX_VALUE);

			colonneNumDocCatalogue.setCellValueFactory(new PropertyValueFactory<>("noDoc"));
			colonneTitreCatalogue.setCellValueFactory(new PropertyValueFactory<>("titre"));
			colonneDatePubCatalogue.setCellValueFactory(new PropertyValueFactory<>("dateParution"));
			colonneDispoCatalogue.setCellValueFactory(new PropertyValueFactory<>("disponible"));

			// Creation des colonnes dans l'onglet Livres
			TableColumn<Livre, String> colonneNumDocLivre = new TableColumn<Livre, String>("Numéro Document");
			TableColumn<Livre, String> colonneTitreLivre = new TableColumn<Livre, String>("Titre");
			TableColumn<Livre, LocalDate> colonneDatePubLivre = new TableColumn<Livre, LocalDate>(
					"Date de publication");
			TableColumn<Livre, String> colonneDispoLivre = new TableColumn<Livre, String>("Disponible");
			TableColumn<Livre, String> colonneAuteurLivre = new TableColumn<Livre, String>("auteur");

			colonneNumDocLivre.setPrefWidth(120);
			colonneTitreLivre.setPrefWidth(120);
			colonneDatePubLivre.setPrefWidth(120);
			colonneDispoLivre.setPrefWidth(120);
			colonneAuteurLivre.setPrefWidth(150);

			colonneNumDocLivre.setMaxWidth(Double.MAX_VALUE);
			colonneTitreLivre.setMaxWidth(Double.MAX_VALUE);
			colonneDatePubLivre.setMaxWidth(Double.MAX_VALUE);
			colonneDispoLivre.setMaxWidth(Double.MAX_VALUE);
			colonneAuteurLivre.setMaxWidth(Double.MAX_VALUE);

			colonneNumDocLivre.setCellValueFactory(new PropertyValueFactory<>("noDoc"));
			colonneTitreLivre.setCellValueFactory(new PropertyValueFactory<>("titre"));
			colonneDatePubLivre.setCellValueFactory(new PropertyValueFactory<>("dateParution"));
			colonneDispoLivre.setCellValueFactory(new PropertyValueFactory<>("disponible"));
			colonneAuteurLivre.setCellValueFactory(new PropertyValueFactory<>("auteur"));

			// Creation des colonnes dans l'onglet DVD
			donneesDVD = FXCollections.observableArrayList(catalogue.getLstDvd());

			TableColumn<DVD, String> colonneNumDocDVD = new TableColumn<DVD, String>("Numéro Document");
			TableColumn<DVD, String> colonneTitreDVD = new TableColumn<DVD, String>("Titre");
			TableColumn<DVD, LocalDate> colonneDatePubDVD = new TableColumn<DVD, LocalDate>("Date de publication");
			TableColumn<DVD, String> colonneDispoDVD = new TableColumn<DVD, String>("Disponible");
			TableColumn<DVD, Integer> colonneNbDisquesDVD = new TableColumn<DVD, Integer>("Nombres de disques");
			TableColumn<DVD, String> colonneRealisateurDVD = new TableColumn<DVD, String>("Réalisateur");

			colonneNumDocDVD.setPrefWidth(120);
			colonneTitreDVD.setPrefWidth(120);
			colonneDatePubDVD.setPrefWidth(120);
			colonneDispoDVD.setPrefWidth(50);
			colonneNbDisquesDVD.setPrefWidth(50);
			colonneRealisateurDVD.setPrefWidth(170);

			colonneNumDocDVD.setMaxWidth(Double.MAX_VALUE);
			colonneTitreDVD.setMaxWidth(Double.MAX_VALUE);
			colonneDatePubDVD.setMaxWidth(Double.MAX_VALUE);
			colonneDispoDVD.setMaxWidth(Double.MAX_VALUE);
			colonneNbDisquesDVD.setMaxWidth(Double.MAX_VALUE);
			colonneRealisateurDVD.setMaxWidth(Double.MAX_VALUE);

			colonneNumDocDVD.setCellValueFactory(new PropertyValueFactory<>("noDoc"));
			colonneTitreDVD.setCellValueFactory(new PropertyValueFactory<>("titre"));
			colonneDatePubDVD.setCellValueFactory(new PropertyValueFactory<>("dateParution"));
			colonneDispoDVD.setCellValueFactory(new PropertyValueFactory<>("disponible"));
			colonneNbDisquesDVD.setCellValueFactory(new PropertyValueFactory<>("nbDisques"));
			colonneRealisateurDVD.setCellValueFactory(new PropertyValueFactory<>("strRealisateur"));

			// Creation des colonnes dans l'onglet periodique

			donneesPeriodique = FXCollections.observableArrayList(catalogue.getLstPeriodiques());

			TableColumn<Periodique, String> colonneNumDocPeriodique = new TableColumn<Periodique, String>(
					"Numéro Document");
			TableColumn<Periodique, String> colonneTitrePeriodique = new TableColumn<Periodique, String>("Titre");
			TableColumn<Periodique, LocalDate> colonneDatePubPeriodique = new TableColumn<Periodique, LocalDate>(
					"Date de publication");
			TableColumn<Periodique, String> colonneDispoPeriodique = new TableColumn<Periodique, String>("Disponible");
			TableColumn<Periodique, Integer> colonneNoVolumePeriodique = new TableColumn<Periodique, Integer>(
					"Numéro volume");
			TableColumn<Periodique, Integer> colonneNoPeriodiquePeriodique = new TableColumn<Periodique, Integer>(
					"Numéro périodique");

			colonneNumDocPeriodique.setPrefWidth(120);
			colonneTitrePeriodique.setPrefWidth(120);
			colonneDatePubPeriodique.setPrefWidth(120);
			colonneDispoPeriodique.setPrefWidth(50);
			colonneNoVolumePeriodique.setPrefWidth(50);
			colonneNoPeriodiquePeriodique.setPrefWidth(170);

			colonneNumDocPeriodique.setMaxWidth(Double.MAX_VALUE);
			colonneTitrePeriodique.setMaxWidth(Double.MAX_VALUE);
			colonneDatePubPeriodique.setMaxWidth(Double.MAX_VALUE);
			colonneDispoPeriodique.setMaxWidth(Double.MAX_VALUE);
			colonneNoVolumePeriodique.setMaxWidth(Double.MAX_VALUE);
			colonneNoPeriodiquePeriodique.setMaxWidth(Double.MAX_VALUE);

			colonneNumDocPeriodique.setCellValueFactory(new PropertyValueFactory<>("noDoc"));
			colonneTitrePeriodique.setCellValueFactory(new PropertyValueFactory<>("titre"));
			colonneDatePubPeriodique.setCellValueFactory(new PropertyValueFactory<>("dateParution"));
			colonneDispoPeriodique.setCellValueFactory(new PropertyValueFactory<>("disponible"));
			colonneNoVolumePeriodique.setCellValueFactory(new PropertyValueFactory<>("noVolume"));
			colonneNoPeriodiquePeriodique.setCellValueFactory(new PropertyValueFactory<>("noPeriodique"));

			// Ajout des colonnes dans les onglets
			tableCatalogue.setItems(donneesCatalogue);
			tableLivre.setItems(donneesLivre);
			tableDVD.setItems(donneesDVD);
			tablePeriodique.setItems(donneesPeriodique);

			tableCatalogue.getColumns().addAll(colonneNumDocCatalogue, colonneTitreCatalogue, colonneDatePubCatalogue,
					colonneDispoCatalogue);
			tableLivre.getColumns().addAll(colonneNumDocLivre, colonneTitreLivre, colonneDatePubLivre,
					colonneDispoLivre, colonneAuteurLivre);
			tableDVD.getColumns().addAll(colonneNumDocDVD, colonneTitreDVD, colonneDatePubDVD, colonneDispoDVD,
					colonneNbDisquesDVD, colonneRealisateurDVD);
			tablePeriodique.getColumns().addAll(colonneNumDocPeriodique, colonneTitrePeriodique,
					colonneDatePubPeriodique, colonneDispoPeriodique, colonneNoVolumePeriodique,
					colonneNoPeriodiquePeriodique);

			root.setCenter(tabPane);
			tabCatalogue.setContent(tableCatalogue);
			tabLivres.setContent(tableLivre);
			tabDVD.setContent(tableDVD);
			tabPeriodique.setContent(tablePeriodique);
			tabPane.getTabs().addAll(tabCatalogue, tabLivres, tabDVD, tabPeriodique);
			// grCatalogue.getChildren().add(table);
			// grCatalogue.getChildren().add(b);

			primaryStage.getIcons().add(new Image("iconMediatheque.PNG"));
			primaryStage.setTitle("Connexion");
			primaryStage.sizeToScene();
			primaryStage.setResizable(false);
			primaryStage.setScene(sceneConnexion);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void SerializationCatalogue() { // Methode qui permet d'aller chercher l'objet Catalogue pour le serializer
		Catalogue catalogueSerialisation = Catalogue.getInstance("Livres.txt", "Periodiques.txt", "DVD.txt");

		String fichierSerial = "";
		// fichierSerial ="C:/Users/rn.merzius/Downloads/test/fichier.ser";
		fichierSerial = "C:/Users/GabrielMarrero/Downloads/test/fichier.ser";
		// fichierSerial = "C:/Users/cg.marrero/Downloads/test/fichier.ser";
		try {
			FileOutputStream fichier = new FileOutputStream(fichierSerial);
			ObjectOutputStream sortie = new ObjectOutputStream(fichier);

			sortie.writeObject(catalogueSerialisation);

			sortie.close();
			fichier.close();

			// System.out.println("l'objet catalogue vient d'être seralizer");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public Catalogue DeserialisationCatalogue() {// Methode qui permet de deserializer l'objet Catalogue pour pouvoir
													// l'utiliser
		Catalogue catalogueDeserializer = null;

		try {

			String FichierDeserial = "";
			// FichierDeserial = "C:/Users/rn.merzius/Downloads/test/fichier.ser";
			FichierDeserial = "C:/Users/GabrielMarrero/Downloads/test/fichier.ser";
			// FichierDeserial = "C:/Users/cg.marrero/Downloads/test/fichier.ser";
			FileInputStream fichier = new FileInputStream(FichierDeserial);

			ObjectInputStream entree = new ObjectInputStream(fichier);

			catalogueDeserializer = (Catalogue) entree.readObject();

			fichier.close();
			entree.close();

			// System.out.println("l'objet catalogue vient d'êetre deserlializer");
			//// System.out.println(catalogueDeserializer);
			// catalogueDeserializer.afficherDvd();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return catalogueDeserializer;

	}

	public static void main(String[] args) {
		launch(args);
	}

}
