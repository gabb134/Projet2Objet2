import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.Callback;

public class Mediatheque extends Application {
	private final TableView<Catalogue> table = new TableView<Catalogue>();
	private ObservableList<Document> donnees = null;

	@Override
	public void start(Stage primaryStage) {
		// TODO Auto-generated method stub

		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root);
			TabPane tabPane = new TabPane();

			// premier onglet (Catalogue)
			Tab tabCatalogue = new Tab();
			tabCatalogue.setClosable(false);
			tabCatalogue.setText("Catalogue");
			tabCatalogue.setGraphic(new ImageView(new Image("icon-collection.png")));

			// deuxieme onglet (Livres)
			Tab tabLivres = new Tab();
			tabLivres.setClosable(false);
			tabLivres.setText("Livres");
			tabLivres.setGraphic(new ImageView(new Image("icon-livre.png")));

			// troisieme onglet (DVD)
			Tab tabDVD = new Tab();
			tabDVD.setClosable(false);
			tabDVD.setText("DVD");
			tabDVD.setGraphic(new ImageView(new Image("icon-dvd.png")));

			// Quatrieme onglet (Periodique)
			Tab tabPeriodique = new Tab();
			tabPeriodique.setClosable(false);
			tabPeriodique.setText("Périodiques");
			tabPeriodique.setGraphic(new ImageView(new Image("icon-periodique.png")));

			// Dans l'oglet Catalogue

			// Node qui va avoir les tablesColumn
			Group grCatalogue = new Group();

			// Pour aller cherche l'objet catalogue serializer
			SerializationCatalogue();
			Catalogue catalogue = DeserialisationCatalogue();
			
			//donnees = FXCollections.observableArrayList(catalogue.afficherDocument()); // ***Demander au prof

			// Creation des colonnes dans l'onglet catalogue
			TableColumn<Catalogue, String> colonneNumDocCatalogue = new TableColumn<Catalogue, String>(
					"Numéro Document");
			TableColumn<Catalogue, String> colonneTitreCatalogue = new TableColumn<Catalogue, String>("Titre");
			TableColumn<Catalogue, LocalDate> colonneDatePubCatalogue = new TableColumn<Catalogue, LocalDate>(
					"Date de publication");
			TableColumn<Catalogue, String> colonneDispoCatalogue = new TableColumn<Catalogue, String>("Disponible");

			colonneNumDocCatalogue.setPrefWidth(120);
			colonneTitreCatalogue.setPrefWidth(120);
			colonneDatePubCatalogue.setPrefWidth(120);
			colonneDispoCatalogue.setPrefWidth(120);

			colonneNumDocCatalogue.setMaxWidth(Double.MAX_VALUE);
			colonneTitreCatalogue.setMaxWidth(Double.MAX_VALUE);
			colonneDatePubCatalogue.setMaxWidth(Double.MAX_VALUE);
			colonneDispoCatalogue.setMaxWidth(Double.MAX_VALUE);

			colonneNumDocCatalogue.setCellValueFactory(new PropertyValueFactory<>("Numéro Document"));
			colonneTitreCatalogue.setCellValueFactory(new PropertyValueFactory<>("Titre"));
			colonneDatePubCatalogue.setCellValueFactory(new PropertyValueFactory<>("Date de publication"));
			colonneDispoCatalogue.setCellValueFactory(new PropertyValueFactory<>("Disponible"));

			// Ajout des colonnes dans l'onglet
			//table.setItems(donnees);
			table.getColumns().addAll(colonneNumDocCatalogue, colonneTitreCatalogue, colonneDatePubCatalogue,
					colonneDispoCatalogue);

			root.setCenter(tabPane);
			tabPane.getTabs().addAll(tabCatalogue, tabLivres, tabDVD, tabPeriodique);
			grCatalogue.getChildren().add(table);
			tabCatalogue.setContent(grCatalogue);

			primaryStage.setTitle("Médiathèque");
			primaryStage.sizeToScene();
			primaryStage.setResizable(false);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void SerializationCatalogue() { // Methode qui permet d'aller chercher l'objet Catalogue pour le serializer
		Catalogue catalogueSerialisation = Catalogue.getInstance("Livres.txt", "Periodiques.txt", "DVD.txt");

		String fichierSerial = "";
		fichierSerial= "C:/Users/GabrielMarrero/Downloads/test/fichier.ser";
		//fichierSerial = "C:/Users/cg.marrero/Downloads/test/fichier.ser";
		try {
			FileOutputStream fichier = new FileOutputStream(fichierSerial);
			ObjectOutputStream sortie = new ObjectOutputStream(fichier);

			sortie.writeObject(catalogueSerialisation);

			sortie.close();
			fichier.close();

			// System.out.println("l'objet catalogue vient d'être seralizer");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public Catalogue DeserialisationCatalogue() {// Methode qui permet de deserializer l'objet Catalogue pour pouvoir
													// l'utiliser
		Catalogue catalogueDeserializer = null;

		try {
			
			String FichierDeserial ="";
			FichierDeserial = "C:/Users/GabrielMarrero/Downloads/test/fichier.ser";
			//FichierDeserial = "C:/Users/cg.marrero/Downloads/test/fichier.ser";
			FileInputStream fichier = new FileInputStream(FichierDeserial);

			ObjectInputStream entree = new ObjectInputStream(fichier);

			catalogueDeserializer = (Catalogue) entree.readObject();

			fichier.close();
			entree.close();

			// System.out.println("l'objet catalogue vient d'êetre deserlializer");
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
