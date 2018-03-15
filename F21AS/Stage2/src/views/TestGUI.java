package views;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


import models.Queue;

public class TestGUI extends JFrame {

	private JTextField text = new JTextField();


	public TestGUI(Queue model) {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());

//		add(BorderLayout.NORTH, methodTest());
		add(new QueueDisplay(model), BorderLayout.CENTER);
		
		setSize(700, 700);
		setVisible(true);
	}
	
	
	/*
	public JPanel methodTest() {
		JPanel setPanel = new JPanel(new BorderLayout());

		JPanel panel = new JPanel(new GridLayout(1, 1));
		panel.add(new JLabel("This is an observer for the queue (testing)"));

		setPanel.add(BorderLayout.CENTER, panel);

		return setPanel;
	}
	*/

	public String getText() {
		return text.getText();
	}

	// add listener to update button
	//public void addSetListener(ActionListener al) {
//
	//}
}
