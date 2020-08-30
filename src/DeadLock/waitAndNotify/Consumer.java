package DeadLock.waitAndNotify;

public class Consumer extends Thread {
    private AbstractStorage abstractStorage;
    private int num;
    private String threadName;

    protected Consumer(AbstractStorage a,int n, String name){
        abstractStorage=a;
        num=n;
        threadName = name;
    }

    @Override
    public void run() {
        consume(num, threadName);
    }
    private void consume(int n, String threadName){
        abstractStorage.consume(n, threadName);
    }
}
