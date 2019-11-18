package controleurEtVue;

import controleurEtVue.InterfacePrepose.GestionnaireButtonPreposeAherent;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import modele.Adherent;
import modele.Administrateur;
import modele.ListePreposes;
import modele.Prepose;

public class InterfaceAdmin extends Application {
	
	private TableView<Prepose> tablePreposes = new TableView<Prepose>();
	private ListePreposes liste;
	private BorderPane root;
	private Scene scene;
	private Accordion accordion;
	private BorderPane bPaneDroite;
	private VBox vboxPartieADroite;
	private VBox vBoxPreposes;
	private Button btnajouterPrepose;
	private Button btnSupprimerPrepose;
	private HBox hboxButtonDeconnexion;
	private Button btnDeconnexion;
	private TitledPane paneGestionPreposes;
	private Administrateur admin=new Administrateur();
	private ObservableList<Prepose> donneesPreposes;
	@SuppressWarnings("unchecked")
	public void start(Stage primaryStage) {
		root = new BorderPane();
		scene = new Scene(root);
		bPaneDroite = new BorderPane();
		vboxPartieADroite = new VBox(5);
		accordion = new Accordion();
		vBoxPreposes = new VBox(15);
		btnajouterPrepose = new Button("Ajouter un pr�pos�");
		btnajouterPrepose.setPrefWidth(180);
		btnSupprimerPrepose = new Button("Supprimer un pr�pos�");
		btnSupprimerPrepose.setPrefWidth(180);
		hboxButtonDeconnexion = new HBox();
		btnDeconnexion = new Button("Deconnexion");
		hboxButtonDeconnexion.getChildren().add(btnDeconnexion);
		hboxButtonDeconnexion.setAlignment(Pos.CENTER);
		vBoxPreposes.getChildren().addAll(btnajouterPrepose,btnSupprimerPrepose);
		paneGestionPreposes = new TitledPane("Gestion des Pr�poses",
				new Label("Show all cars available"));
	liste = ListePreposes.getInstance();
	donneesPreposes = FXCollections.observableArrayList(liste.getLstPreposes());
	tablePreposes.setItems(donneesPreposes);
	
	TableColumn<Prepose, String> colonneNumeroPrepose = new TableColumn<Prepose, String>("Num�ro d'employ�");
	TableColumn<Prepose, String> colonneNomPrepose= new TableColumn<Prepose, String>("Nom");
	TableColumn<Prepose, String> colonnePrenomPrepose = new TableColumn<Prepose, String>("Pr�nom");
	TableColumn<Prepose, String> colonneAdressePrepose = new TableColumn<Prepose, String>("Adresse");
	TableColumn<Prepose, String> colonneNumeroTelephonePrepose = new TableColumn<Prepose, String>("T�l�phone");
	
	
	colonneNumeroPrepose.setPrefWidth(120);
	colonneNomPrepose.setPrefWidth(100);
	colonnePrenomPrepose.setPrefWidth(100);
	colonneAdressePrepose.setPrefWidth(150);
	colonneNumeroTelephonePrepose.setPrefWidth(100);
	

	colonneNumeroPrepose.setMaxWidth(Double.MAX_VALUE);
	colonneNomPrepose.setMaxWidth(Double.MAX_VALUE);
	colonnePrenomPrepose.setMaxWidth(Double.MAX_VALUE);
	colonneAdressePrepose.setMaxWidth(Double.MAX_VALUE);
	colonneNumeroTelephonePrepose.setMaxWidth(Double.MAX_VALUE);
	

	colonneNumeroPrepose.setCellValueFactory(new PropertyValueFactory<>("strNumeroAdherent"));
	colonneNomPrepose.setCellValueFactory(new PropertyValueFactory<>("strNom"));
	colonnePrenomPrepose.setCellValueFactory(new PropertyValueFactory<>("strPrenom"));
	colonneAdressePrepose.setCellValueFactory(new PropertyValueFactory<>("strAdresse"));
	colonneNumeroTelephonePrepose.setCellValueFactory(new PropertyValueFactory<>("strNumeroTelephone"));
	
	
	
	//tableAdherent.setItems(donneesAdherents);
	tablePreposes.getColumns().addAll(colonneNumeroPrepose,colonneNomPrepose,colonnePrenomPrepose,colonneAdressePrepose,colonneNumeroTelephonePrepose);
	paneGestionPreposes.setContent(vBoxPreposes);
	accordion.setPrefWidth(180);
	accordion.getPanes().add(paneGestionPreposes);
	bPaneDroite.setTop(accordion);
	vboxPartieADroite.getChildren().addAll(bPaneDroite, hboxButtonDeconnexion);
	
	root.setCenter(tablePreposes);
	root.setRight(vboxPartieADroite);
	//GestionnaireButtonPreposeAherent gestionnaireButtonPreposeAherent = new GestionnaireButtonPreposeAherent();
	//btnajouterPrepose.setOnMouseClicked(gestionnaireButtonPreposeAherent);
	primaryStage.getIcons().add(new Image("booklibrary.png"));
	primaryStage.setTitle("M�diath�que(Administrateur)");
	primaryStage.sizeToScene();
	primaryStage.setResizable(false);
	primaryStage.setScene(scene);
	primaryStage.show();
	}
	private class GestionnaireButtonPreposeAherent implements EventHandler<MouseEvent> {

		@Override
		public void handle(MouseEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource() == btnajouterPrepose) {
				Stage stageAjoutAdherent = new Stage();
				GridPane gpaneAjoutAdherent = new GridPane();
				Scene sceneAjoutAdherent = new Scene(gpaneAjoutAdherent,280,220);
				
				gpaneAjoutAdherent.setPadding(new Insets(10));
				gpaneAjoutAdherent.setHgap(5);
				gpaneAjoutAdherent.setVgap(10);
				
				Text txtNomAdherent = new Text("Nom :");
				Text txtPrenomAdherent = new Text("Prenom :");
				Text txtAdresseAdherent = new Text("Adresse :");
				Text txtTelephoneAdherent = new Text("T�l�phone :");
				
				TextField txtfNomAdherent = new TextField();
				TextField txtfPrenomAdherent = new TextField();
				TextField txtfAdresseAdherent = new TextField();
				TextField txtfTelephoneAdherent = new TextField();
				
				Button btnConfirmerAJoutAdherent = new Button("Confirmer");
				Button btnAnnulerAjoutAdherent = new Button("Annuler");
				
				HBox hboxButtonAhderent = new HBox(2);
				hboxButtonAhderent.getChildren().addAll(btnConfirmerAJoutAdherent,btnAnnulerAjoutAdherent);
				

				txtfTelephoneAdherent.setPromptText("(###) ###-####");
				
				gpaneAjoutAdherent.add(txtNomAdherent, 0, 0);
				gpaneAjoutAdherent.add(txtfNomAdherent, 1, 0);
				gpaneAjoutAdherent.add(txtPrenomAdherent, 0, 1);
				gpaneAjoutAdherent.add(txtfPrenomAdherent, 1, 1);
				gpaneAjoutAdherent.add(txtAdresseAdherent, 0, 2);
				gpaneAjoutAdherent.add(txtfAdresseAdherent, 1, 2);
				gpaneAjoutAdherent.add(txtTelephoneAdherent, 0, 3);
				gpaneAjoutAdherent.add(txtfTelephoneAdherent, 1, 3);
				gpaneAjoutAdherent.add(hboxButtonAhderent, 1, 4);
				
				
				
				txtfNomAdherent.requestFocus();
				

				btnAnnulerAjoutAdherent.setOnAction(new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent e) {
						// TODO Auto-generated method stub
						stageAjoutAdherent.close();
					}
				});
				btnConfirmerAJoutAdherent.setOnAction(new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent e) {
						// TODO Auto-generated method stub
					
							if (txtfNomAdherent.getText().compareTo("") == 0) {
								Alert Erreur = new Alert(AlertType.ERROR);
								Erreur.setTitle("Erreur");
								Erreur.setHeaderText(null);
								Erreur.setContentText("Vous n'avez pas tap� le nom de l'adh�rent");
								Erreur.showAndWait();
							}
							else if (txtfPrenomAdherent.getText().compareTo("") == 0) {
								Alert Erreur = new Alert(AlertType.ERROR);
								Erreur.setTitle("Erreur");
								Erreur.setHeaderText(null);
								Erreur.setContentText("Vous n'avez pas tap� le pr�nom de l'adh�rent");
								Erreur.showAndWait();
							}
							else if (txtfAdresseAdherent.getText().compareTo("") == 0) {
								Alert Erreur = new Alert(AlertType.ERROR);
								Erreur.setTitle("Erreur");
								Erreur.setHeaderText(null);
								Erreur.setContentText("Vous n'avez pas tap� l'adresse de l'adh�rent");
								Erreur.showAndWait();
							}
							else if (txtfTelephoneAdherent.getText().compareTo("") == 0) {
								Alert Erreur = new Alert(AlertType.ERROR);
								Erreur.setTitle("Erreur");
								Erreur.setHeaderText(null);
								Erreur.setContentText("Vous n'avez pas tap� le t�l�phone");
								Erreur.showAndWait();
							}else if (!txtfTelephoneAdherent.getText().matches("^[\\(][0-9]{3}[\\)][\\s][0-9]{3}[\\-][0-9]{4}$")) {
								Alert Erreur = new Alert(AlertType.ERROR);
								Erreur.setTitle("Erreur");
								Erreur.setHeaderText(null);
								Erreur.setContentText("Voici le format que vous devez mettre : (###) ###-####");
								Erreur.showAndWait();
								txtfTelephoneAdherent.requestFocus();
							}
							else {// ajout d'un adh�rent **important il faut que �a soit le prepose qui est connecter qui ajoute les adherents
							
								Prepose preposeAjouter = new Prepose();
								  admin = new Administrateur(); //juste pour faire des tests
								 admin.AjouterPrepose(preposeAjouter);
								 
								 	Alert confirmation = new Alert(AlertType.CONFIRMATION);
								 	confirmation.setTitle("Confirmation");
								 	confirmation.setHeaderText(null);
								 	confirmation.setContentText("L'adh�rent vient d'�tre ajout�!");
								 	confirmation.showAndWait();
								 	stageAjoutAdherent.close();
								 	donneesPreposes.add(preposeAjouter);
							}
							
						

					}
				});
				
				
				
				stageAjoutAdherent.setTitle("Ajout d'un adh�rent");
				stageAjoutAdherent.getIcons().add(new Image("iconAjouterPersonne.png"));
				stageAjoutAdherent.sizeToScene();
				stageAjoutAdherent.setScene(sceneAjoutAdherent);
				stageAjoutAdherent.show();

			}
			
			else if(e.getSource()==btnSupprimerPrepose) {
				if(tablePreposes.getSelectionModel().getSelectedItem()==null) {//non selectionnee
					Alert Erreur = new Alert(AlertType.ERROR);
					Erreur.setTitle("Erreur");
					Erreur.setHeaderText(null);
					Erreur.setContentText("Vous devez s�lectionner un adh�rent pour le supprimer.");
					Erreur.showAndWait();
				}
				else{ // ne marceh pas, voir erreur: java.lang.NullPointerException
					System.out.println("adh�dent selectionnee");
					//suppresion adherent
					
					Prepose PreposeSupprimer = tablePreposes.getSelectionModel().getSelectedItem();
					
					//prepose.afficherAdherents(adherentSupprimer);
					
					//System.out.println(adherentSupprimer.getStrNom());
			
					prepose.supprimerAdherent(adherentSupprimer);
					
					//donneesAdherents.removeAll(adherentSupprimer);
					
				}
			}
			

		}

	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
