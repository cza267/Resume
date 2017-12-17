import java.awt.GridLayout;

import javax.swing.JFrame;

/**
 * Runs the application 
 * @author Cheyenne Sanchez
 * @version 1.8
 */
public class SortApplication extends JFrame {

	SortPanel panelA = new SortPanel();		
	
	public static void main( String[] args )
	{
		//Create a class object (window)
		SortApplication sortApp  = new SortApplication();
		
		//GUI Window Information
		sortApp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		sortApp.setSize(1000,600);
		sortApp.setLayout(new GridLayout(1,2));
		sortApp.setTitle("Sorting Animation");
		sortApp.setVisible(true);
		sortApp.setResizable(false);
	}
	
	public SortApplication()
	{	
		//Add the sort panel
		this.add(panelA);		
	}
}
