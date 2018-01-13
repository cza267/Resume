package controller;
 
import model.CalculatorModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Button;

/**
 * Controller to connect event of buttons to their corresponding operations
 * @author Cheyenne Sanchez
 * @version 1.0
 */
public class CalculatorController implements EventHandler<ActionEvent> {
	
	@FXML
	private Label label;
	
	private CalculatorModel model;
	
		
	public CalculatorController() {
		this.model = new CalculatorModel();		
	}
	
	/**
	 * Handler for action events of buttons
	 */
	@Override
	public void handle(ActionEvent event) {
			Button button = (Button)event.getSource();
			this.model.update(button.getText());
			this.label.setText(model.getValue());
	}	
}
