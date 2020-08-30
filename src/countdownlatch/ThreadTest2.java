package countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class ThreadTest2 extends Thread {
    CountDownLatch latch;
    ThreadTest2(CountDownLatch l) {
        this.latch = l;
    }

    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("正在马鞍山,准备赶到南京坐飞机,经历了3小时的车程到机场");
        latch.countDown();
    }
}
