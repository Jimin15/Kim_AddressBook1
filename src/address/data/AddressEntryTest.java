package address.data;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;


import static org.junit.jupiter.api.Assertions.*;


/**
 * The AddressEntryTest class contains unit tests for the AddressEntry class.
 */
class AddressEntryTest {

    /**
     * Tests the constructor of AddressEntry class.
     * It creates an AddressEntry instance with provided data and checks if the fields are set correctly.
     */
    @Test
    public void testAddressEntryConstructor() {
        // Test data
        String firstName = "John";
        String lastName = "Doe";
        String street = "123 Main St";
        String city = "Anytown";
        String state = "CA";
        Integer zip = 12345;
        String email = "john.doe@example.com";
        String phone = "123-456-7890";

        // Create an AddressEntry instance
        AddressEntry entry = new AddressEntry(firstName, lastName, street, city, state, zip, email, phone);

        // Check if the fields are set correctly
        assertEquals(firstName, entry.getFirstName());
        assertEquals(lastName, entry.getLastName());
        assertEquals(street, entry.getStreet());
        assertEquals(city, entry.getCity());
        assertEquals(state, entry.getState());
        assertEquals(zip, entry.getZip());
        assertEquals(email, entry.getEmail());
        assertEquals(phone, entry.getPhone());
    }

    /**
     * Tests the constructor of AddressEntry class with identical entries.
     * This test verifies that when two AddressEntry instances are created with identical data,
     * their individual fields are equal to each other.
     */
    @Test
    public void testAddressEntryConstructor2() {
        // Test data
        AddressEntry entry1 = new AddressEntry("John", "Doe", "123 Main St", "Anytown", "CA", 12345, "john.doe@example.com", "123-456-7890");
        AddressEntry entry2 = new AddressEntry("John", "Doe", "123 Main St", "Anytown", "CA", 12345, "john.doe@example.com", "123-456-7890");

        // Test if individual fields of entry1 are equal to corresponding fields of entry2
        assertEquals(entry1.getFirstName(), entry2.getFirstName());
        assertEquals(entry1.getLastName(), entry2.getLastName());
        assertEquals(entry1.getStreet(), entry2.getStreet());
        assertEquals(entry1.getCity(), entry2.getCity());
        assertEquals(entry1.getState(), entry2.getState());
        assertEquals(entry1.getZip(), entry2.getZip());
        assertEquals(entry1.getEmail(), entry2.getEmail());
        assertEquals(entry1.getPhone(), entry2.getPhone());

    }

    /**
     * Tests the toString() method of AddressEntry class.
     * It creates an AddressEntry instance with provided data, sets an index, and checks if the toString() output matches the expected format.
     */
    @Test
    public void testToString() {
        // Test data
        String firstName = "John";
        String lastName = "Doe";
        String street = "123 Main St";
        String city = "Anytown";
        String state = "CA";
        Integer zip = 12345;
        String email = "john.doe@example.com";
        String phone = "123-456-7890";
        String expectedOutput = "1: John Doe\n123 Main St\nAnytown, CA 12345\njohn.doe@example.com\n123-456-7890";

        // Create an AddressEntry instance
        AddressEntry entry = new AddressEntry(firstName, lastName, street, city, state, zip, email, phone);
        entry.index = 1;
        // Split the expected output into lines
        List<String> expectedLines = Arrays.asList(expectedOutput.split("\\n"));

        // Test the toString() method using assertLinesMatch()
        assertLinesMatch(expectedLines, Arrays.asList(entry.toString().split("\\n")));
    }

    /**
     * Tests the toString() method with a different index.
     * This test creates an AddressEntry instance with given data and verifies if the result
     * of the toString() method matches the expected output.
     */
    @Test
    public void testToString2() {
        // Test data
        String firstName = "Jane";
        String lastName = "Smith";
        String street = "456 Oak Ave";
        String city = "Othertown";
        String state = "NY";
        Integer zip = 54321;
        String email = "jane.smith@example.com";
        String phone = "987-654-3210";
        String expectedOutput = "2: Jane Smith\n456 Oak Ave\nOthertown, NY 54321\njane.smith@example.com\n987-654-3210";

        // Create an AddressEntry instance
        AddressEntry entry = new AddressEntry(firstName, lastName, street, city, state, zip, email, phone);
        entry.index = 2;
        // Split the expected output into lines
        List<String> expectedLines = Arrays.asList(expectedOutput.split("\\n"));

        // Test the toString() method with different index using assertLinesMatch()
        assertLinesMatch(expectedLines, Arrays.asList(entry.toString().split("\\n")));
    }

    /**
     * Tests the getEmail() method.
     * This test creates an AddressEntry instance with given data and verifies if the getEmail()
     * method returns the correct email address.
     */
    @Test
    public void testGetEmail() {
        // Test data
        String firstName = "John";
        String lastName = "Doe";
        String street = "123 Main St";
        String city = "Anytown";
        String state = "CA";
        Integer zip = 12345;
        String email = "john.doe@example.com";
        String phone = "123-456-7890";

        // Create an AddressEntry instance
        AddressEntry entry = new AddressEntry(firstName, lastName, street, city, state, zip, email, phone);

        // Test the getEmail() method
        assertEquals(email, entry.getEmail());
    }

    /**
     * Tests the setEmail() and getEmail() methods.
     * This test creates an AddressEntry instance with given data, sets a new email address,
     * and verifies if the getEmail() method returns the updated email address.
     */
    @Test
    public void testGetEmail2() {
        // Test data
        String firstName = "John";
        String lastName = "Doe";
        String street = "123 Main St";
        String city = "Anytown";
        String state = "CA";
        Integer zip = 12345;
        String email = "john.doe@example.com";
        String phone = "123-456-7890";

        // Create an AddressEntry instance
        AddressEntry entry = new AddressEntry(firstName, lastName, street, city, state, zip, email, phone);

        email = "john@example.com";
        entry.setEmail(email);

        // Test the getEmail() method
        assertEquals(email, entry.getEmail());
    }

    /**
     * Test the setEmail() method.
     * This test verifies that setting a new email address, initially not set, and returning it correctly.
     */
    @Test
    public void testSetEmail() {
        // Test data
        String firstName = "John";
        String lastName = "Doe";
        String street = "123 Main St";
        String city = "Anytown";
        String state = "CA";
        Integer zip = 12345;
        String email = "john.doe@example.com";
        String phone = "123-456-7890";

        // Create an AddressEntry instance
        AddressEntry entry = new AddressEntry(firstName, lastName, street, city, state, zip, null, phone);

        // New email to set
        String newEmail = "johndoe@example.com";

        // Set the new email
        entry.setEmail(newEmail);

        // Check if the email is correctly set
        assertEquals(newEmail, entry.getEmail());
    }

    /**
     * Test the setEmail() method with two invocations.
     * This test ensures that the second email set is returned correctly.
     */
    @Test
    public void testSetEmail2() {
        // Test data
        String firstName = "John";
        String lastName = "Doe";
        String street = "123 Main St";
        String city = "Anytown";
        String state = "CA";
        Integer zip = 12345;
        String email = "john.doe@example.com";
        String phone = "123-456-7890";

        // Create an AddressEntry instance
        AddressEntry entry = new AddressEntry(firstName, lastName, street, city, state, zip, null, phone);

        // New email to set
        String newEmail = "johndoe@example.com";
        // Set the new email
        entry.setEmail(newEmail);

        // New email to set
        String newEmail2 = "jo@example.com";
        // Set the new email
        entry.setEmail(newEmail2);

        // Check if the email is correctly set
        assertEquals(newEmail2, entry.getEmail());
    }

    /**
     * Test the getPhone() method.
     * This test verifies that the phone number set during initialization is returned correctly.
     */
    @Test
    public void testGetPhone() {
        // Test data
        String firstName = "John";
        String lastName = "Doe";
        String street = "123 Main St";
        String city = "Anytown";
        String state = "CA";
        Integer zip = 12345;
        String email = "john.doe@example.com";
        String phone = "123-456-7890";

        // Create an AddressEntry instance
        AddressEntry entry = new AddressEntry(firstName, lastName, street, city, state, zip, email, phone);

        // Test the getPhone() method
        assertEquals(phone, entry.getPhone());
    }

    /**
     * Test the setPhone() method.
     * This test verifies that the phone number is set and returned correctly.
     */
    @Test
    public void testGetPhone2() {
        // Test data
        String firstName = "John";
        String lastName = "Doe";
        String street = "123 Main St";
        String city = "Anytown";
        String state = "CA";
        Integer zip = 12345;
        String email = "john.doe@example.com";
        String phone = "123-456-7890";

        // Create an AddressEntry instance
        AddressEntry entry = new AddressEntry(firstName, lastName, street, city, state, zip, email, phone);

        phone = "324-324-5467";
        entry.setPhone(phone);

        // Test the getPhone() method
        assertEquals(phone, entry.getPhone());
    }

    /**
     * Test the setPhone() method.
     * This test verifies that the phone number is set correctly.
     */
    @Test
    public void testSetPhone() {
        // Test data
        String firstName = "John";
        String lastName = "Doe";
        String street = "123 Main St";
        String city = "Anytown";
        String state = "CA";
        Integer zip = 12345;
        String email = "john.doe@example.com";
        String phone = "123-456-7890";

        // Create an AddressEntry instance
        AddressEntry entry = new AddressEntry(firstName, lastName, street, city, state, zip, email, null);

        // New phone number to set
        String newPhone = "987-654-3210";

        // Set the new phone number
        entry.setPhone(newPhone);

        // Check if the phone number is correctly set
        assertEquals(newPhone, entry.getPhone());
    }

    /**
     * Test the setPhone() method with multiple phone number changes.
     * This test verifies that the phone number is updated correctly when set multiple times.
     */
    @Test
    public void testSetPhone2() {
        // Test data
        String firstName = "John";
        String lastName = "Doe";
        String street = "123 Main St";
        String city = "Anytown";
        String state = "CA";
        Integer zip = 12345;
        String email = "john.doe@example.com";
        String phone = "123-456-7890";

        // Create an AddressEntry instance
        AddressEntry entry = new AddressEntry(firstName, lastName, street, city, state, zip, email, null);

        // New phone number to set
        String newPhone = "987-654-3210";
        // Set the new phone number
        entry.setPhone(newPhone);

        String newPhone2 = "234-234-4567";
        entry.setPhone(newPhone2);

        // Check if the phone number is correctly set
        assertEquals(newPhone2, entry.getPhone());
    }

    /**
     * Test the getZip() method.
     * This test verifies that the zip code is retrieved correctly.
     */
    @Test
    public void testGetZip() {
        // Test data
        String firstName = "John";
        String lastName = "Doe";
        String street = "123 Main St";
        String city = "Anytown";
        String state = "CA";
        Integer zip = 12345;
        String email = "john.doe@example.com";
        String phone = "123-456-7890";

        // Create an AddressEntry instance
        AddressEntry entry = new AddressEntry(firstName, lastName, street, city, state, zip, email, phone);

        // Test the getZip() method
        assertEquals(zip, entry.getZip());
    }


    /**
     * Test the setZip() method.
     * This test verifies that the zip code is set correctly.
     */
    @Test
    public void testGetZip2() {
        // Test data
        String firstName = "John";
        String lastName = "Doe";
        String street = "123 Main St";
        String city = "Anytown";
        String state = "CA";
        Integer zip = 12345;
        String email = "john.doe@example.com";
        String phone = "123-456-7890";

        // Create an AddressEntry instance
        AddressEntry entry = new AddressEntry(firstName, lastName, street, city, state, zip, email, phone);

        Integer newzip = 45643;
        entry.setZip(newzip);

        // Test the getZip() method
        assertEquals(newzip, entry.getZip());
    }


    /**
     * Test the setZip() method.
     * This test verifies that the zip code is set correctly.
     */
    @Test
    public void testSetZip() {
        // Test data
        String firstName = "John";
        String lastName = "Doe";
        String street = "123 Main St";
        String city = "Anytown";
        String state = "CA";
        Integer zip = 12345;
        String email = "john.doe@example.com";
        String phone = "123-456-7890";

        // Create an AddressEntry instance
        AddressEntry entry = new AddressEntry(firstName, lastName, street, city, state, zip, email, phone);

        // New zip code to set
        Integer newZip = 54321;

        // Set the new zip code
        entry.setZip(newZip);

        // Check if the zip code is correctly set
        assertEquals(newZip, entry.getZip());
    }

    /**
     * Test the setZip() method with multiple calls.
     * This test verifies that the zip code is correctly updated when set multiple times.
     */
    @Test
    public void testSetZip2() {
        // Test data
        String firstName = "John";
        String lastName = "Doe";
        String street = "123 Main St";
        String city = "Anytown";
        String state = "CA";
        Integer zip = 12345;
        String email = "john.doe@example.com";
        String phone = "123-456-7890";

        // Create an AddressEntry instance
        AddressEntry entry = new AddressEntry(firstName, lastName, street, city, state, zip, email, phone);

        // New zip code to set
        Integer newZip = 54321;
        // Set the new zip code
        entry.setZip(newZip);

        // New zip code to set
        Integer newZip2 = 34321;
        // Set the new zip code
        entry.setZip(newZip2);

        // Check if the zip code is correctly set
        assertEquals(newZip2, entry.getZip());
    }

    /**
     * Test the getState() method.
     * This test verifies that the state is retrieved correctly.
     */
    @Test
    public void testGetState() {
        // Test data
        String firstName = "John";
        String lastName = "Doe";
        String street = "123 Main St";
        String city = "Anytown";
        String state = "CA";
        Integer zip = 12345;
        String email = "john.doe@example.com";
        String phone = "123-456-7890";

        // Create an AddressEntry instance
        AddressEntry entry = new AddressEntry(firstName, lastName, street, city, state, zip, email, phone);

        // Test the getState() method
        assertEquals(state, entry.getState());
    }

    /**
     * Test the setState() method.
     * This test verifies that the state is set correctly.
     */
    @Test
    public void testGetState2() {
        // Test data
        String firstName = "John";
        String lastName = "Doe";
        String street = "123 Main St";
        String city = "Anytown";
        String state = "CA";
        Integer zip = 12345;
        String email = "john.doe@example.com";
        String phone = "123-456-7890";

        // Create an AddressEntry instance
        AddressEntry entry = new AddressEntry(firstName, lastName, street, city, state, zip, email, phone);

        String newstate = "NY";
        entry.setState(newstate);

        // Test the getState() method
        assertEquals(newstate, entry.getState());
    }

    /**
     * Test the setState() method.
     * This test verifies that the state is set correctly.
     */
    @Test
    public void testSetState() {
        // Test data
        String firstName = "John";
        String lastName = "Doe";
        String street = "123 Main St";
        String city = "Anytown";
        String state = "CA";
        Integer zip = 12345;
        String email = "john.doe@example.com";
        String phone = "123-456-7890";

        // Create an AddressEntry instance
        AddressEntry entry = new AddressEntry(firstName, lastName, street, city, state, zip, email, phone);

        // New state to set
        String newState = "NY";

        // Set the new state
        entry.setState(newState);

        // Check if the state is correctly set
        assertEquals(newState, entry.getState());
    }

    /**
     * Test the setState() method with multiple state changes.
     * This test verifies that the state is correctly updated after multiple changes.
     */
    @Test
    public void testSetState2() {
        // Test data
        String firstName = "John";
        String lastName = "Doe";
        String street = "123 Main St";
        String city = "Anytown";
        String state = "CA";
        Integer zip = 12345;
        String email = "john.doe@example.com";
        String phone = "123-456-7890";

        // Create an AddressEntry instance
        AddressEntry entry = new AddressEntry(firstName, lastName, street, city, state, zip, email, phone);

        // New state to set
        String newState = "NY";
        // Set the new state
        entry.setState(newState);

        // New state to set
        String newState2 = "CA";
        // Set the new state
        entry.setState(newState2);

        // Check if the state is correctly set
        assertEquals(newState2, entry.getState());
    }


    /**
     * Test the getCity() method.
     * This test verifies that the city is retrieved correctly.
     */

    @Test
    public void testGetCity() {
        // Test data
        String firstName = "John";
        String lastName = "Doe";
        String street = "123 Main St";
        String city = "Anytown";
        String state = "CA";
        Integer zip = 12345;
        String email = "john.doe@example.com";
        String phone = "123-456-7890";

        // Create an AddressEntry instance
        AddressEntry entry = new AddressEntry(firstName, lastName, street, city, state, zip, email, phone);

        // Test the getCity() method
        assertEquals(city, entry.getCity());
    }


    /**
     * Test the setCity() method.
     * This test verifies that the city is set correctly.
     */
    @Test
    public void testGetCity2() {
        // Test data
        String firstName = "John";
        String lastName = "Doe";
        String street = "123 Main St";
        String city = "Anytown";
        String state = "CA";
        Integer zip = 12345;
        String email = "john.doe@example.com";
        String phone = "123-456-7890";

        // Create an AddressEntry instance
        AddressEntry entry = new AddressEntry(firstName, lastName, street, city, state, zip, email, phone);

        String newcity = "hayward";
        entry.setCity(newcity);
        // Test the getCity() method
        assertEquals(newcity, entry.getCity());
    }


    /**
     * Test the setCity() method.
     * This test verifies that the city name is set correctly.
     */
    @Test
    public void testSetCity() {
        // Test data
        String firstName = "John";
        String lastName = "Doe";
        String street = "123 Main St";
        String city = "Anytown";
        String state = "CA";
        Integer zip = 12345;
        String email = "john.doe@example.com";
        String phone = "123-456-7890";

        // Create an AddressEntry instance
        AddressEntry entry = new AddressEntry(firstName, lastName, street, city, state, zip, email, phone);

        // New city name to set
        String newCity = "New City";

        // Set the new city name
        entry.setCity(newCity);

        // Check if the city name is correctly set
        assertEquals(newCity, entry.getCity());
    }

    /**
     * Test the setCity() method with multiple city name changes.
     * This test verifies that the city name is set correctly when changed multiple times.
     */
    @Test
    public void testSetCity2() {
        // Test data
        String firstName = "John";
        String lastName = "Doe";
        String street = "123 Main St";
        String city = "Anytown";
        String state = "CA";
        Integer zip = 12345;
        String email = "john.doe@example.com";
        String phone = "123-456-7890";

        // Create an AddressEntry instance
        AddressEntry entry = new AddressEntry(firstName, lastName, street, city, state, zip, email, phone);

        // New city name to set
        String newCity = "New City";
        // Set the new city name
        entry.setCity(newCity);

        // New city name to set
        String newCity2 = "Las vegas";
        // Set the new city name
        entry.setCity(newCity2);

        // Check if the city name is correctly set
        assertEquals(newCity2, entry.getCity());
    }


    /**
     * Test the getStreet() method.
     * This test verifies that the street address is retrieved correctly.
     */
    public void testGetStreet() {
        // Test data
        String firstName = "John";
        String lastName = "Doe";
        String street = "123 Main St";
        String city = "Anytown";
        String state = "CA";
        Integer zip = 12345;
        String email = "john.doe@example.com";
        String phone = "123-456-7890";

        // Create an AddressEntry instance
        AddressEntry entry = new AddressEntry(firstName, lastName, street, city, state, zip, email, phone);

        // Test the getStreet() method
        assertEquals(street, entry.getStreet());
    }


    /**
     * Test the getStreet() method with updated street address.
     * This test verifies that the street address is correctly updated and retrieved.
     */
    public void testGetStreet2() {
        // Test data
        String firstName = "John";
        String lastName = "Doe";
        String street = "123 Main St";
        String city = "Anytown";
        String state = "CA";
        Integer zip = 12345;
        String email = "john.doe@example.com";
        String phone = "123-456-7890";

        // Create an AddressEntry instance
        AddressEntry entry = new AddressEntry(firstName, lastName, street, city, state, zip, email, phone);

        String newstreet = "245 Main ST";
        entry.setStreet(newstreet);
        // Test the getStreet() method
        assertEquals(newstreet, entry.getStreet());
    }

    /**
     * Test the setStreet() method.
     * This test verifies that the street address is correctly set.
     */
    @Test
    public void testSetStreet() {
        // Test data
        String firstName = "John";
        String lastName = "Doe";
        String street = "123 Main St";
        String city = "Anytown";
        String state = "CA";
        Integer zip = 12345;
        String email = "john.doe@example.com";
        String phone = "123-456-7890";

        // Create an AddressEntry instance
        AddressEntry entry = new AddressEntry(firstName, lastName, street, city, state, zip, email, phone);

        // New street address to set
        String newStreet = "456 Oak Ave";

        // Set the new street address
        entry.setStreet(newStreet);

        // Check if the street address is correctly set
        assertEquals(newStreet, entry.getStreet());
    }

    /**
     * Test the setStreet() method with multiple street address updates.
     * This test verifies that the street address is correctly updated and retrieved.
     */
    @Test
    public void testSetStreet2() {
        // Test data
        String firstName = "John";
        String lastName = "Doe";
        String street = "123 Main St";
        String city = "Anytown";
        String state = "CA";
        Integer zip = 12345;
        String email = "john.doe@example.com";
        String phone = "123-456-7890";

        // Create an AddressEntry instance
        AddressEntry entry = new AddressEntry(firstName, lastName, street, city, state, zip, email, phone);

        // New street address to set
        String newStreet = "456 Oak Ave";
        // Set the new street address
        entry.setStreet(newStreet);

        // New street address to set
        String newStreet2 = "123 Oak Ave";
        // Set the new street address
        entry.setStreet(newStreet2);

        // Check if the street address is correctly set
        assertEquals(newStreet2, entry.getStreet());
    }

    /**
     * Test the setLastName() method.
     * This test verifies that the last name is correctly set.
     */
    @Test
    public void testSetLastName() {
        // Test data
        String firstName = "John";
        String lastName = "Doe";
        String street = "123 Main St";
        String city = "Anytown";
        String state = "CA";
        Integer zip = 12345;
        String email = "john.doe@example.com";
        String phone = "123-456-7890";

        // Create an AddressEntry instance
        AddressEntry entry = new AddressEntry(firstName, lastName, street, city, state, zip, email, phone);

        // New last name to set
        String newLastName = "Smith";

        // Set the new last name
        entry.setLastName(newLastName);

        // Check if the last name is correctly set
        assertEquals(newLastName, entry.getLastName());
    }

    /**
     * Test the setLastName() method with multiple last name updates.
     * This test verifies that the last name is correctly updated and retrieved.
     */
    @Test
    public void testSetLastName2() {
        // Test data
        String firstName = "John";
        String lastName = "Doe";
        String street = "123 Main St";
        String city = "Anytown";
        String state = "CA";
        Integer zip = 12345;
        String email = "john.doe@example.com";
        String phone = "123-456-7890";

        // Create an AddressEntry instance
        AddressEntry entry = new AddressEntry(firstName, lastName, street, city, state, zip, email, phone);

        // New last name to set
        String newLastName = "Smith";
        // Set the new last name
        entry.setLastName(newLastName);

        // New last name to set
        String newLastName2 = "Satth";
        // Set the new last name
        entry.setLastName(newLastName2);

        // Check if the last name is correctly set
        assertEquals(newLastName2, entry.getLastName());
    }

    /**
     * Test the getLastName() method.
     * This test verifies that the last name is correctly retrieved.
     */
    @Test
    public void testGetLastName() {
        // Test data
        String firstName = "John";
        String lastName = "Doe";
        String street = "123 Main St";
        String city = "Anytown";
        String state = "CA";
        Integer zip = 12345;
        String email = "john.doe@example.com";
        String phone = "123-456-7890";

        // Create an AddressEntry instance
        AddressEntry entry = new AddressEntry(firstName, lastName, street, city, state, zip, email, phone);

        // Test the getLastName() method
        assertEquals(lastName, entry.getLastName());
    }

    /**
     * Test the getLastName() method after updating the last name.
     * This test verifies that the last name is correctly retrieved after being updated.
     */
    @Test
    public void testGetLastName2() {
        // Test data
        String firstName = "John";
        String lastName = "Doe";
        String street = "123 Main St";
        String city = "Anytown";
        String state = "CA";
        Integer zip = 12345;
        String email = "john.doe@example.com";
        String phone = "123-456-7890";

        // Create an AddressEntry instance
        AddressEntry entry = new AddressEntry(firstName, lastName, street, city, state, zip, email, phone);

        String newlastname = "Kim";
        entry.setLastName(newlastname);
        // Test the getLastName() method
        assertEquals(newlastname, entry.getLastName());
    }

    /**
     * Test the getFirstName() method.
     * This test verifies that the first name is correctly retrieved.
     */
    @Test
    public void testGetFirstName() {
        // Test data
        String firstName = "John";
        String lastName = "Doe";
        String street = "123 Main St";
        String city = "Anytown";
        String state = "CA";
        Integer zip = 12345;
        String email = "john.doe@example.com";
        String phone = "123-456-7890";

        // Create an AddressEntry instance
        AddressEntry entry = new AddressEntry(firstName, lastName, street, city, state, zip, email, phone);

        // Test the getFirstName() method
        assertEquals(firstName, entry.getFirstName());
    }

    /**
     * Test the getFirstName() method after updating the first name.
     * This test verifies that the first name is correctly retrieved after being updated.
     */
    @Test
    public void testGetFirstName2() {
        // Test data
        String firstName = "John";
        String lastName = "Doe";
        String street = "123 Main St";
        String city = "Anytown";
        String state = "CA";
        Integer zip = 12345;
        String email = "john.doe@example.com";
        String phone = "123-456-7890";

        // Create an AddressEntry instance
        AddressEntry entry = new AddressEntry(firstName, lastName, street, city, state, zip, email, phone);

        String newfirstname = "Jimin";
        entry.setFirstName(newfirstname);
        // Test the getFirstName() method
        assertEquals(newfirstname, entry.getFirstName());
    }

    /**
     * Test the setFirstName() method.
     * This test verifies that the first name is correctly set.
     */
    @Test
    public void testSetFirstName() {
        // Test data
        String firstName = "John";
        String lastName = "Doe";
        String street = "123 Main St";
        String city = "Anytown";
        String state = "CA";
        Integer zip = 12345;
        String email = "john.doe@example.com";
        String phone = "123-456-7890";

        // Create an AddressEntry instance
        AddressEntry entry = new AddressEntry(firstName, lastName, street, city, state, zip, email, phone);

        // New first name to set
        String newFirstName = "Jane";

        // Set the new first name
        entry.setFirstName(newFirstName);

        // Check if the first name is correctly set
        assertEquals(newFirstName, entry.getFirstName());
    }

    /**
     * Test the setFirstName() method with multiple updates.
     * This test verifies that the first name is correctly set after multiple updates.
     */
    @Test
    public void testSetFirstName2() {
        // Test data
        String firstName = "John";
        String lastName = "Doe";
        String street = "123 Main St";
        String city = "Anytown";
        String state = "CA";
        Integer zip = 12345;
        String email = "john.doe@example.com";
        String phone = "123-456-7890";

        // Create an AddressEntry instance
        AddressEntry entry = new AddressEntry(firstName, lastName, street, city, state, zip, email, phone);

        // New first name to set
        String newFirstName = "Jane";
        // Set the new first name
        entry.setFirstName(newFirstName);

        // New first name to set
        String newFirstName2 = "Jimin";
        // Set the new first name
        entry.setFirstName(newFirstName2);

        // Check if the first name is correctly set
        assertEquals(newFirstName2, entry.getFirstName());
    }
}