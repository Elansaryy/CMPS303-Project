package HashTables;

import java.io.Serializable;

public class ChainingHashTable<E> implements Serializable {
    private StackTable[] hashArray;

    public ChainingHashTable(int size) {
        hashArray = new StackTable[size];
        for (int j = 0; j < hashArray.length; j++)
            hashArray[j] = new StackTable();
    }

    public int hashFunc(int key) {
        return key % hashArray.length;
    }

    public void addWebsite(String date, String url, String title, String Time) {
        int hashVal = hashFunc(Math.abs(date.hashCode()));
        hashArray[hashVal].addWebsite(date, url, title, Time);
    }
        public void deleteWebsite(String date, String url) {
        int hashVal = hashFunc(Math.abs(date.hashCode()));
            hashArray[hashVal].deleteWebsite(url);
    }
    public void SearchWebsite(String url) {
        int count = 0;
        for (int i = 0; i < hashArray.length; i++) {
            count+=hashArray[i].SearchWebsite(url);
        }
        if (count == 0)
            System.out.println("This Website Never been visited");
    }
    public void displayAllWebsites(String date) {
        int hashVal = hashFunc(Math.abs(date.hashCode()));
        boolean exists = hashArray[hashVal].displayAllWebsites();
        if (!exists) {
            System.out.println("There are no websites visited on this day");
        }

    }
}
