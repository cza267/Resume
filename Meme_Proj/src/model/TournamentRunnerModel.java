package model;

import java.util.ArrayList;

import application.Main;
import controller.ChoosePic;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

/**
 * 
 * This class defines the methods for how a tournament is run.
 * It is an extension of the bracket model.
 * @author paul
 *
 */
public class TournamentRunnerModel extends BracketModel {

	public int CurrentMatch;		//current match being played
	public int CurrentRound;		//current round being played
	
	//constructor
	public TournamentRunnerModel(ArrayList<PlayerModel> players) {
		super(players);
	}

	
	//methods
	public void RunTournament() {		
		//TODO may need to set all player total votes to 0
		
		//call RunRound method for each Round
		//increase the round number by 1
		for(this.CurrentRound=0; 
				this.CurrentRound<this.Matches.length; this.CurrentRound++) {
			RunRound();
		}

		//return when current round number > rounds in tournament
		//successbaby.jpg
		return;
	}
	
	private void RunRound() {
		//TODO create method to run each round in the tournament
		
		//call RunMatch method	
		for(this.CurrentMatch=0; 
				this.Matches[this.CurrentMatch]>1; this.CurrentMatch++) {
			RunMatch();
		}
		
		//iterators for making the updated tournament array
		int j=0;
		PlayerModel[] newTournament = new PlayerModel[Matches[CurrentRound]];
		
		//when match number exceeds players in match array
		//push all remaining players up the tournament bracket
		for(int index=0; index<this.Tournament.length; index++) {
			if(this.Tournament[index] == null)
				continue;
			else {
				newTournament[j] = this.Tournament[index];
				j++;
			}
		}
		//update the Tournament bracket
		this.Tournament = newTournament;
		
		return;
	}
	
	private void RunMatch() {
		//define players in match for ease of use later
		PlayerModel player1 = this.Tournament[this.CurrentMatch];
		PlayerModel player2 = this.Tournament[this.CurrentMatch+1];
		
		try {
			Parent root;
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/Vote.fxml")); 
			root = (Parent)fxmlLoader.load(); 
			ChoosePic controller = fxmlLoader.<ChoosePic>getController();
			controller.setUser2(player1, player2);
			Main.stage.setScene(new Scene(root, 1000,800));
			Main.stage.show();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		//choose the meme used for both players randomly
		
//		//run the meme generator for player 1
//		MemeGeneratorModel(player1);
//		//run the meme generator for player 2
//		MemeGeneratorModel(player2);
//		
//		//run the match voting method
//		//ivotedsticker.jpg
//		VoteModel(player1, player2);
		
		//choose the winner
		//ChooseWinner(player1, player2);
		
		return;
	}
	
	private boolean ChooseWinner(PlayerModel player1, PlayerModel player2) {
		//One does not simply choose a winner...
		boolean player1wins = false;
		//compare votes and advance players to the next round
		//tie breaker is total votes per player
		if(player1.votes == player2.votes) {			
			//player 1 wins
			if(player1.totalVotes >= player2.totalVotes) {
				this.Tournament[this.CurrentMatch+1] = null;
				player1wins = true;
			}
			//player 2 wins
			else
				this.Tournament[this.CurrentMatch] = null;
		}
				
		if(player1.votes >= player2.votes) {
			//player 1 wins
			this.Tournament[this.CurrentMatch+1] = null;
			player1wins = true;
		}
				
		else {
			//player2 wins
			this.Tournament[this.CurrentMatch] = null;
		}
				
		//reset the vote count for the next round
		//and increment total vote counts
		player1.totalVotes = 0;
		player2.totalVotes = 0;
			
		player1.votes = 0;
		player2.votes = 0;
		
		return player1wins;
	}
	
}
