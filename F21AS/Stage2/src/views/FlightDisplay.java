package views;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import F21ASE_Stage2.BookingList;
import F21ASE_Stage2.Desk;
import F21ASE_Stage2.Flight;
import interfaces.Observer;

public class FlightDisplay extends JPanel implements Observer {
	private Flight flight;
	private JTextArea textArea;

	private Desk deskData;

	public FlightDisplay(Flight flight) {
		// public FlightDisplay(Flight flight, Desk desk) {

		this.flight = flight;
		flight.registerObserver(this);

		// this.deskData = desk;
		// desk.registerObserver(this);

		textArea = new JTextArea(4, 35);
		textArea.setEditable(false);
		textArea.setFont(new Font("Arial", Font.PLAIN, 10));
		this.add(textArea);
		JScrollPane scrollList = new JScrollPane(textArea);
		this.add(scrollList, BorderLayout.SOUTH);

	}

	@Override
	public void update() {
		String info = flight.getFlightInfo();
		textArea.setText(info);

	}

}
