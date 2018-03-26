package F21ASE_Stage2;

import interfaces.Observer;
import interfaces.Subject;

import java.util.LinkedList;
import java.util.List;

public class Producer extends Thread implements Subject{

    private List<Observer> registeredObservers = new LinkedList<>();
    private PassengerQueue queue;
    private BookingList bookingList;

    /**
     * Constructor
     *
     * @param bookingList Booking list of passengers
     * @param queue Passenger queue
     */
    public Producer(BookingList bookingList, PassengerQueue queue) {
        this.queue = queue;
        this.bookingList = bookingList;
    }

    /**
     * run the producer thread
     */
    public void run() {
        for (int i = 0; i < bookingList.size(); i++) {
            queue.put();
            try {
				sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            notifyObservers();
        }
        queue.setDone();
    }

    /* Implement Subject interface methods*/

    /**
     * Register an observer with this subject
     *
     * @param obs Observer
     */
    @Override
    public void registerObserver(Observer obs)
    {
        registeredObservers.add(obs);
    }

    /**
     * De-register an observer with this subject
     *
     * @param obs Observer
     */
    @Override
    public void removeObserver(Observer obs)
    {
        registeredObservers.remove(obs);
    }

    /**
     * Inform all registered observers that there's been an update
     *
     * Used for updating passenger queue information
     */
    @Override
    public void notifyObservers()
    {
        for (Observer obs : registeredObservers)
            obs.update();
    }
    /**
     * Inform all registered observers that there's been an update
     *
     * Not Used in this class
     */
    public void notifyObservers(String[] info) {
        for (Observer obs : registeredObservers)
            obs.update(info);
    }
}
