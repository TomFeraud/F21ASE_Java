package F21ASE_Stage2;

import java.util.LinkedList;

public class PassengerQueue {

    private LinkedList<Passenger> queue;
    private BookingList bookingList;
    private FlightList flightList;
    private boolean empty;
    private boolean done;
    private Log log;
    /**
     * Constructor
     */
    public PassengerQueue(BookingList bookingList, FlightList flightList) {
        this.queue = new LinkedList<>();
        this.bookingList = bookingList;
        this.flightList = flightList;
        this.empty = true;
        this.done = false;
        this.log = Log.getInstance();
    }

    /**
     * Consumer method
     * Poll a passenger at the head of the Queue
     * Return passenger information and flight information for observer to update
     *
     * @param deskNo Desk Number
     * @return passenger information and flight information
     */
    public synchronized String[] get(int deskNo) {
        // if queue is empty, then wait
        while (empty) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Passenger passenger = queue.poll();
        System.out.println("Desk ["+ deskNo + "] Check-in: " + passenger.toString());
        System.out.println("");
        //check-in passenger
        String passengerInfo = checkIn(passenger, deskNo);
        // get current flight info
        String flightInfo = getFlightInfo(passenger);

        return new String[] {passengerInfo, flightInfo};
    }

    /**
     * Produce the queue
     * add all passengers to the queue randomly
     * then set empty to be false and notify consumer to start
     */
    public synchronized void put() {
        try {
            Thread.sleep(100); // queue in a passenger in every 50 ms
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // select a random passenger
        Passenger tmp = bookingList.randomPassenger();
        // generate random baggage weights and dimensions
        double weightBag = RandomHelper.getRandomWeight();
        double[] dim = RandomHelper.getRandomDimensions();
        double lengthBag = dim[0];
        double widthBag = dim[1];
        double heightBag = dim[2];
        // create a new baggage object
        Baggage bagTmp = new Baggage(weightBag, lengthBag, widthBag, heightBag);
        // assign the baggage to this passenger
        tmp.setBaggage(bagTmp);

        System.out.println("Add: " + tmp.toString());
        // add passenger in queue
        queue.add(tmp);
        //record log
        log.write(tmp.getFullName() +" joined the queue");

    }

    /**
     * Check-in the passenger and get the passenger information
     *
     * @param passenger Passenger
     * @param deskNo Desk Number
     * @return Passenger Information
     */
    private String checkIn(Passenger passenger, int deskNo) {
        // get passenger information
        String name = passenger.getFullName();
        Baggage baggage = passenger.getBaggage();
        String bookingCode = bookingList.getPassengerBookingRef(name);
        Booking booking = bookingList.findByBookingReference(bookingCode);

        String infoPassenger = bookingList.getPassengerInfo(name);
        String info = "Actual passenger at desk n°" + deskNo + ":\n" + name + "\n" + infoPassenger + " "
                + "\nBaggage info " + baggage.getWeight() + "kg  " + baggage.getDimensionX() + " x "
                + baggage.getDimensionY() + " x " + baggage.getDimensionZ() + " Extra fee: £"
                + baggage.calculateBagFee();
        // check-in passenger
        booking.setCheckedIn(true);

        // record log
        log.write("Passenger:" +name +" is checking in");

        return info;
    }

    /**
     * Add the passenger to the corresponding flight and get the current flight information
     *
     * @param passenger Passenger
     * @return flight information
     */
    private String getFlightInfo(Passenger passenger) {
        // get passenger's flight
        Flight flight = flightList.findByFlightCode(bookingList.getPassengerFlightCode(passenger.getFullName()));
        // add passenger to the corresponding flight
        flight.addFlightPassenger(passenger.getBaggage().getWeight(), passenger.getBaggage().calculateDimT());

        // return the flight information after adding the passenger in
        return flight.getFlightInfo();
    }

    /**
     * Get information of the passengers in the queue
     *
     * @return queue information
     */
    public synchronized String getQueuePassengers() {
        StringBuilder queueText = new StringBuilder();
        for (Passenger p : queue) {
            queueText.append(bookingList.getPassengerBookingRef(p.getFullName())).append("        ").append(p.toString()).append(p.getBaggage()).append("\n\n");
        }
        return queueText.toString();
    }

    /**
     * Tell consumer that the producer has finished adding passengers
     */
    synchronized void setDone() {
        done = true;
        empty = false;
        // start the consumer threads
        notifyAll();
    }

    /**
     * Get the status of producer
     * @return done
     */
    boolean getDone() {
        return done;
    }

    /**
     * Get the size of the queue
     * @return size of the queue
     */
    public int getSize() { return queue.size(); }
}
