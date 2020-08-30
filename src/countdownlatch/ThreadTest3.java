package countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class ThreadTest3 extends Thread {
    CountDownLatch latch;
    ThreadTest3(CountDownLatch l) {
        this.latch = l;
    }

    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("正在芜湖,准备赶到南京坐飞机,经历了5小时的车程到机场");
        latch.countDown();
    }
}
