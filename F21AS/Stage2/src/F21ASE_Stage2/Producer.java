package F21ASE_Stage2;

public class Producer extends Thread {

    private PassengerQueue queue;
    private BookingList bookingList;

    /**
     * Constructor
     * @param bookingList Booking list that contains passenger information
     * @param queue Passenger queue that will be filled up randomly
     */
    public Producer(BookingList bookingList, PassengerQueue queue) {
        this.queue = queue;
        this.bookingList = bookingList;
    }

    /**
     * run the producer thread
     */
    public void run() {
        for (int i = 0; i < bookingList.size(); i++){
            try {
                Thread.sleep(50); // queue in a passenger in every 50 ms
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Passenger temp = bookingList.randomPassenger();
            queue.put(temp);
        }
        queue.setDone();
    }
}
