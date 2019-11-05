package controleurEtVue;

import java.time.LocalDate;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import modele.DVD;
import modele.Document;
import modele.Livre;
import modele.Periodique;

public class InterfaceAdherent extends Application{

	
	private TableView<Document> tableDocumentsDelAdherent = new TableView<Document>();


/*	private ObservableList<Document> donneesCataloguePrepose;
	private ObservableList<Livre> donneesLivrePrepose;
	private ObservableList<DVD> donneesDVDPrepose;
	private ObservableList<Periodique> donneesPeriodiquePrepose;*/



	@Override
	public void start(Stage primaryStage)  {
		// TODO Auto-generated method stub
		
		
		BorderPane root = new BorderPane();
	
		
		 Scene sceneAdherent = new Scene(root, 960, 460);
		
		
		 //Ajout des colonnes pour les documents emprunté des préposé
			TableColumn<Document, String> colonneNumDocAdherent = new TableColumn<Document, String>("Numéro Document");
			TableColumn<Document, String> colonneTitreAdherent= new TableColumn<Document, String>("Titre");
			TableColumn<Document, String> colonneAuteurAdherent = new TableColumn<Document, String>("Auteur/Réalisateur");
			TableColumn<Document, LocalDate> colonneDatePubAdherent = new TableColumn<Document, LocalDate>(
					"Date de publication");
			
			colonneNumDocAdherent.setPrefWidth(200);
			colonneTitreAdherent.setPrefWidth(200);
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
			
			
			
			
			
			//Ajout des colonnes dans les tables
			tableDocumentsDelAdherent.getColumns().addAll(colonneNumDocAdherent,colonneTitreAdherent,colonneAuteurAdherent,colonneDatePubAdherent);

			
		root.setTop(tableDocumentsDelAdherent);
	
	
		primaryStage.getIcons().add(new Image("booklibrary.png"));
		primaryStage.setTitle("Médiathèque");
		//primaryStage.sizeToScene();
		primaryStage.setResizable(false);
		primaryStage.setScene(sceneAdherent);
		primaryStage.show();
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
