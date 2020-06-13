package withBrigadier;


import java.util.HashMap;

class Journal {


    private HashMap<String, Integer> table = new HashMap<>();

    synchronized void putWorker(String name, Integer privateCountOfPocket) {
        table.put(name, privateCountOfPocket);
    }

    synchronized void writeCount(String name, Integer privateCountOfPocket) {
        if (table.containsKey(name)) {
            table.replace(name, privateCountOfPocket);
        } else {
            System.err.println("Incorrect name");
        }
    }

    synchronized Integer getPrivateCountFromJournal(String name) {
        Integer privateCountOfPockets = table.get(name);
        return privateCountOfPockets;

    }

}
