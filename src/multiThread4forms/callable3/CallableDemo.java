package multiThread4forms.callable3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
//https://blog.csdn.net/qq_38974634/article/details/81315900
public class CallableDemo implements Callable<List<Integer>> {
    @Override
    public List<Integer> call() throws Exception {
        boolean flag= false;
        List<Integer> lists = new ArrayList<>();
        for (int i=3;i<100;i++) {
            flag = false;
            for (int j=2;j<Math.sqrt(i);j++) {
                if (i%j==0) {
                    flag = true;
                    break;
                }
            }
            if(!flag) {
                //System.out.print(i+" ");
                lists.add(i);
            }
        }


        return lists;
    }
}
