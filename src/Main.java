import java.io.*;
import java.util.Scanner;

/**
 * Main Class
 */
public class Main {

    /**
     * Main Function
     * @param args
     */
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
                            System.out.println(list.sortedList(list).toString());
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

    /**
     * Function to call the Update Contact
     * @param list to update
     */
    private static void updateContact(LinkedList list){
        boolean isWorking = true;
        Scanner sc = new Scanner(System.in);

        System.out.println(list.toString());
        System.out.print("Enter the contact that you want to update");

        if (sc.hasNextInt())
            list.updateContact(sc.nextInt());
    }

    /**
     * Search Menu
     * @param list to search
     */
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
                            System.out.println(list.search(sc.nextLine()).toString());
                        break;
                    case "b":
                        System.out.print("Enter the zip code: ");
                        if (sc.hasNextInt())
                            System.out.println(list.search(sc.nextInt()).toString());
                        break;
                }
                isWorking = false;
            }
        }
    }

    /**
     * Remove contact menu
     * @param list to remove
     */
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

    /**
     * Remove contact Menu
     * @param list to remove
     * @param sc Scanner
     */
    private static void removeByLastAndFirstName(LinkedList list, Scanner sc){
        String firstName = "";
        String lastName = "";

        System.out.print("Enter the first name: ");
        if(sc.hasNextLine())
            firstName = sc.nextLine();

        System.out.print("Enter the last name: ");
        if(sc.hasNextLine())
            lastName = sc.nextLine();

        list.remove(firstName, lastName);
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
