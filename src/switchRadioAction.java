import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class switchRadioAction implements ActionListener{
	JRadioButton radio; 
	JButton browseButton; 
	JButton corruptButton;
	JButton decryptButton;
	JTextField pathField; 
	JTextArea hashArea;
	
public switchRadioAction(JRadioButton radio, JButton browseButton, JButton corruptButton, 
			JButton decryptButton, JTextField pathField, JTextArea hashArea) {
	this.radio = radio;
	this.browseButton = browseButton;
	this.corruptButton = corruptButton;
	this.decryptButton = decryptButton;
	this.pathField = pathField;
	this.hashArea = hashArea;
		
	}

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (radio.getText().equals("File")) {
					
				}
				
				else if (radio.getText().equals("Password Hash")) {
					
				}
				
			}
}