package application;
	
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent parent = FXMLLoader.load(getClass().getResource("Home.fxml"));
			Scene scene = new Scene(parent);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
            primaryStage.setOnCloseRequest(evt -> {
                Platform.exit();
                System.exit(0);
            });
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
