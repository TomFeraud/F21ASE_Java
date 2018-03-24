package F21ASE_Stage2;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Consumer extends Thread{

    private PassengerQueue queue;
    private int deskNo;
    private int endIn;

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
                Thread.sleep(1000); // check in a passenger in every 1s
            } catch (InterruptedException e) {
            }
            // check closing time
            if((System.currentTimeMillis()- startTime) < endIn*1000) {
                queue.get(deskNo);
            } else {
                date.setTime(System.currentTimeMillis());
                System.out.println(dateFormat.format(date) +": Desk ["+deskNo+"] is closed\n");
                return;
            }
        }
    }
}
