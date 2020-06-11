public class WorkersRunnable {

        private static volatile Integer commonCountPocket = 0;

    public static void main(String[] args) throws InterruptedException {

        long startTime = System.currentTimeMillis();
        Thread w1 = new Thread(new Worker("First", 1000L));
        Thread w2 = new Thread(new Worker("Second", 500L));
        Thread w3 = new Thread(new Worker("Third", 300L));
        w1.start();
        w2.start();
        w3.start();
        w1.join();
        w2.join();
        w3.join();


        long finishTime = System.currentTimeMillis() - startTime;
        System.out.println("__________________________________________________________");
        System.out.println("Finish. All workers time is " + finishTime + ". Common count of pockets is " + commonCountPocket);
    }


    private static class Worker implements Runnable {

        String workName;
        Long sleepTime;
        Long workHours;
        int countPocket;

        public Worker(String workName, Long sleepTime) {
            this.sleepTime = sleepTime;
            this.workName = workName;
            this.workHours = 8000L;
            this.countPocket = 0;
        }

        public void run() {
            System.out.println("Worker " + workName + " starts work");
            while (workHours > 0 && workHours - sleepTime > -1) {
                commonCountPocket++;
                countPocket++;
                commonCountPocket++;
                workHours = workHours - sleepTime;
                System.out.println("Worker " + workName + " makes " + countPocket + " pocket. Remaining time: " + workHours);

                try {
                    Thread.sleep(sleepTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("__________________________________________________________");
            System.out.println("Worker " + workName + " finish work and he done " + countPocket);

            System.out.println("Common count of pocket is: " + commonCountPocket + ". Remainig worker time: " + workHours);

        }

    }

}
