package controleurEtVue;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import modele.DVD;
import modele.Document;
import modele.Livre;
import modele.Periodique;

public class InterfacePrepose extends Application{

	
	private TableView<Document> tableCataloguePrepose = new TableView<Document>();
	private TableView<Livre> tableLivrePrepose = new TableView<Livre>();
	private TableView<DVD> tableDVDPrepose = new TableView<DVD>();
	private TableView<Periodique> tablePeriodiquePrepose = new TableView<Periodique>();

	private ObservableList<Document> donneesCataloguePrepose;
	private ObservableList<Livre> donneesLivrePrepose;
	private ObservableList<DVD> donneesDVDPrepose;
	private ObservableList<Periodique> donneesPeriodiquePrepose;



	@Override
	public void start(Stage primaryStage)  {
		// TODO Auto-generated method stub
		
		
		BorderPane root = new BorderPane();
		Scene scenePrepose = new Scene(root) ;
		
		
		primaryStage.setTitle("Médiathèque");
		scenePrepose.getIcons().add(new Image("booklibrary.png"));
		scenePrepose = new Scene(root);
		scenePrepose = new Scene(root, 600, 300);
		primaryStage.setScene(sceneCatalogue);
		
		
		
		primaryStage.sizeToScene();
		primaryStage.setResizable(false);
		primaryStage.setScene(sceneConnexion);
		primaryStage.show();
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
