package address.data;

/**
 * A class representing an entry in the address book.
 *  @author [Jimin Kim]
 *  @since [2024-02-16]
 */
public class AddressEntry {
    /** The first name of the individual */
    private String firstName;

    /** The last name of the individual */
    private String lastName;

    /** The street address */
    private String street;

    /** The city */
    private String city;

    /** The state */
    private String state;

    /** The zip code */
    private Integer zip;

    /** The phone number */
    private String phone;

    /** The email address */
    private String email;

    /** The index of the address entry */
    public int index = 0;

    /**
     * Default constructor
     */
    public AddressEntry(){

    }

    /**
     * Constructor to initialize an address entry with given parameters.
     * @param firstName The first name
     * @param lastName The last name
     * @param street The street address
     * @param city The city
     * @param state The state
     * @param zip The zip code
     * @param email The email address
     * @param phone The phone number
     */
    public AddressEntry(String firstName, String lastName, String street, String city, String state, Integer zip, String email, String phone){
        setFirstName(firstName);
        setLastName(lastName);
        setStreet(street);
        setCity(city);
        setState(state);
        setZip(zip);
        setPhone(phone);
        setEmail(email);

    }

    /**
     * Returns a string representation of the address entry.
     * @return A string representing the address entry
     */
    public String toString() {
        return index + ": " +firstName + " " + lastName + "\n" +
                street + "\n" +
                city + ", " + state + " " + zip + "\n" +
                email + "\n" +
                phone;
    }

    /**
     * Returns the street address.
     * @return The street address
     */
    public String getStreet() {
        return street;
    }

    /**
     * Returns the zip code.
     * @return The zip code
     */
    public Integer getZip() {
        return zip;
    }

    /**
     * Returns the phone number.
     * @return The phone number
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Returns the email address.
     * @return The email address
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email address.
     * @param email The email address
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Sets the phone number.
     * @param phone The phone number
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Sets the zip code.
     * @param zip The zip code
     */
    public void setZip(Integer zip) {
        this.zip = zip;
    }

    /**
     * Returns the city.
     * @return The city
     */
    public String getCity() {
        return city;
    }


    /**
     * Returns the state.
     * @return The state
     */
    public String getState() {
        return state;
    }

    /**
     * Sets the state.
     * @param state The state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Sets the city.
     * @param city The city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Returns the last name.
     * @return The last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name.
     * @param lastName The last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Sets the street address.
     * @param street The street address
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * Returns the first name.
     * @return The first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name.
     * @param firstName The first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


}
