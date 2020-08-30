package DeadLock.waitAndNotify;

public interface AbstractStorage {
    void produce(int num, String threadName);
    void consume(int num, String threadName);
}
