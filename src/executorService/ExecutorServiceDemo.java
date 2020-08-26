package executorService;

import java.util.concurrent.atomic.AtomicInteger;
//https://www.cnblogs.com/zhengbin/p/5653051.html
public class ExecutorServiceDemo {
    private static AtomicInteger num = new AtomicInteger();
    private static int count;
    private static volatile int volatileCount;
    private static Counter counter = new Counter();
    private static volatile Counter volatileCounter = new Counter();


    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                for(int j=0;j<1000;j++) {
                    num.getAndIncrement();
                    count++;
                    volatileCount++;
                    counter.increment();
                    volatileCounter.increment();
                }
            }).start();
        }

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("AtomicInteger num: " + num);
        System.out.println("int count: " + count);
        System.out.println("volatile int volatileCount: " + volatileCount);
        System.out.println("Counter counter: " + counter.getCount());
        System.out.println("volatile Counter volatileCounter: " + volatileCounter.getCount());
    }

}
