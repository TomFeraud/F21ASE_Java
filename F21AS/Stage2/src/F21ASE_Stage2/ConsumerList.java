package F21ASE_Stage2;

import java.util.ArrayList;

public class ConsumerList {
    private ArrayList<Consumer> consumers;

    /**
     * Constructor
     */
    public ConsumerList() {
        this.consumers = new ArrayList<>();
    }

    /**
     * Add consumer
     * @param consumer Consumer
     */
    public void add(Consumer consumer) {
        consumers.add(consumer);
    }

    /**
     * Find consumer by deskNo
     * @param id Desk Number
     * @return consumer
     */
    public Consumer find(int id) {
        for (Consumer d : consumers) {
            if (d.getDeskNo() == id){
                return d;
            }
        }
        return null;
    }

    /**
     * Get Consumer
     *
     * @param i Desk Number
     * @return Consumer
     */
    public Consumer get(int i) {
        return consumers.get(i);
    }

    /**
     * Get the size of consumerList
     * @return total number of consumer
     */
    public int getSize() {
        return consumers.size();
    }

}
