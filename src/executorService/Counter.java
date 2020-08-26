package executorService;

public class Counter {
    private int count;
    public synchronized int increment() {
        return ++count;
    }

    public synchronized int getCount() {
        return count;
    }
}
