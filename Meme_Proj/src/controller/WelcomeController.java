package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import application.Main;

public class WelcomeController implements EventHandler<ActionEvent> {

	@Override
	public void handle(ActionEvent event) {
		
		try {
			Parent root = FXMLLoader.load(getClass().getResource("../view/Mode.fxml"));
			Main.stage.setTitle("Choose A Player Mode");
			Main.stage.setScene(new Scene(root, 1000,800));
			Main.stage.show();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	
	
	
	
}
