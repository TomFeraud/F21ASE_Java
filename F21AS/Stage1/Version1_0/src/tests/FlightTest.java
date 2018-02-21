import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FlightTest {
    private Flight f1, f2;
    @Before
    public void setup() {
         f1 = new Flight(
                "London",
                "York",
                "UK Airway",
                "UK001",
                100,
                100,
                100);
//         f2 = new Flight("London",
//                "York",
//                "UK Airway",
//                "UK10011",
//                100,
//                100,
//                100);

    }

    @Test
    public void flightCodeValidation() throws Exception
    {
        boolean Code1 = Flight.flightCodeValidation("UK221");
        boolean Code2 = Flight.flightCodeValidation("USA221");

//        assertEquals(true,Code1);
        assertEquals(true,Code2);
    }
}