package withBrigadier;

public class Worker extends Thread {

    private static volatile Journal journal = new Journal();
     static volatile Integer commonCount = 0;
    private String name;
    private Long speed;
    private Integer privateCountOfPocket;

     Worker(String name, Long speed) {
        this.name = name;
        this.speed = speed;
        this.privateCountOfPocket = 0;
    }

    public void run() {
        System.out.println("Worker " + name + " starts work");
        journal.putWorker(name, privateCountOfPocket);


        while (commonCount != 101) {
            privateCountOfPocket++;
            synchronized (commonCount) {
                commonCount++;
            }
            writeToJournal();
            System.out.println("Worker " + name + " makes " + privateCountOfPocket);
            try {
                sleep(speed);
            } catch (InterruptedException e) {
                System.out.println("Worker " + name + " comes to launch. He made " + journal.getPrivateCountFromJournal(name) + " pockets");
                try {
                    sleep(1000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }

        }
        System.out.println("Worker " + name + " finish works. " +
                " Worker makes " + journal.getPrivateCountFromJournal(name) + " pockets");
    }


    private synchronized void writeToJournal() {
        journal.writeCount(name, privateCountOfPocket);
    }

}
