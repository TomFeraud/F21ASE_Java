package views;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import interfaces.Observer;
import models.Queue;

@SuppressWarnings("serial")
public class QueueDisplay extends JPanel implements Observer {

	private Queue queueData;
	private JTextField queueSize = new JTextField(8);
	private JTextArea testText = new JTextArea();
	//private JTextArea testBookRef = new JTextArea();
	
	JPanel queuePanel = new JPanel(new GridLayout (1,1));
	JTextArea queueTextArea = new JTextArea(40,25);

	public QueueDisplay(Queue queue) {
		this.queueData = queue;
		queue.registerObserver(this);

		this.add(testText);
		testText.setEditable(false);
		Font timeFont = new Font("SansSerif", Font.BOLD, 14);
		testText.setFont(timeFont);
		
		this.add(queueSize);
		queueSize.setEditable(false);
		
	//	this.add(testBookRef);
		//testBookRef.setEditable(false);
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
