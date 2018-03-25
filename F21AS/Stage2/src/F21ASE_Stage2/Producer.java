package F21ASE_Stage2;

import interfaces.Observer;
import interfaces.Subject;

import java.util.LinkedList;
import java.util.List;

public class Producer extends Thread implements Subject{

    private List<Observer> registeredObservers = new LinkedList<Observer>();
    private PassengerQueue queue;
    private BookingList bookingList;

    /**
     * Constructor
     * @param queue Passenger queue that will be filled up randomly
     * @param bookingList
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
            notifyObservers();
        }
        queue.setDone();
    }

    /* Implement Subject interface methods*/

    /**
     * Register an observer with this subject
     *
     * @param obs
     */
    @Override
    public void registerObserver(Observer obs)
    {
        registeredObservers.add(obs);
    }

    /**
     * De-register an observer with this subject
     *
     * @param obs
     */
    @Override
    public void removeObserver(Observer obs)
    {
        registeredObservers.remove(obs);
    }

    /**
     * Inform all registered observers that there's been an update
     */
    @Override
    public void notifyObservers()
    {
        for (Observer obs : registeredObservers)
            obs.update();
    }

    public void notifyObservers(String[] info) {
        for (Observer obs : registeredObservers)
            obs.update(info);
    }
}
