package F21ASE_Stage2;

import java.util.LinkedList;

public class PassengerQueue {

    private LinkedList<Passenger> queue;
    private boolean empty;
    private boolean done;

    /**
     * Constructor
     */
    public PassengerQueue() {
        this.queue = new LinkedList<Passenger>();
        this.empty = true;
        this.done = false;
    }

    /**
     * wait until the queue is not empty
     * remove and return the first passenger in the queue
     * set empty after poll
     * @param deskNo
     * @return
     */
    public synchronized Passenger get(int deskNo) {
        while (empty) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Passenger p = queue.poll();
        System.out.println("Desk ["+deskNo + "] Check-in: " + p.toString());
        System.out.println("");
        empty = true;
        notifyAll();
        return p;
    }

    /**
     * add passenger to then queue when the queue is empty
     * then set empty to be false
     * @param tmp
     */
    public synchronized void put(Passenger tmp) {
        while (!empty) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Add: " + tmp.toString());
        empty = false;
        notifyAll();
        queue.add(tmp);
    }

    /**
     * tell consumer the producer has finished adding passenger
     */
    public void setDone() {
        done = true;
    }

    /**
     * get the status of producer
     * @return
     */
    public boolean getDone() {
        return done;
    }
}
