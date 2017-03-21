import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Boolean isWorking = true;
        LinkedList list = new LinkedList();
        Scanner sc = new Scanner(System.in);
        parseFiles(list);

        while (isWorking) {
            while (isWorking) {
                System.out.println("\na. Add new Contact\n" +
                        "b. Remove a Contact\n" +
                        "c. Search\n" +
                        "d. Update\n" +
                        "e. Print Number of Contact\n" +
                        "f. Display all Contacts\n" +
                        "q. quit"
                );

                System.out.print("Choice: ");
                if (sc.hasNextLine()) {
                    switch (sc.nextLine()) {
                        case "a":
                            list.add(new Contact());
                            break;
                        case "b":
                            removeContact(list);
                            break;
                        case "c":
                            searchContact(list);
                            break;
                        case "d":
                            updateContact(list);
                            break;
                        case "e":
                            System.out.println("You have " + list.size() + " contacts");
                            break;
                        case "f":
                            list.sortedList(list);
                            System.out.println(list.toString());
                            break;
                        case "q":
                            isWorking = false;
                            list.writeInFile();
                            break;
                    }
                }
            }
        }
    }

    private static void updateContact(LinkedList list){
        boolean isWorking = true;
        Scanner sc = new Scanner(System.in);

        System.out.println(list.toString());
        System.out.print("Enter the contact that you want to update");

        if (sc.hasNextInt())
            list.updateContact(sc.nextInt());

        System.out.println(list.toString());
    }

    private static void searchContact(LinkedList list){
        boolean isWorking = true;
        Scanner sc = new Scanner(System.in);

        while (isWorking) {
            System.out.println("a. Search contact by Last Name\n" +
                    "b. Search contact by Zip Code\n"
            );
            if (sc.hasNextLine()) {
                switch (sc.nextLine()) {
                    case "a":
                        System.out.print("Enter the last name: ");
                        if (sc.hasNextLine())
                            System.out.println(list.searchByLastName(sc.nextLine()).toString());
                        break;
                    case "b":
                        System.out.print("Enter the zip code: ");
                        if (sc.hasNextInt())
                            System.out.println(list.searchByZipCode(sc.nextLine()).toString());
                        break;
                }
                isWorking = false;
            }
        }
    }

    private static void removeContact(LinkedList list) {
        boolean isWorking = true;
        Scanner sc = new Scanner(System.in);

        while (isWorking) {
            System.out.println("a. Delete With First and Last Name\n" +
                    "b. By Index\n"
            );
            if (sc.hasNextLine()) {
                switch (sc.nextLine()) {
                    case "a":
                        removeByLastAndFirstName(list, sc);
                        break;
                    case "b":
                        System.out.print("Enter the index you want to delete: ");
                        if (sc.hasNextInt())
                            list.remove(sc.nextInt());
                        break;
                }
                isWorking = false;
            }
        }
    }

    private static void removeByLastAndFirstName(LinkedList list, Scanner sc){
        String firstName = "";
        String lastName = "";

        System.out.print("Enter the first name: ");
        if(sc.hasNextLine())
            firstName = sc.nextLine();

        System.out.print("Enter the last name: ");
        if(sc.hasNextLine())
            lastName = sc.nextLine();

        list.removeByFirstAndLastName(firstName, lastName);
    }

    /**
     * Parse the file to get the questions inside it
     * @param list of contact
     */
    private static void parseFiles(LinkedList list){
        String str = "";
        File file = new File("addresses.txt");

        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                str = sc.nextLine();
                list.add(new Contact(str));
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("We didnt find your file");
        }
    }
}
