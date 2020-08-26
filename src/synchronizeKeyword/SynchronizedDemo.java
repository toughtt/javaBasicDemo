package synchronizeKeyword;

public class SynchronizedDemo {
    public void method() {
        synchronized (this) {
            System.out.println("synchronized code area.");
        }
    }

}
