package threadYeild;
//https://www.jianshu.com/p/1b2dcb98ead1
/*
* 当调用Thread.yield()方法时,会给线程调度器一个当前线程愿意让出CPU使用的暗示,但是线程调度器可能会忽略这个暗示.
* */
public class YeildDemo {
    public static void main(String[] args) {
        Runnable r = ()->{
            for(int i=0;i<10;i++){
                System.out.println(Thread.currentThread().getName()+" "+i);
                if(i==5) {
                    Thread.yield();
                }
            }
        };
        new Thread(r,"thread A:").start();
        new Thread(r,"Thread B:").start();
    }
}
