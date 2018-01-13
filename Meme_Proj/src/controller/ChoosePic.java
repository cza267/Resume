package controller;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import application.Main;
import javafx.application.Platform;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.FileChooser.ExtensionFilter;
import model.PlayerModel;
public class ChoosePic implements EventHandler<ActionEvent>{

	public ImageView imgView;
	private Image saved;
	private int sizeTourn;
	private PlayerModel play1;
	private PlayerModel play2;
	private int matchIndex;
	private int roundNum;
	private ArrayList<PlayerModel> players = new ArrayList<PlayerModel>();
	
	//public ArrayList<Image> list = new ArrayList<Image>();
	@Override
	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub
		
	}
	
	public void goHandle(ActionEvent event) {
		//TournamentCom comp = new TournamentCom(saved);
		System.out.println("Go pushed");
		
		/*try {
			Parent root;
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/TournamentCreate.fxml")); 
			root = (Parent)fxmlLoader.load(); 
			TournCreate controller = fxmlLoader.<TournCreate>getController();
			controller.setUser(saved, sizeTourn);
			Main.stage.setScene(new Scene(root, 1000,800));
			Main.stage.show();
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/
		if (!saved.equals(null)) {
			Parent root;
			try {
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/TournamentCreate.fxml")); 
				root = (Parent)fxmlLoader.load(); 
				TournCreate controller = fxmlLoader.<TournCreate>getController();
				controller.setUser(this.saved, this.sizeTourn);
				controller.setUser2(this.play1, this.play2);
				controller.setUser3(this.players, this.matchIndex);
				Main.stage.setScene(new Scene(root, 1000,800));
				Main.stage.show();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	public void setUser(int size){
	    this.sizeTourn = size;
	}
	public void setUser2(PlayerModel player1, PlayerModel player2) {
		this.play1 = player1;
		this.play2 = player2;
	}
	public void setUser3(ArrayList<PlayerModel> playerlist, int matchNum) {
		this.players = playerlist;
		this.matchIndex = matchNum;
	}
	public void setUser4(int roundNum) {
		this.roundNum = roundNum;
	}
	public void openFunction(ActionEvent event) throws IOException {		
		FileChooser choice = new FileChooser();
		choice.getExtensionFilters().addAll(new 
				ExtensionFilter("Images Files", "*.png", "*.jpg", "*.gif"));
		File selected = choice.showOpenDialog(null);
		if(selected != null) {
			String location = selected.toURI().toURL().toString();
			System.out.println( location);
			Image img = new Image(location);
			System.out.println("height: " +img.getHeight() + "\nWidth: " + img.getWidth());
			imgView.setImage(img);
			saved = img;
		}
	}	
	public void closeFunction(ActionEvent event) {
		Platform.exit();
		System.exit(0);
	}

}
