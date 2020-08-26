package doubleCheckLock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
//https://www.cnblogs.com/xiemingjun/p/9629025.html
/*
* 32    public static synchronized Singleton getInstanceTS() {
33        if (_instance == null) {
34            _instance = new Singleton();
35        }
36        return _instance;
37    }
* */
//把整个getInstance()方法设为同步（synchronized），就像我们展示的第二段示例代码getInstanceTS()方法一样。尽管这样做到了线程安全，并且解决了多实例问题，但并不高效。
// -----在任何调用这个方法的时候，你都需要承受同步带来的性能开销，然而同步只在第一次调用的时候才被需要，也就是单例类实例创建的时候。------
// 这将促使我们使用双重检查锁模式（double checked locking pattern），一种只在临界区代码加锁的方法。
// 程序员称其为双重检查锁，因为会有两次检查 _instance == null，一次不加锁，另一次在同步块上加锁。
public class MySingleton {
    private volatile static MySingleton instance;
    private MySingleton(){
        System.out.println("execute MySingleton().");
    }
    private static MySingleton getMyInstance() {
        if(instance == null) {
            synchronized (MySingleton.class) {
                if(instance == null) {
                    instance = new MySingleton();
                }
            }

        }
        return instance;
    }

    public static void main(String[] args) {
        //MySingleton myInstance = new MySingleton();
        System.out.println("start myInstance.");

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for(int i =0;i<10;i++) {
            executorService.submit(()->{MySingleton m = new MySingleton();});
        }
        System.out.println("end myInstance.");
    }
}
