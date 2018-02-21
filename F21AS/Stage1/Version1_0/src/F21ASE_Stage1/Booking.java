package F21ASE_Stage1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Tom Feraud
 * @version 1.0
 */

public class Booking {
	private Passenger passenger;
	private String bookingReferenceCode;
	private String flightCode;
	private boolean checkedIn;

	/**
	 * Constructor of Booking with a Passenger, booking Ref. code, and flight code
	 *
	 * threw exceptions if bookingReferenceCode or flightCode has invalid format
	 *
	 * @param passenger
	 * @param bookingReferenceCode
	 * @param flightCode
	 */
	public Booking(Passenger passenger, String bookingReferenceCode, String flightCode) {
		this.passenger = passenger;
		if (!validateBookingReferenceCode(bookingReferenceCode, this.passenger)) {
			throw new InvalidFormatException("Booking Reference code - " + bookingReferenceCode);
		} else {
			this.bookingReferenceCode = bookingReferenceCode;
		}
		if (!Flight.flightCodeValidation(flightCode)) {
			throw new InvalidFormatException("Flight Code - " + flightCode);
		} else {
			this.flightCode = flightCode;
		}
	}

	/**
	 * Returns the passenger of the booking
	 * 
	 * @return passenger
	 */
	public Passenger getPassenger() {
		return passenger;
	}

	/**
	 * Sets the booking' passenger
	 * 
	 * @param passenger
	 */
	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}

	public String getFlightCode() {
		return this.flightCode;
	}

	public String getBookingReferenceCode() {
		return bookingReferenceCode;
	}

	/**
	 * Checks if a passenger according to his ticket has checked in or not yet
	 * 
	 * @return checkedIn
	 */
	public boolean hasCheckedIn() {
		return checkedIn;
	}

	/**
	 * Sets if a passenger according to his ticket has checked in or not yet
	 * 
	 * @param checkedIn
	 */
	public void setCheckedIn(boolean checkedIn) {
		this.checkedIn = checkedIn;
	}

	public String toString() {
		String info = "\n";
		info += String.format("%-38s", "Booking reference code: '" + this.bookingReferenceCode + "', ");
		info += String.format("%-30s", "Name: '" + passenger.getFullName() + "', ");
		info += String.format("%-30s", "FLight Code: '" + this.flightCode + "', ");
		info += String.format("%-15s", "Checked in?: '" + this.hasCheckedIn() + "'");

		return info;
	}

	/**
	 * Validate the booking ref. code format
	 *
	 * Correct format should be the passenger's initials in CAP, plus 8 random
	 * digits
	 *
	 * @param bookingReferenceCode
	 * @param passenger
	 * @return
	 */
	private boolean validateBookingReferenceCode(String bookingReferenceCode, Passenger passenger) {
		String initials = passenger.getInitials();
		Pattern p = Pattern.compile("^[" + initials + "]{2}\\d{8}$");
		Matcher m = p.matcher(bookingReferenceCode);

		return m.find(); // returns true if matches, otherwise false
	}
}
