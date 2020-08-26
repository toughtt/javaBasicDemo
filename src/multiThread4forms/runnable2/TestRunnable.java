package multiThread4forms.runnable2;

public class TestRunnable {
    public static void main(String[] args) {
        RunnableDemo runnableDemo =new RunnableDemo();
        new Thread(runnableDemo).start();
    }
}
