package DeadLock.waitAndNotify;

public class Producer extends Thread {
    private AbstractStorage abstractStorage;
    private int num;
    private String threadName;

    Producer(AbstractStorage a, int n, String name) {
        abstractStorage = a;
        num = n;
        threadName = name;
    }

    @Override
    public void run() {
        //start produce action
        produce(num, threadName);
    }

    private void produce(int num, String threadName) {
        abstractStorage.produce(num,threadName);
    }
}
