package views;


import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import interfaces.Observer;
import models.Queue;

@SuppressWarnings("serial")
public class QueueDisplay extends JPanel implements Observer {

	private Queue queueData;
	private JTextField queueSize = new JTextField(4);
	private JTextArea testText = new JTextArea(20,50);
	
	
	JPanel queuePanel = new JPanel(new GridLayout (2,1));
	JLabel nbOfPeople = new JLabel("Number of people currently in the queue: ");
	

	public QueueDisplay(Queue queue) {

		
		this.queueData = queue;
		queue.registerObserver(this);
		this.add(nbOfPeople);
		

		this.add(queueSize);
		queueSize.setHorizontalAlignment(JTextField.CENTER);
		queueSize.setEditable(false);
		
	
		
		this.add(testText);
		testText.setEditable(false);
		 Font font = new Font("Arial", Font.PLAIN, 10);
		 testText.setFont(font);


	}

	@Override
	public void update() {
		//String test = queueData.getNameNextPassenger();
		String test = queueData.getQueuePassengers();
		testText.setText(test);
		queueSize.setText(String.valueOf(queueData.size()));
		//queueData.getQueuePassengers();
	}

}
