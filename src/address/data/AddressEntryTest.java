package address.data;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;


import static org.junit.jupiter.api.Assertions.*;

class AddressEntryTest {

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
}