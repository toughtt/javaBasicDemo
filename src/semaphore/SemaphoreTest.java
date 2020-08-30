package semaphore;

import java.util.concurrent.Semaphore;
//https://baijiahao.baidu.com/s?id=1648357437301661861&wfr=spider&for=pc
public class SemaphoreTest {
    static Semaphore semaphore = new Semaphore(3);
    private static final int STUDENT_SIZE = 10;
    public static void main(String[] args) {
        for (int i = 0; i <STUDENT_SIZE ; i++) {
            new Student("学生" + i, semaphore).start();
        }
    }
}
