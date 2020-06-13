package withBrigadier;

public class WorkingProcess {

    public static void main(String[] args) throws InterruptedException {

        Brigadier brigadier = new Brigadier();
        brigadier.start();
        brigadier.join();
        System.out.println("Finish workday");
    }
}
