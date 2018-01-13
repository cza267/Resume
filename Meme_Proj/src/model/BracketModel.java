package model;

import java.util.ArrayList;

/**
 * The BracketModel class will be passed an
 * ArrayList that has the players in the tournament.
 * 
 * It will define how a bracket is generated and
 * who plays in what match.
 * 
 * @author paul
 */
public abstract class BracketModel {
	
	private ArrayList<PlayerModel> Players;		//list of players in tournament
	public int[] Matches;					//list of rounds and number 
									//of players in the round
	public PlayerModel[] Tournament;		//the tournament bracket
	
	//Constructor
	public BracketModel(ArrayList<PlayerModel> players) {
		
		//TODO error check Players arraylist to ensure no bugs
		//We are assuming a valid positive integer number of players
		Players = players;
		
		//call tournament builder and set match methods
		SeededTournamentBuilder();
		SetMatches();
	}
	
	
	//Getters and Setters
	public ArrayList<PlayerModel> getPlayers() {
		return Players;
	}

	public void setPlayers(ArrayList<PlayerModel> players) {
		Players = players;
	}
	
	
	//Classmates: you can't just spend 20 hours rewriting
	//	code just because this one runs a little bit faster.
	//Me:
	private void SeededTournamentBuilder() {
		
		//for ease of use later
		int playNum = this.Players.size();

		//initialize the tournament bracket
		//with size up to next valid exponent of 2
		this.Tournament = new 
				PlayerModel[(int) Math.ceil((Math.log(playNum) / Math.log(2)))];
		
		//this stack will be used to keep track of the 
		//list of indices to be reassigned
		int[] AssignmentStack = new int[playNum/2 -1];
		AssignmentStack[this.Tournament.length/2 -1] = -1;

		//pair the first and last elements in the bracket
		this.Tournament[0] = this.Players.get(0);
		this.Tournament[1] = this.Players.get(playNum);
		
		//set the first position in the stack to players/2
		AssignmentStack[0] = this.Tournament.length/2;
		int assignments = 1;
		
		//iterate over the assignment stack until all 
		//assignments have been finished (this is the ugly part)
		for(int i=0; i<=(AssignmentStack.length); i++) {
			
			//place player into appropriate matches based on 
			//assignment stack index
			this.Tournament[AssignmentStack[i]] = this.Players.get(assignments);
			this.Tournament[AssignmentStack[i]] = this.Players.get(playNum-assignments);
			assignments++;
			
			//update the children of the current position in the stack
			if((i*2)+1 < (AssignmentStack.length)) {
				
				//you can't question the algorithm if you don't 
				//understand it **points to brain**
				AssignmentStack[(i*2)+1] = AssignmentStack[i] 
						+ playNum/(2^((int) Math.floor(Math.log(i+1)/Math.log(2))));
				AssignmentStack[(i*2)+2] = AssignmentStack[i] 
						- playNum/(2^((int) Math.floor(Math.log(i+1)/Math.log(2))));
				
			}
			else
				break;
		}
		
		return;
	}
	
	private void SetMatches() {
		
		//get number of players in the tournament
		int playNum = this.Players.size();
		this.Matches = new int[(int) Math.floor(Math.log(playNum)/Math.log(2))];
		
		//assign number of players in each match
		for(int match : Matches) {
			this.Matches[match] = playNum;
			playNum = playNum/2 + playNum%2;
		}
		
		return;
	}

}
