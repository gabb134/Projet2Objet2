package controleurEtVue;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.time.LocalDate;

import javafx.animation.ScaleTransition;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
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
import javafx.util.Duration;
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

	private BorderPane root;
	private BorderPane bPaneConnexion;
	private BorderPane bPaneEsthetique;
	private TabPane tabPane;

	private Stage stageCatalogue;
	private Scene sceneCatalogue;
	private Scene sceneConnexion;

	private Button btnConnecterAdherent;
	private Button btnConnecterAdmin;
	private Button btnConnecterEmploye;
	private Button btnConsulterCatalogue;

	private GridPane gPaneAdherent;
	private GridPane gPaneEmploye;
	private GridPane gPaneAdmin;

	private TextField txtFNom;
	private TextField txtFPrenom;
	private TextField txtFTelephone;
	private TextField txtFNoPrepose;
	private TextField txtFMotDePassePrepose;
	private TextField txtFNoAdmin;
	private TextField txtFMotDePasseAdmin;

	private Text txtNom;
	private Text txtPrenom;
	private Text txtTelephoneAdherent;
	private Text txtNoPrepose;
	private Text txtMotDePassePrepose;
	private Text txtNoAdmin;
	private Text txtMotDePasseAdmin;

	private TabPane tabPaneConnexion;
	private Tab tabConnexionAdherent;
	private Tab tabConnexionEmploye;
	private Tab tabConnexionAdmin;

	private RadioButton rbPrenomEtNom;
	private RadioButton rbTelephone;

	private String fichierSerial = "";
	private String FichierDeserial = "";

	private Text txtChoixconnexion;
	private Text txtNomEtPrenom;
	private Text txtTelephone;

	// Pour la partie de droite
	private Text txtNomDroite;
	private Text txtPrenomDroite;
	private Text txtTelephoneAdherentDroite;

	private TextField txtFNomDroite;
	private TextField txtFPrenomDroite;
	private TextField txtFTelephoneDroite;

	private RadioButton rbPrenomEtNomDroite;
	private RadioButton rbTelephoneDroite;

	private Button btnConnecterAdherentDroite;
	private Text txtChoixconnexionDroite;
	private Text txtNomEtPrenomDroite;
	private Text txtTelephoneDroite;

	private BorderPane bPaneDroite;
	private GridPane gpaneConnexionADroite;

	HBox hboxEnBas;
	ToggleGroup tGroupEnHaut;
	Text txtRechercherPar;
	RadioButton rbAuteurRealisateur;
	RadioButton rbMotsCles;
	TextField txtFRechercherPar;
	Button btnEffacer;

	private Button btnQuitter;

	@Override
	public void start(Stage primaryStage) {
		// TODO Auto-generated method stub

		try {
			// Fichiers serializables

			// fichierSerial ="C:/Users/rn.merzius/Downloads/test/fichier.ser";
			fichierSerial = "C:/Users/GabrielMarrero/Downloads/test/fichier.ser";
			// fichierSerial = "C:/Users/cg.marrero/Downloads/test/fichier.ser";

			// FichierDeserial = "C:/Users/rn.merzius/Downloads/test/fichier.ser";
			FichierDeserial = "C:/Users/GabrielMarrero/Downloads/test/fichier.ser";
			// FichierDeserial = "C:/Users/cg.marrero/Downloads/test/fichier.ser";

			root = new BorderPane();
			bPaneConnexion = new BorderPane();
			bPaneEsthetique = new BorderPane();

			tabPane = new TabPane();
			// tabPane.setPrefHeight(1050);
			// Pour la connexion(Partie � droite)

			stageCatalogue = new Stage();
			stageCatalogue.setTitle("M�diath�que");
			stageCatalogue.getIcons().add(new Image("booklibrary.png"));
			sceneCatalogue = new Scene(root);
			sceneConnexion = new Scene(bPaneConnexion, 600, 300);
			stageCatalogue.setScene(sceneCatalogue);
			stageCatalogue.setResizable(false);
			btnConnecterAdherent = new Button("Consulter mon dossier");

			btnConnecterAdherent.setOnMouseClicked(new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent event) {
					// TODO Auto-generated method stub
					if (rbPrenomEtNom.isSelected() && txtFNom.getText().compareTo("") == 0) {
						Alert Erreur = new Alert(AlertType.ERROR);
						Erreur.setTitle("Erreur");
						Erreur.setHeaderText(null);
						Erreur.setContentText("Vous n'avez pas tap� votre Nom");
						Erreur.showAndWait();
						txtFNom.requestFocus();
					} else if (rbPrenomEtNom.isSelected() && txtFPrenom.getText().compareTo("") == 0) {
						Alert Erreur = new Alert(AlertType.ERROR);
						Erreur.setTitle("Erreur");
						Erreur.setHeaderText(null);
						Erreur.setContentText("Vous n'avez pas tap� votre pr�nom");
						Erreur.showAndWait();
						txtFPrenom.requestFocus();
					} else if (rbTelephone.isSelected() && txtFTelephone.getText().compareTo("") == 0) {
						Alert Erreur = new Alert(AlertType.ERROR);
						Erreur.setTitle("Erreur");
						Erreur.setHeaderText(null);
						Erreur.setContentText("Vous n'avez pas tap� votre t�l�phone");
						Erreur.showAndWait();
						txtFTelephone.requestFocus();
					}

				}
			});
			btnConnecterAdmin = new Button("Connexion");
			btnConnecterAdmin.setOnMouseClicked(new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent event) {
					// TODO Auto-generated method stub
					if (txtFNoAdmin.getText().compareTo("") == 0) {
						Alert Erreur = new Alert(AlertType.ERROR);
						Erreur.setTitle("Erreur");
						Erreur.setHeaderText(null);
						Erreur.setContentText("Vous n'avez pas tap� votre num�ro d'administrateur");
						Erreur.showAndWait();
						txtFNoAdmin.requestFocus();
					} else if (txtFMotDePasseAdmin.getText().compareTo("") == 0) {
						Alert Erreur = new Alert(AlertType.ERROR);
						Erreur.setTitle("Erreur");
						Erreur.setHeaderText(null);
						Erreur.setContentText("Vous n'avez pas tap� votre mot de passe");
						Erreur.showAndWait();
						txtFMotDePasseAdmin.requestFocus();
					}

				}
			});
			btnConnecterEmploye = new Button("Connexion");
			btnConnecterEmploye.setOnMouseClicked(new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent event) {
					// TODO Auto-generated method stub
					if (txtFNoPrepose.getText().compareTo("") == 0) {
						Alert Erreur = new Alert(AlertType.ERROR);
						Erreur.setTitle("Erreur");
						Erreur.setHeaderText(null);
						Erreur.setContentText("Vous n'avez pas tap� votre num�ro d'employ�");
						Erreur.showAndWait();
						txtFNoPrepose.requestFocus();
					} else if (txtFMotDePassePrepose.getText().compareTo("") == 0) {
						Alert Erreur = new Alert(AlertType.ERROR);
						Erreur.setTitle("Erreur");
						Erreur.setHeaderText(null);
						Erreur.setContentText("Vous n'avez pas tap� votre mot de passe");
						Erreur.showAndWait();
						txtFMotDePassePrepose.requestFocus();
					}

				}
			});
			btnConsulterCatalogue = new Button("Consulter le catalogue");

			gPaneAdherent = new GridPane();
			gPaneEmploye = new GridPane();
			gPaneAdmin = new GridPane();

			Font fontText1 = Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 15);

			txtFNom = new TextField();
		
			txtFPrenom = new TextField();
			txtFTelephone = new TextField();
			txtFTelephone.setPromptText("(###) ###-####");
			txtFNoPrepose = new TextField();
			txtFMotDePassePrepose = new TextField();
			txtFNoAdmin = new TextField();
			txtFMotDePasseAdmin = new TextField();
			txtNom = new Text("Nom adh�rent:");
			txtNom.setFill(Color.ANTIQUEWHITE);
			txtNom.setFont(fontText1);
			txtPrenom = new Text("Pr�nom adh�rent:");
			txtPrenom.setFill(Color.ANTIQUEWHITE);
			txtPrenom.setFont(fontText1);
			txtTelephoneAdherent = new Text("T�l�phone:");
			txtTelephoneAdherent.setFill(Color.ANTIQUEWHITE);
			txtTelephoneAdherent.setFont(fontText1);
			txtNoPrepose = new Text("Num�ro de l'employ�:");
			txtNoPrepose.setFill(Color.ANTIQUEWHITE);
			txtNoPrepose.setFont(fontText1);
			txtMotDePassePrepose = new Text("Mot de passe:");
			txtMotDePassePrepose.setFill(Color.ANTIQUEWHITE);
			txtMotDePassePrepose.setFont(fontText1);
			txtNoAdmin = new Text("Num�ro de l'admin:");
			txtNoAdmin.setFill(Color.ANTIQUEWHITE);
			txtNoAdmin.setFont(fontText1);
			txtMotDePasseAdmin = new Text("Mot de passe:");
			txtMotDePasseAdmin.setFill(Color.ANTIQUEWHITE);
			txtMotDePasseAdmin.setFont(fontText1);

			
			
			btnConnecterAdherent.setFont(fontText1);
			btnConnecterEmploye.setFont(fontText1);
			btnConnecterAdmin.setFont(fontText1);
			btnConsulterCatalogue.setFont(fontText1);

			Font fontRb = Font.font("Arial", FontWeight.BOLD, 10);
			Font fontText2 = Font.font("Arial", FontWeight.BOLD, 15);
			ToggleGroup tgroup = new ToggleGroup();
			txtChoixconnexion = new Text("S'identifier avec:");
			txtNomEtPrenom = new Text("Nom et pr�nom");
			txtTelephone = new Text("T�l�phone");
			// HBox hboxChoix = new HBox(2);
			// HBox hboxPrenom = new HBox(5);
			txtChoixconnexion.setFont(fontText1);
			txtChoixconnexion.setFill(Color.ANTIQUEWHITE);
			txtNomEtPrenom.setFill(Color.ANTIQUEWHITE);
			txtTelephone.setFill(Color.ANTIQUEWHITE);
			txtNomEtPrenom.setFont(fontText2);
			txtTelephone.setFont(fontText2);
			rbPrenomEtNom = new RadioButton();
			rbTelephone = new RadioButton();
			rbPrenomEtNom.setToggleGroup(tgroup);
			rbTelephone.setToggleGroup(tgroup);
			rbPrenomEtNom.setFont(fontRb);
			rbTelephone.setFont(fontRb);
			rbPrenomEtNom.setSelected(true);
			// rbTelephone.setSelected(true);
			// hboxChoix.getChildren().addAll(txtChoixconnexion,rbPrenomEtNom,txtNomEtPrenom,rbTelephone,txtTelephone);
			// hboxPrenom.getChildren().addAll(txtPrenom,txtFPrenom);

			btnConsulterCatalogue.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					// TODO Auto-generated method stub
					stageCatalogue.show();
					primaryStage.close();

				}
			});

			tabPaneConnexion = new TabPane();

			// Premier onglet (Adherent)
			tabConnexionAdherent = new Tab();
			tabConnexionAdherent.setClosable(false);
			tabConnexionAdherent.setText("Adh�rent");
			tabConnexionAdherent.setGraphic(new ImageView(new Image("Adherent.jpg")));
			tabConnexionAdherent.setContent(gPaneAdherent);
			// gPaneAdherent.setAlignment(Pos.TOP_CENTER);
			gPaneAdherent.setVgap(10);
			gPaneAdherent.setHgap(2);
			gPaneAdherent.setPadding(new Insets(40));

			gPaneAdherent.add(txtChoixconnexion, 0, 0);
			gPaneAdherent.add(rbPrenomEtNom, 1, 0);
			gPaneAdherent.add(txtNomEtPrenom, 2, 0);
			gPaneAdherent.add(rbTelephone, 1, 1);
			gPaneAdherent.add(txtTelephone, 2, 1);
			gPaneAdherent.add(txtNom, 0, 3, 2, 1);
			gPaneAdherent.add(txtFNom, 2, 3, 2, 1);
			gPaneAdherent.add(txtPrenom, 0, 4, 2, 1);
			gPaneAdherent.add(txtFPrenom, 2, 4, 2, 1);
			gPaneAdherent.add(btnConnecterAdherent, 2, 5, 2, 1);
			gPaneAdherent.add(btnConsulterCatalogue, 2, 6, 2, 1);

			// Deuxieme onglet (Prepose)
			tabConnexionEmploye = new Tab();
			tabConnexionEmploye.setClosable(false);
			tabConnexionEmploye.setText("Employ�");
			tabConnexionEmploye.setGraphic(new ImageView(new Image("Employe.jpg")));
			tabConnexionEmploye.setContent(gPaneEmploye);
			gPaneEmploye.setVgap(10);
			gPaneEmploye.setPadding(new Insets(80));

			gPaneEmploye.add(txtNoPrepose, 0, 0);
			gPaneEmploye.add(txtFNoPrepose, 1, 0);
			gPaneEmploye.add(txtMotDePassePrepose, 0, 1);
			gPaneEmploye.add(txtFMotDePassePrepose, 1, 1);
			gPaneEmploye.add(btnConnecterEmploye, 1, 2, 2, 1);

			// troisieme onglet (Administrateur)
			tabConnexionAdmin = new Tab();
			tabConnexionAdmin.setClosable(false);
			tabConnexionAdmin.setText("Administrateur");
			tabConnexionAdmin.setGraphic(new ImageView(new Image("Admin.jpg")));
			tabConnexionAdmin.setContent(gPaneAdmin);
			gPaneAdmin.setVgap(10);
			gPaneAdmin.setPadding(new Insets(80));

			gPaneAdmin.add(txtNoAdmin, 0, 0);
			gPaneAdmin.add(txtFNoAdmin, 1, 0);
			gPaneAdmin.add(txtMotDePasseAdmin, 0, 1);
			gPaneAdmin.add(txtFMotDePasseAdmin, 1, 1);
			gPaneAdmin.add(btnConnecterAdmin, 1, 2, 2, 1);

			GestionAdherentConnexion1 gConexxcion1 = new GestionAdherentConnexion1();
			GestionAdherentConnexion2 gConexxcion2 = new GestionAdherentConnexion2();
			rbPrenomEtNom.setOnAction(gConexxcion1);
			rbTelephone.setOnAction(gConexxcion1);

			// Ajout des onglets de connexion
			tabPaneConnexion.getTabs().addAll(tabConnexionAdherent, tabConnexionEmploye, tabConnexionAdmin);

			// connexion(Partie � gauche)

			// Font fontText2 = Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR,
			// 15);
			Text txtExplication = new Text("Veuillez choisir un des trois onglet pour acc�der � notre m�diath�que.");
			HBox hBoxText = new HBox();
			hBoxText.getChildren().add(txtExplication);
			// txtExplication.setFont(fontText1);
			hBoxText.setAlignment(Pos.CENTER);
			// bPaneConnexion.setTop(hBoxText);
			Color color = Color.web("#541E1E");
			bPaneConnexion.setBackground(new Background(new BackgroundFill(color, new CornerRadii(10), new Insets(0))));
			Text txtBienvenue = new Text("      BIENVENUE \n� LA M�DIATH�QUE");

			DropShadow ds = new DropShadow();
			ds.setOffsetY(3.0f);
			ds.setColor(Color.color(0.4f, 0.4f, 0.4f));

			txtBienvenue.setEffect(ds);
			txtBienvenue.setCache(true);
			txtBienvenue.setX(10.0f);
			txtBienvenue.setY(270.0f);
			txtBienvenue.setFill(Color.ANTIQUEWHITE);

			txtBienvenue.setFont(Font.font(null, FontWeight.BOLD, 15));

			// txtBienvenue.setFill(Color.ANTIQUEWHITE);
			ImageView image = new ImageView("booklibrary.png");
			image.setFitHeight(130);
			image.setFitWidth(130);

			/*
			 * //Creating scale Transition ScaleTransition scaleTransition = new
			 * ScaleTransition();
			 * 
			 * //Setting the duration for the transition
			 * scaleTransition.setDuration(Duration.millis(10000));
			 * 
			 * //Setting the node for the transition scaleTransition.setNode(image);
			 * 
			 * //Setting the dimensions for scaling scaleTransition.setByY(0.5);
			 * scaleTransition.setByX(0.5);
			 * 
			 * //Setting the cycle count for the translation
			 * scaleTransition.setCycleCount(50);
			 * 
			 * //Setting auto reverse value to true scaleTransition.setAutoReverse(false);
			 * 
			 * //Playing the animation scaleTransition.play();
			 */

			// txtBienvenue.setFont(fontText2);
			bPaneEsthetique.setTop(txtBienvenue);
			bPaneEsthetique.setAlignment(txtBienvenue, Pos.CENTER);
			bPaneEsthetique.setMargin(txtBienvenue, new Insets(15, 5, 5, 15));
			bPaneEsthetique.setCenter(image);

			// premier onglet (Catalogue)
			Tab tabCatalogue = new Tab();
			tabCatalogue.setClosable(false);
			tabCatalogue.setText("Tous les documents");
			tabCatalogue.setGraphic(new ImageView(new Image("icon-collection.png")));

			// deuxieme onglet (Livres)
			Tab tabLivres = new Tab();
			tabLivres.setClosable(false);
			tabLivres.setText("Livres");
			tabLivres.setGraphic(new ImageView(new Image("icon-livre.png")));

			// troisieme onglet (DVD)
			Tab tabDVD = new Tab();
			tabDVD.setClosable(false);
			tabDVD.setText("DVDs");
			tabDVD.setGraphic(new ImageView(new Image("icon-dvd.png")));

			// Quatrieme onglet (Periodique)
			Tab tabPeriodique = new Tab();
			tabPeriodique.setClosable(false);
			tabPeriodique.setText("P�riodiques");
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
			TableColumn<Document, String> colonneNumDocCatalogue = new TableColumn<Document, String>("Num�ro Document");
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
			TableColumn<Livre, String> colonneNumDocLivre = new TableColumn<Livre, String>("Num�ro Document");
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

			TableColumn<DVD, String> colonneNumDocDVD = new TableColumn<DVD, String>("Num�ro Document");
			TableColumn<DVD, String> colonneTitreDVD = new TableColumn<DVD, String>("Titre");
			TableColumn<DVD, LocalDate> colonneDatePubDVD = new TableColumn<DVD, LocalDate>("Date de publication");
			TableColumn<DVD, String> colonneDispoDVD = new TableColumn<DVD, String>("Disponible");
			TableColumn<DVD, Integer> colonneNbDisquesDVD = new TableColumn<DVD, Integer>("Nombres de disques");
			TableColumn<DVD, String> colonneRealisateurDVD = new TableColumn<DVD, String>("R�alisateur");

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
					"Num�ro Document");
			TableColumn<Periodique, String> colonneTitrePeriodique = new TableColumn<Periodique, String>("Titre");
			TableColumn<Periodique, LocalDate> colonneDatePubPeriodique = new TableColumn<Periodique, LocalDate>(
					"Date de publication");
			TableColumn<Periodique, String> colonneDispoPeriodique = new TableColumn<Periodique, String>("Disponible");
			TableColumn<Periodique, Integer> colonneNoVolumePeriodique = new TableColumn<Periodique, Integer>(
					"Num�ro volume");
			TableColumn<Periodique, Integer> colonneNoPeriodiquePeriodique = new TableColumn<Periodique, Integer>(
					"Num�ro p�riodique");

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

			// pour la partie de droite du root(borderpane)
			bPaneDroite = new BorderPane();
			bPaneDroite.setPadding(new Insets(5));

			gpaneConnexionADroite = new GridPane(); // Pour la partie de droite en bas
			bPaneDroite.setTop(gpaneConnexionADroite);

			BorderStroke bordureNoir = new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(5),
					new BorderWidths(2), new Insets(0));
			Border borduregGpane = new Border(bordureNoir);
			gpaneConnexionADroite.setBorder(borduregGpane);
			gpaneConnexionADroite.setVgap(10);
			gpaneConnexionADroite.setHgap(2);
			gpaneConnexionADroite.setPadding(new Insets(15));

			btnConnecterAdherentDroite = new Button("Consulter mon dossier");
			txtChoixconnexionDroite = new Text("S'identifier avec : ");
			txtNomEtPrenomDroite = new Text("Nom et pr�nom");
			txtTelephoneDroite = new Text("T�l�phone");
			txtFNomDroite = new TextField();
			txtFPrenomDroite = new TextField();
			txtFTelephoneDroite = new TextField();
			txtFTelephoneDroite.setPromptText("(###) ###-####");
			txtNomDroite = new Text("Nom adh�rent:");

			txtNomDroite.setFont(fontText1);
			txtPrenomDroite = new Text("Pr�nom adh�rent:");

			txtPrenomDroite.setFont(fontText1);
			txtTelephoneAdherentDroite = new Text("T�l�phone:");

			txtTelephoneAdherentDroite.setFont(fontText1);
			ToggleGroup tgroup1 = new ToggleGroup();
			rbPrenomEtNomDroite = new RadioButton();
			rbTelephoneDroite = new RadioButton();
			rbPrenomEtNomDroite.setToggleGroup(tgroup1);
			rbTelephoneDroite.setToggleGroup(tgroup1);
			rbPrenomEtNomDroite.setFont(fontRb);
			rbTelephoneDroite.setFont(fontRb);
			rbPrenomEtNomDroite.setSelected(true);

			gpaneConnexionADroite.add(txtChoixconnexionDroite, 0, 0);
			gpaneConnexionADroite.add(rbPrenomEtNomDroite, 1, 0);
			gpaneConnexionADroite.add(txtNomEtPrenomDroite, 2, 0);
			gpaneConnexionADroite.add(rbTelephoneDroite, 1, 1);
			gpaneConnexionADroite.add(txtTelephoneDroite, 2, 1);
			gpaneConnexionADroite.add(txtNomDroite, 0, 3, 2, 1);
			gpaneConnexionADroite.add(txtFNomDroite, 2, 3, 2, 1);
			gpaneConnexionADroite.add(txtPrenomDroite, 0, 4, 2, 1);
			gpaneConnexionADroite.add(txtFPrenomDroite, 2, 4, 2, 1);
			gpaneConnexionADroite.add(btnConnecterAdherentDroite, 2, 5, 2, 1);

			rbPrenomEtNomDroite.setOnAction(gConexxcion2);
			rbTelephoneDroite.setOnAction(gConexxcion2);

			root.setRight(bPaneDroite);

			// Partie d'en haut
			hboxEnBas = new HBox(10);
			hboxEnBas.setPadding(new Insets(10));
			ToggleGroup tGroupEnHaut = new ToggleGroup();
			txtRechercherPar = new Text("Rechercher par: ");
			rbAuteurRealisateur = new RadioButton("auteur/r�alisateur");
			rbMotsCles = new RadioButton("Mos cl�s");
			txtFRechercherPar = new TextField();
			btnEffacer = new Button("Effacer");
			btnEffacer.setPrefWidth(170);
			rbAuteurRealisateur.setToggleGroup(tGroupEnHaut);
			rbMotsCles.setToggleGroup(tGroupEnHaut);
			rbAuteurRealisateur.setSelected(true);
			// tPaneEnBas.setAlignment(Pos.le);
			GestionConsulterCatalogue gCCatalogue = new GestionConsulterCatalogue();
			rbAuteurRealisateur.setOnAction(gCCatalogue);
			rbMotsCles.setOnAction(gCCatalogue);
			btnEffacer.setOnAction(gCCatalogue);
			
			hboxEnBas.getChildren().addAll(txtRechercherPar, rbAuteurRealisateur, rbMotsCles, txtFRechercherPar,
					btnEffacer);
			root.setBottom(hboxEnBas); // faire la partie pour la recherche(mot cl�s )

			// partie d'en bas
			HBox hboxButton = new HBox();
			btnQuitter = new Button("Quitter");
			btnQuitter.setPrefWidth(150);
			hboxButton.getChildren().add(btnQuitter);
			hboxButton.setAlignment(Pos.CENTER);
			bPaneDroite.setBottom(hboxButton);

			btnQuitter.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					// TODO Auto-generated method stub
					stageCatalogue.close();
					primaryStage.show();
				}

			});

			// tabPaneConnexion.setBackground(new Background(new
			// BackgroundFill(Color.LIGHTGRAY, new CornerRadii(10), new Insets(0))));

			bPaneConnexion.setRight(tabPaneConnexion);
			bPaneConnexion.setLeft(bPaneEsthetique);

			tabPaneConnexion.setBackground(new Background(new BackgroundImage(new Image("library2.jpg"),
					BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
					new BackgroundSize(500, 600, false, false, false, false))));

			tabCatalogue.setContent(tableCatalogue);
			tabLivres.setContent(tableLivre);
			tabDVD.setContent(tableDVD);
			tabPeriodique.setContent(tablePeriodique);
			tabPane.getTabs().addAll(tabCatalogue, tabLivres, tabDVD, tabPeriodique);
			// grCatalogue.getChildren().add(table);
			// grCatalogue.getChildren().add(b);

			primaryStage.getIcons().add(new Image("booklibrary.png"));
			primaryStage.setTitle("Connexion � la m�diath�que");
			primaryStage.sizeToScene();
			primaryStage.setResizable(false);
			primaryStage.setScene(sceneConnexion);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private class GestionConsulterCatalogue implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource()==rbAuteurRealisateur) {
				txtFRechercherPar.requestFocus();
			}
			else if(e.getSource() == rbMotsCles) {
				txtFRechercherPar.requestFocus();
			}
			if(e.getSource()==btnEffacer) {
				txtFRechercherPar.clear();
			}

		}

	}

	private class GestionAdherentConnexion1 implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource() == rbPrenomEtNom) {
				System.out.println("prenomEtNom");
				// gPaneAdherent.getChildren().clear();
				
				gPaneAdherent.getChildren().removeAll(txtTelephoneAdherent);
				gPaneAdherent.getChildren().removeAll(txtFTelephone);

				gPaneAdherent.add(txtNom, 0, 3, 2, 1);
				gPaneAdherent.add(txtFNom, 2, 3, 2, 1);
				gPaneAdherent.add(txtPrenom, 0, 4, 2, 1);
				gPaneAdherent.add(txtFPrenom, 2, 4, 2, 1);
				txtFNom.requestFocus();

			} else if (e.getSource() == rbTelephone) {
				
				

				gPaneAdherent.getChildren().removeAll(txtNom);
				gPaneAdherent.getChildren().removeAll(txtFNom);
				gPaneAdherent.getChildren().removeAll(txtPrenom);
				gPaneAdherent.getChildren().removeAll(txtFPrenom);
				// gPaneAdherent.add(txtTelephoneAdherent, columnIndex, rowIndex);
				// gPaneAdherent.add(txtFTelephone, columnIndex, rowIndex);
				// gPaneAdherent.getChildren().clear();
				gPaneAdherent.add(txtTelephoneAdherent, 0, 3, 2, 1);
				gPaneAdherent.add(txtFTelephone, 1, 3, 2, 1);
				txtFTelephone.requestFocus();
				System.out.println("Telephone");
			}
		}
	}

	private class GestionAdherentConnexion2 implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent e) {
			// TODO Auto-generated method stub

			if (e.getSource() == rbPrenomEtNomDroite) {
				System.out.println("prenomEtNom");
				// gPaneAdherent.getChildren().clear();
				
				gpaneConnexionADroite.getChildren().removeAll(txtTelephoneAdherentDroite);
				gpaneConnexionADroite.getChildren().removeAll(txtFTelephoneDroite);

				gpaneConnexionADroite.add(txtNomDroite, 0, 3, 2, 1);
				gpaneConnexionADroite.add(txtFNomDroite, 2, 3, 2, 1);
				gpaneConnexionADroite.add(txtPrenomDroite, 0, 4, 2, 1);
				gpaneConnexionADroite.add(txtFPrenomDroite, 2, 4, 2, 1);
				txtFNomDroite.requestFocus();

			} else if (e.getSource() == rbTelephoneDroite) {

				
				gpaneConnexionADroite.getChildren().removeAll(txtNomDroite);
				gpaneConnexionADroite.getChildren().removeAll(txtFNomDroite);
				gpaneConnexionADroite.getChildren().removeAll(txtPrenomDroite);
				gpaneConnexionADroite.getChildren().removeAll(txtFPrenomDroite);
				// gPaneAdherent.add(txtTelephoneAdherent, columnIndex, rowIndex);
				// gPaneAdherent.add(txtFTelephone, columnIndex, rowIndex);
				// gPaneAdherent.getChildren().clear();
				gpaneConnexionADroite.add(txtTelephoneAdherentDroite, 0, 3, 2, 1);
				gpaneConnexionADroite.add(txtFTelephoneDroite, 2, 3, 2, 1);
				txtFTelephoneDroite.requestFocus();
				System.out.println("Telephone");
			}

		}

	}

	public void SerializationCatalogue() { // Methode qui permet d'aller chercher l'objet Catalogue pour le serializer
		Catalogue catalogueSerialisation = Catalogue.getInstance("Livres.txt", "Periodiques.txt", "DVD.txt");

		try {
			FileOutputStream fichier = new FileOutputStream(fichierSerial);
			ObjectOutputStream sortie = new ObjectOutputStream(fichier);

			sortie.writeObject(catalogueSerialisation);

			sortie.close();
			fichier.close();

			// System.out.println("l'objet catalogue vient d'�tre seralizer");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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

			// System.out.println("l'objet catalogue vient d'�etre deserlializer");
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