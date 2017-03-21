import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;
import sun.security.jca.GetInstance;

import java.util.Scanner;

/**
 * Created by Kevin Gay on 20/03/2017.
 */

/**
 * Contact class to stock the data
 */
public class Contact {
    /**
     * Last Name of the contact
     */
    private String lastName;
    /**
     * First of the Contact
     */
    private String firstName;
    private String phoneNumber;
    private String address;
    private String city;
    private String zipCode;

    Contact(String contact){
        String[] split = contact.split(",");
        this.firstName = split[0];
        this.lastName = split[1];
        this.phoneNumber = split[2];
        this.address = split[3];
        this.city = split[4];
        this.zipCode = split[5];
    }

    Contact(){
        addContact();
    }

    /**
     * Add a new Contact
     */
    private void addContact() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Add the First Name : ");
        if (sc.hasNextLine())
            this.firstName = sc.nextLine();
        System.out.print("Add the Last Name : ");
        if (sc.hasNextLine())
            this.lastName = sc.nextLine();
        System.out.print("Add the Phone Number : ");
        if (sc.hasNextLine())
            this.phoneNumber = sc.nextLine();
        System.out.print("Add the Address : ");
        if (sc.hasNextLine())
            this.address = sc.nextLine();
        System.out.print("Add the City : ");
        if (sc.hasNextLine())
            this.city = sc.nextLine();
        System.out.print("Add the Zip Code : ");
        if (sc.hasNextLine())
            this.city = sc.nextLine();
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if(!checkIfEmpty(lastName))
            return;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if(!checkIfEmpty(firstName))
            return;

        this.firstName = firstName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if(!checkIfEmpty(phoneNumber))
            return;

        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if(!checkIfEmpty(address))
            return;

        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        if(!checkIfEmpty(city))
            return;

        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    private boolean checkIfEmpty(String str){
        return !str.equals("");
    }

    public void setZipCode(String zipCode) {
        if(!checkIfEmpty(zipCode))
            return;

        this.zipCode = zipCode;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Contact){
            if (this.firstName.equals(((Contact) obj).getFirstName()))
                if(this.lastName.equals(((Contact) obj).lastName))
                    return true;
            return false;
        }

        return super.equals(obj);
    }

    public int compareTo(Contact contact){
        int compareTo = this.firstName.compareTo(contact.getFirstName());

        if(compareTo == 0)
            return this.lastName.compareTo(contact.getLastName());
        else
            return compareTo;
    }

    @Override
    public String toString(){
        String str = "";
        str = str + this.firstName + " ";
        str = str + this.lastName + " ";
        str = str + this.phoneNumber + " ";
        str = str + this.address + " ";
        str = str + this.city + " ";
        str = str + this.zipCode + "\n";

        return str;
    }
}