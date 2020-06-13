package withBrigadier;


public class Brigadier extends Thread {

    public void run() {
        Worker w1 = new Worker("First", 1000L);
        Worker w2 = new Worker("Second", 500L);
        Worker w3 = new Worker("Third", 300L);
        System.out.println("Workers start work");
        w1.start();
        w2.start();
        w3.start();

        for (int i = 0; i < 3; i++) {
            try {
                sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            w1.interrupt();
            w2.interrupt();
            w3.interrupt();
        }

        try {
            w1.join();
            w2.join();
            w3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Common count is " + Worker.commonCount);
        System.out.println("Finish brigadire work");


    }

}
