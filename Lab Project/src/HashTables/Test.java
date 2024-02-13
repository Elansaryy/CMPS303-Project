package HashTables;

import stack_queue.LinkedStack;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.InputMismatchException;
import java.util.Scanner;

//Abdulrahman Qasim Al-shawabkeh - 202108150
//Mohamed Elansari - 202209852
//Ahmad Almashhadani - 202203014

public class Test implements Serializable {
    int choice;
    String getUrl;
    String getTitle;
    String getDate;
    String getTime;
    ObjectInputStream in;
    ObjectOutputStream out;
    boolean validTime;
    boolean validDate;

    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    Scanner kb = new Scanner(bufferedReader);


    public static void main(String arg[]) throws IOException {
        new Test();
    }
    public static void displayOptions() {
        System.out.println("1- Add Website.");
        System.out.println("2- Delete Website.");
        System.out.println("3- Search Website.");
        System.out.println("4- Print Websites.");
        System.out.println("5- Exit");
        System.out.print("Enter your choice:");

    }
    public ChainingHashTable<Object> readFile() {
        try {
            in = new ObjectInputStream(new FileInputStream("webHistory.dat"));
            return (ChainingHashTable<Object>) in.readObject();
        } catch (IOException e) {
            return new ChainingHashTable<>(100000);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean isDateValid(String dateStr) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(dateStr);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    public static boolean isTimeValid(String timeStr) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        timeFormat.setLenient(false);
        try {
            timeFormat.parse(timeStr);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    public Test() throws IOException {
        ChainingHashTable<Object> myHash = readFile();

        while (true) {
            try {
                displayOptions();
                choice = kb.nextInt();
                while (choice < 0 || choice > 5) {
                    System.out.print("Please enter a value from 1-5 or zero to exit: ");
                    choice = kb.nextInt();
                }
            } catch (InputMismatchException err) {
                System.err.println("please enter an integer from 0-5: ");
                kb.nextLine();
                continue;
            }
            switch (choice) {
                case 1 -> {
                    kb.nextLine();
                    System.out.print("Enter the URL: ");
                    getUrl = kb.nextLine();
                    validDate = false;
                    while (!validDate) {
                        System.out.print("Enter the Date in \"dd-mm-yyyy\" format: ");
                        getDate = kb.nextLine();
                        if (isDateValid(getDate)) {
                            validDate = true;
                        } else {
                            System.out.print("Invalid date format. Please enter a date in the format (dd-MM-yyyy): ");
                        }
                    }
                    validTime = false;
                    while (!validTime) {
                        System.out.print("Enter a time (hh:mm:ss): ");
                        getTime = kb.nextLine();
                        if (isTimeValid(getTime)) {
                            validTime = true;
                        } else {
                            System.out.print("Invalid time format. Please enter a time in the format (hh:mm:ss): ");
                        }
                    }
                    System.out.print("Enter the Title: ");
                    getTitle = kb.nextLine();
                    myHash.addWebsite(getDate, getUrl, getTitle, getTime);
                }
                case 2 -> {
                    kb.nextLine();
                    validDate = false;
                    while (!validDate) {
                        System.out.print("Enter the Date in \"dd-mm-yyyy\" format: ");
                        getDate = kb.nextLine();
                        if (isDateValid(getDate)) {
                            validDate = true;
                        } else {
                            System.out.print("Invalid date format. Please enter a date in the format (dd-MM-yyyy): ");
                        }
                    }
                    System.out.println("Enter the URL: ");
                    getUrl = kb.nextLine();
                    myHash.deleteWebsite(getDate, getUrl);
                }
                case 3 -> {
                    kb.nextLine();
                    System.out.println("Enter the URL: ");
                    getUrl = kb.nextLine();
                    myHash.SearchWebsite(getUrl);
                }
                case 4 -> {
                    kb.nextLine();
                    validDate = false;
                    while (!validDate) {
                        System.out.print("Enter the Date in \"dd-mm-yyyy\" format: ");
                        getDate = kb.nextLine();
                        if (isDateValid(getDate)) {
                            validDate = true;
                        } else {
                            System.out.print("Invalid date format. Please enter a date in the format (dd-MM-yyyy): ");
                        }
                    }
                    myHash.displayAllWebsites(getDate);
                }
                case 5 -> {
                    System.out.println("Exiting...");
                    kb.close();
                    out = new ObjectOutputStream(new FileOutputStream("webHistory.dat"));
                    out.writeObject(myHash);
                    out.close();
                    System.exit(0);
                }
            }
        }
    }
}

