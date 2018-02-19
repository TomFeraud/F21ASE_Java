package F21ASE_Stage1;

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
		bookingList.readFile("booking.txt");
		bookingList.printSize();
		bookingList.printBookingList();

		flightList.readFile("flight.txt");
		System.out.println(flightList.getTotalNumberofFlights());
		flightList.printFlightList();

		GUI gui = new GUI(bookingList, flightList);
		gui.setVisible(true);
	}


}
