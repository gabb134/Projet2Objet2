package controleurEtVue;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
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


	@Override
	public void start(Stage primaryStage) {
		// TODO Auto-generated method stub
		
		try {
			
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root);
			
			
			
			
			primaryStage.getIcons().add(new Image("booklibrary.png"));
			primaryStage.setTitle("Médiathèque");
			primaryStage.sizeToScene();
			primaryStage.setResizable(false);
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch(Exception e ) {
			e.printStackTrace();
		}
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}


}
