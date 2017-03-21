/**
 * Created by Kevin Gay on 20/03/2017.
 */
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * LinkedList Class
 */
public class LinkedList {
    private static class Node {
        /**
         * Circle data class
         */
        private Contact data;
        /**
         * Next Node Class
         */
        private Node next;

        /**
         * Init Node Class
         * @param s Circle parm
         */
        public Node(Contact s) {
            this.data = s;
            this.next = null;
        }

        /**
         * Create a Node Class with the next Node
         * @param s Circle Class
         * @param n Noce next class6
         */
        public Node(Contact s, Node n) {
            this.data = s;
            this.next = n;
        }

        /**
         * Get Data Contact
         * @return Contact
         */
        public Contact getData() {
            return data;
        }
    }

    /**
     * First Node Class
     */
    private Node first;
    /**
     * Last Node Class
     */
    private Node last;

    /**
     * Default Constructor LinkedList class
     */
    LinkedList() {
        this.first = null;
        this.last = null;
    }

    /**
     * Clone a List to a new List
     * @param list to clone
     */
    private LinkedList(LinkedList list){
        for (int i = 0; i < list.size(); i++){
            String str = "";
            str += list.getNode(i).data.getFirstName() + ",";
            str += list.getNode(i).data.getLastName() + ",";
            str += list.getNode(i).data.getPhoneNumber() + ",";
            str += list.getNode(i).data.getAddress() + ",";
            str += list.getNode(i).data.getCity() + ",";
            str += list.getNode(i).data.getZipCode();
            Contact contact = new Contact(str);
            add(contact);
        }
    }

    /**
     * Check if the linkedlist is empty
     * @return true or flase
     */
    private boolean isEmpty() {
        return first == null;
    }

    /**
     * Count the linkedlist
     * @return int
     */
    int size() {
        int count = 0;
        Node n = this.first;
        while( n != null ) {
            count++;
            n = n.next;
        }
        return count;
    }

    /**
     * get the Circle class from index
     * @param index index
     * @return Circle
     */
    Contact get(int index) {
        if( index < 0 || index > size()){
            System.out.println("Index out of bounds.");
            return null;
        } else {
            return getNode(index).data;
        }
    }

    /**
     * Return the node from the Index
     * @param index that you want
     * @return the Node of the Index
     */
    Node getNode(int index){
        if( index < 0 || index > size()){
            System.out.println("Index out of bounds.");
            return null;
        } else {
            Node n = this.first;
            for( int j = 1; j <= index; j++) {
                n = n.next;
            }
            return n;
        }
    }

    /**
     * Set new Circle Class from Index
     * @param i index
     * @param s  Contact to set
     */
    public void set(int i, Contact s) {
        if( i < 0 || i > size() ) {
            System.out.println("Index out of bounds.");
            return;
        }
        Node n = getNode(i);
        n.data = s;
    }

    /**
     * Return the List to a string
     * @return string
     */
    public String toString() {
        String str = "";
        int i = 0;
        Node n = this.first;
        while( n != null ) {
            str = str + String.valueOf(i++) + ") ";
            str = str + n.data.toString();
            n = n.next;
        }
        return str;
    }

    /**
     * Add new Circle class
     * @param s Circle class
     */
    void add(Contact s) {
        if(isEmpty()) {
            this.first = new Node(s);
            this.last = first;
        } else {
            Node n = new Node(s);
            this.last.next = n;
            this.last = n;
        }
    }

    /**
     * Remove the Node from an index
     * @param index to delete
     */
    void remove(int index) {
        Node n = getNode(index);
        if(n == null){
            System.out.println("The node doesn't exit");
            return;
        }

        if (index == 0) {
            this.first = this.first.next;
            return;
        }

        Node tmp = this.first;

        while (tmp.next != null){
            if ((tmp.next).data == n.data)
                tmp.next = (tmp.next).next;
            else
                tmp = tmp.next;
        }
    }

    /**
     * Remove From First And Last Name
     * @param firstName to find
     * @param lastName to find
     */
    void remove(String firstName, String lastName){
        if (this.first.data.getFirstName().equals(firstName) && this.first.data.getLastName().equals(lastName)) {
            this.first = this.first.next;
            return;
        }

        Node tmp = this.first;

        while (tmp.next != null){
            if ((tmp.next).data.getFirstName().equals(firstName) && (tmp.next).data.getLastName().equals(lastName))
                tmp.next = (tmp.next).next;
            else
                tmp = tmp.next;
        }
    }

    /**
     * Find from Last Name
     * @param lastName to find
     * @return a List of Contact
     */
    LinkedList search(String lastName){
        LinkedList listLastName = new LinkedList();

        if (this.first.data.getLastName().equals(lastName)) {
            listLastName.add(this.first.data);
        }

        Node tmp = this.first;

        while (tmp.next != null){
            if ((tmp.next).data.getLastName().equals(lastName))
                listLastName.add(tmp.next.data);
            tmp = tmp.next;
        }

        if (listLastName.isEmpty())
            System.out.println("Any " + lastName + " has been found");

        return listLastName;
    }

    /**
     * Find from Zip Code
     * @param zipCode to find
     * @return a List of Contact
     */
    LinkedList search(int zipCode){
        String code = String.valueOf(zipCode);
        LinkedList listZipCode = new LinkedList();

        if (this.first.data.getZipCode().equals(code)) {
            listZipCode.add(this.first.data);
        }

        Node tmp = this.first;

        while (tmp.next != null){
            if ((tmp.next).data.getZipCode().equals(code))
                listZipCode.add(tmp.next.data);
            tmp = tmp.next;
        }

        if (listZipCode.isEmpty())
            System.out.println("Any " + zipCode+ " has been found");

        return listZipCode;
    }

    /**
     * Update Contact
     * @param index to update
     */
    void updateContact(int index){
        Scanner sc = new Scanner(System.in);
        if (getNode(index) == null)
            return;

        System.out.print("Type the first name["+ getNode(index).data.getFirstName() + "]:");
        if (sc.hasNextLine())
            getNode(index).data.setFirstName(sc.nextLine());
        System.out.print("Type the last name["+ getNode(index).data.getLastName() + "]:");
        if (sc.hasNextLine())
            getNode(index).data.setLastName(sc.nextLine());
        System.out.print("Type the phone number["+ getNode(index).data.getPhoneNumber() + "]:");
        if (sc.hasNextLine())
            getNode(index).data.setPhoneNumber(sc.nextLine());
        System.out.print("Type the address["+ getNode(index).data.getAddress() + "]:");
        if (sc.hasNextLine())
            getNode(index).data.setAddress(sc.nextLine());
        System.out.print("Type the city["+ getNode(index).data.getCity() + "]:");
        if (sc.hasNextLine())
            getNode(index).data.setCity(sc.nextLine());
        System.out.print("Type the zip code["+ getNode(index).data.getZipCode() + "]:");
        if (sc.hasNextInt())
            getNode(index).data.setZipCode(sc.nextLine());
    }

    /**
     * Sorted the List
     * @param list to sort
     * @return sorted list
     */
    LinkedList sortedList(LinkedList list){
        LinkedList sorted = new LinkedList(list);

        for (int i = 0; i < sorted.size(); i++ ) {
            Node node = sorted.first;
            Node next = node.next;
            for (int j = 0; j < sorted.size() - 1; j++) {
                if (node.getData().compareTo(next.getData()) > 0) {
                    Contact tmp = node.data;
                    node.data = next.data;
                    next.data = tmp;
                }
                node = next;
                next = next.next;
            }
        }
        return sorted;
    }

    /**
     * Write in a file all the contact of the list
     */
    void writeInFile(){
        BufferedWriter bw = null;
        FileWriter fw = null;

        try {

            fw = new FileWriter("addresses.txt");
            bw = new BufferedWriter(fw);

            for (int i = 0; i < size(); i++){
                String str = "";
                str += getNode(i).data.getFirstName() + ",";
                str += getNode(i).data.getLastName() + ",";
                str += getNode(i).data.getPhoneNumber() + ",";
                str += getNode(i).data.getAddress() + ",";
                str += getNode(i).data.getCity() + ",";
                str += getNode(i).data.getZipCode() + "\n";
                bw.write(str);
            }

            System.out.println("addresses.txt has been updated!");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {

                if (bw != null)
                    bw.close();

                if (fw != null)
                    fw.close();

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

}
