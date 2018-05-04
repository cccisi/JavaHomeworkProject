package project_3;

/**
 * @Auther: cccis
 * @Date: 5/4/2018 20:10
 * @Description:
 */

public class ThreadTest4 implements Runnable {
    public static void main(String[] args) {
        Runnable r = new ThreadTest4();
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        t1.start();
        t2.start();
    }

    public void run() {
        synchronized (this) {
            for (int i = 0; i < 10; i++)
                System.out.print(" " + i);
        }
    }
}