package application;
	



import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			
			TabPane tabPane = new TabPane();
			
			// premier onglet
			 Tab tab1 = new Tab();
			 tab1.setClosable(false);
			 tab1.setText("tab1");
			 tab1.setGraphic(new ImageView(new Image("icon-dvd.png")));
			 GridPane gr = new GridPane();
			 gr.setVgap(5);
			 gr.setHgap(5);
			 gr.add(new Button ("allo"), 0, 2);
			 gr.add(new Button("merci"), 2, 3);
			 tab1.setContent(gr);
			 
			 root.setCenter(tabPane);
			 tabPane.getTabs().add(tab1);
			 
			 // deuxième onglet
			 Tab tab2 = new Tab();
			 Text text = new Text("deuxième onglet");
			 text.setFill(Color.RED);
			 text.setFont(Font.font(30));
			 tab2.setContent(text);
			 tab2.setClosable(false);
			 tab2.setText("tab2");
			 tabPane.getTabs().add(tab2);
			
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
