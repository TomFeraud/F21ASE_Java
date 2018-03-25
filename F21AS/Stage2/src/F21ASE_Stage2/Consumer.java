package F21ASE_Stage2;

import interfaces.Observer;
import interfaces.Subject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Consumer extends Thread implements Subject {

    private List<Observer> registeredObservers = new LinkedList<>();
    private PassengerQueue queue;
    private int deskNo;
    private int endIn;
    private Log log;

    /**
     * Constructor
     * @param queue Passenger queue that will be checked in
     * @param deskNo Desk number
     * @param endIn close in seconds
     */
    public Consumer(PassengerQueue queue, int deskNo, int endIn) {
        this.queue = queue;
        this.deskNo = deskNo;
        this.endIn = endIn;
        this.log = Log.getInstance();
    }

    /**
     * run the consumer thread
     * thread will be closed in the given time
     */
    public void run() {
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date();
        long startTime = System.currentTimeMillis();
        date.setTime(startTime);
        System.out.println(dateFormat.format(date) + ": Desk [" +deskNo+ "] is open");

        while (!queue.getDone()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // check-in passengers until the queue is empty
            while (queue.getSize() > 0) {
                // close the desk after the given time
                if((System.currentTimeMillis()- startTime) < endIn*1000) {
                    // notify DeskDisplay and FlightDisplay
                    notifyObservers(queue.get(deskNo));
                    // notify QueueDisplay
                    notifyObservers();
                    try {
                        Thread.sleep(1000); // check in a passenger in every 1s
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    // notify DeskDisplay only
                    notifyObservers(new String[] {"Desk [" + deskNo + "] is closed"});
                    System.out.println("Desk [" + deskNo + "] is closed\n");
                    log.write("Desk [" + deskNo + "] is closed\n");
                    return;
                }
            }
        }
    }

    /**
     * Get the desk number
     * @return deskNo
     */
    int getDeskNo() {
        return this.deskNo;
    }

    /* Implement Subject interface methods*/

    public void registerObserver(Observer obs) {
        registeredObservers.add(obs);
    }

    public void removeObserver(Observer obs) {
        registeredObservers.remove(obs);
    }

    public void notifyObservers() {
        for (Observer obs : registeredObservers)
            obs.update();
    }

    public void notifyObservers(String[] info) {
        for (Observer obs : registeredObservers)
            obs.update(info);
    }
}
