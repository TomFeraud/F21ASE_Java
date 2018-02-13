package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import F21ASE_Stage1.Booking;
import F21ASE_Stage1.BookingList;
import F21ASE_Stage1.FlightCode;
import F21ASE_Stage1.Passenger;
import F21ASE_Stage1.Ticket;

public class TestMyBookingList {

	private BookingList bookingList;
	private Booking booking1;
	private Booking booking2;
	private Booking booking3;

	private FlightCode flightCode1;
	private Ticket ticket1;
	private Passenger passenger1;

	private FlightCode flightCode2;
	private Ticket ticket2;
	private Passenger passenger2;

	private FlightCode flightCode3;
	private Ticket ticket3;
	private Passenger passenger3;

	@Before
	public void setUp() {
		bookingList = new BookingList();

		flightCode1 = new FlightCode("FR1286");
		ticket1 = new Ticket("GETYDH23", flightCode1);
		passenger1 = new Passenger("Jean", "MICHEL");
		booking1 = new Booking(passenger1, ticket1);

		flightCode2 = new FlightCode("IJ6789");
		ticket2 = new Ticket("RALJHE7", flightCode2);
		passenger2 = new Passenger("Eva", "LONGORIA");
		booking2 = new Booking(passenger2, ticket2);

		flightCode3 = new FlightCode("AL562");
		ticket3 = new Ticket("GARAY3", flightCode3);
		passenger3 = new Passenger("Louis", "Ran", "SON");
		booking3 = new Booking(passenger3, ticket3);

		bookingList.addBooking(booking1);
		bookingList.addBooking(booking2);
		bookingList.addBooking(booking3);

	}

	@Test
	public void testFindByBookingReference() {
		assertTrue(passenger2 == bookingList.findByBookingReference("RALJHE7"));
		assertFalse(passenger3 == bookingList.findByBookingReference("FALSE"));
	}

	@Test
	public void testHasPassengerBooked() {
		assertTrue(bookingList.hasPassengerBooked("LONGORIA", "RALJHE7"));
		assertFalse(bookingList.hasPassengerBooked("FAKE", "KLHOHUI4"));
	}

	@Test
	public void testAddBooking() {
		FlightCode flightCode4;
		Ticket ticket4;
		Passenger passenger4;
		flightCode4 = new FlightCode("OL365");
		ticket4 = new Ticket("UIKBJ6", flightCode4);
		passenger4 = new Passenger("Jo", "La", "MOUCHE");
		Booking booking4 = new Booking(passenger4, ticket4);
		bookingList.addBooking(booking4);
		assertTrue(bookingList.hasPassengerBooked("MOUCHE", "UIKBJ6"));

	}

}