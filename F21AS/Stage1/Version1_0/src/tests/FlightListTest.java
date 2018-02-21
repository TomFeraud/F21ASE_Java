import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FlightListTest {
    private Flight flight1;
    private Flight flight2;
    private FlightList flightList;

    @Before
    public void setup() {
        flight1 = new Flight(
                "London",
                "York",
                "UK Airway",
                "UK001",
                100,
                100,
                100);
        flight2 = new Flight(
                "Boston",
                "London",
                "US Airway",
                "US001",
                50,
                50,
                50);
        flightList = new FlightList();
        flightList.addFlight(flight1);
        flightList.addFlight(flight2);
    }

    @Test
    public void findByFlightCode() throws Exception
    {
        Flight f = flightList.findByFlightCode("LL02");
        Flight f1 = flightList.findByFlightCode("US001");
        assertEquals(null,f);
        assertEquals(flight2,f1);
    }

    @Test
    public void getTotalNumberofFlights() throws Exception
    {
        int size = flightList.getTotalNumberofFlights();
        assertEquals(2,size);
    }
}