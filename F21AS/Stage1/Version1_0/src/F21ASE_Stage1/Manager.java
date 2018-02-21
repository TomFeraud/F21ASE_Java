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
		
		System.out.println("Size + contents of booking.txt:\n ---------------------------------------------------------------------------------------------------");
		Passenger passenger1 = new Passenger("Jean", "MICHEL");
		Booking booking1 = new Booking(passenger1, "JM12345678", "FR1286");
		bookingList.addBooking(booking1);
		bookingList.readFile("booking.txt");
		bookingList.printSize();
		bookingList.printBookingList();
		
		//System.out.println(bookingList.findByBookingReference("TF12345678"));
		
		
		System.out.println("Size + contents of flight.txt:\n ---------------------------------------------------------------------------------------------------");
		flightList.readFile("flight.txt");
		System.out.println(flightList.getTotalNumberofFlights());
		flightList.printFlightList();

		GUI gui = new GUI(bookingList, flightList);
		gui.setVisible(true);
	}


}
