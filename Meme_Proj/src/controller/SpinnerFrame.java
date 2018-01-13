package controller;
import java.awt.BorderLayout;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import javafx.event.ActionEvent;

/**
 * A frame with a panel that contains several spinners and a button that displays the spinner
 * values.
 */
public class SpinnerFrame extends JFrame
{
   public SpinnerFrame()
   {
      setTitle("SpinnerTest");
      setSize(50, 50);
      JPanel buttonPanel = new JPanel();
      okButton = new JButton("Ok");
      buttonPanel.add(okButton);
      add(buttonPanel, BorderLayout.CENTER);

      mainPanel = new JPanel();
      mainPanel.setLayout(new GridLayout(1,2 ));
      add(mainPanel, BorderLayout.CENTER);

      JSpinner defaultSpinner = new JSpinner();
      addRow("Default", defaultSpinner);
   }

   /**
    * Adds a row to the main panel.
    */
   public void addRow(String labelText, final JSpinner spinner)
   {
      mainPanel.add(new JLabel(labelText));
      mainPanel.add(spinner);
      final JLabel valueLabel = new JLabel();
      mainPanel.add(valueLabel);
      okButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event)
            {
               Object value = spinner.getValue();
               valueLabel.setText(value.toString());
            }

			@Override
			public void actionPerformed(java.awt.event.ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
         });
   }

   public static final int DEFAULT_WIDTH = 10;
   public static final int DEFAULT_HEIGHT = 10;

   private JPanel mainPanel;
   private JButton okButton;
}
