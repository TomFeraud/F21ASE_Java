package F21ASE_Stage2;

import models.Desk;
import models.Queue;
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


		// TEST STAGE2
		// Run the thread who adds a random passenger to the queue
		// This is working
		Queue testQueue = new Queue(bookingList);
		testQueue.start();

		Desk deskTest1 = new Desk(testQueue, bookingList, 1, 10);
		deskTest1.start();
		//Desk deskTest2 = new Desk(testQueue, bookingList, 2);
		//deskTest2.start();
		//Desk deskTest3 = new Desk(testQueue, bookingList, 3);
		//deskTest3.start();
		
		//GUI gui = new GUI();
		//gui.setVisible(true);
		
		TestGUI gui = new TestGUI(testQueue);
		gui.setVisible(true);
		
	}

}