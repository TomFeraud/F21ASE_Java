package views;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import F21ASE_Stage2.Consumer;
import interfaces.Observer;

@SuppressWarnings("serial")
public class DeskDisplay extends JPanel implements Observer {

	private JTextArea textArea;

	/**
	 * Constructor
	 *
	 * @param consumer
	 *            consumer
	 */
	public DeskDisplay(Consumer consumer) {

		consumer.registerObserver(this);

		textArea = new JTextArea(6, 40);
		textArea.setEditable(false);
		textArea.setFont(new Font("Arial", Font.PLAIN, 10));
		textArea.setText("This desk is closed");
		this.add(textArea);
		JScrollPane scrollList = new JScrollPane(textArea);
		this.add(scrollList, BorderLayout.CENTER);
	}

	/* Implement Observer */

	/**
	 * Update Observer
	 *
	 * Not Used in this class
	 */
	@Override
	public void update() {
	}

	/**
	 * Update Observer Only the first element of the array is used to Update the
	 * current passenger on the check-in desk
	 *
	 * @param info
	 *            Info contains two elements: passenger info and flight info
	 */
	@Override
	public void update(String[] info) {
		textArea.setText(info[0]);
	}

}
