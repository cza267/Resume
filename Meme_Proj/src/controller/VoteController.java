package controller;


import application.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.VoteModel;

/**UNDER CONSTRUCTION PLZ IGNORE 
 * @auhor Danielle L
 * import javafx.event.EventHandler;
 */

	 
	import javafx.fxml.FXML;
	import javafx.scene.control.Slider;
	import javafx.scene.control.TextField;

	public class VoteController {
	
		VoteModel model = new VoteModel(1, 2);

	    @FXML
	    private Slider mySlider;
	    @FXML
	    private TextField textField;
	    
	    public void initialize() {

	        mySlider.valueProperty().addListener((observable, oldValue, newValue) -> {

	            textField.setText(Double.toString(newValue.intValue()));


	        });
	        
	    
		try {
			Parent root = FXMLLoader.load(getClass().getResource("../view/Vote.fxml"));
			Main.stage.setScene(new Scene(root, 1000, 800));
			Main.stage.show();
		} catch(Exception e) {
			e.printStackTrace();
			
		} 

	    }
	    
	
	}
	


 
