package model;
import java.util.ArrayList;
import controller.*;

public class PickPlayer {
	
	public ArrayList<PlayerModel> playerlist;

	int currentPlayerNum;
	
	public PickPlayer() {
		this.playerlist = new ArrayList<PlayerModel>();
		this.currentPlayerNum = 0;
	}
	public void update(String text, String tfText) {
		String name;
		if (text.equals("OK")) {
			name = tfText;
			playerlist.add(currentPlayerNum, new PlayerModel(name));
			currentPlayerNum++;
			
		}else if(text.equals("Play")) {
			// send playerList to tournament 
			//TournamentRunnerModel tourn = new TournamentRunnerModel(playerlist);
			TournamentController tourn = new TournamentController(playerlist);
		}
		
	}
}
