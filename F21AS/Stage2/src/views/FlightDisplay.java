package views;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import F21ASE_Stage2.ConsumerList;
import F21ASE_Stage2.Flight;
import interfaces.Observer;

public class FlightDisplay extends JPanel implements Observer {
	private JTextArea textArea;

	/**
	 * Constructor
	 *
	 * @param flight Flight
	 * @param consumerList Consumer List
	 */
	public FlightDisplay(Flight flight, ConsumerList consumerList) {

		for (int i = 0; i < consumerList.getSize(); i++) {
			consumerList.get(i).registerObserver(this);
		}

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

	/* Implement Observer */

	/**
	 * Update Observer
	 *
	 * Not Used in this class
	 */
	@Override
	public void update() {}

	/**
	 * Update Observer
	 * Only the second element of the array is used to
	 * Update the flight capacity
	 *
	 * @param info Info contains two elements: passenger info and flight info
	 */
	@Override
	public void update(String[] info)
	{
		// info.length < 1 means desks are closed
		// then there is no need to update flight capacity
		if(info.length > 1) {
			textArea.setText(info[1]);
		}
	}
}
