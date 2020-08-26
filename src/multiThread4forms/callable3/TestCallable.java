package multiThread4forms.callable3;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class TestCallable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CallableDemo callableDemo= new CallableDemo();
        FutureTask<List<Integer>> futureTask = new FutureTask<>(callableDemo);
        new Thread(futureTask).start();
        List<Integer> lists =  futureTask.get();
        for(Integer i : lists) {
            System.out.print(i+" ");
        }
    }

}
