package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {
	static Stage current;
	Scene scene;
	static int hello = 0;

	@Override
	public void start(Stage primaryStage) {
		try {
			current = primaryStage;
	        FXMLLoader loader = new FXMLLoader(getClass().getResource("Fxml.fxml"));
	        Parent root = loader.load();
	        if(hello>0) {scene = new Scene(root,298, 327);}
	        else {scene = new Scene(root,288, 317);}
	        hello++;
			//BorderPane root = new BorderPane();
			//Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Tic Tac Toe");
			primaryStage.setResizable(false);
			primaryStage.show();

		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
