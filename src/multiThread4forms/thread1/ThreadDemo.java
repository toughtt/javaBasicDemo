package multiThread4forms.thread1;

public class ThreadDemo extends Thread {
    @Override
    public void run() {
        boolean flag= false;
        for (int i=3;i<100;i++) {
            flag = false;
            for (int j=2;j<Math.sqrt(i);j++) {
                if (i%j==0) {
                    flag = true;
                    break;
                }
            }
            if(!flag) {
                System.out.print(i+" ");
            }
        }
    }
}
