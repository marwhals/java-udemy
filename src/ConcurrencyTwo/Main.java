package ConcurrencyTwo;



public class Main {
    public static void main(String[] args) {
        var currentThread = Thread.currentThread();
        System.out.println(currentThread.getClass().getName());

        System.out.println(currentThread);
        printThreadState(currentThread);

        currentThread.setName("MainGuy");
        currentThread.setPriority(Thread.MAX_PRIORITY); // Priority is from 1 to 10 (max) and is more of a suggestion
        printThreadState(currentThread);
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