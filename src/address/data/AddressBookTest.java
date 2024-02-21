package address.data;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class AddressBookTest {
    @Test
    public void testListEmptyAddressBook() {
        AddressBook addressBook = new AddressBook();
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        addressBook.list();

        assertTrue(outContent.toString().contains("Address book is empty."));
    }

    //test1
    @Test
    public void testListNonEmptyAddressBook() {
        AddressBook addressBook = new AddressBook();
        AddressEntry entry1 = new AddressEntry("John", "C", "123 Main St", "Anytown", "CA", 12345, "555-1234", "john@example.com");
        AddressEntry entry2 = new AddressEntry("Jane", "A", "456 Elm St", "Othertown", "NY", 54321, "555-5678", "jane@example.com");
        AddressEntry entry3 = new AddressEntry("Jimin", "B", "456 Elm St", "Othertown", "NY", 52321, "555-5238", "jimin@example.com");
        addressBook.add(entry1);
        addressBook.add(entry2);
        addressBook.add(entry3);
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        addressBook.list();

        String expectedOutput = "1:\n" +
                "First Name: Jane\n" +
                "Last Name: A\n" +
                "Street: 456 Elm St\n" +
                "City: Othertown\n" +
                "State: NY\n" +
                "Zip Code: 54321\n" +
                "Phone: 555-5678\n" +
                "Email: jane@example.com" +
                "\n"+
                "2:\n" +
                "First Name: Jimin\n" +
                "Last Name: B\n" +
                "Street: 456 Elm St\n" +
                "City: Othertown\n" +
                "State: NY\n" +
                "Zip Code: 52321\n" +
                "Phone: 555-5238\n" +
                "Email: jimin@example.com"+
                "\n"+
                "3:\n" +
                "First Name: John\n" +
                "Last Name: C\n" +
                "Street: 123 Main St\n" +
                "City: Anytown\n" +
                "State: CA\n" +
                "Zip Code: 12345\n" +
                "Phone: 555-1234\n" +
                "Email: john@example.com"+
                "\n";
        assertLinesMatch(expectedOutput.lines(), outContent.toString().lines());
    }

    @Test
    public void testRemoveNoEntryFound() {
        AddressBook addressBook = new AddressBook();
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        addressBook.remove("Doe");

        assertTrue(outContent.toString().contains("No address entry found for Doe"));
    }

    @Test
    public void testRemoveSingleEntryFound() {
        AddressBook addressBook = new AddressBook();
        AddressEntry entry1 = new AddressEntry("John", "Doe", "123 Main St", "Anytown", "CA", 12345, "555-1234", "john@example.com");
        addressBook.add(entry1);

        ByteArrayInputStream inContent = new ByteArrayInputStream("y".getBytes());
        System.setIn(inContent);
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        addressBook.remove("Doe");

        assertTrue(outContent.toString().contains("Entry removed successfully."));
        assertTrue(addressBook.addressEntryList.isEmpty());
    }

    @Test
    public void testRemoveMultipleEntriesFound() {
        AddressBook addressBook = new AddressBook();
        AddressEntry entry1 = new AddressEntry("John", "Doe", "123 Main St", "Anytown", "CA", 12345, "555-1234", "john@example.com");
        AddressEntry entry2 = new AddressEntry("Jane", "Doe", "456 Elm St", "Othertown", "NY", 54321, "555-5678", "jane@example.com");
        addressBook.add(entry1);
        addressBook.add(entry2);

        ByteArrayInputStream inContent = new ByteArrayInputStream("1\ny".getBytes());
        System.setIn(inContent);
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        addressBook.remove("Doe");

        assertTrue(outContent.toString().contains("Entry removed successfully."));
        assertEquals(1, addressBook.addressEntryList.size());
    }

    @org.junit.jupiter.api.Test
    @Test
    public void testAdd() {
        AddressBook addressBook = new AddressBook();
        AddressEntry entry1 = new AddressEntry("John", "C", "123 Main St", "Anytown", "CA", 12345, "555-1234", "john@example.com");
        AddressEntry entry2 = new AddressEntry("Jane", "A", "456 Elm St", "Othertown", "NY", 54321, "555-5678", "jane@example.com");
        AddressEntry entry3 = new AddressEntry("Jimin", "B", "456 Elm St", "Othertown", "NY", 52321, "555-5238", "jimin@example.com");
        addressBook.add(entry1);
        addressBook.add(entry2);
        addressBook.add(entry3);
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @org.junit.jupiter.api.Test
    void readFromFile() {
    }

    @org.junit.jupiter.api.Test
    void find() {
    }
}