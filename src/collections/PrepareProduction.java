package collections;

import java.util.List;

public class PrepareProduction implements Runnable {
    private final List<String> queue;
    PrepareProduction(List<String> q) {
        queue = q;
    }
    public void run() {
        queue.add("1");
        queue.add("done");
    }
}
