package application;

import java.util.ArrayList;
import java.util.Optional;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.DialogEvent;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.TilePane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			TilePane root = new TilePane(Orientation.VERTICAL);
			root.setVgap(20);
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			root.setPadding(new Insets(10));
			Button btnAfficher = new Button ("Afficher boite de dialogue");
			Button btnAfficherTextInput = new Button ("Afficher boite  entrée de text");
			btnAfficher.setFont(Font.font("Arial", FontWeight.BOLD, 20));
			btnAfficherTextInput.setFont(Font.font("Arial", FontWeight.BOLD, 20));
			
			Button btnAfficherBoiteChoix = new Button ("Afficher boite  de choix");
			btnAfficherBoiteChoix.setFont(Font.font("Arial", FontWeight.BOLD, 20));
			
			btnAfficherBoiteChoix.setMaxWidth(Double.MAX_VALUE);
		
			
			
			btnAfficher.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					// TODO Auto-generated method stub
					Optional<ButtonType> retour =null;
					//retour =afficherBoiteInfo(AlertType.INFORMATION);
					//retour = afficherBoiteInfo(AlertType.WARNING);
					//retour = afficherBoiteInfo(AlertType.ERROR);
					retour = afficherBoiteInfo(AlertType.CONFIRMATION);
				    if (retour.isPresent())
					if (retour.get() == ButtonType.OK){
					    System.out.println("Ok est choisi");
					} else {
						 System.out.println("Ok  non est choisi");
					}
				}
			});
			

			btnAfficherTextInput.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					// TODO Auto-generated method stub
					TextInputDialog txtDialogue = new TextInputDialog("Votre nom");
					
					txtDialogue.setHeaderText(null);
					
					txtDialogue.setTitle("boite d'entrée de texte");
					
					txtDialogue.setContentText("Entrer votre nom:");

					// Traditional way to get the response value.
					Optional<String> retour = txtDialogue.showAndWait();
					if (retour.isPresent()){
					    System.out.println("Votre nom est: " + retour.get());
					}
				  
				}

			});
			
			btnAfficherBoiteChoix.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					// TODO Auto-generated method stub
					
					ArrayList<String>  lstChoix = new ArrayList<String> ();
					lstChoix.add("choix 1");
					lstChoix.add("choix 2");
					lstChoix.add("choix 3");
					lstChoix.add("choix 4");
					
					ChoiceDialog<String> boiteChoix = new ChoiceDialog<>(lstChoix.get(0), lstChoix);
					boiteChoix.setTitle("Boite de choix");
					boiteChoix.setHeaderText(null);
					boiteChoix.setContentText("Choisir une valeur");

					// Traditional way to get the response value.
					Optional<String> retour = boiteChoix.showAndWait();
					if (retour.isPresent()){
					    System.out.println("Votre choix est: " + retour.get());
					}

				}

			});
			

			root.getChildren().addAll(btnAfficher,btnAfficherTextInput,btnAfficherBoiteChoix);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}


	public Optional<ButtonType> afficherBoiteInfo(AlertType type) {

		String entete=null;
		String texte=null;
		String titre = null;
		Alert alert= null;
		
		switch (type) {

		case INFORMATION: 
			alert = new Alert (AlertType.INFORMATION);
			titre = " boite d'information";
			texte = "Ceci est un message d'information";	
			break;
		case WARNING: 
			alert = new Alert (AlertType.WARNING);
			titre = " boite d'averissement";
			texte = "Ceci est un message d'avertissement";
			break;
			
		case ERROR: 
			alert = new Alert (AlertType.ERROR);
			titre = " boite d'erreur";
			texte = "attention! vous avez un erreur";
			break;
			
		case CONFIRMATION: 

			alert = new Alert (AlertType.CONFIRMATION);
			titre = " boite de confirmation";
			texte = "êtes vous d'accord pour.... ";
			break;
		default:
			break;

		}

		alert.setTitle(titre);
		alert.setHeaderText(entete);  
		alert.setContentText(texte);
		return alert.showAndWait();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
