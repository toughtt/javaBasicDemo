package collections;

import java.util.LinkedList;
import java.util.List;

public class DoProduction implements Runnable{
    private final LinkedList<String> queue;
    DoProduction(LinkedList<String> q) {
        queue = q;
    }
    public void run() {
        String value = queue.removeFirst();;
        while (!value.equals("*")) {
            System.out.println(value);
            value = queue.removeFirst();;
        }
    }
}
