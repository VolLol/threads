
public class WorkersThreads {
    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        Worker w1 = new Worker("First", 1000L);
        Worker w2 = new Worker("Second", 500L);
        Worker w3 = new Worker("Third", 300L);
        w1.start();
        w2.start();
        w3.start();
        w1.join();
        w2.join();
        w3.join();

        long finishTime = System.currentTimeMillis() - startTime;
        System.out.println("End. All workers time is " + finishTime);
    }


    private static class Worker extends Thread {

        String workName;
        Long sleepTime;

        public Worker(String workName, Long sleepTime) {
            this.sleepTime = sleepTime;
            this.workName = workName;
        }

        public void run() {
            System.out.println("Worker " + workName + " starts work");

            for (int i = 1; i < 11; i++) {
                System.out.println("Worker " + workName + " makes " + i + " pocket");
                try {
                    sleep(sleepTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Worker " + workName + " finish work");
        }

    }
}

