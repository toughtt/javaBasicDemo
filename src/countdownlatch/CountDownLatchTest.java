package countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CountDownLatchTest {
    public static void main(String[] args) {
        System.out.println("南京禄口机场_机长正在等待所有乘客登机");
        long starttime = System.currentTimeMillis();
        //CountDownLatch的计数器数量必须与线程的数量一致,否则可能出现一直等待的情况,即计数器不为0的情况
        //使用CountDownLatch 需要注意,子线程中的countDown()最好放到finnally里面,防止计数器不为0
        CountDownLatch countDownLatch = new CountDownLatch(3);
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new ThreadTest1(countDownLatch));
        executorService.execute(new ThreadTest2(countDownLatch));
        executorService.execute(new ThreadTest3(countDownLatch));
        //等待所有乘客来机场
        System.out.println("所有乘客都在赶飞机的路上");
        try {
            //countDownLatch.await(2, TimeUnit.SECONDS);//模拟超时等待的情况
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("南京禄口机场_机长启动飞机起飞");
        long endtime = System.currentTimeMillis();
        long duration = endtime - starttime;
        System.out.println("机长就位到起飞耗时："+ duration);
        executorService.shutdown();

    }


}
