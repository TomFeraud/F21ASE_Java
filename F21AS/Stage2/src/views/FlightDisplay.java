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
	private Flight flight = new Flight("departure", "destination", "carrier", "FR1286", 0, 0, 0);
	private JTextArea textArea;


	public FlightDisplay(Flight flight) {


		this.flight = flight;
		flight.registerObserver(this);

		textArea = new JTextArea(4, 35);
		textArea.setEditable(false);
		textArea.setFont(new Font("Arial", Font.PLAIN, 10));
		textArea.setText("Check in for flight " + flight.getFlightCode()+ " to " + flight.getDestination() +" open\n"
				+ "Passengers please make your way to the gate" );
		this.add(textArea);
		JScrollPane scrollList = new JScrollPane(textArea);
		this.add(scrollList, BorderLayout.SOUTH);
		setVisible(true);
	}

	@Override
	public void update() {
		String info = flight.getFlightInfo();
		textArea.setText(info);

	}

}
