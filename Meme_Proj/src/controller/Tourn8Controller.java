package controller;

import java.util.ArrayList;

import application.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import model.PlayerModel;

public class Tourn8Controller implements EventHandler<ActionEvent>{

	ArrayList<PlayerModel> playerlist = new ArrayList<PlayerModel>();
	TournamentRunnerModel2 tourn = new TournamentRunnerModel2(playerlist);
	@FXML 
	private Button b1;
	@FXML 
	private Button b2;
	@FXML 
	private Button b3;
	@FXML 
	private Button b4;
	@FXML 
	private Button b5;
	@FXML 
	private Button b6;
	@FXML 
	private Button b7;
	@FXML 
	private Button b8;
	@FXML 
	private Button b21;
	@FXML 
	private Button b22;
	@FXML 
	private Button b23;
	@FXML 
	private Button b24;
	@FXML 
	private Button b31;
	@FXML 
	private Button b32;
	@FXML 
	private Button b41;
	@FXML
	private Button done;
	private ArrayList<PlayerModel> winners = new ArrayList<PlayerModel>();
	private int votes1, votes2;
	private PlayerModel bye = new PlayerModel("bye");
	
	public void goHandle(ActionEvent event) {
		//this.bye.setName("bye");
		if(tourn.roundNum == 1) {
			if (b1 == null) {
				if (this.tourn.Players8.get(0) == null) {
					b1.setText("bye");
				}else {
					b1.setText(this.tourn.Players8.get(0).getName());	
				}
				if (this.tourn.Players8.get(1) == null) {
					b2.setText("bye");
				}else {
					b2.setText(this.tourn.Players8.get(1).getName());	
				}if (this.tourn.Players8.get(2) == null) {
					b3.setText("bye");
				}else {
					b3.setText(this.tourn.Players8.get(2).getName());	
				}if (this.tourn.Players8.get(3) == null) {
					b4.setText("bye");
				}else {
					b4.setText(this.tourn.Players8.get(3).getName());	
				}if (this.tourn.Players8.get(4) == null) {
					b5.setText("bye");
				}else {
					b5.setText(this.tourn.Players8.get(4).getName());	
				}if (this.tourn.Players8.get(5) == null) {
					b6.setText("bye");
				}else {
					b6.setText(this.tourn.Players8.get(5).getName());	
				}if (this.tourn.Players8.get(6) == null) {
					b7.setText("bye");
				}else {
					b7.setText(this.tourn.Players8.get(6).getName());	
				}if (this.tourn.Players8.get(7) == null) {
					b8.setText("bye");
				}else {
					b8.setText(this.tourn.Players8.get(7).getName());	
				}
				for(int i = 0; i < this.tourn.Players8.size(); i += 2) {
					if(this.tourn.Players8.get(i) == null) {
						this.tourn.Match[i] = this.bye;
					}else if(this.tourn.Players8.get(i + 1) == null) {
						this.tourn.Match[i+1] = this.bye;
					}else {
						this.tourn.Match[i] = this.tourn.Players8.get(i);
						this.tourn.Match[i+1] = this.tourn.Players8.get(i+1);
					}
					
				}
				tourn.RunRound();
			}
			
			
			
		}else if(tourn.roundNum == 2) {
			b21.setText(winners.get(0).getName());
			tourn.Match[0] = winners.get(0);
			b22.setText(winners.get(1).getName());
			tourn.Match[1] = winners.get(1);
			b23.setText(winners.get(2).getName());
			tourn.Match[2] = winners.get(2);
			b24.setText(winners.get(3).getName());
			tourn.Match[3] = winners.get(3);
			tourn.RunRound();
		}else if(tourn.roundNum == 3) {
			b31.setText(winners.get(4).getName());
			tourn.Match[0] = winners.get(4);
			b32.setText(winners.get(5).getName());
			tourn.Match[1] = winners.get(5);
		}else if(tourn.roundNum == 4) {
			b41.setText(winners.get(6).getName());
		}
		
		
		
		
		
	}
	public void setUser(ArrayList<PlayerModel> players) {
		this.playerlist = players;
	}
	public void setUser2(int vote1, int vote2) {
		this.votes1 = vote1;
		this.votes2 = vote2;
	}
	public void setUser3(PlayerModel winner) {
		this.winners.add(winner);
	}
	@Override
	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub
		
	}
	public void doneFunction(ActionEvent event) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("../view/Congrats.fxml"));
			Main.stage.setScene(new Scene(root, 700, 600));
			Main.stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
