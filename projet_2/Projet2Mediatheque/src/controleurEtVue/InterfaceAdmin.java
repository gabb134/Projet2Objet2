package controleurEtVue;


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
import javafx.stage.Modality;
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
		btnajouterPrepose = new Button("Ajouter un préposé");
		btnajouterPrepose.setPrefWidth(180);
		btnSupprimerPrepose = new Button("Supprimer un préposé");
		btnSupprimerPrepose.setPrefWidth(180);
		hboxButtonDeconnexion = new HBox();
		liste = ListePreposes.getInstance();
		donneesPreposes = FXCollections.observableArrayList(liste.getLstPreposes());
		btnDeconnexion = new Button("Deconnexion");
		btnDeconnexion.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				// TODO Auto-generated method stub
				primaryStage.close();
				Stage stageConnexionMediatheque = new Stage();
				stageConnexionMediatheque.initModality(Modality.APPLICATION_MODAL);
				Mediatheque meditheque = new Mediatheque();
				meditheque.start(stageConnexionMediatheque);
				ListePreposes.serialisationPrepose();

			}
		});
		hboxButtonDeconnexion.getChildren().add(btnDeconnexion);
		hboxButtonDeconnexion.setAlignment(Pos.CENTER);
		vBoxPreposes.getChildren().addAll(btnajouterPrepose,btnSupprimerPrepose);
		paneGestionPreposes = new TitledPane("Gestion des Préposes",
				new Label("Show all cars available"));


		TableColumn<Prepose, String> colonneNumeroPrepose = new TableColumn<Prepose, String>("Numéro d'employé");
		TableColumn<Prepose, String> colonneNomPrepose= new TableColumn<Prepose, String>("Nom");
		TableColumn<Prepose, String> colonnePrenomPrepose = new TableColumn<Prepose, String>("Prénom");
		TableColumn<Prepose, String> colonneAdressePrepose = new TableColumn<Prepose, String>("Adresse");
		TableColumn<Prepose, String> colonneNumeroTelephonePrepose = new TableColumn<Prepose, String>("Téléphone");


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


		colonneNumeroPrepose.setCellValueFactory(new PropertyValueFactory<>("strNumEmploye"));
		colonneNomPrepose.setCellValueFactory(new PropertyValueFactory<>("strNom"));
		colonnePrenomPrepose.setCellValueFactory(new PropertyValueFactory<>("strPrenom"));
		colonneAdressePrepose.setCellValueFactory(new PropertyValueFactory<>("strAdresse"));
		colonneNumeroTelephonePrepose.setCellValueFactory(new PropertyValueFactory<>("strTelephone"));



		tablePreposes.setItems(donneesPreposes);
		tablePreposes.getColumns().addAll(colonneNumeroPrepose,colonneNomPrepose,colonnePrenomPrepose,colonneAdressePrepose,colonneNumeroTelephonePrepose);
		paneGestionPreposes.setContent(vBoxPreposes);
		accordion.setPrefWidth(180);
		accordion.getPanes().add(paneGestionPreposes);
		bPaneDroite.setTop(accordion);
		vboxPartieADroite.getChildren().addAll(bPaneDroite, hboxButtonDeconnexion);

		root.setCenter(tablePreposes);
		root.setRight(vboxPartieADroite);
		GestionnaireButtonPreposeAherent gestionnaireButtonPreposeAherent = new GestionnaireButtonPreposeAherent();
		btnajouterPrepose.setOnMouseClicked(gestionnaireButtonPreposeAherent);
		btnSupprimerPrepose.setOnMouseClicked(gestionnaireButtonPreposeAherent);
		primaryStage.getIcons().add(new Image("booklibrary.png"));
		primaryStage.setTitle("Médiathèque(Administrateur)");
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
				Stage stageAjoutPrepose = new Stage();
				GridPane gpaneAjoutPrepose = new GridPane();
				Scene sceneAjoutPrepose = new Scene(gpaneAjoutPrepose,280,220);

				gpaneAjoutPrepose.setPadding(new Insets(10));
				gpaneAjoutPrepose.setHgap(5);
				gpaneAjoutPrepose.setVgap(10);

				Text txtNomPrepose = new Text("Nom :");
				Text txtPrenomPrepose = new Text("Prenom :");
				Text txtAdressePrepose = new Text("Adresse :");
				Text txtTelephonePrepose = new Text("Téléphone :");
				Text txtMotDePasse=new Text ("Mot de Passe");
				TextField txtfNomPrepose = new TextField();
				TextField txtfPrenomPrepose = new TextField();
				TextField txtfAdressePrepose = new TextField();
				TextField txtfTelephonePrepose = new TextField();
				TextField txtfMotDePasse= new TextField();
				Button btnConfirmerAjoutPrepose = new Button("Confirmer");
				Button btnAnnulerAjoutPrepose = new Button("Annuler");

				HBox hboxButtonPrepose = new HBox(2);
				hboxButtonPrepose.getChildren().addAll(btnConfirmerAjoutPrepose,btnAnnulerAjoutPrepose);


				txtfTelephonePrepose.setPromptText("(###) ###-####");

				gpaneAjoutPrepose.add(txtNomPrepose, 0, 0);
				gpaneAjoutPrepose.add(txtfNomPrepose, 1, 0);
				gpaneAjoutPrepose.add(txtPrenomPrepose, 0, 1);
				gpaneAjoutPrepose.add(txtfPrenomPrepose, 1, 1);
				gpaneAjoutPrepose.add(txtAdressePrepose, 0, 2);
				gpaneAjoutPrepose.add(txtfAdressePrepose, 1, 2);
				gpaneAjoutPrepose.add(txtTelephonePrepose, 0, 3);
				gpaneAjoutPrepose.add(txtfTelephonePrepose, 1, 3);
				gpaneAjoutPrepose.add(txtMotDePasse, 0, 4);
				gpaneAjoutPrepose.add(txtfMotDePasse, 1, 4);
				gpaneAjoutPrepose.add(hboxButtonPrepose, 1, 5);



				txtfNomPrepose.requestFocus();


				btnAnnulerAjoutPrepose.setOnAction(new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent e) {
						// TODO Auto-generated method stub
						stageAjoutPrepose.close();
					}
				});
				btnConfirmerAjoutPrepose.setOnAction(new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent e) {
						// TODO Auto-generated method stub

						if (txtfNomPrepose.getText().compareTo("") == 0) {
							Alert Erreur = new Alert(AlertType.ERROR);
							Erreur.setTitle("Erreur");
							Erreur.setHeaderText(null);
							Erreur.setContentText("Vous n'avez pas tapé le nom du préposé");
							Erreur.showAndWait();
						}
						else if (txtfPrenomPrepose.getText().compareTo("") == 0) {
							Alert Erreur = new Alert(AlertType.ERROR);
							Erreur.setTitle("Erreur");
							Erreur.setHeaderText(null);
							Erreur.setContentText("Vous n'avez pas tapé le prénom du préposé");
							Erreur.showAndWait();
						}
						else if (txtfAdressePrepose.getText().compareTo("") == 0) {
							Alert Erreur = new Alert(AlertType.ERROR);
							Erreur.setTitle("Erreur");
							Erreur.setHeaderText(null);
							Erreur.setContentText("Vous n'avez pas tapé l'adresse du préposé");
							Erreur.showAndWait();
						}
						else if (txtfMotDePasse.getText().compareTo("") == 0) {
							Alert Erreur = new Alert(AlertType.ERROR);
							Erreur.setTitle("Erreur");
							Erreur.setHeaderText(null);
							Erreur.setContentText("Vous n'avez pas tapé le mot de passe du préposé");
							Erreur.showAndWait();
						}
						else if (txtfTelephonePrepose.getText().compareTo("") == 0) {
							Alert Erreur = new Alert(AlertType.ERROR);
							Erreur.setTitle("Erreur");
							Erreur.setHeaderText(null);
							Erreur.setContentText("Vous n'avez pas tapé le téléphone");
							Erreur.showAndWait();
						}else if (!txtfTelephonePrepose.getText().matches("^[\\(][0-9]{3}[\\)][\\s][0-9]{3}[\\-][0-9]{4}$")) {
							Alert Erreur = new Alert(AlertType.ERROR);
							Erreur.setTitle("Erreur");
							Erreur.setHeaderText(null);
							Erreur.setContentText("Voici le format que vous devez mettre : (###) ###-####");
							Erreur.showAndWait();
							txtfTelephonePrepose.requestFocus();
						}
						else {

							Prepose preposeAjouter = new Prepose("",txtfMotDePasse.getText(),txtfAdressePrepose.getText(),txtfNomPrepose.getText(),txtfPrenomPrepose.getText(),txtfTelephonePrepose.getText());
							admin = new Administrateur(); 
							admin.AjouterPrepose(preposeAjouter);

							Alert confirmation = new Alert(AlertType.CONFIRMATION);
							confirmation.setTitle("Confirmation");
							confirmation.setHeaderText(null);
							confirmation.setContentText("L'adhérent vient d'être ajouté!");
							confirmation.showAndWait();
							stageAjoutPrepose.close();
							donneesPreposes.add(preposeAjouter);
						}



					}
				});



				stageAjoutPrepose.setTitle("Ajout d'un adhérent");
				stageAjoutPrepose.getIcons().add(new Image("iconAjouterPersonne.png"));
				stageAjoutPrepose.sizeToScene();
				stageAjoutPrepose.setScene(sceneAjoutPrepose);
				stageAjoutPrepose.show();

			}

			else if(e.getSource()==btnSupprimerPrepose) {
				if(tablePreposes.getSelectionModel().getSelectedItem()==null) {//non selectionnee
					Alert Erreur = new Alert(AlertType.ERROR);
					Erreur.setTitle("Erreur");
					Erreur.setHeaderText(null);
					Erreur.setContentText("Vous devez sélectionner un adhérent pour le supprimer.");
					Erreur.showAndWait();
				}
				else{ // ne marceh pas, voir erreur: java.lang.NullPointerException
					System.out.println("adhédent selectionnee");
					//suppresion adherent

					Prepose PreposeSupprimer = tablePreposes.getSelectionModel().getSelectedItem();

					//prepose.afficherAdherents(adherentSupprimer);

					System.out.println(PreposeSupprimer.getStrNom());

					admin.supprimerPrepose(PreposeSupprimer);

					donneesPreposes.removeAll(PreposeSupprimer);

				}
			}


		}

	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
