package DeadLock.waitAndNotify;

import java.util.LinkedList;
import java.util.List;

public class Storage implements AbstractStorage {
    private LinkedList list = new LinkedList();
    private final int MAX_SIZE = 100;


    @Override
    public void produce(int num, String threadName) {
        synchronized (list) {
            while (list.size()+num>MAX_SIZE) {
                System.out.println("【当前线程】:"+ threadName + "【要生产的产品数量】:" + num + "\t【库存量】:"
                       + list.size() + "\t暂时不能执行生产任务!");
                try {
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for(int i=0;i<num;i++){
                list.add(new Object());
            }
            System.out.println("【当前线程】:"+ threadName + "【已经生产产品数】:"+num+"\t【现仓储量为】:"+list.size());
            list.notifyAll();
        }
    }

    @Override
    public void consume(int num, String threadName) {
        synchronized (list){
            while (num>list.size()) {
                System.out.println("【当前线程】:"+ threadName + "【要消费的产品数量】:" + num + "\t【库存量】:"
                        + list.size() + "\t暂时不能执行生产任务!");
                try {
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for (int i = 0; i <num; i++) {
                list.remove();
            }
            System.out.println("【当前线程】:"+ threadName + "【已经消费产品数】:"+num+"\t【现仓储量为】:"+list.size());
            list.notifyAll();
        }
    }
}
