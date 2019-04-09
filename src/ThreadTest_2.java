import java.util.concurrent.locks.ReentrantLock;

public class ThreadTest_2 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Run_1("Thread 1"));
        t1.start();

        Thread t2 = new Thread(new Run_1("Thread 2"));
        t2.start();

        t1.join();
        t2.join();
    }
}

class Run_1 implements Runnable {

    String name = "";


    ReentrantLock lock = null;
    Run_1(String name) {
        lock = new ReentrantLock();
        this.name = name;
    }

    @Override
    public void run() {
        lock.lock();
        System.out.println(name + " ");
        try {

            for (int i = 1; i <= 30; i++) {

                System.out.print(i + " ");

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println();
        } finally {
            lock.unlock();
        }
    }
}
