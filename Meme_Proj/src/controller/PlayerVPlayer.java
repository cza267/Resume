package controller;

import application.Main;
import javafx.event.ActionEvent;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;

public class PlayerVPlayer implements EventHandler<ActionEvent>{

	private int sizeTourn = 2;
	@FXML 
	private Button win;
	@Override
	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub
	}
	
	public void goHandle(ActionEvent event) {
		System.out.println("winner button pushed");
		try {
			Parent root;
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/choosePic.fxml")); 
			root = (Parent)fxmlLoader.load(); 
			ChoosePic controller = fxmlLoader.<ChoosePic>getController();
			controller.setUser(sizeTourn);
			Main.stage.setScene(new Scene(root, 1000,800));
			Main.stage.show();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void setUser(int player1Votes, int player2Votes){
		if(player1Votes > player2Votes) {
			win.setText("Player1 Wins");
		}else {
			win.setText("Player2 Wins");
		}	    
	}
	public void goToWelcome(ActionEvent event) {
		try {
			Parent root;
			root = FXMLLoader.load(getClass().getResource("../view/WelcomeView.fxml"));
			Main.stage.setScene(new Scene(root, 1000,800));
			Main.stage.show();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}


}
