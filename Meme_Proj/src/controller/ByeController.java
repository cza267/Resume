package controller;

import java.io.IOException;
import java.util.ArrayList;

import application.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import model.PlayerModel;

public class ByeController implements EventHandler<ActionEvent> {

	public PlayerModel play1;
	public PlayerModel play2;
	private ArrayList<PlayerModel> players = new ArrayList<PlayerModel>();
	TournamentRunnerModel2 tourn;
	int iMatch;
	@Override
	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub
		
	}
	public void yesHandle(ActionEvent event) {
		Parent root;
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/byecreate.fxml"));
			root = (Parent)fxmlLoader.load();
			CreateByeController controller = fxmlLoader.<CreateByeController>getController();
			controller.setUser2(this.play1, this.play2);
			Main.stage.setScene(new Scene(root, 1000,800));
			Main.stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	public void noHandle(ActionEvent event) {
		Parent root;
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/tourn4.fxml"));
			root = (Parent)fxmlLoader.load();
			Tourn4Controller controller = fxmlLoader.<Tourn4Controller>getController();
			if (this.play1.getName().equals("bye")) {
				controller.setUser3(this.play2);
			}else {
				controller.setUser3(this.play1);
			}
			controller.setUser4(this.tourn.matchNum, 1);
			controller.setUser(this.players);
			Main.stage.setScene(new Scene(root, 1000,800));
			Main.stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	public void setUser3(ArrayList<PlayerModel> playerlist, int matchNum) {
		this.players = playerlist;
		this.tourn = new TournamentRunnerModel2(playerlist, matchNum++);
		//this.iMatch = matchNum;
	}
	public void setUser2(PlayerModel player1, PlayerModel player2) {
		this.play1 = player1;
		this.play2 = player2;
	}
}
