package doubleCheckLock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MySingleton1 {
    private static MySingleton1 instance;
    private MySingleton1() {
        System.out.println("MySingleton1 execute.");
    }

    public static MySingleton1 getInstance1() {
        if(instance==null){
            instance = new MySingleton1();
        }
        return instance;
    }

    public static void main(String[] args) {
        System.out.println("start myInstance1.");

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for(int i =0;i<10;i++) {
            executorService.submit(()->{MySingleton1 m = new MySingleton1();});
        }
        System.out.println("end myInstance1.");
    }
}
