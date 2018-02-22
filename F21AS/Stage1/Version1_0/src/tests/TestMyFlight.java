package tests;

import org.junit.Before;
import org.junit.Test;

import F21ASE_Stage1.Flight;

import static org.junit.Assert.*;

public class TestMyFlight {
	private Flight f1;

	@Before
	public void setup() {
		f1 = new Flight("London", "York", "UK Airway", "UK001", 100, 100, 100);

	}

	@SuppressWarnings("static-access")
	@Test
	public void testFlightCodeValidation() throws Exception {
		boolean Code1 = Flight.flightCodeValidation("UK221");
		assertTrue(Code1);

		boolean Code2 = Flight.flightCodeValidation("USA221");
		assertFalse(Code2);

		assertTrue((f1.flightCodeValidation(f1.getFlightCode())));
	}
}