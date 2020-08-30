package countdownlatch;

import java.util.concurrent.CountDownLatch;

public class ThreadTest1 extends Thread {
    CountDownLatch latch;
    ThreadTest1(CountDownLatch l) {
        this.latch = l;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(2L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("正在徐州,准备赶到南京坐飞机,经历了2小时的车程到机场");
        latch.countDown();
    }
}
