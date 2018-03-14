package views;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import models.Queue;

public class TestGUI extends JFrame {

	private JTextField text = new JTextField();
	// private JButton updateButton = new JButton("Update");

	public TestGUI(Queue model) {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());

		// add update panel at the top (doesn't need to know about the clock
		// object)
		add(BorderLayout.NORTH, methodTest());

		add(new QueueDisplay(model), BorderLayout.CENTER);

		setSize(250, 300);
		setVisible(true);
	}

	public JPanel methodTest() {
		JPanel setPanel = new JPanel(new BorderLayout());

		JPanel panel = new JPanel(new GridLayout(1, 1));
		panel.add(new JLabel("This is an observer for the queue (testing)"));

		setPanel.add(BorderLayout.CENTER, panel);

		return setPanel;
	}

	public String getText() {
		return text.getText();
	}

	// add listener to update button
	//public void addSetListener(ActionListener al) {
//
	//}
}
