package ConcurrencyTwo;


import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        var currentThread = Thread.currentThread();
        System.out.println(currentThread.getClass().getName());

        System.out.println(currentThread);
        printThreadState(currentThread);

        currentThread.setName("MainGuy");
        currentThread.setPriority(Thread.MAX_PRIORITY); // Priority is from 1 to 10 (max) and is more of a suggestion
        printThreadState(currentThread);

        CustomThread customThread = new CustomThread();
        customThread.start(); // Run is executed synchoronously from the running thread it is invoked from use start if you want it to be asynchronous

        /*
            - More flexibility implementing the runnable interface - loosely coupled to the thread class but less control.
         */
        Runnable myRunnable = () -> {
          System.out.println(" 2 ");
          try {
              TimeUnit.MILLISECONDS.sleep(250);
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
        };

        Thread myThread = new Thread(myRunnable);
        myThread.start();

        for (int i = 1; i<= 3; i ++) {
            System.out.println(" 0 ");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public static void printThreadState(Thread thread) {
        System.out.println("-------------");
        System.out.println("Thread ID: " + thread.getId());
        System.out.println(thread.getName());
        System.out.println(thread.getPriority());
        System.out.println(thread.getState());
        System.out.println(thread.getThreadGroup());
        System.out.println(thread.isAlive());
        System.out.println("-------------");

    }

}