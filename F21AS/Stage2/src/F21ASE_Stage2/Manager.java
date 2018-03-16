package F21ASE_Stage2;

import views.GUI;
import views.TestGUI;

/**
 * @author Tom Feraud
 * @version 1.0
 */

public class Manager {
	private BookingList bookingList;
	private FlightList flightList;

	/**
	 * Constructor of Manager, initialize both list
	 */
	public Manager() {
		bookingList = new BookingList();
		flightList = new FlightList();
	}

	/**
	 * Launches the GUI, reads the file to fill the lists
	 */
	public void run() {

		System.out.println(
				"Size + contents of booking.txt:\n ---------------------------------------------------------------------------------------------------");
		bookingList.readFile("booking.txt");
		bookingList.printSize();
		bookingList.printBookingList();

		System.out.println(
				"Size + contents of flight.txt:\n ---------------------------------------------------------------------------------------------------");
		flightList.readFile("flight.txt");
		System.out.println(flightList.getTotalNumberofFlights());
		flightList.printFlightList();

	}

}
