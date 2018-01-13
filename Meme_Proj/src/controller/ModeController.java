/**
 * Mode Controller displays modes for players to choose and links to the Create Meme page
 * @author Danielle Lawrence
 */
package controller;


import application.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;


public class ModeController implements EventHandler<ActionEvent> {
	

	private	Button free;
	private	Button tournament;
	private	Button playervsplayer;

	
	@Override
	public void handle(ActionEvent arg0) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("../view/CreateView.fxml"));
			Main.stage.setScene(new Scene(root, 1100, 850));
			Main.stage.show();
		} catch(Exception e) {
			e.printStackTrace();
			
		}
		//System.out.println("Free Play Clicked");
	}

	
	public void tournamenthandle(ActionEvent event) {
		try {

			Parent root = FXMLLoader.load(getClass().getResource("../view/pickPlayer.fxml"));

			Main.stage.setScene(new Scene(root, 1000, 800));
			Main.stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("Tournament Clicked");	
	}

	
	public void playerhandle(ActionEvent event) {
		try {

			Parent root = FXMLLoader.load(getClass().getResource("../view/pvp.fxml"));
			Main.stage.setScene(new Scene(root, 1000, 800));
			Main.stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
		//System.out.println("Player vs. Player Clicked");
		System.out.println("Player vs. Player Clicked");
	}
	

}