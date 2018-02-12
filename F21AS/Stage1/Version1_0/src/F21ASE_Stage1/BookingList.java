package F21ASE_Stage1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @author Tom Feraud
 * @version 1.0
 */

public class BookingList {
	// String is the key: the unique booking reference code
	private TreeMap<String, Booking> bookingList;

	/**
	 * Constructor of BookingList
	 */
	public BookingList() {
		bookingList = new TreeMap<String, Booking>();
	}

	/**
	 * Print the booking list' size
	 */
	public void printSize() {
		System.out.println(bookingList.size());
	}

	/**
	 * Add a booking in our booking list
	 * 
	 * @param booking
	 */
	public void addBooking(Booking booking) {
		bookingList.put(booking.getTicket().getBookingReferenceCode(), booking);
	}

	/**
	 * Find via the booking reference code a booking
	 * 
	 * @param bookingRefCode
	 * @return Passenger
	 */
	public Passenger findByBookingReference(String bookingRefCode) {
		for (Map.Entry<String, Booking> entry : bookingList.entrySet()) {
			String key = entry.getKey();
			if (key.equals(bookingRefCode)) {
				return bookingList.get(key).getPassenger();
			}
		}
		return null;
	}

	/**
	 * Check if a passenger, according to his last name and booking reference
	 * code has booked (used in the GUI)
	 * 
	 * @param lastName
	 * @param bookingRefCode
	 * @return
	 */
	public boolean hasPassengerBooked(String lastName, String bookingRefCode) {
		for (Map.Entry<String, Booking> entry : bookingList.entrySet()) {
			String key = entry.getKey();
			Booking value = entry.getValue();
			if (key.equals(bookingRefCode) && value.getPassenger().getLastName().equals(lastName)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Read the element of the text file provided in parameter and fill the
	 * booking list by calling processLine method
	 * 
	 * @param filename
	 */
	public void readFile(String filename) {
		try {
			File file = new File(filename);
			Scanner scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				// read first line and process it
				String inputLine = scanner.nextLine();
				if (inputLine.length() != 0) {// ignored if blank line
					processLine(inputLine);
				}
			}
		}
		// if the file is not found, stop with system exit
		catch (FileNotFoundException fnf) {
			System.out.println(filename + " not found ");
			System.exit(0);
		}
	}

	/**
	 * Process the line provided in parameter
	 * 
	 * @param line
	 */
	private void processLine(String line) {
		try {
			String parts[] = line.split(",");
			String uniqueRef = parts[0];
			String flightCodeString = parts[2];
			// If the unique booking reference code is missing
			if (uniqueRef.equals("")) {
				String error = "The booking reference code on the line:" + line + " is missing";
				System.err.println(error);
			} else if (flightCodeString.equals("")) {
				String error = "The flight code on the line:" + line + " is missing";
				System.err.println(error);
			} else {
				Passenger passenger = new Passenger(parts[1]);
				FlightCode flightCode = new FlightCode(flightCodeString);
				Ticket ticket = new Ticket(uniqueRef, flightCode);

				// create Booking object and add it to the list
				Booking booking = new Booking(passenger, ticket);
				boolean checkedIn = Boolean.parseBoolean(parts[3]);
				booking.setCheckedIn(checkedIn);
				this.addBooking(booking);
			}
		}
		// this catches missing item(s) for a booking
		catch (ArrayIndexOutOfBoundsException aieoobe) {
			System.out.println("Not enough item in line: " + line
					+ ".\nPlease insert a booking as: (bookingReferenceCode,Passenger,FlightCode,false)");
		} catch (java.lang.StringIndexOutOfBoundsException siooe) {
			System.out.println("The passenger name is incomplete in line " + line
					+ ".\nPlease insert a booking as: (bookingReferenceCode,Passenger,FlightCode,false)");
		}
	}

	/**
	 * Print all the values of the booking list
	 */
	public void printBookingList() {
		System.out.println(bookingList.values());
	}

	/**
	 * Returns the booking list
	 * 
	 * @return bookingList
	 */
	public TreeMap<String, Booking> getBookingList() {
		return bookingList;
	}

	/**
	 * Sets the booking list
	 * 
	 * @param bookingList
	 */
	public void setBookingList(TreeMap<String, Booking> bookingList) {
		this.bookingList = bookingList;
	}

}
