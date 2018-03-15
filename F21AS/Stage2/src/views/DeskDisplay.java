package views;


import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import interfaces.Observer;
import models.Desk;

@SuppressWarnings("serial")
public class DeskDisplay extends JPanel implements Observer {

	private Desk deskData;
	//private JTextField queueSize = new JTextField(4);
	private JTextArea testText = new JTextArea(20,50);
	
	JPanel queuePanel = new JPanel(new GridLayout (2,1));
	JLabel nbOfPeople = new JLabel("Number of people currently in the queue: ");
	

	
	public DeskDisplay(Desk desk) {

		this.deskData = desk;
		desk.registerObserver(this);

		testText.setText("SUUUUUP");
		this.add(testText);
		testText.setEditable(false);
		Font font = new Font("Arial", Font.PLAIN, 10);
		testText.setFont(font);
		

	}




	@Override
	public void update() {
		//String test = queueData.getNameNextPassenger();
	//	String test = deskData.processPassenger();
	//	testText.setText(test);
//		queueSize.setText(String.valueOf(deskData.size()));
		//queueData.getQueuePassengers();
		
		
	}

}
