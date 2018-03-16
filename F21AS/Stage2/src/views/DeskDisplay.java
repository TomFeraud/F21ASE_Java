package views;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import F21ASE_Stage2.Desk;
import interfaces.Observer;

@SuppressWarnings("serial")
public class DeskDisplay extends JPanel implements Observer {

	private Desk deskData;
	private JTextArea textArea, textAreaFlight;

	public DeskDisplay(Desk desk) {

		this.deskData = desk;
		desk.registerObserver(this);

		textArea = new JTextArea(4, 35);
		textArea.setEditable(false);
		textArea.setFont(new Font("Arial", Font.PLAIN, 10));
		textArea.setText("This desk is open");
		this.add(textArea);
		JScrollPane scrollList = new JScrollPane(textArea);
		this.add(scrollList, BorderLayout.CENTER);
		
		
	/*	textAreaFlight = new JTextArea(4, 35);
		textAreaFlight.setEditable(false);
		textAreaFlight.setFont(new Font("Arial", Font.PLAIN, 10));
		this.add(textAreaFlight);
		JScrollPane scrollListFlight = new JScrollPane(textArea);
		this.add(scrollListFlight, BorderLayout.SOUTH); */
		
		

	}

	@Override
	public void update() {
		String test = deskData.getDeskInfo();
		textArea.setText(test);
		//String info = flight.getFlightInfo();
		//textAreaFlight.setText(info);

	}

}
