package address.data;

public class AddressEntry {

    String firstName;
    String lastName;
    String street;
    String city;
    String state;
    Integer zip;
    String phone;
    String email;
    public AddressEntry(){

    }
    public AddressEntry(String firstName, String lastName, String street, String city, String state, Integer zip, String phone, String email){
        setFirstName(firstName);
        setLastName(lastName);
        setStreet(street);
        setCity(city);
        setState(state);
        setZip(zip);
        setPhone(phone);
        setEmail(email);
    }

    public String toString() {
        return "First Name: " + firstName + "\n" +
                "Last Name: " + lastName + "\n" +
                "Street: " + street + "\n" +
                "City: " + city + "\n" +
                "State: " + state + "\n" +
                "Zip Code: " + zip + "\n" +
                "Phone: " + phone + "\n" +
                "Email: " + email;
    }

    public String getStreet() {
        return street;
    }

    public Integer getZip() {
        return zip;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setZip(Integer zip) {
        this.zip = zip;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setStreet(String street) {
        this.street = street;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


}
