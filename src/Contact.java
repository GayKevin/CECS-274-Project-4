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
    /**
     * Phone number of the Contact
     */
    private String phoneNumber;
    /**
     * Adresse of the Contact
     */
    private String address;
    /**
     * City of the contact
     */
    private String city;
    /**
     * Zip Code of the Contact
     */
    private String zipCode;

    /**
     * Default Constructor to create a contact
     * @param contact is the string from a file
     */
    Contact(String contact){
        String[] split = contact.split(",");
        this.firstName = split[0];
        this.lastName = split[1];
        this.phoneNumber = split[2];
        this.address = split[3];
        this.city = split[4];
        this.zipCode = split[5];
    }

    /**
     * Create a Contact from user input
     */
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

    /**
     * Get the Last name
     * @return String
     */
    String getLastName() {
        return lastName;
    }

    /**
     * set The Last Name
     * @param lastName to set
     */
    void setLastName(String lastName) {
        if(!checkIfEmpty(lastName))
            return;
        this.lastName = lastName;
    }

    /**
     * Get the First Name
     * @return String
     */
    String getFirstName() {
        return firstName;
    }

    /**
     * Set the First Name
     * @param firstName to set
     */
    void setFirstName(String firstName) {
        if(!checkIfEmpty(firstName))
            return;

        this.firstName = firstName;
    }

    /**
     * Get the phone number
     * @return String
     */
    String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Set the Phone Nuber
     * @param phoneNumber to set
     */
    void setPhoneNumber(String phoneNumber) {
        if(!checkIfEmpty(phoneNumber))
            return;

        this.phoneNumber = phoneNumber;
    }

    /**
     * Return the address
     * @return String
     */
    String getAddress() {
        return address;
    }

    /**
     * Set the address
     * @param address to set
     */
    void setAddress(String address) {
        if(!checkIfEmpty(address))
            return;

        this.address = address;
    }

    /**
     * Get the city
     * @return String
     */
    String getCity() {
        return city;
    }

    /**
     * Set the city
     * @param city to set
     */
    void setCity(String city) {
        if(!checkIfEmpty(city))
            return;

        this.city = city;
    }

    /**
     * Get the zip code
     * @return String
     */
    String getZipCode() {
        return zipCode;
    }

    /**
     * Set the Zip Code
     * @param zipCode to set
     */
    void setZipCode(String zipCode) {
        if(!checkIfEmpty(zipCode))
            return;

        this.zipCode = zipCode;
    }

    /**
     * Check if the String is empty
     * @param str String
     * @return True or False
     */
    private boolean checkIfEmpty(String str){
        return !str.equals("");
    }

    /**
     * Check if the Two Object are equals
     * @param obj to check
     * @return True or False
     */
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

    /**
     * Compare two Object
     * @param contact to Compary
     * @return number of difference
     */
    int compareTo(Contact contact){
        int compareTo = this.lastName.compareTo(contact.getLastName());

        if(compareTo == 0)
            return this.firstName.compareTo(contact.getFirstName());
        else
            return compareTo;
    }

    /**
     * Return the Contact Object into String
     * @return String
     */
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