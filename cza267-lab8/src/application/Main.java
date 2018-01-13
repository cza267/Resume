package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
/**
 * Main class initializes application
 * @author Cheyenne Sanchez
 * @version 1.0
 */
public class Main extends Application {
	private static Stage stage;
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/view/Calculator.fxml"));
			primaryStage.setScene(new Scene(root, 590,650));
			primaryStage.setTitle("Calculator");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
		Main.stage = primaryStage;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public static Stage getStage() {
		return stage;
	}
}
