package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import F21ASE_Stage2.Passenger;

public class TestMyPassenger {

	private Passenger passenger1;
	private Passenger passenger2;
	private Passenger passenger3;

	@Before
	public void setUp() {
		passenger1 = new Passenger("Jean", "Michel", "Saumon");
		passenger2 = new Passenger("Pierre Yves Lafonte");
		passenger3 = new Passenger("Rose Brune");
	}

	@Test
	public void testgetFirstName() {
		String firstName1 = "Jean";
		String testMethod1 = passenger1.getFirstName();
		assertTrue(firstName1.equalsIgnoreCase(testMethod1));

		String firstName2 = "Pierre";
		String testMethod2 = passenger2.getFirstName();
		assertTrue(firstName2.equalsIgnoreCase(testMethod2));
	}

	@Test
	public void testSetFirstName() {
		String firstName = "Jose";
		passenger1.setFirstName(firstName);
		assertTrue(firstName.equalsIgnoreCase(passenger1.getFirstName()));
		assertTrue(passenger1.getFirstName().equalsIgnoreCase("Jose"));
		assertFalse(passenger1.getFirstName().equalsIgnoreCase("Jean"));
	}

	@Test
	public void testGetInitials() {
		String initials1 = "J.M.S";
		String testMethod1 = passenger1.getInitials();
		assertTrue(initials1.equalsIgnoreCase(testMethod1));

		String initials2 = "P.Y.L";
		String testMethod2 = passenger2.getInitials();
		assertTrue(initials2.equalsIgnoreCase(testMethod2));

		String initials3 = "R.B";
		String testMethod3 = passenger3.getInitials();
		assertTrue(initials3.equalsIgnoreCase(testMethod3));

		String initials4 = "p.y.l";
		String testMethod4 = passenger2.getInitials();
		assertTrue(initials4.equalsIgnoreCase(testMethod4));

		String initials5 = "r.b";
		String testMethod5 = passenger3.getInitials();
		assertTrue(initials5.equalsIgnoreCase(testMethod5));
	}

}
