package controleurEtVue;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;

import controleurEtVue.Mediatheque.ValidationAdherentDroite;
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
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
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
import javafx.stage.Stage;
import modele.Catalogue;
import modele.DVD;
import modele.Document;
import modele.Livre;
import modele.Periodique;

public class InterfacePrepose extends Application{
	
	private TableView<Document> tableCatalogue = new TableView<Document>();
	private TableView<Livre> tableLivre = new TableView<Livre>();
	private TableView<DVD> tableDVD = new TableView<DVD>();
	private TableView<Periodique> tablePeriodique = new TableView<Periodique>();

	private ObservableList<Document> donneesCatalogue;
	private ObservableList<Livre> donneesLivre;
	private ObservableList<DVD> donneesDVD;
	private ObservableList<Periodique> donneesPeriodique;
	
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
	
	private String fichierSerial = "";
	private String FichierDeserial = "";


	private BorderPane root ;
	private Scene scene ;
	private TabPane tabPane ;
	
	
	private BorderPane bPaneDroite;
	
	private VBox vboxPartieADroite ;
	private Accordion accordion ;
	private VBox vboxCatalogue ;
	private VBox vBoxAhderents ;
	private VBox vboxPrets;
	
	private Button btnAjouterDocumentCatalogue ;
	private Button btnSupprimerDocumentCatalogue ;
	
	
	private Button btnajouterAherent ;
	private Button btnModifierAdherent ;
	private Button btnSupprimerAdherent ;
	private Button btnPayerSoldeAdhernent ;
	
	private Button btnInscrireUnPret ;
	private Button btnIscrireUnRetour;
	
	private HBox hboxButtonDeconnexion;
	
	private Button btnDeconnexion ;

	@Override
	public void start(Stage primaryStage) {
		// TODO Auto-generated method stub
		
		try {
			/********************************************* FICHIERS SERIALIZABLES********************************************************/

			// fichierSerial ="C:/Users/rn.merzius/Downloads/test/fichier.ser";
			// fichierSerial = "C:/Users/GabrielMarrero/Downloads/test/fichier.ser";
			fichierSerial = "C:/Users/cg.marrero/Downloads/test/fichier.ser";
			// fichierSerial= "/Users/r.merzius/Desktop/fichier.ser";
			// FichierDeserial="/Users/r.merzius/Desktop/fichier.ser";
			// FichierDeserial = "C:/Users/rn.merzius/Downloads/test/fichier.ser";
			 //FichierDeserial = "C:/Users/GabrielMarrero/Downloads/test/fichier.ser";
			FichierDeserial = "C:/Users/cg.marrero/Downloads/test/fichier.ser";
			
			 root = new BorderPane();
			 scene = new Scene(root);
			 tabPane = new TabPane();
			 bPaneDroite = new BorderPane();
			
			/******************************************** CATALOGUE PR�POS�*************************************************/
			
			/******************************************** DANS CHAQUE ONGLET DU CATALOGUE **********************************/
			
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
			TableColumn<Livre, String> colonneNumDocLivre = new TableColumn<Livre, String>("Num�ro Document");
			TableColumn<Livre, String> colonneTitreLivre = new TableColumn<Livre, String>("Titre");
			TableColumn<Livre, LocalDate> colonneDatePubLivre = new TableColumn<Livre, LocalDate>("Date de publication");
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

			TableColumn<DVD, String> colonneNumDocDVD = new TableColumn<DVD, String>("Num�ro Document");
			TableColumn<DVD, String> colonneTitreDVD = new TableColumn<DVD, String>("Titre");
			TableColumn<DVD, LocalDate> colonneDatePubDVD = new TableColumn<DVD, LocalDate>("Date de publication");
			TableColumn<DVD, String> colonneDispoDVD = new TableColumn<DVD, String>("Disponible");
			TableColumn<DVD, Integer> colonneNbDisquesDVD = new TableColumn<DVD, Integer>("Nombres de disques");
			TableColumn<DVD, String> colonneRealisateurDVD = new TableColumn<DVD, String>("R�alisateur");

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
			tableLivre.getColumns().addAll(colonneNumDocLivre, colonneTitreLivre, colonneDatePubLivre, colonneDispoLivre,
					colonneAuteurLivre);
			tableDVD.getColumns().addAll(colonneNumDocDVD, colonneTitreDVD, colonneDatePubDVD, colonneDispoDVD,
					colonneNbDisquesDVD, colonneRealisateurDVD);
			tablePeriodique.getColumns().addAll(colonneNumDocPeriodique, colonneTitrePeriodique, colonneDatePubPeriodique,
					colonneDispoPeriodique, colonneNoVolumePeriodique, colonneNoPeriodiquePeriodique);
			
			
			/***************************** PARTIE D'EN BAS DU CATALOGUE***********************/
			hboxEnBas = new HBox(10);
			hboxEnBas.setPadding(new Insets(10));
			tGroupEnHaut = new ToggleGroup();
			txtRechercherPar = new Text("Rechercher par: ");
			rbAuteurRealisateur = new RadioButton("auteur/r�alisateur");
			rbMotsCles = new RadioButton("Mos cl�s");
			txtFRechercherPar = new TextField();
			btnEffacer = new Button("Effacer");
			btnEffacer.setPrefWidth(170);
			rbAuteurRealisateur.setToggleGroup(tGroupEnHaut);
			rbMotsCles.setToggleGroup(tGroupEnHaut);
			rbAuteurRealisateur.setSelected(true);

			hboxEnBas.getChildren().addAll(txtRechercherPar, rbAuteurRealisateur, rbMotsCles, txtFRechercherPar,
					btnEffacer);
			root.setBottom(hboxEnBas);
			
			/********************************************* DANS LE CATALOGUE(GERE TOUT CE QUI EST DANS L'INTERFACE DEU CATALOGUE DU PR�POS�)********************************************************/
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
			tabPeriodique.setText("P�riodiques");
			tabPeriodique.setGraphic(new ImageView(new Image("icon-periodique.png")));
			
			tabCatalogue.setContent(tableCatalogue);
			tabLivres.setContent(tableLivre);
			tabDVD.setContent(tableDVD);
			tabPeriodique.setContent(tablePeriodique);
			
			
			
		
			/****************************************DANS LE CATALOGUE PARTIE � DROITE(GESTION DES ADHERENT, CATALOGUE ET PRETS)  ******************************************************/
			
			//bPaneDroite.setPadding(new Insets(10));
			
			 vboxPartieADroite = new VBox(5);
			 accordion = new Accordion();
			 vboxCatalogue = new VBox(15);
			 vBoxAhderents = new VBox(15);
			 vboxPrets = new VBox(15);
			
			 btnAjouterDocumentCatalogue = new Button("Ajouter un document");
			 btnSupprimerDocumentCatalogue = new Button("Supprimer un document");
			
			
			 btnajouterAherent = new Button("Ajouter un adh�rent");
			 btnModifierAdherent = new Button("Modifier un adh�rent");
			 btnSupprimerAdherent = new Button("Supprimer un adh�rent");
			 btnPayerSoldeAdhernent = new Button("Payer solde adh�rent");
			
			 btnInscrireUnPret = new Button("Inscrire un pr�t");
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
			
			vboxCatalogue.getChildren().addAll(btnAjouterDocumentCatalogue,btnSupprimerDocumentCatalogue);
			vBoxAhderents.getChildren().addAll(btnajouterAherent,btnModifierAdherent,btnSupprimerAdherent,btnPayerSoldeAdhernent);
			vboxPrets.getChildren().addAll(btnInscrireUnPret,btnIscrireUnRetour);
			
			vboxCatalogue.setAlignment(Pos.CENTER);
			vBoxAhderents.setAlignment(Pos.CENTER);
			vboxPrets.setAlignment(Pos.CENTER);
			

	        TitledPane paneGestionCatalogue = new TitledPane("Gestion du catalogue" , new Label("Show all boats available"));
	        TitledPane paneGestionAdherents = new TitledPane("Gestion des adh�rents"  , new Label("Show all cars available"));
	        TitledPane paneGestionPrets = new TitledPane("Gestion des pr�ts", new Label("Show all planes available"));

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
	       
			
	        vboxPartieADroite.getChildren().addAll(bPaneDroite,hboxButtonDeconnexion);
			root.setRight(vboxPartieADroite);
			
			/********************************************* GESTION DES EVENEMENT DES BUTTON *******************************/
			
			GestionnaireButtonPrepose gestionnaireButton = new GestionnaireButtonPrepose();
			btnAjouterDocumentCatalogue.setOnMouseClicked(gestionnaireButton);
			
			/********************************************* AFFICHAGE********************************************************/
			
			tabPane.getTabs().addAll(tabCatalogue, tabLivres, tabDVD, tabPeriodique);
			root.setCenter(tabPane);
			
			primaryStage.getIcons().add(new Image("booklibrary.png"));
			primaryStage.setTitle("M�diath�que(Pr�pos�)");
			primaryStage.sizeToScene();
			primaryStage.setResizable(false);
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch(Exception e ) {
			e.printStackTrace();
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
	private class GestionnaireButtonPrepose implements EventHandler<MouseEvent> {

		@Override
		public void handle(MouseEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource() == btnAjouterDocumentCatalogue) {
				
				
				 Stage stageAjout = new Stage();
				 GridPane gPaneAjoutDoc = new GridPane();
					
				 Scene sceneAjout = new Scene(gPaneAjoutDoc,380,250);
				 //Scene sceneAjout = new Scene(gPaneAjoutDoc);
				 
				 ToggleGroup tRadioAjout = new ToggleGroup();
				 RadioButton rbLivre = new RadioButton("Livre");
				 RadioButton rbPeriodique = new RadioButton("P�riodique");
				 RadioButton rbDvd = new RadioButton("Dvd");
				 HBox hboxRadioButton = new HBox(5);
				 hboxRadioButton.getChildren().addAll(rbLivre,rbDvd,rbPeriodique);
				 
				 rbLivre.setToggleGroup(tRadioAjout);
				 rbPeriodique.setToggleGroup(tRadioAjout);
				 rbDvd.setToggleGroup(tRadioAjout);
				 rbLivre.setSelected(true);
				 
				 
				 
				 //pour les livres
				 Text txtTypeDoc = new Text("Type de document :");
				 Text txtTitre = new Text("Titre :");
				 Text txtAuteur = new Text("Auteur :");
				 Text txtDateParution = new Text("Date de parution :");
				 Text txtMotsCledEspaces = new Text("Mots cl�s (s�par�s par espaces):");
				 
				 //pour les dvd
				 Text txtNbDisques = new Text("Nombre de disques :");
				 Text txtRealisateur = new Text("R�alisateur :");
				 
				 TextField txtFNbDisques = new TextField();
				 TextField txtFRealisateur = new TextField();
				 
				 //pour les p�riodiques
				 Text txtNoVolume = new Text("Num�ro de volume :");
				 Text txtNoPeriodique = new Text("Num�ro de p�riodique :");
				 
				 TextField txtFNoVolume = new TextField();
				 TextField txtFNoPeriodique = new TextField();
				 
				 
				 
				 
				 
				 TextField txtFtitre = new TextField();
				 TextField txtFAuteur = new TextField();
				 TextField txtFDateParution= new TextField();
				 TextField txtFMotsClesEspaces = new TextField();
				 
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
				 
				 txtFtitre.requestFocus();
				 
				 
				 /******************************GEstion radio button dans ajouter document *************************/
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
						
						
						
						 
						gPaneAjoutDoc.add(txtAuteur, 0, 3);
						gPaneAjoutDoc.add(txtFAuteur, 1, 3);
						
						 gPaneAjoutDoc.add(txtDateParution, 0, 4);
						 gPaneAjoutDoc.add(txtFDateParution, 1, 4);
						 gPaneAjoutDoc.add(txtMotsCledEspaces, 0, 5);
						 gPaneAjoutDoc.add(txtFMotsClesEspaces, 1, 5);
						
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
							
							
							gPaneAjoutDoc.add(txtNbDisques, 0, 3);
							gPaneAjoutDoc.add(txtFNbDisques, 1, 3);
							
							gPaneAjoutDoc.add(txtRealisateur, 0, 4);
							gPaneAjoutDoc.add(txtFRealisateur, 1, 4);
							
							gPaneAjoutDoc.add(txtDateParution, 0, 5);
							gPaneAjoutDoc.add(txtFDateParution, 1, 5);
							
							gPaneAjoutDoc.add(txtMotsCledEspaces, 0, 6);
							gPaneAjoutDoc.add(txtFMotsClesEspaces, 1, 6);
							
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
							
							
							gPaneAjoutDoc.add(txtNoVolume, 0, 3);
							gPaneAjoutDoc.add(txtFNoVolume, 1, 3);
							
							gPaneAjoutDoc.add(txtNoPeriodique, 0, 4);
							gPaneAjoutDoc.add(txtFNoPeriodique, 1, 4);
							
							gPaneAjoutDoc.add(txtDateParution, 0, 5);
							gPaneAjoutDoc.add(txtFDateParution, 1, 5);
							
							gPaneAjoutDoc.add(txtMotsCledEspaces, 0, 6);
							gPaneAjoutDoc.add(txtFMotsClesEspaces, 1, 6);
							
							txtFtitre.requestFocus();
						}
					});
				 
				 
				 
				stageAjout.setTitle("Ajout d'un document");
				stageAjout.getIcons().add(new Image("iconAjouterDocument.png"));
				stageAjout.sizeToScene();
				stageAjout.setScene(sceneAjout);
				stageAjout.show();
				
				
				
				
				
			}
			else if(e.getSource() == btnSupprimerDocumentCatalogue) {
				//v�rifier si il a selectionner un doc sur le catalogue, si non mettre un mesage d'erreur
			}
			
		}
		
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}


}
