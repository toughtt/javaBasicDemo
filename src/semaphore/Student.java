package semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Student extends Thread {
    private String name;
    private Semaphore semaphore;

    Student(String name, Semaphore s) {
        this.name = name;
        this.semaphore = s;
    }
    @Override
    public void run() {
        try {
            System.out.println(name+"进入了餐厅");
            semaphore.acquire();
            System.out.println(name+"拿到了打饭许可");
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(name+"打好了饭，释放了这个窗口");
            semaphore.release();
        }


    }
}
