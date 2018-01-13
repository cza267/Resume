package controller;

import java.util.ArrayList;

import application.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import model.BracketModel;
import model.PlayerModel;

public class TournamentRunnerModel2{
	PlayerModel[] Match;
	PlayerModel[] Match2;
	public PlayerModel[] Tournament;
	public ArrayList<PlayerModel> Players = new ArrayList<PlayerModel>();
	public ArrayList<PlayerModel> Players2 = new ArrayList<PlayerModel>();
	public ArrayList<PlayerModel> Players4 = new ArrayList<PlayerModel>();
	public ArrayList<PlayerModel> Players8 = new ArrayList<PlayerModel>();
	public ArrayList<PlayerModel> Players16 = new ArrayList<PlayerModel>();
	public int roundNum;
	public int matchNum;
	public PlayerModel bye;
	public int sizeTourn;
	public TournamentRunnerModel2(ArrayList<PlayerModel> players) {
		super();
		//this.Players = players;
		this.bye = new PlayerModel("bye");
		this.Match = new PlayerModel[16];
		SeededTournamentBuilder(players);
		if(players.size() <= 4) {
			this.sizeTourn = 4;
		}else if(players.size() <= 8) {
			this.sizeTourn = 8;
		}else if(players.size() <= 16) {
			this.sizeTourn = 16;
		}
		this.roundNum = 1;
		this.matchNum = 1;
	}
	public TournamentRunnerModel2(ArrayList<PlayerModel> players, int iMatch) {
		super();
		//this.Players = players;
		this.bye = new PlayerModel("bye");
		this.Match = new PlayerModel[16];
		SeededTournamentBuilder(players);
		if(players.size() <= 4) {
			this.sizeTourn = 4;
		}else if(players.size() <= 8) {
			this.sizeTourn = 8;
		}else if(players.size() <= 16) {
			this.sizeTourn = 16;
		}
		this.roundNum = 1;
		this.matchNum = iMatch;
	}

	
	//methods
	public void RunRound() {
		
			if (this.roundNum == 1) {
				if (this.matchNum == 1) {
					if (this.Match[0].getName().equals("bye") || this.Match[1].getName().equals("bye")) {
						try {
							Parent root;
							FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/byeOption.fxml"));
							root = (Parent)fxmlLoader.load(); 
							ByeController controller = fxmlLoader.<ByeController>getController();
							controller.setUser2(this.Match[0], this.Match[1]);
							if(this.sizeTourn == 4) {
								this.matchNum++;
								controller.setUser3(Players4, this.matchNum);
							}else if(this.sizeTourn == 8) {
								controller.setUser3(Players8, this.matchNum);
								this.matchNum++;
							}else if(this.sizeTourn == 16) {
								controller.setUser3(Players16, this.matchNum);
								this.matchNum++;
							}
							
							Main.stage.setScene(new Scene(root, 1000,800));
							Main.stage.show();
						}catch(Exception e) {
							e.printStackTrace();
						}
					}else {
						try {
							Parent root;
							FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/choosePic.fxml")); 
							root = (Parent)fxmlLoader.load(); 
							ChoosePic controller = fxmlLoader.<ChoosePic>getController();
							controller.setUser(this.sizeTourn);
							controller.setUser2(this.Match[0], this.Match[1]);
							if (this.sizeTourn == 4) {
								this.matchNum++;
								controller.setUser3(this.Players4, this.matchNum);
							}else if(this.sizeTourn == 8) {
								this.matchNum++;
								controller.setUser3(this.Players8, this.matchNum);
								
							}else if (this.sizeTourn == 16) {
								this.matchNum++;
								controller.setUser3(this.Players16, this.matchNum);
								
							}
							
							Main.stage.setScene(new Scene(root, 1000,800));
							Main.stage.show();
						}catch(Exception e) {
							e.printStackTrace();
						}
					}
					
				
				
			}else if(this.matchNum == 2) {
				if (this.Match[2].getName().equals("bye") || this.Match[3].getName().equals("bye")) {
					try {
						Parent root;
						FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/byeOption.fxml"));
						root = (Parent)fxmlLoader.load(); 
						ByeController controller = fxmlLoader.<ByeController>getController();
						controller.setUser2(this.Match[2], this.Match[3]);
						if(this.sizeTourn == 4) {
							controller.setUser3(Players4, this.matchNum);
							this.matchNum = 1;
							this.roundNum++;
						}else if(this.sizeTourn == 8) {
							controller.setUser3(Players8, this.matchNum);
							this.matchNum++;
						}else if(this.sizeTourn == 16) {
							controller.setUser3(Players16, this.matchNum);
							this.matchNum++;
						}
						
						Main.stage.setScene(new Scene(root, 1000,800));
						Main.stage.show();
					}catch(Exception e) {
						e.printStackTrace();
					}
				}else {
					try {
						Parent root;
						FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/choosePic.fxml")); 
						root = (Parent)fxmlLoader.load(); 
						ChoosePic controller = fxmlLoader.<ChoosePic>getController();
						controller.setUser(this.sizeTourn);
						controller.setUser2(this.Match[2], this.Match[3]);
						if (this.sizeTourn == 4) {
							controller.setUser3(this.Players4, this.matchNum);
							this.matchNum = 1;
							this.roundNum++;
							controller.setUser4(this.roundNum);
						}else if(this.sizeTourn == 8) {
							controller.setUser3(this.Players8, this.matchNum);
							this.matchNum++;
						}else if (this.sizeTourn == 16) {
							controller.setUser3(this.Players16, this.matchNum);
							this.matchNum++;
						}
						
						Main.stage.setScene(new Scene(root, 1000,800));
						Main.stage.show();
					}catch(Exception e) {
						e.printStackTrace();
					}
				}
				
			}else if(this.matchNum == 3) {
				if (this.Match[4].getName().equals("bye") || this.Match[5].getName().equals("bye")) {
					try {
						Parent root;
						FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/byeOption.fxml"));
						root = (Parent)fxmlLoader.load(); 
						ByeController controller = fxmlLoader.<ByeController>getController();
						controller.setUser2(this.Match[4], this.Match[5]);
						if(this.sizeTourn == 4) {
							controller.setUser3(Players4, this.matchNum);
							this.matchNum++;
							this.roundNum++;
						}else if(this.sizeTourn == 8) {
							controller.setUser3(Players8, this.matchNum);
							this.matchNum++;
						}else if(this.sizeTourn == 16) {
							controller.setUser3(Players16, this.matchNum);
							this.matchNum++;
						}
						
						Main.stage.setScene(new Scene(root, 1000,800));
						Main.stage.show();
					}catch(Exception e) {
						e.printStackTrace();
					}
					
				}else {
					try {
						Parent root;
						FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/choosePic.fxml")); 
						root = (Parent)fxmlLoader.load(); 
						ChoosePic controller = fxmlLoader.<ChoosePic>getController();
						controller.setUser(this.sizeTourn);
						controller.setUser2(this.Match[4], this.Match[5]);
						if (this.sizeTourn == 4) {
							controller.setUser3(this.Players4, this.matchNum);
							this.matchNum++;
							this.roundNum++;
						}else if(this.sizeTourn == 8) {
							controller.setUser3(this.Players8, this.matchNum);
							this.matchNum++;
						}else if (this.sizeTourn == 16) {
							controller.setUser3(this.Players16, this.matchNum);
							this.matchNum++;
						}
						
						Main.stage.setScene(new Scene(root, 1000,800));
						Main.stage.show();
					}catch(Exception e) {
						e.printStackTrace();
					}
				}
			}else if(this.matchNum == 4) {
				if (this.Match[6].getName().equals("bye") || this.Match[7].getName().equals("bye")) {
					try {
						Parent root;
						FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/byeOption.fxml"));
						root = (Parent)fxmlLoader.load(); 
						ByeController controller = fxmlLoader.<ByeController>getController();
						controller.setUser2(this.Match[6], this.Match[7]);
						if(this.sizeTourn == 4) {
							controller.setUser3(Players4, this.matchNum);
						}else if(this.sizeTourn == 8) {
							controller.setUser3(Players8, this.matchNum);
						}else if(this.sizeTourn == 16) {
							controller.setUser3(Players16, this.matchNum);
						}
						//this.matchNum++;
						if (this.sizeTourn == 8) {
							this.matchNum = 1;
							this.roundNum++;
						}
						Main.stage.setScene(new Scene(root, 1000,800));
						Main.stage.show();
					}catch(Exception e) {
						e.printStackTrace();
					}
				}else {
					try {
						Parent root;
						FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/choosePic.fxml")); 
						root = (Parent)fxmlLoader.load(); 
						ChoosePic controller = fxmlLoader.<ChoosePic>getController();
						controller.setUser(this.sizeTourn);
						controller.setUser2(this.Match[6], this.Match[7]);
						if (this.sizeTourn == 4) {
							controller.setUser3(this.Players4, this.matchNum);
						}else if(this.sizeTourn == 8) {
							controller.setUser3(this.Players8, this.matchNum);
						}else if (this.sizeTourn == 16) {
							controller.setUser3(this.Players16, this.matchNum);
						}
						this.matchNum++;
						if (this.sizeTourn == 8) {
							this.matchNum = 1;
							this.roundNum++;
						}
						Main.stage.setScene(new Scene(root, 1000,800));
						Main.stage.show();
					}catch(Exception e) {
						e.printStackTrace();
					}
				}
			}else if(this.matchNum == 5) {
				if (this.Match[8].getName().equals("bye") || this.Match[9].getName().equals("bye")) {
					try {
					Parent root;
					FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/byeOption.fxml"));
					root = (Parent)fxmlLoader.load(); 
					ByeController controller = fxmlLoader.<ByeController>getController();
					controller.setUser2(this.Match[8], this.Match[9]);
					if(this.sizeTourn == 4) {
						controller.setUser3(Players4, this.matchNum);
					}else if(this.sizeTourn == 8) {
						controller.setUser3(Players8, this.matchNum);
					}else if(this.sizeTourn == 16) {
						controller.setUser3(Players16, this.matchNum);
					}
					this.matchNum++;
					Main.stage.setScene(new Scene(root, 1000,800));
					Main.stage.show();
					}catch(Exception e) {
						e.printStackTrace();
					}
				}else {
					try {
						Parent root;
						FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/choosePic.fxml")); 
						root = (Parent)fxmlLoader.load(); 
						ChoosePic controller = fxmlLoader.<ChoosePic>getController();
						controller.setUser(this.sizeTourn);
						controller.setUser2(this.Match[8], this.Match[9]);
						if (this.sizeTourn == 4) {
							controller.setUser3(this.Players4, this.matchNum);
						}else if(this.sizeTourn == 8) {
							controller.setUser3(this.Players8, this.matchNum);
						}else if (this.sizeTourn == 16) {
							controller.setUser3(this.Players16, this.matchNum);
						}
						this.matchNum++;
						Main.stage.setScene(new Scene(root, 1000,800));
						Main.stage.show();
					}catch(Exception e) {
						e.printStackTrace();
					}
				}
			}else if(this.matchNum == 6) {
				if (this.Match[10].getName().equals("bye") || this.Match[11].getName().equals("bye")) {
					try {
					Parent root;
					FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/byeOption.fxml"));
					root = (Parent)fxmlLoader.load(); 
					ByeController controller = fxmlLoader.<ByeController>getController();
					controller.setUser2(this.Match[10], this.Match[11]);
					if(this.sizeTourn == 4) {
						controller.setUser3(Players4, this.matchNum);
					}else if(this.sizeTourn == 8) {
						controller.setUser3(Players8, this.matchNum);
					}else if(this.sizeTourn == 16) {
						controller.setUser3(Players16, this.matchNum);
					}
					this.matchNum++;
					Main.stage.setScene(new Scene(root, 1000,800));
					Main.stage.show();
					}catch(Exception e) {
						e.printStackTrace();
					}
				}else {
					try {
						Parent root;
						FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/choosePic.fxml")); 
						root = (Parent)fxmlLoader.load(); 
						ChoosePic controller = fxmlLoader.<ChoosePic>getController();
						controller.setUser(this.sizeTourn);
						controller.setUser2(this.Match[10], this.Match[11]);
						if (this.sizeTourn == 4) {
							controller.setUser3(this.Players4, this.matchNum);
						}else if(this.sizeTourn == 8) {
							controller.setUser3(this.Players8, this.matchNum);
						}else if (this.sizeTourn == 16) {
							controller.setUser3(this.Players16, this.matchNum);
						}
						this.matchNum++;
						Main.stage.setScene(new Scene(root, 1000,800));
						Main.stage.show();
					}catch(Exception e) {
						e.printStackTrace();
					}
				}
			}else if(this.matchNum == 7) {
				if (this.Match[12].getName().equals("bye") || this.Match[13].getName().equals("bye")) {
					try {
					Parent root;
					FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/byeOption.fxml"));
					root = (Parent)fxmlLoader.load(); 
					ByeController controller = fxmlLoader.<ByeController>getController();
					controller.setUser2(this.Match[12], this.Match[13]);
					if(this.sizeTourn == 4) {
						controller.setUser3(Players4, this.matchNum);
					}else if(this.sizeTourn == 8) {
						controller.setUser3(Players8, this.matchNum);
					}else if(this.sizeTourn == 16) {
						controller.setUser3(Players16, this.matchNum);
					}
					this.matchNum++;
					Main.stage.setScene(new Scene(root, 1000,800));
					Main.stage.show();
					}catch(Exception e) {
						e.printStackTrace();
					}
				}else {
					try {
						Parent root;
						FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/choosePic.fxml")); 
						root = (Parent)fxmlLoader.load(); 
						ChoosePic controller = fxmlLoader.<ChoosePic>getController();
						controller.setUser(this.sizeTourn);
						controller.setUser2(this.Match[12], this.Match[13]);
						if (this.sizeTourn == 4) {
							controller.setUser3(this.Players4, this.matchNum);
						}else if(this.sizeTourn == 8) {
							controller.setUser3(this.Players8, this.matchNum);
						}else if (this.sizeTourn == 16) {
							controller.setUser3(this.Players16, this.matchNum);
						}
						this.matchNum++;
						Main.stage.setScene(new Scene(root, 1000,800));
						Main.stage.show();
					}catch(Exception e) {
						e.printStackTrace();
					}
				}
			}else if(this.matchNum == 8) {
				if (this.Match[14].getName().equals("bye") || this.Match[15].getName().equals("bye")) {
					try {
					Parent root;
					FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/byeOption.fxml"));
					root = (Parent)fxmlLoader.load(); 
					ByeController controller = fxmlLoader.<ByeController>getController();
					controller.setUser2(this.Match[14], this.Match[15]);
					if(this.sizeTourn == 4) {
						controller.setUser3(Players4, this.matchNum);
					}else if(this.sizeTourn == 8) {
						controller.setUser3(Players8, this.matchNum);
					}else if(this.sizeTourn == 16) {
						controller.setUser3(Players16, this.matchNum);
					}
					this.matchNum++;
					if (this.sizeTourn == 16) {
						this.matchNum = 1;
						this.roundNum++;
					}
					Main.stage.setScene(new Scene(root, 1000,800));
					Main.stage.show();
					}catch(Exception e) {
						e.printStackTrace();
					}
				}else {
					try {
						Parent root;
						FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/choosePic.fxml")); 
						root = (Parent)fxmlLoader.load(); 
						ChoosePic controller = fxmlLoader.<ChoosePic>getController();
						controller.setUser(this.sizeTourn);
						controller.setUser2(this.Match[14], this.Match[15]);
						if (this.sizeTourn == 4) {
							controller.setUser3(this.Players4, this.matchNum);
						}else if(this.sizeTourn == 8) {
							controller.setUser3(this.Players8, this.matchNum);
						}else if (this.sizeTourn == 16) {
							controller.setUser3(this.Players16, this.matchNum);
						}
						if (this.sizeTourn == 16) {
							this.matchNum = 1;
							this.roundNum++;
						}
						
						Main.stage.setScene(new Scene(root, 1000,800));
						Main.stage.show();
					}catch(Exception e) {
						e.printStackTrace();
					}
				}
				
			}
			}else if (this.roundNum == 2) {
				if (this.matchNum == 1) {
					if (this.Match[0].getName().equals("bye") || this.Match[1].getName().equals("bye")) {
						try {
						Parent root;
						FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/byeOption.fxml"));
						root = (Parent)fxmlLoader.load(); 
						ByeController controller = fxmlLoader.<ByeController>getController();
						controller.setUser2(this.Match[0], this.Match[1]);
						if(this.sizeTourn == 4) {
							controller.setUser3(Players4, this.matchNum);
							this.matchNum = 1;
							this.roundNum++;
						}else if(this.sizeTourn == 8) {
							controller.setUser3(Players8, this.matchNum);
							this.matchNum++;
						}else if(this.sizeTourn == 16) {
							controller.setUser3(Players16, this.matchNum);
							this.matchNum++;
						}
						
						Main.stage.setScene(new Scene(root, 1000,800));
						Main.stage.show();
						}catch(Exception e) {
							e.printStackTrace();
						}
					}else {
						try {
							Parent root;
							FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/choosePic.fxml")); 
							root = (Parent)fxmlLoader.load(); 
							ChoosePic controller = fxmlLoader.<ChoosePic>getController();
							controller.setUser(this.sizeTourn);
							controller.setUser2(this.Match[0], this.Match[1]);
							if (this.sizeTourn == 4) {
								controller.setUser3(this.Players4, this.matchNum);
							}else if(this.sizeTourn == 8) {
								controller.setUser3(this.Players8, this.matchNum);
							}else if (this.sizeTourn == 16) {
								controller.setUser3(this.Players16, this.matchNum);
							}
							this.matchNum++;
							Main.stage.setScene(new Scene(root, 1000,800));
							Main.stage.show();
						}catch(Exception e) {
							e.printStackTrace();
						}
					}
				}else if(this.matchNum == 2) {
					if (this.Match[2].getName().equals("bye") || this.Match[3].getName().equals("bye")) {
						try {
						Parent root;
						FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/byeOption.fxml"));
						root = (Parent)fxmlLoader.load(); 
						ByeController controller = fxmlLoader.<ByeController>getController();
						controller.setUser2(this.Match[2], this.Match[3]);
						if(this.sizeTourn == 4) {
							controller.setUser3(Players4, this.matchNum);
						}else if(this.sizeTourn == 8) {
							controller.setUser3(Players8, this.matchNum);
						}else if(this.sizeTourn == 16) {
							controller.setUser3(Players16, this.matchNum);
						}
						this.matchNum++;
						Main.stage.setScene(new Scene(root, 1000,800));
						Main.stage.show();
						}catch(Exception e) {
							e.printStackTrace();
						}
					}else {
						try {
							Parent root;
							FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/choosePic.fxml")); 
							root = (Parent)fxmlLoader.load(); 
							ChoosePic controller = fxmlLoader.<ChoosePic>getController();
							controller.setUser(this.sizeTourn);
							controller.setUser2(this.Match[2], this.Match[3]);
							if (this.sizeTourn == 4) {
								controller.setUser3(this.Players4, this.matchNum);
							}else if(this.sizeTourn == 8) {
								controller.setUser3(this.Players8, this.matchNum);
							}else if (this.sizeTourn == 16) {
								controller.setUser3(this.Players16, this.matchNum);
							}
							this.matchNum++;
							Main.stage.setScene(new Scene(root, 1000,800));
							Main.stage.show();
						}catch(Exception e) {
							e.printStackTrace();
						}
					}
				}else if(this.matchNum == 3) {
					if (this.Match[4].getName().equals("bye") || this.Match[5].getName().equals("bye")) {
						try {
						Parent root;
						FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/byeOption.fxml"));
						root = (Parent)fxmlLoader.load(); 
						ByeController controller = fxmlLoader.<ByeController>getController();
						controller.setUser2(this.Match[4], this.Match[5]);
						if(this.sizeTourn == 4) {
							controller.setUser3(Players4,this.matchNum);
						}else if(this.sizeTourn == 8) {
							controller.setUser3(Players8, this.matchNum);
						}else if(this.sizeTourn == 16) {
							controller.setUser3(Players16, this.matchNum);
						}
						this.matchNum++;
						Main.stage.setScene(new Scene(root, 1000,800));
						Main.stage.show();
						}catch(Exception e) {
							e.printStackTrace();
						}
					}else {
						try {
							Parent root;
							FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/choosePic.fxml")); 
							root = (Parent)fxmlLoader.load(); 
							ChoosePic controller = fxmlLoader.<ChoosePic>getController();
							controller.setUser(this.sizeTourn);
							controller.setUser2(this.Match[4], this.Match[5]);
							if (this.sizeTourn == 4) {
								controller.setUser3(this.Players4, this.matchNum);
							}else if(this.sizeTourn == 8) {
								controller.setUser3(this.Players8, this.matchNum);
							}else if (this.sizeTourn == 16) {
								controller.setUser3(this.Players16, this.matchNum);
							}
							this.matchNum++;
							Main.stage.setScene(new Scene(root, 1000,800));
							Main.stage.show();
						}catch(Exception e) {
							e.printStackTrace();
						}
					}
				}else if(this.matchNum == 4) {
					if (this.Match[6].getName().equals("bye") || this.Match[7].getName().equals("bye")) {
						try {
						Parent root;
						FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/byeOption.fxml"));
						root = (Parent)fxmlLoader.load(); 
						ByeController controller = fxmlLoader.<ByeController>getController();
						controller.setUser2(this.Match[6], this.Match[7]);
						if(this.sizeTourn == 4) {
							controller.setUser3(Players4, this.matchNum);
						}else if(this.sizeTourn == 8) {
							controller.setUser3(Players8, this.matchNum);
						}else if(this.sizeTourn == 16) {
							controller.setUser3(Players16, this.matchNum);
						}
						this.matchNum++;
						this.roundNum++;
						Main.stage.setScene(new Scene(root, 1000,800));
						Main.stage.show();
						}catch(Exception e) {
							e.printStackTrace();
						}
					}else {
						try {
							Parent root;
							FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/choosePic.fxml")); 
							root = (Parent)fxmlLoader.load(); 
							ChoosePic controller = fxmlLoader.<ChoosePic>getController();
							controller.setUser(this.sizeTourn);
							controller.setUser2(this.Match[6], this.Match[7]);
							if (this.sizeTourn == 4) {
								controller.setUser3(this.Players4, this.matchNum);
							}else if(this.sizeTourn == 8) {
								controller.setUser3(this.Players8, this.matchNum);
							}else if (this.sizeTourn == 16) {
								controller.setUser3(this.Players16, this.matchNum);
							}
							this.matchNum = 1;
							this.roundNum++;
							Main.stage.setScene(new Scene(root, 1000,800));
							Main.stage.show();
						}catch(Exception e) {
							e.printStackTrace();
						}
					}
				}
			}else if (this.roundNum == 3) {
				if (this.matchNum == 1) {
					if (this.Match[0].getName().equals("bye") || this.Match[1].getName().equals("bye")) {
						try {
						Parent root;
						FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/byeOption.fxml"));
						root = (Parent)fxmlLoader.load(); 
						ByeController controller = fxmlLoader.<ByeController>getController();
						controller.setUser2(this.Match[0], this.Match[1]);
						if(this.sizeTourn == 4) {
							this.matchNum++;
							controller.setUser3(Players4, this.matchNum);
						}else if(this.sizeTourn == 8) {
							this.matchNum++;
							controller.setUser3(Players8, this.matchNum);
						}else if(this.sizeTourn == 16) {
							controller.setUser3(Players16, this.matchNum);
							this.matchNum++;
						}
						
						Main.stage.setScene(new Scene(root, 1000,800));
						Main.stage.show();
						}catch(Exception e) {
							e.printStackTrace();
						}
					}else {
						try {
							Parent root;
							FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/choosePic.fxml")); 
							root = (Parent)fxmlLoader.load(); 
							ChoosePic controller = fxmlLoader.<ChoosePic>getController();
							controller.setUser(this.sizeTourn);
							controller.setUser2(this.Match[0], this.Match[1]);
							if (this.sizeTourn == 4) {
								this.matchNum++;
								controller.setUser3(this.Players4, this.matchNum);
							}else if(this.sizeTourn == 8) {
								this.matchNum++;
								controller.setUser3(this.Players8, this.matchNum);
							}else if (this.sizeTourn == 16) {
								this.matchNum++;
								controller.setUser3(this.Players16, this.matchNum);
							}
							
							Main.stage.setScene(new Scene(root, 1000,800));
							Main.stage.show();
						}catch(Exception e) {
							e.printStackTrace();
						}
					}
				}else if(this.matchNum == 2) {
					if (this.Match[2].getName().equals("bye") || this.Match[3].getName().equals("bye")) {
						try {
						Parent root;
						FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/byeOption.fxml"));
						root = (Parent)fxmlLoader.load(); 
						ByeController controller = fxmlLoader.<ByeController>getController();
						controller.setUser2(this.Match[2], this.Match[3]);
						if(this.sizeTourn == 4) {
							this.matchNum++;
							controller.setUser3(Players4, this.matchNum);
						}else if(this.sizeTourn == 8) {
							this.matchNum++;
							controller.setUser3(Players8, this.matchNum);
						}else if(this.sizeTourn == 16) {
							this.matchNum++;
							controller.setUser3(Players16, this.matchNum);
						}
						
						Main.stage.setScene(new Scene(root, 1000,800));
						Main.stage.show();
						}catch(Exception e) {
							e.printStackTrace();
						}
					}else {
						try {
							Parent root;
							FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/choosePic.fxml")); 
							root = (Parent)fxmlLoader.load(); 
							ChoosePic controller = fxmlLoader.<ChoosePic>getController();
							controller.setUser(this.sizeTourn);
							controller.setUser2(this.Match[2], this.Match[3]);
							if (this.sizeTourn == 4) {
								this.matchNum++;
								controller.setUser3(this.Players4, this.matchNum);
							}else if(this.sizeTourn == 8) {
								this.matchNum++;
								controller.setUser3(this.Players8, this.matchNum);
							}else if (this.sizeTourn == 16) {
								this.matchNum++;
								controller.setUser3(this.Players16, this.matchNum);
							}
							
							this.roundNum++;
							this.matchNum = 1;
							Main.stage.setScene(new Scene(root, 1000,800));
							Main.stage.show();
						}catch(Exception e) {
							e.printStackTrace();
						}
					}
					
					
				}
			}
			
			
			
	}
	private void SeededTournamentBuilder(ArrayList<PlayerModel> players) {
		
		//for ease of use later
		int playNum = players.size();
		System.out.println(players.size());
		//initialize the tournament bracket
		//with size up to next valid exponent of 2
		
		switch(playNum) {
		case(3):
			this.Players4.add(players.get(0));
			this.Players4.add(null);
			this.Players4.add(players.get(1));
			this.Players4.add(players.get(2));
			break;
		case(4):
			this.Players4.add(players.get(0));
			this.Players4.add(players.get(1));
			this.Players4.add(players.get(2));
			this.Players4.add(players.get(3));
			break;
		case(5):
			this.Players8.add(players.get(0));
			this.Players8.add(null);
			this.Players8.add(players.get(1));
			this.Players8.add(null);
			this.Players8.add(players.get(2));
			this.Players8.add(null);
			this.Players8.add(players.get(3));
			this.Players8.add(players.get(4));
			break;
		case(6):
			this.Players8.add(players.get(0));
			this.Players8.add(players.get(1));
			this.Players8.add(players.get(2));
			this.Players8.add(null);
			this.Players8.add(players.get(3));
			this.Players8.add(players.get(4));
			this.Players8.add(players.get(5));
			this.Players8.add(null);
			break;
		case(7):
			this.Players8.add(players.get(0));
			this.Players8.add(players.get(1));
			this.Players8.add(players.get(2));
			this.Players8.add(players.get(3));
			this.Players8.add(players.get(4));
			this.Players8.add(players.get(5));
			this.Players8.add(players.get(6));
			this.Players8.add(null);
			break;
		case(8):
			this.Players8.add(players.get(0));
			this.Players8.add(players.get(1));
			this.Players8.add(players.get(2));
			this.Players8.add(players.get(3));
			this.Players8.add(players.get(4));
			this.Players8.add(players.get(5));
			this.Players8.add(players.get(6));
			this.Players8.add(players.get(7));
			break;
		case(9):
			this.Players16.add(players.get(0));
			this.Players16.add(null);
			this.Players16.add(players.get(1));
			this.Players16.add(null);
			this.Players16.add(players.get(2));
			this.Players16.add(null);
			this.Players16.add(players.get(3));
			this.Players16.add(players.get(4));
			this.Players16.add(players.get(5));
			this.Players16.add(null);
			this.Players16.add(players.get(6));
			this.Players16.add(null);
			this.Players16.add(players.get(7));
			this.Players16.add(null);
			this.Players16.add(players.get(8));
			this.Players16.add(null);
			break;
		case(10):
			this.Players16.add(players.get(0));
			this.Players16.add(null);
			this.Players16.add(players.get(1));
			this.Players16.add(null);
			this.Players16.add(players.get(2));
			this.Players16.add(null);
			this.Players16.add(players.get(3));
			this.Players16.add(null);
			this.Players16.add(players.get(4));
			this.Players16.add(null);
			this.Players16.add(players.get(5));
			this.Players16.add(players.get(6));
			this.Players16.add(players.get(7));
			this.Players16.add(null);
			this.Players16.add(players.get(8));
			this.Players16.add(players.get(9));
			break;
		case(11):
			this.Players16.add(players.get(0));
			this.Players16.add(null);
			this.Players16.add(players.get(1));
			this.Players16.add(players.get(2));
			this.Players16.add(players.get(3));
			this.Players16.add(null);
			this.Players16.add(players.get(4));
			this.Players16.add(null);
			this.Players16.add(players.get(5));
			this.Players16.add(null);
			this.Players16.add(players.get(6));
			this.Players16.add(players.get(7));
			this.Players16.add(players.get(8));
			this.Players16.add(null);
			this.Players16.add(players.get(9));
			this.Players16.add(players.get(10));
			break;
		case(12):
			this.Players16.add(players.get(0));
			this.Players16.add(null);
			this.Players16.add(players.get(1));
			this.Players16.add(players.get(2));
			this.Players16.add(players.get(3));
			this.Players16.add(players.get(4));
			this.Players16.add(players.get(5));
			this.Players16.add(null);
			this.Players16.add(players.get(6));
			this.Players16.add(players.get(7));
			this.Players16.add(players.get(8));
			this.Players16.add(players.get(9));
			this.Players16.add(players.get(10));
			this.Players16.add(null);
			this.Players16.add(players.get(11));
			this.Players16.add(null);
			break;
		case(13):
			this.Players16.add(players.get(0));
			this.Players16.add(null);
			this.Players16.add(players.get(1));
			this.Players16.add(players.get(2));
			this.Players16.add(players.get(3));
			this.Players16.add(players.get(4));
			this.Players16.add(players.get(5));
			this.Players16.add(null);
			this.Players16.add(players.get(6));
			this.Players16.add(players.get(7));
			this.Players16.add(players.get(8));
			this.Players16.add(players.get(9));
			this.Players16.add(null);
			this.Players16.add(players.get(10));
			this.Players16.add(players.get(11));
			this.Players16.add(players.get(12));
			break;
		case(14):
			this.Players16.add(players.get(0));
			this.Players16.add(players.get(1));
			this.Players16.add(players.get(2));
			this.Players16.add(players.get(3));
			this.Players16.add(null);
			this.Players16.add(players.get(4));
			this.Players16.add(players.get(5));
			this.Players16.add(players.get(6));
			this.Players16.add(players.get(7));
			this.Players16.add(players.get(8));
			this.Players16.add(null);
			this.Players16.add(players.get(9));
			this.Players16.add(players.get(10));
			this.Players16.add(players.get(11));
			this.Players16.add(players.get(12));
			this.Players16.add(players.get(13));
			break;
		case(15):
			this.Players16.add(players.get(0));
			this.Players16.add(players.get(1));
			this.Players16.add(players.get(2));
			this.Players16.add(players.get(3));
			this.Players16.add(players.get(4));
			this.Players16.add(players.get(5));
			this.Players16.add(players.get(6));
			this.Players16.add(players.get(7));
			this.Players16.add(players.get(8));
			this.Players16.add(players.get(9));
			this.Players16.add(players.get(10));
			this.Players16.add(players.get(11));
			this.Players16.add(players.get(12));
			this.Players16.add(null);
			this.Players16.add(players.get(13));
			this.Players16.add(players.get(14));
			break;
		case(16):
			this.Players16.add(players.get(0));
			this.Players16.add(players.get(1));
			this.Players16.add(players.get(2));
			this.Players16.add(players.get(3));
			this.Players16.add(players.get(4));
			this.Players16.add(players.get(5));
			this.Players16.add(players.get(6));
			this.Players16.add(players.get(7));
			this.Players16.add(players.get(8));
			this.Players16.add(players.get(9));
			this.Players16.add(players.get(10));
			this.Players16.add(players.get(11));
			this.Players16.add(players.get(12));
			this.Players16.add(players.get(13));
			this.Players16.add(players.get(14));
			this.Players16.add(players.get(15));
			break;
		default:
			break;
		}

		
		//this stack will be used to keep track of the 
		//list of indices to be reassigned
		
		/*int[] AssignmentStack = new int[playNum/2 -1];
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
		*/
	}

}
