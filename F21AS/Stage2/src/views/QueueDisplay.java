package views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import F21ASE_Stage2.Queue;
import interfaces.Observer;

@SuppressWarnings("serial")
public class QueueDisplay extends JPanel implements Observer {

	private Queue queueData;
	private JTextField queueSize;
	private JTextArea testText;

	JLabel nbOfPeople = new JLabel("Number of people currently in the queue: ");

	public QueueDisplay(Queue queue) {
	    
		testText = new JTextArea(20, 50);
		queueSize = new JTextField(4);
		this.queueData = queue;
		queue.registerObserver(this);
		this.add(nbOfPeople);
		this.add(queueSize);
		queueSize.setEditable(false);
		testText.setEditable(false);
		Font font = new Font("Arial", Font.PLAIN, 10);
		testText.setFont(font);
		this.add(testText);
		JScrollPane scrollList = new JScrollPane(testText);
		this.add(scrollList);
		
	}
	

	@Override
	public void update() {
		String test = queueData.getQueuePassengers();
		testText.setText(test);
		queueSize.setText(String.valueOf(queueData.size()));

	}

}
