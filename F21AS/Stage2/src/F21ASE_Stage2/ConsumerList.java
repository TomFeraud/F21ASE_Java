package F21ASE_Stage2;

import java.util.ArrayList;

public class ConsumerList {
    private ArrayList<Consumer> consumers;


    public ConsumerList() {
        this.consumers = new ArrayList<Consumer> ();
    }

    public void add(Consumer l) {
        consumers.add(l);
    }

    public Consumer find(int id) {
        for (Consumer d : consumers) {
            if (d.getDeskNo() == id){
                return d;
            }
        }
        return null;
    }

    public Consumer get(int i) {
        return consumers.get(i);
    }


    public int getSize() {
        return consumers.size();
    }

}
