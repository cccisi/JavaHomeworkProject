package project_3;

/**
 * @Auther: cccis
 * @Date: 5/4/2018 20:06
 * @Description:
 */

public class ThreadTest2 implements Runnable {
    public static void main(String[] args) {
        Runnable r1 = new ThreadTest2();
        Runnable r2 = new ThreadTest2();
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.start();
        t2.start();
    }

    public synchronized void run() {
        for (int i = 0; i < 10; i++)
            System.out.print(" " + i);
    }
}
