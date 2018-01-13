package controller;

import java.util.ArrayList;

import application.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.PlayerModel;

public class VotePage implements EventHandler<ActionEvent>{
	@FXML
	private TextArea ta1;
	@FXML
	private TextArea ta2;
	@FXML
	private Button vote1;
	@FXML
	private Button vote2;
	private int votes1;
	private int votes2;
	private Image img;
	private Image img2;
	private int sizeTourn;
	@FXML
	public ImageView imgView1;
	@FXML
	public ImageView imgView2;
	private PlayerModel play1;
	private PlayerModel play2;
	private int numMatch;
	private PlayerModel[] Match;
	private ArrayList<PlayerModel[]> Matches;
	private Button win;
	private PlayerModel winner;
	private ArrayList<PlayerModel> players = new ArrayList<PlayerModel>();
	private int numBye;
	private TournamentRunnerModel2 tourn;
	
	public void updateVotes1(ActionEvent event) {
		this.votes1+= 1;
		String string = Integer.toString(this.votes1);
		this.ta1.setText(string);
	}
	public void updateVotesDown1(ActionEvent event) {
		this.votes1-= 1;
		String string = Integer.toString(this.votes1);
		this.ta1.setText(string);
	}
	public void updateVotes2(ActionEvent event) {
		this.votes2+= 1;
		String string = Integer.toString(this.votes2);
		this.ta2.setText(string);
	}
	public void updateVotesDown2(ActionEvent event) {
		this.votes2-= 1;
		String string = Integer.toString(this.votes2);
		this.ta2.setText(string);
	}
	public void sendFunction(ActionEvent event) {
		// tie goes to player 1
		if (this.votes1 == this.votes2) {
			this.votes1 += 1;
		}
		Parent root;
		if (this.sizeTourn == 2) {
			try {
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/pvp.fxml")); 
				root = (Parent)fxmlLoader.load(); 
				PlayerVPlayer controller = fxmlLoader.<PlayerVPlayer>getController();
				controller.setUser(this.votes1, this.votes2);
				Main.stage.setScene(new Scene(root, 1000,800));
				Main.stage.show();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}else if(this.sizeTourn == 4) {
			this.play1.setVotes(this.votes1);
			this.play2.setVotes(this.votes2);
			if (this.play1.getVotes() >= this.play2.getVotes()) {
				this.winner = this.play1;
			}else {
				this.winner = this.play2;
			}
			this.play1.setTotalVotes(this.votes1);
			this.play2.setTotalVotes(this.votes2);
			try {
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/tourn4.fxml")); 
				root = (Parent)fxmlLoader.load(); 
				Tourn4Controller controller = fxmlLoader.<Tourn4Controller>getController();
				controller.setUser(this.players);
				controller.setUser3(this.winner);
				controller.setUser4(this.numMatch, this.numBye);
				Main.stage.setScene(new Scene(root, 1000,800));
				Main.stage.show();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}else if(this.sizeTourn == 8) {
			this.play1.setVotes(this.votes1);
			this.play2.setVotes(this.votes2);
			this.play1.setTotalVotes(this.votes1);
			this.play2.setTotalVotes(this.votes2);
			try {
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/tourn8.fxml")); 
				root = (Parent)fxmlLoader.load(); 
				Tourn8Controller controller = fxmlLoader.<Tourn8Controller>getController();
				controller.setUser3(this.winner);
				Main.stage.setScene(new Scene(root, 1000,800));
				Main.stage.show();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}else if(this.sizeTourn == 16) {
			this.play1.setVotes(this.votes1);
			this.play2.setVotes(this.votes2);
			this.play1.setTotalVotes(this.votes1);
			this.play2.setTotalVotes(this.votes2);
			try {
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/tourn16.fxml")); 
				root = (Parent)fxmlLoader.load(); 
				Tourn16Controller controller = fxmlLoader.<Tourn16Controller>getController();
				controller.setUser3(this.winner);
				Main.stage.setScene(new Scene(root, 1000,800));
				Main.stage.show();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	public void setUser(int player1Votes, int player2Votes){
		if(player1Votes > player2Votes) {
			this.win.setText("Player1 Wins");
		}else {
			this.win.setText("Player2 Wins");
		}
	}
	public void setUser1(Image image, Image image2, int size){
	    this.img = image;
	    this.img2 = image2;
	    this.sizeTourn = size;
	    
	}
	public void setUser2(PlayerModel play12, PlayerModel play22) {
		this.play1 = play12;
		this.play2 = play22;
	}
	public void setUser3(ArrayList<PlayerModel> playerlist, int matchNum) {
		this.players = playerlist;
		this.tourn = new TournamentRunnerModel2(playerlist, matchNum++);
	}
	public void setPics(ActionEvent event) {
		System.out.println("Set Test");
		imgView1.setImage(this.img);
		System.out.println("Set Test2");
	    imgView2.setImage(this.img2);
	}
	@Override
	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub
		
	}
	
}
