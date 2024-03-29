package address.data;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

import java.io.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * The AddressBookTest class defines unit tests for the AddressBook class.
 */
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

        String expectedOutput = "1: " +
                "Jane"+ " " + "A\n" +
                "456 Elm St\n" +
                "Othertown" + ", "+ "NY" + " " + "54321\n" +
                "555-5678\n" +
                "jane@example.com" +
                "\n\n"+
                "2: " +
                "Jimin"+ " " + "B\n" +
                "456 Elm St\n" +
                "Othertown" + ", " + "NY" + " " + "52321\n" +
                "555-5238\n" +
                "jimin@example.com"+
                "\n\n"+
                "3: " +
                "John" + " " +"C\n" +
                "123 Main St\n" +
                "Anytown" + ", " + "CA" + " " +"12345\n" +
                "555-1234\n" +
                "john@example.com"+
                "\n\n";
        assertLinesMatch(expectedOutput.lines(), outContent.toString().lines());
    }

    /**
     * Tests the case when the address book contains entries.
     */
    @Test
    public void testRemoveNoEntryFound() {
        AddressBook addressBook = new AddressBook();
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        addressBook.remove("Doe");

        assertTrue(outContent.toString().contains("No address entry found for Doe"));
    }

    /**
     * Tests the case when no entry is found for the given last name.
     */
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

    /**
     * Tests the case when multiple entries are found and one is selected and removed.
     */
    @Test
    public void testRemoveMultipleEntriesFound() {
        AddressBook addressBook = new AddressBook();
        AddressEntry entry1 = new AddressEntry("John", "Doe", "123 Main St", "Anytown", "CA", 12345, "555-1234", "john@example.com");
        AddressEntry entry2 = new AddressEntry("Jane", "Doer", "456 Elm St", "Othertown", "NY", 54321, "555-5678", "jane@example.com");
        addressBook.add(entry1);
        addressBook.add(entry2);

        ByteArrayInputStream inContent = new ByteArrayInputStream("1\ny".getBytes());
        System.setIn(inContent);
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        addressBook.remove("Do");

        assertTrue(outContent.toString().contains("Entry removed successfully."));
        assertEquals(1, addressBook.addressEntryList.size());
    }

    /**
     * Tests adding an entry to the address book.
     */
    @Test
    public void testAdd1() {
        AddressBook addressBook = new AddressBook();
        AddressEntry entry1 = new AddressEntry("John", "C", "123 Main St", "Anytown", "CA", 12345, "555-1234", "john@example.com");

        addressBook.add(entry1);
        assertEquals(1, addressBook.addressEntryList.size());

    }

    /**
     * Tests adding multiple entries to the address book.
     */
    @Test
    public void testAdd2() {
        AddressBook addressBook = new AddressBook();
        AddressEntry entry1 = new AddressEntry("John", "C", "123 Main St", "Anytown", "CA", 12345, "555-1234", "john@example.com");
        AddressEntry entry2 = new AddressEntry("hn", "C", "123 Main St", "Anytown", "CA", 12345, "555-1234", "john@example.com");
        addressBook.add(entry1);
        addressBook.add(entry2);
        assertEquals(2, addressBook.addressEntryList.size());

    }

    /**
     * Tests adding a duplicate entry to the address book.
     */
    @Test
    public void testAddDuplicate1() {
        AddressBook addressBook = new AddressBook();
        AddressEntry entry1 = new AddressEntry("John", "C", "123 Main St", "Anytown", "CA", 12345, "555-1234", "john@example.com");
        AddressEntry entry2 = new AddressEntry("John", "C", "123 Main St", "Anytown", "CA", 12345, "555-1234", "john@example.com");
        addressBook.add(entry1);
        addressBook.add(entry2);
        assertEquals(1, addressBook.addressEntryList.size());

    }

    /**
     * Tests adding multiple entries with duplicates to the address book.
     */
    @Test
    public void testAddDuplicate2() {
        AddressBook addressBook = new AddressBook();
        AddressEntry entry1 = new AddressEntry("John", "C", "123 Main St", "Anytown", "CA", 12345, "555-1234", "john@example.com");
        AddressEntry entry2 = new AddressEntry("John", "C", "123 Main St", "Anytown", "CA", 12345, "555-1234", "john@example.com");
        AddressEntry entry3 = new AddressEntry("hn", "C", "123 Main St", "Anytown", "CA", 12345, "555-5234","hn@example.com");
        addressBook.add(entry1);
        addressBook.add(entry2);
        addressBook.add(entry3);
        assertEquals(2, addressBook.addressEntryList.size());

    }

    /**
     * Tests reading address entries from a file.
     */
    @Test
    public void testReadFromFile() {
        // Arrange
        String testFilename = "testFile.txt";
        createTestFile(testFilename);
        AddressBook addressBook = new AddressBook();

        // Act
        try {
            addressBook.readFromFile(testFilename);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Assert
        assertEquals(2, addressBook.addressEntryList.size());

        AddressEntry entry1 = addressBook.addressEntryList.get(0);
        assertEquals("Lynne", entry1.getFirstName());
        assertEquals("Grewe", entry1.getLastName());
        assertEquals("123 3rd avenue", entry1.getStreet());
        assertEquals("hayward", entry1.getCity());
        assertEquals("ca", entry1.getState());
        int zip = entry1.getZip();
        String zipString = String.valueOf(zip);
        assertEquals( "99999", zipString);
        assertEquals("l@gmail.com", entry1.getEmail());
        assertEquals("222233233", entry1.getPhone());

        AddressEntry entry2 = addressBook.addressEntryList.get(1);
        assertEquals("Peanut", entry2.getFirstName());
        assertEquals("Grow", entry2.getLastName());
        assertEquals("389 market ave", entry2.getStreet());
        assertEquals("Los Angeles", entry2.getCity());
        assertEquals("CA", entry2.getState());
        int zip2 = entry2.getZip();
        String zipString2 = String.valueOf(zip2);
        assertEquals("393939", zipString2);
        assertEquals("market@yahoo.com", entry2.getEmail());
        assertEquals("319-293-3838", entry2.getPhone());
    }

    /**
     * Tests reading address entries from a file.
     */
    @Test
    public void testReadFromFile1() {
        // Arrange
        String testFilename = "testFile2.txt";
        createTestFile1(testFilename);
        AddressBook addressBook = new AddressBook();

        // Act
        try {
            addressBook.readFromFile(testFilename);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Assert
        assertEquals(3, addressBook.addressEntryList.size());

        AddressEntry entry1 = addressBook.addressEntryList.get(0);
        assertEquals("Lynne", entry1.getFirstName());
        assertEquals("Grewe", entry1.getLastName());
        assertEquals("123 3rd avenue", entry1.getStreet());
        assertEquals("hayward", entry1.getCity());
        assertEquals("ca", entry1.getState());
        int zip = entry1.getZip();
        String zipString = String.valueOf(zip);
        assertEquals( "99999", zipString);
        assertEquals("l@gmail.com", entry1.getEmail());
        assertEquals("222233233", entry1.getPhone());

        AddressEntry entry2 = addressBook.addressEntryList.get(1);
        assertEquals("Peanut", entry2.getFirstName());
        assertEquals("Grow", entry2.getLastName());
        assertEquals("389 market ave", entry2.getStreet());
        assertEquals("Los Angeles", entry2.getCity());
        assertEquals("CA", entry2.getState());
        int zip2 = entry2.getZip();
        String zipString2 = String.valueOf(zip2);
        assertEquals("393939", zipString2);
        assertEquals("market@yahoo.com", entry2.getEmail());
        assertEquals("319-293-3838", entry2.getPhone());

        AddressEntry entry3 = addressBook.addressEntryList.get(2);
        assertEquals("Jepsom", entry3.getFirstName());
        assertEquals("Nelson", entry3.getLastName());
        assertEquals("1111 Address St.", entry3.getStreet());
        assertEquals("Oakland", entry3.getCity());
        assertEquals("CA", entry3.getState());
        int zip3 = entry3.getZip();
        String zipString3 = String.valueOf(zip3);
        assertEquals("12345", zipString3);
        assertEquals("sij@gmail.com", entry3.getEmail());
        assertEquals("111-234-5678", entry3.getPhone());
    }


    /**
     * Creates a test file with sample address entries for testing purposes.
     * @param filename The name of the file to be created.
     */
    private void createTestFile(String filename) {
        try {
            File file = new File(filename);
            FileWriter writer = new FileWriter(file);
            writer.write("Lynne Grewe\n");
            writer.write("123 3rd avenue\n");
            writer.write("hayward, ca 99999\n");
            writer.write("l@gmail.com\n");
            writer.write("222233233\n");

            writer.write("\n");

            writer.write("Peanut Grow\n");
            writer.write("389 market ave\n");
            writer.write("Los Angeles, CA 393939\n");
            writer.write("market@yahoo.com\n");
            writer.write("319-293-3838\n");

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Creates a test file with additional sample address entries for testing purposes.
     * @param filename The name of the file to be created.
     */
    private void createTestFile1(String filename) {
        try {
            File file = new File(filename);
            FileWriter writer = new FileWriter(file);
            writer.write("Lynne Grewe\n");
            writer.write("123 3rd avenue\n");
            writer.write("hayward, ca 99999\n");
            writer.write("l@gmail.com\n");
            writer.write("222233233\n");

            writer.write("\n");

            writer.write("Peanut Grow\n");
            writer.write("389 market ave\n");
            writer.write("Los Angeles, CA 393939\n");
            writer.write("market@yahoo.com\n");
            writer.write("319-293-3838\n");

            writer.write("\n");

            writer.write("Jepsom Nelson\n");
            writer.write("1111 Address St.\n");
            writer.write("Oakland, CA 12345\n");
            writer.write("sij@gmail.com\n");
            writer.write("111-234-5678\n");

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tests finding entries by last name.
     */
    @Test
    public void testFind1() {
        // Arrange
        AddressBook addressBook = new AddressBook();
        AddressEntry entry1 = new AddressEntry("John", "C", "123 Main St", "Anytown", "CA", 12345, "555-1234", "john@example.com");
        AddressEntry entry2 = new AddressEntry("Jane", "A", "456 Elm St", "Othertown", "NY", 54321, "555-5678", "jane@example.com");
        AddressEntry entry3 = new AddressEntry("Jimin", "Boa", "456 Elm St", "Othertown", "NY", 52321, "555-5238", "jimin@example.com");
        AddressEntry entry4 = new AddressEntry("Min", "Boo", "456 Elm St", "ktown", "NY", 12321, "555-1238", "kim@example.com");
        addressBook.add(entry1);
        addressBook.add(entry2);
        addressBook.add(entry3);
        addressBook.add(entry4);

        // Redirect System.out to capture printed output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Act
        addressBook.find("Bo");

        // Assert
        String expectedOutput = "The following 2 entries were found in the address book for a last name starting with \"Bo\":\n" +
                "\n" +
                "1: " +
                "Jimin" + " " + "Boa\n" +
                "456 Elm St\n" +
                "Othertown" +", " + "NY" + " " + "52321\n" +
                "555-5238\n" +
                "jimin@example.com\n" +
                "\n" +
                "2: " +
                "Min" + " " +"Boo\n" +
                "456 Elm St\n" +
                "ktown" + ", " + "NY" + " " + "12321\n" +
                "555-1238\n" +
                "kim@example.com\n"+
                "\n";

        assertLinesMatch(expectedOutput.lines(), outContent.toString().lines());
    }

    /**
     * Tests finding entries by last name.
     */
    @Test
    public void testFind2() {
        // Arrange
        AddressBook addressBook = new AddressBook();
        AddressEntry entry1 = new AddressEntry("John", "C", "123 Main St", "Anytown", "CA", 12345, "555-1234", "john@example.com");
        AddressEntry entry2 = new AddressEntry("Jane", "A", "456 Elm St", "Othertown", "NY", 54321, "555-5678", "jane@example.com");
        AddressEntry entry3 = new AddressEntry("Jimin", "Boa", "456 Elm St", "Othertown", "NY", 52321, "555-5238", "jimin@example.com");

        addressBook.add(entry1);
        addressBook.add(entry2);
        addressBook.add(entry3);

        // Redirect System.out to capture printed output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Act
        addressBook.find("B");

        // Assert
        String expectedOutput = "The following 1 entries were found in the address book for a last name starting with \"B\":\n" +
                "\n" +
                "1: " +
                "Jimin" + " " + "Boa\n" +
                "456 Elm St\n" +
                "Othertown" + ", "+ "NY" + " " + "52321\n" +
                "555-5238\n" +
                "jimin@example.com\n" +
                "\n";

        assertLinesMatch(expectedOutput.lines(), outContent.toString().lines());
    }
}