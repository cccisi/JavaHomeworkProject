package project_3;

/**
 * @Auther: cccis
 * @Date: 5/4/2018 20:03
 * @Description:
 */

//implements Runnable
public class ThreadTest1 extends Thread {
    public static void main(String[] args) {
        new ThreadTest1().start();
        new ThreadTest1().start();
    }

    public void run() {
        for (int i = 0; i < 10; i++)
            System.out.print(" " + i);
    }
}
