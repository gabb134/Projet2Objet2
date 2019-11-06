package controleurEtVue;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.text.TabableView;

import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.ParallelTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
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
import modele.Prepose;

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

	private HBox hboxEnBas;
	private ToggleGroup tGroupEnHaut;
	private Text txtRechercherPar;
	private RadioButton rbAuteurRealisateur;
	private RadioButton rbMotsCles;
	private TextField txtFRechercherPar;
	private Button btnEffacer;

	private Button btnQuitter;

	private Font fontText1;
	private ValidationAdherent validationadherent;

	private ValidationAdmin validationadmin;

	private ValidationEmploye validationemploye;

	private GestionAdherentConnexion1 gConexxcion1;
	private GestionAdherentConnexion2 gConexxcion2;

	private Font fontRb;
	private Font fontText2;

	private Tab tabCatalogue;

	private Tab tabLivres;

	private Tab tabDVD;

	private Tab tabPeriodique;

	@Override
	public void start(Stage primaryStage) {
		// TODO Auto-generated method stub

		try {
			// FICHIERS SERIALIZABLES

			// fichierSerial ="C:/Users/rn.merzius/Downloads/test/fichier.ser";
			// fichierSerial = "C:/Users/GabrielMarrero/Downloads/test/fichier.ser";
			fichierSerial = "C:/Users/cg.marrero/Downloads/test/fichier.ser";
			// fichierSerial= "/Users/r.merzius/Desktop/fichier.ser";
			// FichierDeserial="/Users/r.merzius/Desktop/fichier.ser";
			// FichierDeserial = "C:/Users/rn.merzius/Downloads/test/fichier.ser";
			// FichierDeserial = "C:/Users/GabrielMarrero/Downloads/test/fichier.ser";
			FichierDeserial = "C:/Users/cg.marrero/Downloads/test/fichier.ser";

			root = new BorderPane();
			bPaneConnexion = new BorderPane();
			bPaneEsthetique = new BorderPane();
			tabPane = new TabPane();

			// DANS LA CONNEXION

			gestionConnexionADroite(); // methode qui gere la partie a droite de la connexion (adhérent,préposé et
										// administrateur...)

			btnConsulterCatalogue.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					// TODO Auto-generated method stub
					stageCatalogue.show();
					primaryStage.close();

				}
			});


			gestionConnexionAgauche();// methode qui gere la partie a gauche de la connexion (le titre et le logo)

			// DANS LE CATALOGUE
			gestionCatalogue(); // methode qui gere tout ce qui est dans l'interface du catalogue

			btnQuitter.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					// TODO Auto-generated method stub
					stageCatalogue.close();
					primaryStage.show();
				}

			});

			// AFFICHAGE
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
		

			primaryStage.getIcons().add(new Image("booklibrary.png"));
			primaryStage.setTitle("Connexion à la médiathèque");
			primaryStage.sizeToScene();
			primaryStage.setResizable(false);
			primaryStage.setScene(sceneConnexion);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void gestionConnexionAgauche() {
		// Font fontText2 = Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR,
		// 15);
		Text txtExplication = new Text("Veuillez choisir un des trois onglet pour accéder à notre médiathèque.");
		HBox hBoxText = new HBox();
		hBoxText.getChildren().add(txtExplication);
		// txtExplication.setFont(fontText1);
		hBoxText.setAlignment(Pos.CENTER);
		// bPaneConnexion.setTop(hBoxText);
		Color color = Color.web("#541E1E");
		bPaneConnexion.setBackground(new Background(new BackgroundFill(color, new CornerRadii(10), new Insets(0))));
		Text txtBienvenue = new Text("          BIENVENUE \nÀ NOTRE MÉDIATHÈQUE  ");

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

		// txtBienvenue.setFont(fontText2);
		bPaneEsthetique.setTop(txtBienvenue);
		bPaneEsthetique.setAlignment(txtBienvenue, Pos.CENTER);
		bPaneEsthetique.setMargin(txtBienvenue, new Insets(15, 5, 5, 15));
		bPaneEsthetique.setCenter(image);
	}

	public void gestionCatalogue() {
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
		tabPeriodique.setText("Péiodiques");
		tabPeriodique.setGraphic(new ImageView(new Image("icon-periodique.png")));

		// gestion des tablesViews
		gestionTableViewCatalogue(); // permet de mettres les colonnes et les remplir

		root.setCenter(tabPane);

		// pour la partie de droite du root(borderpane)
		GestionConsulterCatalogue gCatalogue = new GestionConsulterCatalogue();

		bPaneDroite = new BorderPane();

		bPaneDroite.setPadding(new Insets(10));
		gpaneConnexionADroite = new GridPane();
		bPaneDroite.setPadding(new Insets(5));

		bPaneDroite.setTop(gpaneConnexionADroite);

		ImageView image1 = new ImageView(new Image("catalogue2.png"));
		image1.setFitHeight(200);
		image1.setFitWidth(170);
		bPaneDroite.setCenter(image1);

		// animation image

		BorderStroke bordureNoir = new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(5),
				new BorderWidths(2), new Insets(0));
		Border borduregGpane = new Border(bordureNoir);
		ToggleGroup tGroupDroite = new ToggleGroup();
		gpaneConnexionADroite.setBorder(borduregGpane);
		gpaneConnexionADroite.setVgap(10);
		gpaneConnexionADroite.setHgap(2);
		gpaneConnexionADroite.setPadding(new Insets(10));

		btnConnecterAdherentDroite = new Button("Consulter mon dossier");
		txtChoixconnexionDroite = new Text("S'identifier avec : ");
		txtNomEtPrenomDroite = new Text("Nom et prénom");
		txtTelephoneDroite = new Text("Téléphone");
		txtFNomDroite = new TextField();
		txtFPrenomDroite = new TextField();
		txtFTelephoneDroite = new TextField();
		txtFTelephoneDroite.setPromptText("(###) ###-####");
		txtNomDroite = new Text("Nom adhérent:");

		txtNomDroite.setFont(fontText1);
		txtPrenomDroite = new Text("Prénom adhérent:");

		txtPrenomDroite.setFont(fontText1);
		txtTelephoneAdherentDroite = new Text("Téléphone:");

		txtTelephoneAdherentDroite.setFont(fontText1);

		rbPrenomEtNomDroite = new RadioButton();
		rbTelephoneDroite = new RadioButton();
		rbPrenomEtNomDroite.setToggleGroup(tGroupDroite);
		rbTelephoneDroite.setToggleGroup(tGroupDroite);
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

		btnConnecterAdherentDroite.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				if (rbPrenomEtNomDroite.isSelected() && txtFNomDroite.getText().compareTo("") == 0) {
					Alert Erreur = new Alert(AlertType.ERROR);
					Erreur.setTitle("Erreur");
					Erreur.setHeaderText(null);
					Erreur.setContentText("Vous n'avez pas tapez votre Nom");
					Erreur.showAndWait();
					txtFNom.requestFocus();
				} else if (rbPrenomEtNomDroite.isSelected() && txtFPrenomDroite.getText().compareTo("") == 0) {
					Alert Erreur = new Alert(AlertType.ERROR);
					Erreur.setTitle("Erreur");
					Erreur.setHeaderText(null);
					Erreur.setContentText("Vous n'avez pas tapez votre prénom");
					Erreur.showAndWait();
					txtFPrenomDroite.requestFocus();
				} else if (rbTelephoneDroite.isSelected() && txtFTelephoneDroite.getText().compareTo("") == 0) {
					Alert Erreur = new Alert(AlertType.ERROR);
					Erreur.setTitle("Erreur");
					Erreur.setHeaderText(null);
					Erreur.setContentText("Vous n'avez pas tapez votre téléphone");
					Erreur.showAndWait();
					txtFTelephoneDroite.requestFocus();
				}

			}
		});

		rbPrenomEtNomDroite.setOnAction(gConexxcion2);
		rbTelephoneDroite.setOnAction(gConexxcion2);

		root.setRight(bPaneDroite);

		// Partie d'en haut
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
		// tPaneEnBas.setAlignment(Pos.le);

		rbAuteurRealisateur.setOnAction(gCatalogue);
		rbMotsCles.setOnAction(gCatalogue);
		btnEffacer.setOnAction(gCatalogue);

		hboxEnBas.getChildren().addAll(txtRechercherPar, rbAuteurRealisateur, rbMotsCles, txtFRechercherPar,
				btnEffacer);
		root.setBottom(hboxEnBas); // faire la partie pour la recherche(mot clï¿½s )

		// partie d'en bas
		HBox hboxButton = new HBox();
		btnQuitter = new Button("Quitter");
		btnQuitter.setPrefWidth(150);
		hboxButton.getChildren().add(btnQuitter);
		hboxButton.setAlignment(Pos.CENTER);
		bPaneDroite.setBottom(hboxButton);

	}

	public void gestionConnexionADroite() {

		stageCatalogue = new Stage();
		stageCatalogue.setTitle("Médiathèque");
		stageCatalogue.getIcons().add(new Image("booklibrary.png"));
		sceneCatalogue = new Scene(root);
		sceneConnexion = new Scene(bPaneConnexion, 600, 300);
		stageCatalogue.setScene(sceneCatalogue);
		stageCatalogue.setResizable(false);
		btnConnecterAdherent = new Button("Consulter mon dossier");
		validationadherent = new ValidationAdherent();
		btnConnecterAdherent.setOnMouseClicked(validationadherent);
		btnConnecterAdmin = new Button("Connexion");
		validationadmin = new ValidationAdmin();
		btnConnecterAdmin.setOnMouseClicked(validationadmin);
		btnConnecterEmploye = new Button("Connexion");
		validationemploye = new ValidationEmploye();
		btnConnecterEmploye.setOnMouseClicked(validationemploye);
		btnConsulterCatalogue = new Button("Consulter le catalogue");

		gPaneAdherent = new GridPane();
		gPaneEmploye = new GridPane();
		gPaneAdmin = new GridPane();

		fontText1 = Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 15);

		txtFNom = new TextField();
		txtFPrenom = new TextField();
		txtFTelephone = new TextField();
		txtFTelephone.setPromptText("(###) ###-####");
		txtFNoPrepose = new TextField();
		txtFMotDePassePrepose = new TextField();
		txtFNoAdmin = new TextField();
		txtFMotDePasseAdmin = new TextField();
		txtNom = new Text("Nom adhérent:");
		txtNom.setFill(Color.ANTIQUEWHITE);
		txtNom.setFont(fontText1);
		txtPrenom = new Text("Prénom adhérent:");
		txtPrenom.setFill(Color.ANTIQUEWHITE);
		txtPrenom.setFont(fontText1);
		txtTelephoneAdherent = new Text("Téléphone:");
		txtTelephoneAdherent.setFill(Color.ANTIQUEWHITE);
		txtTelephoneAdherent.setFont(fontText1);
		txtNoPrepose = new Text("Numéro de l'employé:");
		txtNoPrepose.setFill(Color.ANTIQUEWHITE);
		txtNoPrepose.setFont(fontText1);
		txtMotDePassePrepose = new Text("Mot de passe:");
		txtMotDePassePrepose.setFill(Color.ANTIQUEWHITE);
		txtMotDePassePrepose.setFont(fontText1);
		txtNoAdmin = new Text("Numéro de l'admin:");
		txtNoAdmin.setFill(Color.ANTIQUEWHITE);
		txtNoAdmin.setFont(fontText1);
		txtMotDePasseAdmin = new Text("Mot de passe:");
		txtMotDePasseAdmin.setFill(Color.ANTIQUEWHITE);
		txtMotDePasseAdmin.setFont(fontText1);

		btnConnecterAdherent.setFont(fontText1);
		btnConnecterEmploye.setFont(fontText1);
		btnConnecterAdmin.setFont(fontText1);
		btnConsulterCatalogue.setFont(fontText1);

		// btnConnecterAdherent.setPrefWidth(50);

		fontRb = Font.font("Arial", FontWeight.BOLD, 10);
		fontText2 = Font.font("Arial", FontWeight.BOLD, 15);
		ToggleGroup tgroup = new ToggleGroup();
		txtChoixconnexion = new Text("S'identifier avec:");
		txtNomEtPrenom = new Text("Nom et prénom");
		txtTelephone = new Text("Téléphone");
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

		// hboxChoix.getChildren().addAll(txtChoixconnexion,rbPrenomEtNom,txtNomEtPrenom,rbTelephone,txtTelephone);
		// hboxPrenom.getChildren().addAll(txtPrenom,txtFPrenom);

		tabPaneConnexion = new TabPane();

		// Premier onglet (Adherent)
		tabConnexionAdherent = new Tab();
		tabConnexionAdherent.setClosable(false);
		tabConnexionAdherent.setText("Adhérent");
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
		tabConnexionEmploye.setText("Employé");
		tabConnexionEmploye.setGraphic(new ImageView(new Image("Employe.jpg")));
		tabConnexionEmploye.setContent(gPaneEmploye);
		gPaneEmploye.setVgap(10);
		gPaneEmploye.setHgap(2);
		gPaneEmploye.setPadding(new Insets(40));
		gPaneEmploye.setAlignment(Pos.CENTER);
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
		gPaneAdmin.setPadding(new Insets(40));
		gPaneAdmin.setAlignment(Pos.CENTER);

		gPaneAdmin.add(txtNoAdmin, 0, 0);
		gPaneAdmin.add(txtFNoAdmin, 1, 0);
		gPaneAdmin.add(txtMotDePasseAdmin, 0, 1);
		gPaneAdmin.add(txtFMotDePasseAdmin, 1, 1);
		gPaneAdmin.add(btnConnecterAdmin, 1, 2, 2, 1);

		gConexxcion1 = new GestionAdherentConnexion1();
		gConexxcion2 = new GestionAdherentConnexion2();
		rbPrenomEtNom.setOnAction(gConexxcion1);
		rbTelephone.setOnAction(gConexxcion1);

		// Ajout des onglets de connexion
		tabPaneConnexion.getTabs().addAll(tabConnexionAdherent, tabConnexionEmploye, tabConnexionAdmin);

	}

	public void gestionTableViewCatalogue() {
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
		TableColumn<Livre, LocalDate> colonneDatePubLivre = new TableColumn<Livre, LocalDate>("Date de publication");
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
		tableLivre.getColumns().addAll(colonneNumDocLivre, colonneTitreLivre, colonneDatePubLivre, colonneDispoLivre,
				colonneAuteurLivre);
		tableDVD.getColumns().addAll(colonneNumDocDVD, colonneTitreDVD, colonneDatePubDVD, colonneDispoDVD,
				colonneNbDisquesDVD, colonneRealisateurDVD);
		tablePeriodique.getColumns().addAll(colonneNumDocPeriodique, colonneTitrePeriodique, colonneDatePubPeriodique,
				colonneDispoPeriodique, colonneNoVolumePeriodique, colonneNoPeriodiquePeriodique);
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
				gPaneAdherent.add(txtFTelephone, 2, 3, 2, 1);
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
				gpaneConnexionADroite.add(txtFTelephoneDroite, 1, 3, 2, 1);
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

			// System.out.println("l'objet catalogue vient d'ï¿½tre seralizer");

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

	private class ValidationEmploye implements EventHandler<MouseEvent> {

		public void handle(MouseEvent event) {
			// TODO Auto-generated method stub
			if (txtFNoPrepose.getText().compareTo("") == 0) {
				Alert Erreur = new Alert(AlertType.ERROR);
				Erreur.setTitle("Erreur");
				Erreur.setHeaderText(null);
				Erreur.setContentText("Vous n'avez pas tapé votre numéro d'employé");
				Erreur.showAndWait();
				txtFNoPrepose.requestFocus();
			} else if (txtFMotDePassePrepose.getText().compareTo("") == 0) {
				Alert Erreur = new Alert(AlertType.ERROR);
				Erreur.setTitle("Erreur");
				Erreur.setHeaderText(null);
				Erreur.setContentText("Vous n'avez pas tapé votre mot de passe");
				Erreur.showAndWait();
				txtFMotDePassePrepose.requestFocus();
			} else

			{
				boolean booValide = false;

				try {

					// dï¿½sï¿½rialisation des prï¿½posï¿½s
					// File fichierPreposes= new
					// File("C:/Users/rn.merzius/Downloads/test/fichierPreposes.ser");
					// File fichierPreposes = new
					// File("C:/Users/GabrielMarrero/Downloads/test/fichierPreposes.ser");
					File fichierPreposes = new File("C:/Users/cg.marrero/Downloads/test/fichierPreposes.ser");
					// File fichierPreposes= new
					// File("/Users/r.merzius/Desktop/fichierPreposes.ser");
					FileInputStream fichier1 = new FileInputStream(fichierPreposes);

					ObjectInputStream entree1 = new ObjectInputStream(fichier1);

					ArrayList<Prepose> lstPreposes = (ArrayList) entree1.readObject();
					fichier1.close();
					entree1.close();
					for (int i = 0; i < lstPreposes.size(); i++) {
						if (lstPreposes.get(i).getNoEmploye().equals(txtFNoPrepose.getText())
								&& lstPreposes.get(i).getMotDePasse().equals(txtFMotDePassePrepose.getText())) {
							booValide = true;
							Alert Validation = new Alert(AlertType.INFORMATION);
							Validation.setTitle("Confirmation");
							Validation.setHeaderText(null);
							Validation.setContentText("Valide !");
							Validation.showAndWait();

						}

					}
					if (booValide == false) {
						Alert Validation = new Alert(AlertType.INFORMATION);
						Validation.setTitle("Confirmation");
						Validation.setHeaderText(null);
						Validation.setContentText("Nom d'utilisateur ou Mot de passe invalide");
						Validation.showAndWait();
					}

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			}

		}

	}

	private class ValidationAdmin implements EventHandler<MouseEvent> {

		@Override
		public void handle(MouseEvent event) {
			// TODO Auto-generated method stub
			if (txtFNoAdmin.getText().compareTo("") == 0) {
				Alert Erreur = new Alert(AlertType.ERROR);
				Erreur.setTitle("Erreur");
				Erreur.setHeaderText(null);
				Erreur.setContentText("Vous n'avez pas tapé votre numéro d'administrateur");
				Erreur.showAndWait();
				txtFNoAdmin.requestFocus();
			} else if (txtFMotDePasseAdmin.getText().compareTo("") == 0) {
				Alert Erreur = new Alert(AlertType.ERROR);
				Erreur.setTitle("Erreur");
				Erreur.setHeaderText(null);
				Erreur.setContentText("Vous n'avez pas tapé votre mot de passe");
				Erreur.showAndWait();
				txtFMotDePasseAdmin.requestFocus();
			}

		}
	}

	private class ValidationAdherent implements EventHandler<MouseEvent> {

		@Override
		public void handle(MouseEvent event) {
			// TODO Auto-generated method stub
			if (rbPrenomEtNom.isSelected() && txtFNom.getText().compareTo("") == 0) {
				Alert Erreur = new Alert(AlertType.ERROR);
				Erreur.setTitle("Erreur");
				Erreur.setHeaderText(null);
				Erreur.setContentText("Vous n'avez pas tapé votre Nom");
				Erreur.showAndWait();
				txtFNom.requestFocus();
			} else if (rbPrenomEtNom.isSelected() && txtFPrenom.getText().compareTo("") == 0) {
				Alert Erreur = new Alert(AlertType.ERROR);
				Erreur.setTitle("Erreur");
				Erreur.setHeaderText(null);
				Erreur.setContentText("Vous n'avez pas tapé votre prénom");
				Erreur.showAndWait();
				txtFPrenom.requestFocus();
			} else if (rbTelephone.isSelected() && txtFTelephone.getText().compareTo("") == 0) {
				Alert Erreur = new Alert(AlertType.ERROR);
				Erreur.setTitle("Erreur");
				Erreur.setHeaderText(null);
				Erreur.setContentText("Vous n'avez pas tapé votre téléphone");
				Erreur.showAndWait();
				txtFTelephone.requestFocus();

			} else if (!txtFTelephone.getText().matches("^[\\(][0-9]{3}[\\)][\\s][0-9]{3}[\\-][0-9]{4}$")) {
				Alert Erreur = new Alert(AlertType.ERROR);
				Erreur.setTitle("Erreur");
				Erreur.setHeaderText(null);
				Erreur.setContentText("Voici le format que vous devez mettre : (###) ###-####");
				Erreur.showAndWait();
				txtFTelephone.requestFocus();
			} else {
				Alert Valide = new Alert(AlertType.CONFIRMATION);
				Valide.setTitle("Confirmation");
				Valide.setHeaderText(null);
				Valide.setContentText("Confirmation");
				Valide.showAndWait();
				InterfaceAdherent i = new InterfaceAdherent();
				i.start(new Stage());

			}
		}

	}

	public static void main(String[] args) {
		launch(args);
	}

}
