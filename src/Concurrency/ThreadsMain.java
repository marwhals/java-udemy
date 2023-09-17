package Concurrency;

import java.awt.desktop.SystemSleepEvent;

import static Concurrency.ThreadColor.*;

public class ThreadsMain {
    public static void main(String[] args) {
        System.out.println(ANSI_PURPLE+"Hello from the main thread.");

        Thread anotherThread = new AnotherThread();
        anotherThread.setName("==== Another name ====");
        anotherThread.start(); // Want to use start method not run method when running a thread

        new Thread() {
            public void run() {
                System.out.println(ANSI_GREEN + "Hello from the anonymous class thread");
            }
        }.start();

//        Thread myRunnableThread = new Thread(new MyRunnable());
        Thread myRunnableThread = new Thread(new MyRunnable() {
            @Override
            public void run() {
                System.out.println(ANSI_RED + "Hello from the anonymous class's implementation of runnable ");
            }
        });

        myRunnableThread.start();

        System.out.println(ANSI_PURPLE+"Hello again from the main thread.");

    }
}
