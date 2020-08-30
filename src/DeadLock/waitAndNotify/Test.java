package DeadLock.waitAndNotify;

public class Test {
    public static void main(String[] args) {
        AbstractStorage abstractStorage = new Storage();
        Producer p1 = new Producer(abstractStorage,10, "p1");
        Producer p2 = new Producer(abstractStorage,10, "p2");
        Producer p3 = new Producer(abstractStorage,10, "p3");
        Producer p4 = new Producer(abstractStorage,10, "p4");
        Producer p5 = new Producer(abstractStorage,10, "p5");
        Producer p6 = new Producer(abstractStorage,10, "p6");
        Producer p7 = new Producer(abstractStorage,70, "p7");

        Consumer c1 = new Consumer(abstractStorage, 50, "c1");
        Consumer c2 = new Consumer(abstractStorage, 20, "c2");
        Consumer c3 = new Consumer(abstractStorage, 30, "c3");
        c1.start();
        c2.start();
        c3.start();
        p1.start();
        p2.start();
        p3.start();
        p4.start();
        p5.start();
        p6.start();
        p7.start();
    }
}
