package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;


public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		try {
			primaryStage.setTitle("Web Scraper");
			final FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("main-window.fxml"));
			loader.setController(new MainWindowController());
			Pane root = (Pane) loader.load();
			
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
