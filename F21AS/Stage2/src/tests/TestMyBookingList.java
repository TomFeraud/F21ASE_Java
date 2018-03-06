package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import F21ASE_Stage2.Booking;
import F21ASE_Stage2.BookingList;
import F21ASE_Stage2.Passenger;

public class TestMyBookingList {

	private BookingList bookingList;
	private Booking booking1;
	private Booking booking2;
	private Booking booking3;


	private Passenger passenger1;
	private Passenger passenger2;
	private Passenger passenger3;

	@Before
	public void setUp() {
		bookingList = new BookingList();

		passenger1 = new Passenger("Jean", "MICHEL");
		booking1 = new Booking(passenger1, "JM12345678", "FR1286");
		

		passenger2 = new Passenger("Eva", "LONGORIA");
		booking2 = new Booking(passenger2, "EL12345678", "IJ6789");

		passenger3 = new Passenger("Louis", "Ran", "SON");
		booking3 = new Booking(passenger3, "LR54637821", "AL562");

		bookingList.addBooking(booking1);
		bookingList.addBooking(booking2);
		bookingList.addBooking(booking3); 

		bookingList.printSize();
		bookingList.printBookingList();

	}

	@Test
	public void testFindByBookingReference() {
		assertTrue(booking1.equals(bookingList.findByBookingReference("JM12345678")));
		assertTrue(booking2 == bookingList.findByBookingReference("EL12345678"));
		assertFalse(booking3 == bookingList.findByBookingReference("TESTFALSE"));
	}

	@Test
	public void testHasPassengerBooked() {
		assertTrue(bookingList.hasPassengerBooked("LONGORIA", "EL12345678"));
		assertFalse(bookingList.hasPassengerBooked("FAKE", "FK98765432"));
	}

	@Test
	public void testAddBooking() {
		Passenger passenger4;
		passenger4 = new Passenger("Jo", "La", "MOUCHE");
		Booking booking4 = new Booking(passenger4, "JL12345678", "UI5436");
		bookingList.addBooking(booking4);
		assertTrue(bookingList.hasPassengerBooked("MOUCHE", "JL12345678"));

	}
 
}
