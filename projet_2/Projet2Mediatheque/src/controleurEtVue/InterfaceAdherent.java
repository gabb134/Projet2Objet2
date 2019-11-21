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

	
	private TableView<DocumentEmprunter> tableDocumentsDelAdherent = new TableView<DocumentEmprunter>();
	 private ObservableList<DocumentEmprunter> donneesDocument;
    private static Stage PrimaryStage;
   
	private TableView<Pret> tablePret = new TableView<Pret>();
    private ObservableList<Pret> donneesPrets;
  //  private Catalogue catalogue =  Catalogue.getInstance("Livres.txt", "Periodiques.txt", "DVD.txt");
	private ListeAdherents liste = ListeAdherents.getInstance();
	Mediatheque mediatheque;
	
	private ArrayList<DocumentEmprunter> lstDocumentEmprunter = new ArrayList<DocumentEmprunter>();
	private ArrayList<Pret> lstPrets = new ArrayList<Pret>();
	private DocumentEmprunter docEmprunter;
	private DocumentEmprunter dvdEmprunter;
	private DocumentEmprunter livreEmprunter;
	private DocumentEmprunter periodiqueEmprunter;
	private Pret pret;
	
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
		
		//
		
		//Voir comment je peux parcourir les adhéent pour reperer celui qui ses connecter(si les adherent dans la liste est eal a celui qui s'est connecter)
		Boolean booTrouver = false;
		
		for(int i = 0; i < liste.getLstAdherents().size()&& !booTrouver;i++) {
			//System.out.println(liste.getLstAdherents().get(i));
			
			if(liste.getLstAdherents().get(i).getStrNom().equals(mediatheque.getTxtFNom().getText()) && liste.getLstAdherents().get(i).getStrPrenom().equals(mediatheque.getTxtFPrenom().getText())||liste.getLstAdherents().get(i).getStrNom().equals(mediatheque.getTxtFNomDroite().getText()) && liste.getLstAdherents().get(i).getStrPrenom().equals(mediatheque.getTxtFPrenomDroite().getText())) {
			//booTrouver= true;	
				System.out.println("trouver!");
				//pret = new Pret(liste.getLstAdherents().get(i).get, dateEmprunt, dateRetourPrevu, dateRetourEffectue, amende) 
				
				
				for(int j = 0;j <  liste.getLstAdherents().get(i).getLstDvdAdherent().size();j++) {
					//docEmprunter = new DocumentEmprunter(liste.getLstAdherents().get(i).getLstDocAdherent().get(j).getNoDoc(), liste.getLstAdherents().get(i).getLstDocAdherent().get(j).getTitre(), "test", liste.getLstAdherents().get(i).getLstDocAdherent().get(j).getDateParution());
					
					dvdEmprunter = new DocumentEmprunter(liste.getLstAdherents().get(i).getLstDvdAdherent().get(j).getNoDoc(), liste.getLstAdherents().get(i).getLstDvdAdherent().get(j).getTitre(), liste.getLstAdherents().get(i).getLstDvdAdherent().get(j).getStrRealisateur(), liste.getLstAdherents().get(i).getLstDvdAdherent().get(j).getDateParution());
					
					//livreEmprunter = new DocumentEmprunter(liste.getLstAdherents().get(i).getLstLivreAdherent().get(j).getNoDoc(), liste.getLstAdherents().get(i).getLstLivreAdherent().get(j).getTitre(), liste.getLstAdherents().get(i).getLstLivreAdherent().get(j).getAuteur(), liste.getLstAdherents().get(i).getLstLivreAdherent().get(j).getDateParution());
					
					//

					
				/*	if(dvdEmprunter.getNoDoc().substring(0, 3).equals("DVD")) {
						System.out.println("DVD");
		
						lstDocumentEmprunter.add(dvdEmprunter);
						
						
					}
					else if(livreEmprunter.getNoDoc().substring(0, 3).equals("Livre")) {
						System.out.println("Livre");
						lstDocumentEmprunter.add(dvdEmprunter);
						
				
					}
					else if(periodiqueEmprunter.getNoDoc().substring(0, 3).equals("Per")) {
						System.out.println("Periodique");
						lstDocumentEmprunter.add(periodiqueEmprunter);
						
					}*/
					
					
					
					lstDocumentEmprunter.add(dvdEmprunter);
				}
				for(int j = 0;j <  liste.getLstAdherents().get(i).getLstLivreAdherent().size();j++) {
					livreEmprunter = new DocumentEmprunter(liste.getLstAdherents().get(i).getLstLivreAdherent().get(j).getNoDoc(), liste.getLstAdherents().get(i).getLstLivreAdherent().get(j).getTitre(), liste.getLstAdherents().get(i).getLstLivreAdherent().get(j).getAuteur(), liste.getLstAdherents().get(i).getLstLivreAdherent().get(j).getDateParution());
					
					lstDocumentEmprunter.add(livreEmprunter);
				}
				for(int j = 0;j <  liste.getLstAdherents().get(i).getLstPeriodiqueAdherent().size();j++) {
					periodiqueEmprunter = new DocumentEmprunter(liste.getLstAdherents().get(i).getLstPeriodiqueAdherent().get(j).getNoDoc(), liste.getLstAdherents().get(i).getLstPeriodiqueAdherent().get(j).getTitre(), "Inconnu", liste.getLstAdherents().get(i).getLstPeriodiqueAdherent().get(j).getDateParution());
					
					lstDocumentEmprunter.add(periodiqueEmprunter);
				}
								
			
			}
					
		}
		
		
		
		System.out.println("Documents empruntés par l'adhérent connecté");
		for(DocumentEmprunter doc: lstDocumentEmprunter) {
			System.out.println(doc);
		}
	
		donneesDocument = FXCollections.observableArrayList(lstDocumentEmprunter);
		//System.out.println(mediatheque.getTxtFNom().getText());
		 //Ajout des colonnes pour les documents emprunté des préposé
			TableColumn<DocumentEmprunter, String> colonneNumDocAdherent = new TableColumn<DocumentEmprunter, String>("Numéro Document");
			TableColumn<DocumentEmprunter, String> colonneTitreAdherent= new TableColumn<DocumentEmprunter, String>("Titre");
			TableColumn<DocumentEmprunter, String> colonneAuteurAdherent = new TableColumn<DocumentEmprunter, String>("Auteur/Réalisateur");
			TableColumn<DocumentEmprunter, LocalDate> colonneDatePubAdherent = new TableColumn<DocumentEmprunter, LocalDate>("Date de publication");
			
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
			colonneAuteurAdherent.setCellValueFactory(new PropertyValueFactory<>("auteur"));
			colonneDatePubAdherent.setCellValueFactory(new PropertyValueFactory<>("dateParution"));
			
			//Ajout des colonnes pour l'information du prêt
			TableColumn<Pret, Integer> colonneNumPretAdherent = new TableColumn<Pret, Integer>("Numéro de prêt");
			TableColumn<Pret, LocalDate> colonneDatePretAdherent= new TableColumn<Pret, LocalDate>("Date du prêt");
			TableColumn<Pret, LocalDate> colonneDatePrevuRetourAdherent = new TableColumn<Pret, LocalDate>("Date de retour prévu");
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
		primaryStage.setTitle("Médiathèque");
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
