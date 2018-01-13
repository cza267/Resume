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

public class Tourn16Controller implements EventHandler<ActionEvent>{
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
	private Button b9;
	@FXML 
	private Button b10;
	@FXML 
	private Button b11;
	@FXML 
	private Button b12;
	@FXML 
	private Button b13;
	@FXML 
	private Button b14;
	@FXML 
	private Button b15;
	@FXML 
	private Button b16;
	@FXML 
	private Button b21;
	@FXML 
	private Button b22;
	@FXML 
	private Button b23;
	@FXML 
	private Button b24;
	@FXML 
	private Button b25;
	@FXML 
	private Button b26;
	@FXML 
	private Button b27;
	@FXML 
	private Button b28;
	@FXML 
	private Button b31;
	@FXML 
	private Button b32;
	@FXML 
	private Button b33;
	@FXML 
	private Button b34;
	@FXML 
	private Button b41;
	@FXML 
	private Button b42;
	@FXML 
	private Button b51;
	@FXML
	private Button done;
	private ArrayList<PlayerModel> winners = new ArrayList<PlayerModel>();
	private int votes1, votes2;
	private PlayerModel bye = new PlayerModel("bye");
	
	public void goHandle(ActionEvent event) {
		//this.bye.setName("bye");
		if(tourn.roundNum == 1) {
			if (b1 == null) {
				if (this.tourn.Players16.get(0) == null) {
					b1.setText("bye");
				}else {
					b1.setText(this.tourn.Players16.get(0).getName());	
				}
				if (this.tourn.Players16.get(1) == null) {
					b2.setText("bye");
				}else {
					b2.setText(this.tourn.Players16.get(1).getName());	
				}if (this.tourn.Players16.get(2) == null) {
					b3.setText("bye");
				}else {
					b3.setText(this.tourn.Players16.get(2).getName());	
				}if (this.tourn.Players16.get(3) == null) {
					b4.setText("bye");
				}else {
					b4.setText(this.tourn.Players16.get(3).getName());	
				}if (this.tourn.Players16.get(4) == null) {
					b5.setText("bye");
				}else {
					b5.setText(this.tourn.Players16.get(4).getName());	
				}if (this.tourn.Players16.get(5) == null) {
					b6.setText("bye");
				}else {
					b6.setText(this.tourn.Players16.get(5).getName());	
				}if (this.tourn.Players16.get(6) == null) {
					b7.setText("bye");
				}else {
					b7.setText(this.tourn.Players16.get(6).getName());	
				}if (this.tourn.Players16.get(7) == null) {
					b8.setText("bye");
				}else {
					b8.setText(this.tourn.Players16.get(7).getName());	
				}if (this.tourn.Players16.get(8) == null) {
					b9.setText("bye");
				}else {
					b9.setText(this.tourn.Players16.get(8).getName());	
				}
				if (this.tourn.Players16.get(9) == null) {
					b10.setText("bye");
				}else {
					b10.setText(this.tourn.Players16.get(9).getName());	
				}if (this.tourn.Players16.get(10) == null) {
					b11.setText("bye");
				}else {
					b11.setText(this.tourn.Players16.get(10).getName());	
				}if (this.tourn.Players16.get(11) == null) {
					b12.setText("bye");
				}else {
					b12.setText(this.tourn.Players16.get(11).getName());	
				}if (this.tourn.Players16.get(12) == null) {
					b13.setText("bye");
				}else {
					b13.setText(this.tourn.Players16.get(12).getName());	
				}if (this.tourn.Players16.get(13) == null) {
					b14.setText("bye");
				}else {
					b14.setText(this.tourn.Players16.get(13).getName());	
				}if (this.tourn.Players16.get(14) == null) {
					b15.setText("bye");
				}else {
					b15.setText(this.tourn.Players16.get(14).getName());	
				}if (this.tourn.Players16.get(15) == null) {
					b16.setText("bye");
				}else {
					b16.setText(this.tourn.Players16.get(15).getName());	
				}
				for(int i = 0; i < this.tourn.Players16.size(); i += 2) {
					if(this.tourn.Players16.get(i) == null) {
						this.tourn.Match[i] = this.bye;
					}else if(this.tourn.Players16.get(i + 1) == null) {
						this.tourn.Match[i+1] = this.bye;
					}else {
						this.tourn.Match[i] = this.tourn.Players16.get(i);
						this.tourn.Match[i+1] = this.tourn.Players16.get(i+1);
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
			b21.setText(winners.get(4).getName());
			tourn.Match[4] = winners.get(4);
			b22.setText(winners.get(5).getName());
			tourn.Match[5] = winners.get(5);
			b23.setText(winners.get(6).getName());
			tourn.Match[6] = winners.get(6);
			b24.setText(winners.get(7).getName());
			tourn.Match[7] = winners.get(7);
			tourn.RunRound();
		}else if(tourn.roundNum == 3) {
			b31.setText(winners.get(8).getName());
			tourn.Match[8] = winners.get(8);
			b32.setText(winners.get(9).getName());
			tourn.Match[9] = winners.get(9);
			b33.setText(winners.get(10).getName());
			tourn.Match[10] = winners.get(10);
			b34.setText(winners.get(11).getName());
			tourn.Match[11] = winners.get(11);
		}
		else if(tourn.roundNum == 4) {
			b31.setText(winners.get(12).getName());
			tourn.Match[12] = winners.get(12);
			b32.setText(winners.get(13).getName());
			tourn.Match[13] = winners.get(13);
		}else if(tourn.roundNum == 5) {
			b41.setText(winners.get(14).getName());
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
