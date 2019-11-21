package controleurEtVue;

import java.time.LocalDate;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import modele.Catalogue;
import modele.DVD;
import modele.Document;
import modele.DocumentEmprunter;
import modele.ListeAdherents;
import modele.ListeDocumentsEmpruntes;
import modele.Livre;
import modele.Periodique;
import modele.Pret;

public class InterfaceAdherent extends Application{

	
	private TableView<Document> tableDocumentsDelAdherent = new TableView<Document>();
	private TableView<Pret> tablePret = new TableView<Pret>();
    private static Stage PrimaryStage;
/*	private ObservableList<Document> donneesCataloguePrepose;
	private ObservableList<Livre> donneesLivrePrepose;
	private ObservableList<DVD> donneesDVDPrepose;
	private ObservableList<Periodique> donneesPeriodiquePrepose;*/

    private ObservableList<Document> donneesDocument;
    private ObservableList<Pret> donneesPrets;
    private Catalogue catalogue =  Catalogue.getInstance("Livres.txt", "Periodiques.txt", "DVD.txt");
	private ListeAdherents liste = ListeAdherents.getInstance();
	Mediatheque mediatheque;
	
	private ArrayList<DocumentEmprunter> lstDocumentEmprunter = new ArrayList<DocumentEmprunter>();
	private DocumentEmprunter docEmprunter;
	
	public InterfaceAdherent(Mediatheque mediatheque){
		this.mediatheque = mediatheque;
	}

	@Override
	public void start(Stage primaryStage)  {
		// TODO Auto-generated method stub
		
		
		BorderPane root = new BorderPane();
		BorderPane bPaneDroitePrepose = new BorderPane();
		BorderPane bPaneGauchePrepose = new BorderPane();
		VBox vboxTableView = new VBox(10);
		bPaneDroitePrepose.setPadding(new Insets(5));
		 Scene sceneAdherent = new Scene(root);
		 BouttonQuitter ClickBtnQuitter=new BouttonQuitter();
		 Button btnQuitter = new Button("Quitter");
		 btnQuitter.setOnMouseClicked(ClickBtnQuitter);
		btnQuitter.setPrefWidth(150);
		
		//ListeDocumentsEmpruntes listeDocumentEmprunter = ListeDocumentsEmpruntes.getInstance();
		
		//donneesDocument = FXCollections.observableArrayList(listeDocumentEmprunter.getLstDocumentsEmpruntes());
		
		//Voir comment je peux parcourir les adh�ent pour reperer celui qui ses connecter(si les adherent dans la liste est eal a celui qui s'est connecter)
		Boolean booTrouver = false;
		
		for(int i = 0; i < liste.getLstAdherents().size()&& !booTrouver;i++) {
			//System.out.println(liste.getLstAdherents().get(i));
			
			if(liste.getLstAdherents().get(i).getStrNom().equals(mediatheque.getTxtFNom().getText()) && liste.getLstAdherents().get(i).getStrPrenom().equals(mediatheque.getTxtFPrenom().getText())||liste.getLstAdherents().get(i).getStrNom().equals(mediatheque.getTxtFNomDroite().getText()) && liste.getLstAdherents().get(i).getStrPrenom().equals(mediatheque.getTxtFPrenomDroite().getText())) {
			booTrouver= true;	
			System.out.println("trouver!");
			//voir comment ajouter ca dans une liste et le mettre dans le observablelist pour le mettre dans les donnees 
			//docEmprunter = new DocumentEmprunter(noDoc, titre, auteur, dateParution)
			
			}
					
		}
	
		
		//System.out.println(mediatheque.getTxtFNom().getText());
		 //Ajout des colonnes pour les documents emprunt� des pr�pos�
			TableColumn<Document, String> colonneNumDocAdherent = new TableColumn<Document, String>("Num�ro Document");
			TableColumn<Document, String> colonneTitreAdherent= new TableColumn<Document, String>("Titre");
			TableColumn<Document, String> colonneAuteurAdherent = new TableColumn<Document, String>("Auteur/R�alisateur");
			TableColumn<Document, LocalDate> colonneDatePubAdherent = new TableColumn<Document, LocalDate>(
					"Date de publication");
			
			colonneNumDocAdherent.setPrefWidth(200);
			colonneTitreAdherent.setPrefWidth(300);
			colonneAuteurAdherent.setPrefWidth(200);
			colonneDatePubAdherent.setPrefWidth(200);

			colonneNumDocAdherent.setMaxWidth(Double.MAX_VALUE);
			colonneTitreAdherent.setMaxWidth(Double.MAX_VALUE);
			colonneAuteurAdherent.setMaxWidth(Double.MAX_VALUE);
			colonneDatePubAdherent.setMaxWidth(Double.MAX_VALUE);

			colonneNumDocAdherent.setCellValueFactory(new PropertyValueFactory<>("noDoc"));
			colonneTitreAdherent.setCellValueFactory(new PropertyValueFactory<>("titre"));
			colonneAuteurAdherent.setCellValueFactory(new PropertyValueFactory<>("dateParution"));
			colonneDatePubAdherent.setCellValueFactory(new PropertyValueFactory<>("disponible"));
			
			//Ajout des colonnes pour l'information du pr�t
			TableColumn<Pret, Integer> colonneNumPretAdherent = new TableColumn<Pret, Integer>("Num�ro de pr�t");
			TableColumn<Pret, LocalDate> colonneDatePretAdherent= new TableColumn<Pret, LocalDate>("Date du pr�t");
			TableColumn<Pret, LocalDate> colonneDatePrevuRetourAdherent = new TableColumn<Pret, LocalDate>("Date de retour pr�vu");
			TableColumn<Pret, LocalDate> colonneDateRetourEffectueAdherent = new TableColumn<Pret, LocalDate>("Date du retour");
			TableColumn<Pret, Double> colonneAmendeAdherent = new TableColumn<Pret, Double>("Amende");
			
			colonneNumPretAdherent.setPrefWidth(200);
			colonneDatePretAdherent.setPrefWidth(150);
			colonneDatePrevuRetourAdherent.setPrefWidth(200);
			colonneDateRetourEffectueAdherent.setPrefWidth(200);
			colonneAmendeAdherent.setPrefWidth(150);

			colonneNumPretAdherent.setMaxWidth(Double.MAX_VALUE);
			colonneDatePretAdherent.setMaxWidth(Double.MAX_VALUE);
			colonneDatePrevuRetourAdherent.setMaxWidth(Double.MAX_VALUE);
			colonneDateRetourEffectueAdherent.setMaxWidth(Double.MAX_VALUE);
			colonneAmendeAdherent.setMaxWidth(Double.MAX_VALUE);
			
			colonneNumPretAdherent.setCellValueFactory(new PropertyValueFactory<>("noEmprunt"));
			colonneDatePretAdherent.setCellValueFactory(new PropertyValueFactory<>("dateEmprunt"));
			colonneDatePrevuRetourAdherent.setCellValueFactory(new PropertyValueFactory<>("dateRetourPrevu"));
			colonneDateRetourEffectueAdherent.setCellValueFactory(new PropertyValueFactory<>("dateRetourEffectue"));
			colonneAmendeAdherent.setCellValueFactory(new PropertyValueFactory<>("amende"));
			
			
			//Ajout des colonnes dans les tables
			
			tableDocumentsDelAdherent.setItems(donneesDocument);
			tableDocumentsDelAdherent.getColumns().addAll(colonneNumDocAdherent,colonneTitreAdherent,colonneAuteurAdherent,colonneDatePubAdherent);
			tablePret.getColumns().addAll(colonneNumPretAdherent,colonneDatePretAdherent,colonneDatePrevuRetourAdherent,colonneDateRetourEffectueAdherent,colonneAmendeAdherent);
			
			
		//Affichage
			//bPaneDroitePrepose.setTop(btnQuitter);
		tableDocumentsDelAdherent.setPrefHeight(70);
		vboxTableView.getChildren().addAll(tableDocumentsDelAdherent,tablePret);
		//bPaneGauchePrepose.setTop(tableDocumentsDelAdherent);
		bPaneGauchePrepose.setCenter(vboxTableView);
		bPaneDroitePrepose.setTop(btnQuitter);
		root.setLeft(bPaneGauchePrepose);
		root.setRight(bPaneDroitePrepose);
	    PrimaryStage=primaryStage;
		primaryStage.getIcons().add(new Image("booklibrary.png"));
		primaryStage.setTitle("M�diath�que");
		primaryStage.sizeToScene();
		primaryStage.setResizable(false);
		primaryStage.setScene(sceneAdherent);
		primaryStage.show();
		
		
	}
	public class BouttonQuitter implements EventHandler<MouseEvent> {

		@Override
		public void handle(MouseEvent arg0) {
			// TODO Auto-generated method stub
			Mediatheque.AfficherMediatheque();
			PrimaryStage.close();
			
		}}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
