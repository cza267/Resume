package application;
	
import java.awt.EventQueue;

import javax.swing.JFrame;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import model.PlayerModel;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import java.util.ArrayList;
import controller.TournamentController;

public class Main extends Application {
	public static Stage stage;
	@Override
	public void start(Stage primaryStage) {
		try {
			 Parent root = FXMLLoader.load(getClass().getResource("/view/WelcomeView.fxml"));
			 	primaryStage.setTitle("MemeMe");
			    primaryStage.setScene(new Scene(root, 1000, 800));
			    primaryStage.show();
			    
		} catch(Exception e) {
			e.printStackTrace();
		}
		this.stage = primaryStage;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
