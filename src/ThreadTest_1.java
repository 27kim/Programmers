public class ThreadTest_1 {
    public static void main(String[] args) throws InterruptedException {

        for(int i = 1 ; i <= 10 ; i++){
            System.out.println("Main : " + i);
        }

        Thread t1 = new Thread(new Run("Thread 1"));
        Thread t2 = new Thread(new Run("Thread 2"));

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}

class Run implements Runnable{

    String name = "";

    Run(String name){
        this.name= name;
    }
    @Override
    public void run() {
        for(int i = 1 ; i <= 10 ; i++){
            System.out.println(name + " : " + i);

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
