package views;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import F21ASE_Stage2.ConsumerList;
import F21ASE_Stage2.PassengerQueue;
import F21ASE_Stage2.Producer;
import interfaces.Observer;

@SuppressWarnings("serial")
public class QueueDisplay extends JPanel implements Observer {

	private PassengerQueue queue;
	private JTextField queueSize;
	private JTextArea testText;

	/**
	 * Constructor
	 *
	 * @param queue
	 *            Passenger Queue
	 * @param producer
	 *            Producer
	 * @param consumerList
	 *            Consumer
	 */
	public QueueDisplay(PassengerQueue queue, Producer producer, ConsumerList consumerList) {
		JLabel nbOfPeople = new JLabel("Number of people currently in the queue: ");
		testText = new JTextArea(20, 50);
		queueSize = new JTextField(4);

		this.queue = queue;
		producer.registerObserver(this);
		for (int i = 0; i < consumerList.getSize(); i++) {
			consumerList.get(i).registerObserver(this);
		}

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

	/* Implement Observer */

	/**
	 * Update Observer
	 *
	 * Not Used in this class
	 *
	 * @param info
	 *            Info
	 */
	@Override
	public void update(String[] info) {
	}

	/**
	 * Update Observer Update the current queue's content When adding random
	 * passenger to the queue And checking passenger off the queue
	 *
	 */
	@Override
	public void update() {
		String test = queue.getQueuePassengers();
		testText.setText(test);
		queueSize.setText(String.valueOf(queue.getSize()));
	}
}
