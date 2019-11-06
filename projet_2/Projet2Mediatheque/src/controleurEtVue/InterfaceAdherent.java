package controleurEtVue;

import java.time.LocalDate;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import modele.DVD;
import modele.Document;
import modele.Livre;
import modele.Periodique;
import modele.Pret;

public class InterfaceAdherent extends Application{

	
	private TableView<Document> tableDocumentsDelAdherent = new TableView<Document>();
	private TableView<Pret> tablePret = new TableView<Pret>();

/*	private ObservableList<Document> donneesCataloguePrepose;
	private ObservableList<Livre> donneesLivrePrepose;
	private ObservableList<DVD> donneesDVDPrepose;
	private ObservableList<Periodique> donneesPeriodiquePrepose;*/



	@Override
	public void start(Stage primaryStage)  {
		// TODO Auto-generated method stub
		
		
		BorderPane root = new BorderPane();
		BorderPane bPaneDroitePrepose = new BorderPane();
		BorderPane bPaneGauchePrepose = new BorderPane();
		VBox vboxTableView = new VBox(10);
		bPaneDroitePrepose.setPadding(new Insets(5));
		 Scene sceneAdherent = new Scene(root);
		 
		 Button btnQuitter = new Button("Quitter");
		btnQuitter.setPrefWidth(150);
		
		 //Ajout des colonnes pour les documents emprunté des préposé
			TableColumn<Document, String> colonneNumDocAdherent = new TableColumn<Document, String>("Numéro Document");
			TableColumn<Document, String> colonneTitreAdherent= new TableColumn<Document, String>("Titre");
			TableColumn<Document, String> colonneAuteurAdherent = new TableColumn<Document, String>("Auteur/Réalisateur");
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
	
		primaryStage.getIcons().add(new Image("booklibrary.png"));
		primaryStage.setTitle("Médiathèque");
		primaryStage.sizeToScene();
		primaryStage.setResizable(false);
		primaryStage.setScene(sceneAdherent);
		primaryStage.show();
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
