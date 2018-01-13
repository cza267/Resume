package controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class CongratsController implements EventHandler<ActionEvent> {

	@FXML
	private Button exit;

	@Override
	public void handle(ActionEvent arg0) {
		Platform.exit();
		System.exit(0);
	}	
}
