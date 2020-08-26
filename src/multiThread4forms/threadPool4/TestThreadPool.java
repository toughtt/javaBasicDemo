package multiThread4forms.threadPool4;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class TestThreadPool {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService= Executors.newFixedThreadPool(5);
        List<Future<List<Integer>>> lists = new ArrayList<>();
        for(int i=0;i<5;i++) {
            Future<List<Integer>> eachLists =executorService.submit(new Callable<List<Integer>>() {
                @Override
                public List<Integer> call() throws Exception {
                    boolean flag = false;
                    System.out.println(Thread.currentThread().getName()+"  ");
                    List<Integer> lists = new ArrayList<>();
                    for(int i  = 3 ; i < 100 ; i ++) {
                        flag = false;
                        for(int j = 2; j <= Math.sqrt(i) ; j++) {
                            if(i % j == 0) {
                                flag = true;
                                break;
                            }
                        }
                        if(flag == false) {
                            lists.add(i);
                        }
                    }
                    return lists;
                }
            });
            lists.add(eachLists);
        }
        for (Future<List<Integer>> t:lists) {
            System.out.println(t.get());
            System.out.println(t.getClass());
        }
    }
}
