package DeadLock;

//https://www.cnblogs.com/jxldjsn/p/10872154.html
public class DeadLockDemo {
    private static Object resource1= new Object();
    private static Object resource2= new Object();

    public static void main(String[] args) {
        new Thread(
                ()->{
                    synchronized (resource1) {
                        System.out.println(Thread.currentThread()+"get resource1");
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread()+"waiting to get resource2");
                        synchronized (resource2) {
                            System.out.println(Thread.currentThread()+"get resource2");
                            System.out.println("线程1 get resource2:"+System.currentTimeMillis());
                        }
                    }
                },"线程1"

        ).start();

        new Thread(() -> {
            synchronized (resource1) {
                System.out.println(Thread.currentThread() + "get resource1");
                System.out.println("线程2 get resource1:"+System.currentTimeMillis());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + "waiting to get resource2");
                synchronized (resource2) {
                    System.out.println(Thread.currentThread() + "get resource2");
                }
            }
        }, "线程 2").start();

    }


}
