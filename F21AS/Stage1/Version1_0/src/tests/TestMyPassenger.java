package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import F21ASE_Stage1.Passenger;

public class TestMyPassenger {

	private Passenger passenger1;
	private Passenger passenger2;

	@Before
	public void setUp() {
		passenger1 = new Passenger("Jean", "Michel", "Saumon");
		passenger2 = new Passenger("Pierre Yves Lafonte");
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
	public void testSetFirstName(){
		String firstName = "Jose";
		passenger1.setFirstName(firstName);
		assertTrue(firstName.equalsIgnoreCase(passenger1.getFirstName()));
		assertTrue(passenger1.getFirstName().equalsIgnoreCase("Jose"));
		assertFalse(passenger1.getFirstName().equalsIgnoreCase("Jean"));
	}
	
	@Test
	public void testGetInitials(){
		String initials1 = "J.M.S";
		String testMethod1 = passenger1.getInitials();
		assertTrue(initials1.equalsIgnoreCase(testMethod1));
		
		String initials2 = "P.Y.L";
		String testMethod2 = passenger2.getInitials();
		assertTrue(initials2.equalsIgnoreCase(testMethod2));
	}

}