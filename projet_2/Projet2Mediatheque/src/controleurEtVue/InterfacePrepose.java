package controleurEtVue;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;

import controleurEtVue.Mediatheque.ClickValidationAdherentDroite;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import modele.Adherent;
import modele.Catalogue;
import modele.DVD;
import modele.Document;
import modele.ListeAdherents;
import modele.Livre;
import modele.Periodique;
import modele.Prepose;

public class InterfacePrepose extends Application {

	private TableView<Document> tableCatalogue = new TableView<Document>();
	private TableView<Livre> tableLivre = new TableView<Livre>();
	private TableView<DVD> tableDVD = new TableView<DVD>();
	private TableView<Periodique> tablePeriodique = new TableView<Periodique>();

	private ObservableList<Document> donneesCatalogue;
	private ObservableList<Livre> donneesLivre;
	private ObservableList<DVD> donneesDVD;
	private ObservableList<Periodique> donneesPeriodique;
	
	private TableView<Adherent> tableAdherent = new TableView<Adherent>();
	
	private ObservableList<Adherent> donneesAdherents;

	private HBox hboxEnBas;
	private ToggleGroup tGroupEnHaut;
	private Text txtRechercherPar;
	private RadioButton rbAuteurRealisateur;
	private RadioButton rbMotsCles;
	private TextField txtFRechercherPar;
	private Button btnEffacer;
	private Button btnQuitter;

	private Tab tabCatalogue;

	private Tab tabLivres;

	private Tab tabDVD;

	private Tab tabPeriodique;

	private File fichierSerial;
	private File FichierDeserial;

	private BorderPane root;
	private Scene scene;
	private TabPane tabPane;

	private BorderPane bPaneDroite;

	private VBox vboxPartieADroite;
	private Accordion accordion;
	
	private TitledPane paneGestionCatalogue ;
	private TitledPane paneGestionAdherents;
	private TitledPane paneGestionPrets ;
	
	private VBox vboxCatalogue;
	private VBox vBoxAhderents;
	private VBox vboxPrets;

	private Button btnAjouterDocumentCatalogue;
	private Button btnSupprimerDocumentCatalogue;

	private Button btnajouterAherent;
	private Button btnModifierAdherent;
	private Button btnSupprimerAdherent;
	private Button btnPayerSoldeAdhernent;

	private Button btnInscrireUnPret;
	private Button btnIscrireUnRetour;

	private HBox hboxButtonDeconnexion;

	private Button btnDeconnexion;

	private Stage stageAjout;
	private GridPane gPaneAjoutDoc;

	private Scene sceneAjout;
	// Scene sceneAjout = new Scene(gPaneAjoutDoc);

	private ToggleGroup tRadioAjout;
	private RadioButton rbLivre;
	private RadioButton rbPeriodique;
	private RadioButton rbDvd;
	private HBox hboxRadioButton;

	// pour les livres
	private Text txtTypeDoc;
	private Text txtTitre;
	private Text txtAuteur;
	private Text txtDateParution;
	private Text txtMotsCledEspaces;

	// pour les dvd
	private Text txtNbDisques;
	private Text txtRealisateur;

	private TextField txtFNbDisques;
	private TextField txtFRealisateur;

	// pour les périodiques
	private Text txtNoVolume;
	private Text txtNoPeriodique;

	private TextField txtFNoVolume;
	private TextField txtFNoPeriodique;

	private TextField txtFtitre;
	private TextField txtFAuteur;
	private TextField txtFDateParution;
	private TextField txtFMotsClesEspaces;

	private Button btnConfirmer;
	private Button btnAnnulerAjout;
	private HBox hboxButtonAjout;
	private ListeAdherents liste;
	private Prepose prepose = new Prepose();
	
	//ajout adherent 
	private Text txtNomAdherent ;
	private Text txtPrenomAdherent ;
	private Text txtAdresseAdherent ;
	private Text txtTelephoneAdherent ;
	
	private TextField txtfNomAdherent;
	private TextField txtfPrenomAdherent ;
	private TextField txtfAdresseAdherent ;
	private TextField txtfTelephoneAdherent;
	
	private Button btnConfirmerAJoutAdherent ;
	private Button btnAnnulerAjoutAdherent ;
	
	private HBox hboxButtonAhderent = new HBox(2);
	private Catalogue catalogue;
	@Override
	public void start(Stage primaryStage) {
		// TODO Auto-generated method stub

		try {
			/*********************************************
			 * FICHIERS SERIALIZABLES
			 ********************************************************/

			// fichierSerial = new File("C:/Users/rn.merzius/Downloads/test/fichier.ser");
			// fichierSerial =  new File("C:/Users/GabrielMarrero/Downloads/test/fichier.ser");
			fichierSerial = new File( "fichier.ser");
			// fichierSerial= new File("C:/Users/r.merzius/Desktop/fichier.ser");
			// FichierDeserial=new File("C:/Users/r.merzius/Desktop/fichier.ser");
			// FichierDeserial = new File("C:/Users/rn.merzius/Downloads/test/fichier.ser");
			// FichierDeserial = new File("C:/Users/GabrielMarrero/Downloads/test/fichier.ser");
			FichierDeserial = new File("fichier.ser");

			root = new BorderPane();
			scene = new Scene(root);
			tabPane = new TabPane();
			bPaneDroite = new BorderPane();

			/********************************************
			 * CATALOGUE PRÉPOSÉ
			 *************************************************/

			/********************************************
			 * DANS CHAQUE ONGLET DU CATALOGUE TABLEVIEW CATALOGUE
			 **********************************/

			// Pour aller cherche l'objet catalogue serializer
			SerializationCatalogue();
			 catalogue = DeserialisationCatalogue();
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
			colonneTitreCatalogue.setPrefWidth(250);
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
			colonneTitreLivre.setPrefWidth(250);
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
			colonneTitreDVD.setPrefWidth(250);
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
			colonneTitrePeriodique.setPrefWidth(250);
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
			
			/*****************************
			 *TABLE VIEW POUR LES ADHERENTS 
			 ***********************/
			
			//faire les donnesAdherents avec l'arraylist adheretn qui est dans prepose
			
			/*****************************************SEUELEMENT POUR DES TESTS*****************************************/
		
		
			
		/*	Adherent a1 = new Adherent("2", "allossssttttt", "tets", "afge", "(333) 987-3344", 2, 2);
			Adherent a2 = new Adherent("3", "klk", "tets", "afge", "(334) 444-4444", 2, 2);
			Adherent a3 = new Adherent("4", "klk", "tets", "afge", "(334) 444-2345", 2, 2);

			// a1.setStrNumeroAdherent(1+a1.getStrNumeroAdherent());
			
			Prepose prepose  = new Prepose();
			prepose.ajouterAdherent(a1);
			prepose.ajouterAdherent(a2);
			prepose.ajouterAdherent(a3);
			prepose.afficherAdherents();*/
			
			
			
			/*************************************************************************************************/
			 liste = ListeAdherents.getInstance();
			donneesAdherents = FXCollections.observableArrayList(liste.getLstAdherents());
			//tableAdherent.setItems(donneesAdherents);
			
			TableColumn<Adherent, String> colonneNumeroAdherent = new TableColumn<Adherent, String>("Numéro d'adhérent");
			TableColumn<Adherent, String> colonneNomAdherent= new TableColumn<Adherent, String>("Nom");
			TableColumn<Adherent, String> colonnePrenomAdherent = new TableColumn<Adherent, String>("Prénom");
			TableColumn<Adherent, String> colonneAdresseAdherent = new TableColumn<Adherent, String>("Adresse");
			TableColumn<Adherent, String> colonneNumeroTelephoneAdherent = new TableColumn<Adherent, String>("Téléphone");
			TableColumn<Adherent, Integer> colonnePretsActifsAdherent = new TableColumn<Adherent, Integer>("Prêts actif");
			TableColumn<Adherent, Double> colonneSoldeDuAdherent = new TableColumn<Adherent, Double>("Solde dû");
			
			colonneNumeroAdherent.setPrefWidth(120);
			colonneNomAdherent.setPrefWidth(100);
			colonnePrenomAdherent.setPrefWidth(100);
			colonneAdresseAdherent.setPrefWidth(150);
			colonneNumeroTelephoneAdherent.setPrefWidth(100);
			colonnePretsActifsAdherent.setPrefWidth(100);
			colonneSoldeDuAdherent.setPrefWidth(100);

			colonneNumeroAdherent.setMaxWidth(Double.MAX_VALUE);
			colonneNomAdherent.setMaxWidth(Double.MAX_VALUE);
			colonnePrenomAdherent.setMaxWidth(Double.MAX_VALUE);
			colonneAdresseAdherent.setMaxWidth(Double.MAX_VALUE);
			colonneNumeroTelephoneAdherent.setMaxWidth(Double.MAX_VALUE);
			colonnePretsActifsAdherent.setMaxWidth(Double.MAX_VALUE);
			colonneSoldeDuAdherent.setMaxWidth(Double.MAX_VALUE);

			colonneNumeroAdherent.setCellValueFactory(new PropertyValueFactory<>("strNumeroAdherent"));
			colonneNomAdherent.setCellValueFactory(new PropertyValueFactory<>("strNom"));
			colonnePrenomAdherent.setCellValueFactory(new PropertyValueFactory<>("strPrenom"));
			colonneAdresseAdherent.setCellValueFactory(new PropertyValueFactory<>("strAdresse"));
			colonneNumeroTelephoneAdherent.setCellValueFactory(new PropertyValueFactory<>("strNumeroTelephone"));
			colonnePretsActifsAdherent.setCellValueFactory(new PropertyValueFactory<>("intNbPrets"));
			colonneSoldeDuAdherent.setCellValueFactory(new PropertyValueFactory<>("dblSolde"));
			//colonneSoldeDuAdherent.setCellValueFactory(new PropertyValueFactory<Adherent, Double>("$"));
			
			
			tableAdherent.setItems(donneesAdherents);
			tableAdherent.getColumns().addAll(colonneNumeroAdherent,colonneNomAdherent,colonnePrenomAdherent,colonneAdresseAdherent,colonneNumeroTelephoneAdherent,colonnePretsActifsAdherent,colonneSoldeDuAdherent);
			
			/*****************************
			 * PARTIE D'EN BAS DU CATALOGUE
			 ***********************/
			hboxEnBas = new HBox(10);
			hboxEnBas.setPadding(new Insets(10));
			tGroupEnHaut = new ToggleGroup();
			txtRechercherPar = new Text("Rechercher par: ");
			rbAuteurRealisateur = new RadioButton("auteur/réalisateur");
			rbMotsCles = new RadioButton("Mos clés");
			txtFRechercherPar = new TextField();
			btnEffacer = new Button("Effacer");
			btnEffacer.setPrefWidth(170);
			rbAuteurRealisateur.setToggleGroup(tGroupEnHaut);
			rbMotsCles.setToggleGroup(tGroupEnHaut);
			rbAuteurRealisateur.setSelected(true);
			
		
			hboxEnBas.getChildren().addAll(txtRechercherPar, rbAuteurRealisateur, rbMotsCles, txtFRechercherPar,
					btnEffacer);
			root.setBottom(hboxEnBas);

			/*********************************************
			 * DANS LE CATALOGUE(GERE TOUT CE QUI EST DANS L'INTERFACE DEU CATALOGUE DU
			 * PRÉPOSÉ)
			 ********************************************************/
			// premier onglet (Catalogue)
			tabCatalogue = new Tab();
			tabCatalogue.setClosable(false);
			tabCatalogue.setText("Tous les documents");
			tabCatalogue.setGraphic(new ImageView(new Image("icon-collection.png")));

			// deuxieme onglet (Livres)
			tabLivres = new Tab();
			tabLivres.setClosable(false);
			tabLivres.setText("Livres");
			tabLivres.setGraphic(new ImageView(new Image("icon-livre.png")));

			// troisieme onglet (DVD)
			tabDVD = new Tab();
			tabDVD.setClosable(false);
			tabDVD.setText("DVDs");
			tabDVD.setGraphic(new ImageView(new Image("icon-dvd.png")));

			// Quatrieme onglet (Periodique)
			tabPeriodique = new Tab();
			tabPeriodique.setClosable(false);
			tabPeriodique.setText("Périodiques");
			tabPeriodique.setGraphic(new ImageView(new Image("icon-periodique.png")));

			tabCatalogue.setContent(tableCatalogue);
			tabLivres.setContent(tableLivre);
			tabDVD.setContent(tableDVD);
			tabPeriodique.setContent(tablePeriodique);

			/****************************************
			 * DANS LE CATALOGUE PARTIE À DROITE(GESTION DES ADHERENT, CATALOGUE ET PRETS)
			 ******************************************************/

			// bPaneDroite.setPadding(new Insets(10));

			vboxPartieADroite = new VBox(5);
			accordion = new Accordion();
			vboxCatalogue = new VBox(15);
			vBoxAhderents = new VBox(15);
			vboxPrets = new VBox(15);

			btnAjouterDocumentCatalogue = new Button("Ajouter un document");
			btnSupprimerDocumentCatalogue = new Button("Supprimer un document");

			btnajouterAherent = new Button("Ajouter un adhérent");
			btnModifierAdherent = new Button("Modifier un adhérent");
			btnSupprimerAdherent = new Button("Supprimer un adhérent");
			btnPayerSoldeAdhernent = new Button("Payer solde adhérent");

			btnInscrireUnPret = new Button("Inscrire un prêt");
			btnIscrireUnRetour = new Button("Inscrire un retour");

			hboxButtonDeconnexion = new HBox();

			btnDeconnexion = new Button("Deconnexion");
			hboxButtonDeconnexion.getChildren().add(btnDeconnexion);
			hboxButtonDeconnexion.setAlignment(Pos.CENTER);

			btnAjouterDocumentCatalogue.setPrefWidth(180);
			btnSupprimerDocumentCatalogue.setPrefWidth(180);

			btnajouterAherent.setPrefWidth(180);
			btnModifierAdherent.setPrefWidth(180);
			btnSupprimerAdherent.setPrefWidth(180);
			btnPayerSoldeAdhernent.setPrefWidth(180);

			btnInscrireUnPret.setPrefWidth(180);
			btnIscrireUnRetour.setPrefWidth(180);

			btnDeconnexion.setPrefWidth(150);

			btnDeconnexion.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent e) {
					// TODO Auto-generated method stub
					primaryStage.close();
					Stage stageConnexionMediatheque = new Stage();
					stageConnexionMediatheque.initModality(Modality.APPLICATION_MODAL);
					Mediatheque meditheque = new Mediatheque();
					meditheque.start(stageConnexionMediatheque);
					//serialisation pour sauvegarder les adherents qui ont ete ajouter, modifier ou supprimer
					liste.serialisationAdherent();

				}
			});

			vboxCatalogue.getChildren().addAll(btnAjouterDocumentCatalogue, btnSupprimerDocumentCatalogue);
			vBoxAhderents.getChildren().addAll(btnajouterAherent, btnModifierAdherent, btnSupprimerAdherent,
					btnPayerSoldeAdhernent);
			vboxPrets.getChildren().addAll(btnInscrireUnPret, btnIscrireUnRetour);

			vboxCatalogue.setAlignment(Pos.CENTER);
			vBoxAhderents.setAlignment(Pos.CENTER);
			vboxPrets.setAlignment(Pos.CENTER);

			 paneGestionCatalogue = new TitledPane("Gestion du catalogue",
					new Label("Show all boats available"));
			 paneGestionAdherents = new TitledPane("Gestion des adhérents",
					new Label("Show all cars available"));
			 paneGestionPrets = new TitledPane("Gestion des prêts", new Label("Show all planes available"));

			accordion.getPanes().add(paneGestionCatalogue);
			accordion.getPanes().add(paneGestionAdherents);
			accordion.getPanes().add(paneGestionPrets);

			ImageView imageCatalogue = new ImageView(new Image("icon-collection.png"));
			ImageView imageAdherent = new ImageView(new Image("Adherentss.png"));
			ImageView imagePrets = new ImageView(new Image("LibraryCatalogue.png"));

			paneGestionCatalogue.setGraphic(imageCatalogue);
			paneGestionAdherents.setGraphic(imageAdherent);
			paneGestionPrets.setGraphic(imagePrets);

			paneGestionCatalogue.setContent(vboxCatalogue);
			paneGestionAdherents.setContent(vBoxAhderents);
			paneGestionPrets.setContent(vboxPrets);

			accordion.setPrefWidth(180);

			bPaneDroite.setTop(accordion);

			vboxPartieADroite.getChildren().addAll(bPaneDroite, hboxButtonDeconnexion);
			root.setRight(vboxPartieADroite);

			/*********************************************
			 * GESTION DES EVENEMENT DES BUTTON
			 *******************************/
			GestionConsulterCatalogue gCatalogue = new GestionConsulterCatalogue();
			
			rbAuteurRealisateur.setOnAction(gCatalogue);
			rbMotsCles.setOnAction(gCatalogue);
			btnEffacer.setOnAction(gCatalogue);

			GestionnaireButtonPreposeCatalogue gestionnaireButtonPreposeCatalogue = new GestionnaireButtonPreposeCatalogue();
			btnAjouterDocumentCatalogue.setOnMouseClicked(gestionnaireButtonPreposeCatalogue);
			btnSupprimerDocumentCatalogue.setOnMouseClicked(gestionnaireButtonPreposeCatalogue);
			
			
			GestionnaireChangementTables gestionnaireChangementTables = new GestionnaireChangementTables();
			paneGestionCatalogue.setOnMouseClicked(gestionnaireChangementTables);
			paneGestionAdherents.setOnMouseClicked(gestionnaireChangementTables);
			paneGestionPrets.setOnMouseClicked(gestionnaireChangementTables);
			//btnConfirmer.setOnMouseClicked(gestionnaireButtonPreposeCatalogue);
			
			GestionnaireButtonPreposeAherent gestionnaireButtonPreposeAherent = new GestionnaireButtonPreposeAherent();
			btnajouterAherent.setOnMouseClicked(gestionnaireButtonPreposeAherent);
			btnModifierAdherent.setOnMouseClicked(gestionnaireButtonPreposeAherent);
			btnSupprimerAdherent.setOnMouseClicked(gestionnaireButtonPreposeAherent);
			btnPayerSoldeAdhernent.setOnMouseClicked(gestionnaireButtonPreposeAherent);
			
			GestionnaireButtonPrets gestionnaireButtonPrets = new GestionnaireButtonPrets();

			btnInscrireUnPret.setOnMouseClicked(gestionnaireButtonPrets);
			btnIscrireUnRetour.setOnMouseClicked(gestionnaireButtonPrets);

			/*********************************************
			 * AFFICHAGE
			 ********************************************************/

			tabPane.getTabs().addAll(tabCatalogue, tabLivres, tabDVD, tabPeriodique);
			root.setCenter(tabPane);

			primaryStage.getIcons().add(new Image("booklibrary.png"));
			primaryStage.setTitle("Médiathèque(Préposé)");
			primaryStage.sizeToScene();
			primaryStage.setResizable(false);
			primaryStage.setScene(scene);
			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void SerializationCatalogue() { // Methode qui permet d'aller chercher l'objet Catalogue pour le serializer
		
		if(!fichierSerial.exists()) {
			Catalogue catalogueSerialisation = Catalogue.getInstance("Livres.txt", "Periodiques.txt", "DVD.txt");

			try {
				FileOutputStream fichier = new FileOutputStream(fichierSerial);
				ObjectOutputStream sortie = new ObjectOutputStream(fichier);

				sortie.writeObject(catalogueSerialisation);

				sortie.close();
				fichier.close();

				// System.out.println("l'objet catalogue vient d'ï¿½tre seralizer");

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			DeserialisationCatalogue();
		}
		

	}

	public Catalogue DeserialisationCatalogue() {// Methode qui permet de deserializer l'objet Catalogue pour pouvoir
													// l'utiliser
		Catalogue catalogueDeserializer = null;

		try {

			FileInputStream fichier = new FileInputStream(FichierDeserial);

			ObjectInputStream entree = new ObjectInputStream(fichier);

			catalogueDeserializer = (Catalogue) entree.readObject();
			fichier.close();
			entree.close();

			// System.out.println("l'objet catalogue vient d'ï¿½etre deserlializer");
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
	
	private class GestionConsulterCatalogue implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource() == rbAuteurRealisateur) {
				txtFRechercherPar.requestFocus();
			} else if (e.getSource() == rbMotsCles) {
				txtFRechercherPar.requestFocus();
			}
			if (e.getSource() == btnEffacer) {
				txtFRechercherPar.clear();
			}

		}

	}

	private class GestionnaireButtonPreposeCatalogue implements EventHandler<MouseEvent> {

		@Override
		public void handle(MouseEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource() == btnAjouterDocumentCatalogue) {
				

				stageAjout = new Stage();
				gPaneAjoutDoc = new GridPane();

				sceneAjout = new Scene(gPaneAjoutDoc, 380, 250);
				// Scene sceneAjout = new Scene(gPaneAjoutDoc);

				tRadioAjout = new ToggleGroup();
				rbLivre = new RadioButton("Livre");
				rbPeriodique = new RadioButton("Périodique");
				rbDvd = new RadioButton("Dvd");
				hboxRadioButton = new HBox(5);
				hboxRadioButton.getChildren().addAll(rbLivre, rbDvd, rbPeriodique);

				rbLivre.setToggleGroup(tRadioAjout);
				rbPeriodique.setToggleGroup(tRadioAjout);
				rbDvd.setToggleGroup(tRadioAjout);
				rbLivre.setSelected(true);

				// pour les livres
				txtTypeDoc = new Text("Type de document :");
				txtTitre = new Text("Titre :");
				txtAuteur = new Text("Auteur :");
				txtDateParution = new Text("Date de parution :");
				txtMotsCledEspaces = new Text("Mots clés (séparés par espaces):");

				// pour les dvd
				txtNbDisques = new Text("Nombre de disques :");
				txtRealisateur = new Text("Réalisateur :");

				txtFNbDisques = new TextField();
				txtFRealisateur = new TextField();

				// pour les périodiques
				txtNoVolume = new Text("Numéro de volume :");
				txtNoPeriodique = new Text("Numéro de périodique :");

				txtFNoVolume = new TextField();
				txtFNoPeriodique = new TextField();

				txtFtitre = new TextField();
				txtFAuteur = new TextField();
				txtFDateParution = new TextField();
				txtFMotsClesEspaces = new TextField();

				btnConfirmer = new Button("Confimer");
				btnAnnulerAjout = new Button("Annuler");
				hboxButtonAjout = new HBox(2);
				// btnConfirmer.setBackground(new Background(new
				// BackgroundFill(Color.LIGHTSKYBLUE,new CornerRadii(2),new Insets(0))));
				hboxButtonAjout.getChildren().addAll(btnConfirmer, btnAnnulerAjout);

				gPaneAjoutDoc.setPadding(new Insets(10));
				gPaneAjoutDoc.setHgap(5);
				gPaneAjoutDoc.setVgap(10);

				gPaneAjoutDoc.add(txtTypeDoc, 0, 0);
				gPaneAjoutDoc.add(hboxRadioButton, 1, 0);
				gPaneAjoutDoc.add(txtTitre, 0, 2);
				gPaneAjoutDoc.add(txtFtitre, 1, 2);
				gPaneAjoutDoc.add(txtAuteur, 0, 3);
				gPaneAjoutDoc.add(txtFAuteur, 1, 3);
				gPaneAjoutDoc.add(txtDateParution, 0, 4);
				gPaneAjoutDoc.add(txtFDateParution, 1, 4);
				gPaneAjoutDoc.add(txtMotsCledEspaces, 0, 5);
				gPaneAjoutDoc.add(txtFMotsClesEspaces, 1, 5);
				gPaneAjoutDoc.add(hboxButtonAjout, 1, 6);

				txtFtitre.requestFocus();

				btnAnnulerAjout.setOnAction(new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent e) {
						// TODO Auto-generated method stub
						stageAjout.close();
					}
				});
				btnConfirmer.setOnAction(new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent e) {
						// TODO Auto-generated method stub
						if (rbLivre.isSelected()) {
							if (txtFtitre.getText().compareTo("") == 0) {
								Alert Erreur = new Alert(AlertType.ERROR);
								Erreur.setTitle("Erreur");
								Erreur.setHeaderText(null);
								Erreur.setContentText("Vous n'avez pas tapé le titre");
								Erreur.showAndWait();
							}
							else if (txtFAuteur.getText().compareTo("") == 0) {
								Alert Erreur = new Alert(AlertType.ERROR);
								Erreur.setTitle("Erreur");
								Erreur.setHeaderText(null);
								Erreur.setContentText("Vous n'avez pas tapé le nom de l'auteur");
								Erreur.showAndWait();
							}
							else if (txtFDateParution.getText().compareTo("") == 0) {
								Alert Erreur = new Alert(AlertType.ERROR);
								Erreur.setTitle("Erreur");
								Erreur.setHeaderText(null);
								Erreur.setContentText("Vous n'avez pas tapé la date de parution");
								Erreur.showAndWait();
							}
							else if (txtFMotsClesEspaces.getText().compareTo("") == 0) {
								Alert Erreur = new Alert(AlertType.ERROR);
								Erreur.setTitle("Erreur");
								Erreur.setHeaderText(null);
								Erreur.setContentText("Vous n'avez pas tapé le mot clé");
								Erreur.showAndWait();
							}
							else {// ajout d'un document
								Document documentAjouter = tableCatalogue.getSelectionModel().getSelectedItem();
								Livre livreAjouter = (Livre) tableCatalogue.getSelectionModel().getSelectedItem();
								//catalogue.getLstDocuments().add(documentAjouter);
								//catalogue.getLstLivres().add(livreAjouter);
								prepose.ajouterDocument(documentAjouter);
								
								donneesCatalogue.add(documentAjouter);
								
								Alert confirmation = new Alert(AlertType.CONFIRMATION);
							 	confirmation.setTitle("Confirmation");
							 	confirmation.setHeaderText(null);
							 	confirmation.setContentText("Le document "+txtFtitre.getText() +" a été ajouté!");
							 	confirmation.showAndWait();
							 	stageAjout.close();
							}
							
						}

					}
				});

				/******************************
				 * GEstion radio button dans ajouter document
				 *************************/
				rbLivre.setOnAction(new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent e) {
						// TODO Auto-generated method stub

						gPaneAjoutDoc.getChildren().removeAll(txtNoVolume);
						gPaneAjoutDoc.getChildren().removeAll(txtFNoVolume);

						gPaneAjoutDoc.getChildren().removeAll(txtNoPeriodique);
						gPaneAjoutDoc.getChildren().removeAll(txtFNoPeriodique);

						gPaneAjoutDoc.getChildren().removeAll(txtNbDisques);
						gPaneAjoutDoc.getChildren().removeAll(txtFNbDisques);

						gPaneAjoutDoc.getChildren().removeAll(txtRealisateur);
						gPaneAjoutDoc.getChildren().removeAll(txtFRealisateur);

						gPaneAjoutDoc.getChildren().removeAll(txtDateParution);
						gPaneAjoutDoc.getChildren().removeAll(txtFDateParution);

						gPaneAjoutDoc.getChildren().removeAll(txtMotsCledEspaces);
						gPaneAjoutDoc.getChildren().removeAll(txtFMotsClesEspaces);

						gPaneAjoutDoc.getChildren().removeAll(hboxButtonAjout);

						gPaneAjoutDoc.add(txtAuteur, 0, 3);
						gPaneAjoutDoc.add(txtFAuteur, 1, 3);

						gPaneAjoutDoc.add(txtDateParution, 0, 4);
						gPaneAjoutDoc.add(txtFDateParution, 1, 4);
						gPaneAjoutDoc.add(txtMotsCledEspaces, 0, 5);
						gPaneAjoutDoc.add(txtFMotsClesEspaces, 1, 5);
						gPaneAjoutDoc.add(hboxButtonAjout, 1, 6);
						txtFtitre.clear();
						txtFAuteur.clear();
						txtFDateParution.clear();
						txtFMotsClesEspaces.clear();
						txtFtitre.requestFocus();

					}
				});
				rbDvd.setOnAction(new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent e) {
						// TODO Auto-generated method stub

						gPaneAjoutDoc.getChildren().removeAll(txtAuteur);
						gPaneAjoutDoc.getChildren().removeAll(txtFAuteur);

						gPaneAjoutDoc.getChildren().removeAll(txtNoVolume);
						gPaneAjoutDoc.getChildren().removeAll(txtFNoVolume);

						gPaneAjoutDoc.getChildren().removeAll(txtNoPeriodique);
						gPaneAjoutDoc.getChildren().removeAll(txtFNoPeriodique);

						gPaneAjoutDoc.getChildren().removeAll(txtDateParution);
						gPaneAjoutDoc.getChildren().removeAll(txtFDateParution);

						gPaneAjoutDoc.getChildren().removeAll(txtMotsCledEspaces);
						gPaneAjoutDoc.getChildren().removeAll(txtFMotsClesEspaces);

						gPaneAjoutDoc.getChildren().removeAll(hboxButtonAjout);

						gPaneAjoutDoc.add(txtNbDisques, 0, 3);
						gPaneAjoutDoc.add(txtFNbDisques, 1, 3);

						gPaneAjoutDoc.add(txtRealisateur, 0, 4);
						gPaneAjoutDoc.add(txtFRealisateur, 1, 4);

						gPaneAjoutDoc.add(txtDateParution, 0, 5);
						gPaneAjoutDoc.add(txtFDateParution, 1, 5);

						gPaneAjoutDoc.add(txtMotsCledEspaces, 0, 6);
						gPaneAjoutDoc.add(txtFMotsClesEspaces, 1, 6);

						gPaneAjoutDoc.add(hboxButtonAjout, 1, 7);
						txtFtitre.clear();
						txtFDateParution.clear();
						txtFMotsClesEspaces.clear();
						txtFtitre.requestFocus();

					}
				});
				rbPeriodique.setOnAction(new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent e) {
						// TODO Auto-generated method stub
						gPaneAjoutDoc.getChildren().removeAll(txtAuteur);
						gPaneAjoutDoc.getChildren().removeAll(txtFAuteur);

						gPaneAjoutDoc.getChildren().removeAll(txtNbDisques);
						gPaneAjoutDoc.getChildren().removeAll(txtFNbDisques);

						gPaneAjoutDoc.getChildren().removeAll(txtRealisateur);
						gPaneAjoutDoc.getChildren().removeAll(txtFRealisateur);

						gPaneAjoutDoc.getChildren().removeAll(txtDateParution);
						gPaneAjoutDoc.getChildren().removeAll(txtFDateParution);

						gPaneAjoutDoc.getChildren().removeAll(txtMotsCledEspaces);
						gPaneAjoutDoc.getChildren().removeAll(txtFMotsClesEspaces);

						gPaneAjoutDoc.getChildren().removeAll(hboxButtonAjout);

						gPaneAjoutDoc.add(txtNoVolume, 0, 3);
						gPaneAjoutDoc.add(txtFNoVolume, 1, 3);

						gPaneAjoutDoc.add(txtNoPeriodique, 0, 4);
						gPaneAjoutDoc.add(txtFNoPeriodique, 1, 4);

						gPaneAjoutDoc.add(txtDateParution, 0, 5);
						gPaneAjoutDoc.add(txtFDateParution, 1, 5);

						gPaneAjoutDoc.add(txtMotsCledEspaces, 0, 6);
						gPaneAjoutDoc.add(txtFMotsClesEspaces, 1, 6);

						gPaneAjoutDoc.add(hboxButtonAjout, 1, 7);
						
						txtFtitre.clear();
						txtFDateParution.clear();
						txtFMotsClesEspaces.clear();
						txtFtitre.requestFocus();
					}
				});

				stageAjout.setTitle("Ajout d'un document");
				stageAjout.getIcons().add(new Image("iconAjouterDocument.png"));
				stageAjout.sizeToScene();
				stageAjout.setScene(sceneAjout);
				stageAjout.show();

			} else if (e.getSource() == btnSupprimerDocumentCatalogue) {
				// vérifier si il a selectionner un doc sur le catalogue, si non mettre un
				// mesage d'erreur
				// System.out.println("allo");

				if (tabCatalogue.isSelected()) {
					if (tableCatalogue.getSelectionModel().getSelectedItem() == null) { // non selectionnee
						// System.out.println("selectionne");
						// System.out.println(tableCatalogue.getSelectionModel().getSelectedItem());
						Alert Erreur = new Alert(AlertType.ERROR);
						Erreur.setTitle("Erreur");
						Erreur.setHeaderText(null);
						Erreur.setContentText("Vous devez sélectionner le document à supprimer.");
						Erreur.showAndWait();

					} else {

						System.out.println("Document choisi : " + tableCatalogue.getSelectionModel().getSelectedItem());
						// suppresion du document selectionnee

						tableCatalogue.getSelectionModel().clearSelection(); // derniere instruction

					}
				} else if (tabLivres.isSelected()) {
					if (tableLivre.getSelectionModel().getSelectedItem() == null) { // non selectionnee
						// System.out.println("selectionne");
						// System.out.println(tableCatalogue.getSelectionModel().getSelectedItem());
						Alert Erreur = new Alert(AlertType.ERROR);
						Erreur.setTitle("Erreur");
						Erreur.setHeaderText(null);
						Erreur.setContentText("Vous devez sélectionner le document à supprimer.");
						Erreur.showAndWait();

					} else {
						System.out.println("Document choisi : " + tableLivre.getSelectionModel().getSelectedItem());

						tableLivre.getSelectionModel().clearSelection(); // derniere instruction
					}
				} else if (tabDVD.isSelected()) {
					if (tableDVD.getSelectionModel().getSelectedItem() == null) { // non selectionnee
						// System.out.println("selectionne");
						// System.out.println(tableCatalogue.getSelectionModel().getSelectedItem());
						Alert Erreur = new Alert(AlertType.ERROR);
						Erreur.setTitle("Erreur");
						Erreur.setHeaderText(null);
						Erreur.setContentText("Vous devez sélectionner le document à supprimer.");
						Erreur.showAndWait();

					} else {
						System.out.println("Document choisi : " + tableDVD.getSelectionModel().getSelectedItem());

						tableDVD.getSelectionModel().clearSelection(); // derniere instruction
					}
				} else if (tabPeriodique.isSelected()) {
					if (tablePeriodique.getSelectionModel().getSelectedItem() == null) { // non selectionnee
						// System.out.println("selectionne");
						// System.out.println(tableCatalogue.getSelectionModel().getSelectedItem());
						Alert Erreur = new Alert(AlertType.ERROR);
						Erreur.setTitle("Erreur");
						Erreur.setHeaderText(null);
						Erreur.setContentText("Vous devez sélectionner le document à supprimer.");
						Erreur.showAndWait();

					} else {
						System.out
								.println("Document choisi : " + tablePeriodique.getSelectionModel().getSelectedItem());

						tablePeriodique.getSelectionModel().clearSelection(); // derniere instruction
					}
				}

			}

		}

	}
	private class GestionnaireChangementTables implements EventHandler<MouseEvent> {

		@Override
		public void handle(MouseEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource() == paneGestionCatalogue) {
				System.out.println("catalogue");
				
				root.setCenter(tabPane);
				root.setBottom(hboxEnBas);
				
			}else if(e.getSource()==paneGestionAdherents) {
				System.out.println("andherent");
				root.getChildren().removeAll(tabPane);
				root.getChildren().removeAll(hboxEnBas);
				root.setCenter(tableAdherent);
				//mettre le tableview des adherents
				
				
				
			}else if(e.getSource()==paneGestionPrets) {
				System.out.println("prets");
				root.setCenter(tabPane);
				root.setBottom(hboxEnBas);
			}
			
			
			
		}
		
	}

	private class GestionnaireButtonPreposeAherent implements EventHandler<MouseEvent> {

		@Override
		public void handle(MouseEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource() == btnajouterAherent) {
				Stage stageAjoutAdherent = new Stage();
				GridPane gpaneAjoutAdherent = new GridPane();
				Scene sceneAjoutAdherent = new Scene(gpaneAjoutAdherent,280,220);
				
				gpaneAjoutAdherent.setPadding(new Insets(10));
				gpaneAjoutAdherent.setHgap(5);
				gpaneAjoutAdherent.setVgap(10);
				
				 txtNomAdherent = new Text("Nom :");
				 txtPrenomAdherent = new Text("Prenom :");
				 txtAdresseAdherent = new Text("Adresse :");
				 txtTelephoneAdherent = new Text("Téléphone :");
				
				 txtfNomAdherent = new TextField();
				 txtfPrenomAdherent = new TextField();
				 txtfAdresseAdherent = new TextField();
				 txtfTelephoneAdherent = new TextField();
				
				 btnConfirmerAJoutAdherent = new Button("Confirmer");
				 btnAnnulerAjoutAdherent = new Button("Annuler");
				
				 hboxButtonAhderent = new HBox(2);
				hboxButtonAhderent.getChildren().addAll(btnConfirmerAJoutAdherent,btnAnnulerAjoutAdherent);
				

				txtfTelephoneAdherent.setPromptText("(###) ###-####");
				
				gpaneAjoutAdherent.add(txtNomAdherent, 0, 0);
				gpaneAjoutAdherent.add(txtfNomAdherent, 1, 0);
				gpaneAjoutAdherent.add(txtPrenomAdherent, 0, 1);
				gpaneAjoutAdherent.add(txtfPrenomAdherent, 1, 1);
				gpaneAjoutAdherent.add(txtAdresseAdherent, 0, 2);
				gpaneAjoutAdherent.add(txtfAdresseAdherent, 1, 2);
				gpaneAjoutAdherent.add(txtTelephoneAdherent, 0, 3);
				gpaneAjoutAdherent.add(txtfTelephoneAdherent, 1, 3);
				gpaneAjoutAdherent.add(hboxButtonAhderent, 1, 4);
				
				
				
				txtfNomAdherent.requestFocus();
				

				btnAnnulerAjoutAdherent.setOnAction(new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent e) {
						// TODO Auto-generated method stub
						stageAjoutAdherent.close();
					}
				});
				btnConfirmerAJoutAdherent.setOnAction(new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent e) {
						// TODO Auto-generated method stub
					
							if (txtfNomAdherent.getText().compareTo("") == 0) {
								Alert Erreur = new Alert(AlertType.ERROR);
								Erreur.setTitle("Erreur");
								Erreur.setHeaderText(null);
								Erreur.setContentText("Vous n'avez pas tapé le nom de l'adhérent");
								Erreur.showAndWait();
							}
							else if (txtfPrenomAdherent.getText().compareTo("") == 0) {
								Alert Erreur = new Alert(AlertType.ERROR);
								Erreur.setTitle("Erreur");
								Erreur.setHeaderText(null);
								Erreur.setContentText("Vous n'avez pas tapé le prénom de l'adhérent");
								Erreur.showAndWait();
							}
							else if (txtfAdresseAdherent.getText().compareTo("") == 0) {
								Alert Erreur = new Alert(AlertType.ERROR);
								Erreur.setTitle("Erreur");
								Erreur.setHeaderText(null);
								Erreur.setContentText("Vous n'avez pas tapé l'adresse de l'adhérent");
								Erreur.showAndWait();
							}
							else if (txtfTelephoneAdherent.getText().compareTo("") == 0) {
								Alert Erreur = new Alert(AlertType.ERROR);
								Erreur.setTitle("Erreur");
								Erreur.setHeaderText(null);
								Erreur.setContentText("Vous n'avez pas tapé le téléphone");
								Erreur.showAndWait();
							}else if (!txtfTelephoneAdherent.getText().matches("^[\\(][0-9]{3}[\\)][\\s][0-9]{3}[\\-][0-9]{4}$")) {
								Alert Erreur = new Alert(AlertType.ERROR);
								Erreur.setTitle("Erreur");
								Erreur.setHeaderText(null);
								Erreur.setContentText("Voici le format que vous devez mettre : (###) ###-####");
								Erreur.showAndWait();
								txtfTelephoneAdherent.requestFocus();
							}
							else {// ajout d'un adhérent **important il faut que ça soit le prepose qui est connecter qui ajoute les adherents
							
								Adherent adheretnAjouter = new Adherent("1", txtfNomAdherent.getText(), txtfPrenomAdherent.getText(), txtfAdresseAdherent.getText(), txtfTelephoneAdherent.getText(), 0, 0);
								adheretnAjouter.setIntNbPrets(0);
								adheretnAjouter.setDblSolde(0);
								
								
								
								 prepose.ajouterAdherent(adheretnAjouter);
								 donneesAdherents.add(adheretnAjouter);
								// System.out.println(adheretnAjouter.getintNbPrets());
								 
								 	Alert confirmation = new Alert(AlertType.CONFIRMATION);
								 	confirmation.setTitle("Confirmation");
								 	confirmation.setHeaderText(null);
								 	confirmation.setContentText("L'adhérent dont le numéro est "+adheretnAjouter.getStrNumeroAdherent() +" a été ajouté!");
								 	confirmation.showAndWait();
								 	stageAjoutAdherent.close();
								 	
							}
							
						

					}
				});
				
				
				
				stageAjoutAdherent.setTitle("Ajout d'un adhérent");
				stageAjoutAdherent.getIcons().add(new Image("iconAjouterPersonne.png"));
				stageAjoutAdherent.sizeToScene();
				stageAjoutAdherent.setScene(sceneAjoutAdherent);
				stageAjoutAdherent.show();

			}
			else if(e.getSource()==btnModifierAdherent) {
				if(tableAdherent.getSelectionModel().getSelectedItem()==null) {//non selectionnee
					Alert Erreur = new Alert(AlertType.ERROR);
					Erreur.setTitle("Erreur");
					Erreur.setHeaderText(null);
					Erreur.setContentText("Vous devez sélectionner un adhérent pour le modifier");
					Erreur.showAndWait();
				}
				else{
					System.out.println("adhédent selectionnee");
					//modification adherent
					Stage stageModifAdherent = new Stage();
					GridPane gpaneModifAdherent = new GridPane();
					Scene sceneModifAdherent = new Scene(gpaneModifAdherent,320,220);
					
					gpaneModifAdherent.setPadding(new Insets(10));
					gpaneModifAdherent.setHgap(5);
					gpaneModifAdherent.setVgap(10);
					
					 txtNomAdherent = new Text("Nom :");
					 txtPrenomAdherent = new Text("Prenom :");
					 txtAdresseAdherent = new Text("Adresse :");
					 txtTelephoneAdherent = new Text("Téléphone :");
					
					 txtfNomAdherent = new TextField();
					 txtfPrenomAdherent = new TextField();
					 txtfAdresseAdherent = new TextField();
					 txtfTelephoneAdherent = new TextField();
					
					Button btnConfirmerModificationAdherent = new Button("Modifier");
					Button btnAnnulerModificationAdherent = new Button("Annuler");
					
					 hboxButtonAhderent = new HBox(2);
					hboxButtonAhderent.getChildren().addAll(btnConfirmerModificationAdherent,btnAnnulerModificationAdherent);
					

					
					
					gpaneModifAdherent.add(txtNomAdherent, 0, 0);
					gpaneModifAdherent.add(txtfNomAdherent, 1, 0);
					gpaneModifAdherent.add(txtPrenomAdherent, 0, 1);
					gpaneModifAdherent.add(txtfPrenomAdherent, 1, 1);
					gpaneModifAdherent.add(txtAdresseAdherent, 0, 2);
					gpaneModifAdherent.add(txtfAdresseAdherent, 1, 2);
					gpaneModifAdherent.add(txtTelephoneAdherent, 0, 3);
					gpaneModifAdherent.add(txtfTelephoneAdherent, 1, 3);
					gpaneModifAdherent.add(hboxButtonAhderent, 1, 4);
					
					//il faut aller chercher l'infor de l'adhérent selectioneee
					Adherent adherentModifier = tableAdherent.getSelectionModel().getSelectedItem();
					
					txtfNomAdherent.setText(adherentModifier.getStrNom());
					txtfPrenomAdherent.setText(adherentModifier.getStrPrenom());
					txtfAdresseAdherent.setText(adherentModifier.getStrAdresse());
					txtfTelephoneAdherent.setText(adherentModifier.getStrNumeroTelephone());
					
					btnAnnulerModificationAdherent.setOnAction(new EventHandler<ActionEvent>() {

						@Override
						public void handle(ActionEvent e) {
							// TODO Auto-generated method stub
							stageModifAdherent.close();
						}
					});
					btnConfirmerModificationAdherent.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent e) {
							// TODO Auto-generated method stub
							
							//voir comment modifier 
							
							//1. get l'emplacement ou se trouve l'adherent que jai cliquer
							//2. le supprimer
							//3. ajouter un nouvel adherent à l'emplacement choisi
							
							
							
							

						}
					});
					
					stageModifAdherent.setTitle("Modification d'un adhérent");
					stageModifAdherent.getIcons().add(new Image("iconModifierAdherent.png"));
					stageModifAdherent.sizeToScene();
					stageModifAdherent.setScene(sceneModifAdherent);
					stageModifAdherent.show();
					
				}
			}
			else if(e.getSource()==btnSupprimerAdherent) {
				if(tableAdherent.getSelectionModel().getSelectedItem()==null) {//non selectionnee
					Alert Erreur = new Alert(AlertType.ERROR);
					Erreur.setTitle("Erreur");
					Erreur.setHeaderText(null);
					Erreur.setContentText("Vous devez sélectionner un adhérent pour le supprimer.");
					Erreur.showAndWait();
				}
				else{ // ne marceh pas, voir erreur: java.lang.NullPointerException
					System.out.println("adhédent selectionnee");
					//suppresion adherent
					
					Adherent adherentSupprimer = tableAdherent.getSelectionModel().getSelectedItem();
					
					//prepose.afficherAdherents(adherentSupprimer);
					
					//System.out.println(adherentSupprimer.getStrNom());
			
					
					Alert confirmation = new Alert(AlertType.CONFIRMATION);
				 	confirmation.setTitle("Confirmation");
				 	confirmation.setHeaderText(null);
				 	confirmation.setContentText("L'adhérent dont le numéro est "+adherentSupprimer.getStrNumeroAdherent()+" sera supprimer. \nÊtes-vous sur que vous voulez le supprimer?");
				 	confirmation.showAndWait();
				 	if (confirmation.getResult() == ButtonType.OK) {
				 		prepose.supprimerAdherent(adherentSupprimer);
				 		donneesAdherents.removeAll(adherentSupprimer);
				 	}
				 
				 	
					
					
					
				}
			}
			else if(e.getSource()==btnPayerSoldeAdhernent) {
				if(tableAdherent.getSelectionModel().getSelectedItem()==null) {//non selectionnee
					Alert Erreur = new Alert(AlertType.ERROR);
					Erreur.setTitle("Erreur");
					Erreur.setHeaderText(null);
					Erreur.setContentText("Vous devez sélectionner un adhérent pour payer son solde.");
					Erreur.showAndWait();
				}
				else{
					System.out.println("adhédent selectionnee");
				}
			}

		}

	}
	private class GestionnaireButtonPrets implements EventHandler<MouseEvent> {

		@Override
		public void handle(MouseEvent e) {
			// TODO Auto-generated method stub
			
			if(e.getSource()==btnInscrireUnPret) {
				if(tableCatalogue.getSelectionModel().getSelectedItem()==null) {//non selectionnee
					Alert Erreur = new Alert(AlertType.ERROR);
					Erreur.setTitle("Erreur");
					Erreur.setHeaderText(null);
					Erreur.setContentText("Vous devez sélectionner un document pour l'emprunter");
					Erreur.showAndWait();
				}
				else{
					Document doc=tableCatalogue.getSelectionModel().getSelectedItem();
					System.out.println(doc.getTitre());
				}
			}
			else if(e.getSource()==btnIscrireUnRetour) {
				if(tableCatalogue.getSelectionModel().getSelectedItem()==null) {//non selectionnee
					Alert Erreur = new Alert(AlertType.ERROR);
					Erreur.setTitle("Erreur");
					Erreur.setHeaderText(null);
					Erreur.setContentText("Vous devez sélectionner un document pour le retourner");
					Erreur.showAndWait();
				}
				else{
					System.out.println("adhérent selectionnee");
				}
			}
			
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
