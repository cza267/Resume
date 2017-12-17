import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * A panel that holds all methods for functions corresponding buttons
 * to sort an array of integer and animates the sorting of array
 * @author Cheyenne Sanchez
 * @version 1.8 
 *
 */
public class SortPanel extends JPanel {

	
	/**
	 * A JButton that populates the array to be sorted
	 */
	private JButton populateArray = new JButton("Populate Array");
	
	/**
	 * A JButton that sorts the array
	 */
	private JButton sortButton = new JButton("Sort");
				
	/**
	 * String array for the sorting methods
	 */
	private String[] sortMethods = { "Selection", "Quick", "Bubble",  "Insertion", "Merge"};
		
	/**
	 * A JComboBox that lists the sorting methods
	 */
	private JComboBox sortTypes = new JComboBox<>(sortMethods);
		
	/**
	 * Integer array to be sorted
	 */
	private int[] integerArray = new int[10];
		
	/**
	 * Integer representing the default speed of the sorting
	 */
	int speed = 500; 
		
	/**
	 * String array for the speeds
	 */
	private String[] speedArray = { "Medium", "Slow", "Fast"};
		
	/**
	 * A JComboBox that lists the speeds
	 */
	private JComboBox speeds = new JComboBox<>(speedArray);
	
	/**
	 * A JTextField where the user enters 10 numbers
	 */
	private JTextField userInput;
		
		
		
	/**
	 * Sets up a panel and adds components
	 */
	public SortPanel(){
		
		//Create a SortAnimationPanel and add it to the sort panel
		final SortAnimationPanel topPanel = new SortAnimationPanel();
		this.add(topPanel);
						
		//Create a panel to hold the controls
		JPanel controlPanel = new JPanel();
			
		//Set the control panel layout to centered flow layout
		controlPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		JLabel label = new JLabel("Enter 10  numbers, 1-53:");
		controlPanel.add(label);
		label.setForeground(new Color(52, 229, 92));
		label.setFont(new Font("Courier New", Font.BOLD, 17));
		userInput = new JTextField(20);
			
		//Add the controls to the control panel
		controlPanel.add(userInput);
		controlPanel.add(populateArray);
		controlPanel.add(sortButton);
		controlPanel.add(sortTypes);
		controlPanel.add(speeds);
		controlPanel.setBackground(new Color(92,96,77));
						
		//Disable the sort button
		sortButton.setEnabled(false);
			
		//Add the control panel to the sort panel
		this.add(controlPanel);
		controlPanel.setVisible(true);
		
		/**
		 * Registers the listener for the populateArray and sort buttons
		 */
		//When the populate array button is pressed fill it with user entered numbers and display it. 
		//Also enable the sort button and populate button
		populateArray.addActionListener(new ActionListener(){ 
			public void actionPerformed(ActionEvent e){
	            	
				ArrayList<Integer> allowed = new ArrayList<Integer>();
				for(int i = 1; i< 54; i++)
					allowed.add(i);
				String input = userInput.getText();
				String values = input.replaceAll(" ",",");
				String delims = "[ ,]+";
				String[] numbers = values.split(delims);
					
				if(numbers.length != 10){
					JOptionPane.showMessageDialog(null,"Must enter 10 numbers");
					return;
				}				
				for (String tok : numbers)
				{
					try
					{
						if(!(allowed.contains(Integer.parseInt(tok))))
						{
							JOptionPane.showMessageDialog(null, "All numbers must be bewtween 1 and 53");
							return;
						}
					}
					catch(NumberFormatException e1)//In case the user enters something unacceptable.
					{
						JOptionPane.showMessageDialog(null, " ["+tok+"] is not a valid number!");
						return;	
					}			
				}
				//array of user entered values
				for(int i=0; i< integerArray.length; i++)
				{
					integerArray[i] = Integer.parseInt(numbers[i]);
				}
				repaint();
	       	}
		});
				//Enable populate button and sort button
				sortButton.setEnabled(true);
				populateArray.setEnabled(true);
					
			//When the sort button is pressed call the appropriate sort method
			sortButton.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent f)
	            {
					Thread t1 = new Thread(topPanel);
					t1.start();	
				}
			});			
		}		
		
	/**
	 * JPanel for displaying the sorting animation
	 */
	private class SortAnimationPanel extends JPanel implements Runnable {
			
		/**
		 * Call the sort methods to run the animation
		 */
		public void run(){
			//Get the values of sort type and speed
			String selectedValue = sortTypes.getSelectedItem().toString();
			String selectedSpeed = speeds.getSelectedItem().toString();
			
			sortButton.setEnabled(false);
			
			if(selectedSpeed.equals("Slow"))
			{
				speed = 750;
			}
				
			if(selectedSpeed.equals("Medium"))
			{
				speed = 500;
			}
				
			if(selectedSpeed.equals("Fast"))
			{
				speed = 250;
			}
				
			//Run the selected sort algorithm
			if(selectedValue.equals("Selection"))
			{
				selectionSort(integerArray);
			}
				
			if(selectedValue.equals("Quick"))
			{
				quickSort(integerArray, 0, integerArray.length - 1);
				populateArray.setEnabled(true);
			}
					
			if(selectedValue.equals("Bubble"))
			{
				bubbleSort(integerArray);
			}
				
			if(selectedValue.equals("Insertion"))
			{
				insertionSort(integerArray);
			}
				
			if(selectedValue.equals("Merge"))
			{
				sort(0, integerArray.length - 1);
				populateArray.setEnabled(true);
			}
		}
		
		/**
		 * Creates Panel for SortAnimation
		 */
		public SortAnimationPanel()	{
			//set the size of the animation window
			this.setPreferredSize(new Dimension(530, 525));			
			//set the background to white
			this.setBackground(new Color(250,250,250));				
		}
			
		/**
		 * Paint method to draw the lines
		 */
		public void paintComponent( Graphics g ){	

			if(integerArray[0] !=0)
			{				
				for(int i=0; i<integerArray.length; i++)
			{
				Color col = new Color(52, 229, 92);
					g.setColor(col); 						
					Graphics2D g2 = (Graphics2D) g;
					g2.setStroke(new BasicStroke(20));
					g.drawLine(i*25 + 25,530,i*25 + 25,530-integerArray[i] * 10);
			
				}
			}
		}		
	}
		
		/**
		 * Sorts the array using the selection sort algorithm and redraws the lines after each swap
		 * @param intArray An integer array specifying the integers to be sorted
		 */
		public void selectionSort(int[] intArray) 
		{
			try
			{			
				for (int i=0; i<intArray.length-1; i++) 
				{
					for (int j=i+1; j<intArray.length; j++) 
					{
						if (intArray[i] > intArray[j]) 
						{
							int temp = intArray[i];
							intArray[i] = intArray[j];
							intArray[j] = temp;
							
							//Redraw the lines after swapping elements
							repaint();
						}
					}
					Thread.sleep(speed);
				}				
				//Re-Enable array and sort button
				populateArray.setEnabled(true);
				sortButton.setEnabled(true);
			}			
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
		}
	
		/**
		 * Sorts the array using the quick sort algorithm and redraws the lines after each swap
		 * @param intArray An integer array specifying the integers to be sorted
		 * @param start Integer at the start of the array
		 * @param end Integer at the end of the array
		 */
		public void quickSort(int intArray[], int start, int end)
		{
			int i = start;                          
			int k = end;                            
		
			try
			{
				if (end - start >= 1)               
				{
					int pivot = intArray[start];       
				
					while (k > i)                   
					{
						while (intArray[i] <= pivot && i <= end && k > i)  
						{
							i++;                                    
						}
						
						while (intArray[k] > pivot && k >= start && k >= i) 
						{	
							k--;                                        
						}
						if (k > i) 
						{
							int temp = intArray[i];           
							intArray[i] = intArray[k];      
							intArray[k] = temp; 
							repaint();
						}
					}
					
					int temp1 = intArray[start];           
					intArray[start] = intArray[k];      
					intArray[k] = temp1; 
					repaint();

					quickSort(intArray, start, k - 1);
					Thread.sleep(speed);	
					quickSort(intArray, k + 1, end);   
				}
				//Re-Enable array and sort button
				populateArray.setEnabled(true);
				sortButton.setEnabled(true);
			}
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
		}
		
		/**
		 * Sort the array using the bubble sort algorithm and redraws the lines after each swap
		 * @param intArray An integer array specifying the integers to be sorted
		 */
		public void bubbleSort(int[] intArray) 
		{
			
			try
			{
				int n = intArray.length;
				int temp = 0;
			
				for(int i=0; i < n; i++)
				{
	                for(int j=1; j < (n-i); j++)
					{           
	                    if(intArray[j-1] > intArray[j])
						{
							//swap the elements!
							temp = intArray[j-1];
							intArray[j-1] = intArray[j];
							intArray[j] = temp;
							repaint();
	                    }          
	                }
					Thread.sleep(speed);
	            }

				//Re-Enable array and sort button
				populateArray.setEnabled(true);
				sortButton.setEnabled(true);
			}
			
			catch (InterruptedException e) 
			{
				e.printStackTrace();
	    
			}
	    }
		
		/**
		 * Sorts the array using the insertion sort algorithm and redraws the lines after each swap
		 * @param intArray An integer array specifying the integers to be sorted
		 */
		public void insertionSort(int[] intArray) 
		{	
			try
			{
				for (int i = 1; i < intArray.length; i++) 
				{	
					int j = i;
					int temp = intArray[i];
					
					while ((j > 0) && (intArray[j-1] > temp)) {
						
						intArray[j] = intArray[j-1];
						j--;
						repaint();
					}
					
					intArray[j] = temp;
					repaint();
					Thread.sleep(speed);
				}
				
				//Re-Enable array and sort button
				populateArray.setEnabled(true);
				sortButton.setEnabled(true);
			}
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
		}
		
		
			//private data members.
			protected int lastSwap=-1; //the last swap index.
			protected int index=-1; //the current position index the program is working.		  
		   
		/**
		 * Sorts the array using the merge sort algorithm and redraws the lines after each swap	
		 * merge the two subarrays, this function do the merge int the same array rather
		 * using a temorary array.
		 * @param first The first integer of the array
		 * @param mid The middle integer of the array
		 * @param last The last intger of the array
		 */
		 public void merge(int first, int mid, int last)
		  {
		    int first1 = first;
		    int last1 = mid;
		    int first2 = mid+1;
		    int last2 = last;

		    while((first1 <= last1) && (first2 <= last2))
		    {
		      index = first1;
		      lastSwap = first2;
		      repaint();
		        try {
					Thread.sleep(speed - 200);
					//Re-Enable array and sort button
					populateArray.setEnabled(true);
					sortButton.setEnabled(true);	
		        }
		        catch (InterruptedException e) {
					e.printStackTrace();
				}
		   
		      if(integerArray[first1] > integerArray[first2])
		      {
		        int temp = integerArray[first2];
		        shiftBlockRightOnePos(first1, last1);
		        integerArray[first1] = temp;
		        first1++;
		        first2++;
		        last1++;
		      }
		     
		      else
		      {//array[first1] is smaller than array[first2]
		        first1++;
		      }
		    }
		  }

		 /**
		  * Recursive merge sort, merge the two subarrays
		  * @param first The first integer of the array
		  * @param last The last integer of the array
		  */
		public void sort(int first, int last)
		  {
		    if(first < last)
		    {
		      int mid = (int)(first+last)/2;
		      sort(first, mid);
		      sort(mid+1, last);
		      merge(first, mid, last); 
		    }		    		    
		  }


		/**
		 * Shift a block inside "array" one position to the right, the element at "last+1"
		 * will be overwritten
		 * @param first The first integer of the array
		 * @param last The last integer of the array
		 */
		  public void shiftBlockRightOnePos(int first, int last)
		  {
		      while(last >= first)
		      {
		        integerArray[last+1] = integerArray[last];
		        last--;
		        repaint();
		      }			    
		  }	
}
