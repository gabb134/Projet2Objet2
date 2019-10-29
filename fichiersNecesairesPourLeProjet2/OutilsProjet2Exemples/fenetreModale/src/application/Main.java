package application;
	


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;


public class Main extends Application {
	
	Button btnScene1, btnScene2;
	FlowPane flPane1, flPane2;
	Stage  fenetre2;
	Label lblScene1, lblScene2;
	Scene scene1, scene2;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			
			
		
			
			btnScene1=new Button("Cliquer pour changer de scene");
			btnScene2=new Button("Cliquer pour retourner � la premi�re scene");
			
			btnScene1.setOnAction(new EventHandler<ActionEvent>(){

				@Override
				public void handle(ActionEvent e) {
					// TODO Auto-generated method stub
					fenetre2.showAndWait();
				}});
				
			// Noter cette autre fa�on ... avec une lambda expression. 
	        btnScene2.setOnAction(e-> fenetre2.close());
	        
	        lblScene1=new Label("Premi�re sc�ne");
	        lblScene2=new Label("Deuxi�me sc�ne");
	        
	        //make 2 Panes
	        flPane1=new FlowPane();
	        flPane2=new FlowPane();
	        flPane1.setHgap(20);
	        flPane2.setVgap(10);
	        flPane1.setPadding(new Insets(15));
	        flPane2.setPadding(new Insets(15));
	             
	        flPane1.getChildren().addAll(lblScene1, btnScene1);
	        flPane2.getChildren().addAll(lblScene2, btnScene2);
	       
	        
	        BackgroundFill bgFillflPane1= new BackgroundFill(Color.AQUA, null, null);
	        flPane1.setBackground(new Background(bgFillflPane1));
	        
	        BackgroundFill bgFillflPane2= new BackgroundFill(Color.BEIGE, null, null);
	        flPane2.setBackground(new Background(bgFillflPane2));
	        
	        //cr�e  2 scenes � partir des deux panneaux 
	        scene1 = new Scene(flPane1, 200, 100);
	        scene2 = new Scene(flPane2, 350, 100);
	       
	       //cr�er une fen�tre (Stage)  pour scene2
	       fenetre2 = new Stage();
	       fenetre2.setScene(scene2);
	       
	      // d�clare une fen�tre modale 
	       fenetre2.initModality(Modality.APPLICATION_MODAL);
	       fenetre2.setTitle("Fen�tre modale");
	       
	       primaryStage.setTitle("Fen�tre principale");
	       primaryStage.setScene(scene1);
	       primaryStage.setMinWidth(300);
	       primaryStage.show();
	       
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	


	public static void main(String[] args) {
		launch(args);
	}
}
