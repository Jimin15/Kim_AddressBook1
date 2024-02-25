package address.data;
import java.io.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

/**
 * The AddressBook class represents an address book, providing functionality to add, remove, list, read from file, and find address entries.
 * @author [Jimin Kim]
 * @since [2024-02-16]
 */

public class AddressBook {

    /** List of address entries */
    List<AddressEntry> addressEntryList;

    /**
     * Constructor for AddressBook class. Creates a new address book.
     */
    public AddressBook() {
        addressEntryList = new ArrayList<>();
    }

    /**
     * Lists all entries in the address book. If the address book is empty, "Address book is empty." is printed.
     */
    public void list() {
        // Check if address book is empty
        if (addressEntryList.isEmpty()) {
            System.out.println("Address book is empty.");
            return;
        }

        // Sort address entries by last name
        Collections.sort(addressEntryList, (a1, a2) -> a1.getLastName().compareToIgnoreCase(a2.getLastName()));

        // Print each address entry
        for (int i = 0; i < addressEntryList.size(); i++) {
            addressEntryList.get(i).index = i+1;
            System.out.println(addressEntryList.get(i).toString());
            System.out.println();
        }
    }

    /**
     * Removes an address entry with the given last name.
     * @param lastName Last name of the address entry to be removed
     */
    public void remove(String lastName) {

        int found = 0;
        List<AddressEntry> foundEntries = new ArrayList<>();
        for (AddressEntry entry : addressEntryList) {
            if (entry.getLastName().toLowerCase().startsWith(lastName.toLowerCase())) {
                found += 1;
                foundEntries.add(entry);
            }
        }

        if (found == 0) {
            System.out.println("No address entry found for " + lastName);
            return;
        }

        if (found > 1) {
            System.out.println("The following entries were found in the address book, select number of entry you wish to remove:\n");
            int i = 1;
            for (AddressEntry entry : foundEntries) {
                entry.index = i;
                System.out.println(entry);
                i++;
            }

            Scanner scanner = new Scanner(System.in);
            int choice;
            while (true) {
                System.out.print("\nEnter the number of entry you wish to remove: ");
                if (scanner.hasNextInt()) {
                    choice = scanner.nextInt();
                    scanner.nextLine();
                    if (choice >= 1 && choice <= foundEntries.size()) {
                        break; // Exit loop if choice is valid
                    } else {
                        System.out.println("Invalid choice. Please enter a number between 1 and " + foundEntries.size() + ".");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a valid number.");
                    scanner.next(); // Consume invalid input
                }
            }


            AddressEntry entryToRemove = foundEntries.get(choice - 1); // Get entry to remove

            System.out.println("Hit 'y' to remove the entry or 'n' to return to main menu");
            String cho = scanner.nextLine().trim();
            if (cho.equalsIgnoreCase("y")) {
                addressEntryList.remove(entryToRemove);
                System.out.println("Entry removed successfully.");
            } else {
                System.out.println("Removal cancelled.");
            }

        } else {
            AddressEntry entryToRemove = foundEntries.get(0); // Get the only entry found
            entryToRemove.index = 1;
            System.out.println("The following entry was found in the address book:");
            System.out.println(entryToRemove);

            Scanner scanner = new Scanner(System.in);
            System.out.println("Hit 'y' to remove the entry or 'n' to return to main menu");
            String choice = scanner.nextLine().trim();
            if (choice.equalsIgnoreCase("y")) {
                addressEntryList.remove(entryToRemove);
                System.out.println("Entry removed successfully.");
            } else {
                System.out.println("Removal cancelled.");
            }
        }

    }


    /**
     * Adds a new address entry to the address book. Duplicate entries are not added.
     * @param entry Address entry to be added
     */

    public void add(AddressEntry entry) {
        boolean isDuplicate = addressEntryList.stream().anyMatch(e ->
                e.getFirstName().equalsIgnoreCase(entry.getFirstName()) &&
                        e.getLastName().equalsIgnoreCase(entry.getLastName()) &&
                        e.getPhone().equalsIgnoreCase(entry.getPhone()) &&
                        e.getEmail().equalsIgnoreCase(entry.getEmail()));

        if (isDuplicate) {
            return;
        } else {
            addressEntryList.add(entry);
        }
    }

    /**
     * Reads address entries from a file and adds them to the address book.
     * @param filename Path and name of the file to read from
     * @throws IOException If an error occurs while reading the file
     */
    public void readFromFile(String filename) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = br.readLine()) != null) {
            //Each line is read to extract information
            String firstlastName = line;
            String street = br.readLine();
            String cityStateZip = br.readLine();
            String email = br.readLine();
            String phone = br.readLine();
            br.readLine();

            // To separate firstName, lastName, we split and extract the necessary information
            String[] firstlastNameParts = firstlastName.split(" ");
            String firstName = firstlastNameParts[0];
            String lastName = firstlastNameParts[1];

            // To separate city, state, and zip code, we split and extract the necessary information
            String[] cityStateZipParts = cityStateZip.split(", ");
            String city = cityStateZipParts[0];
            String stateZip = cityStateZipParts[1];
            String[] stateZipParts = stateZip.split(" ");
            String state = stateZipParts[0];
            int zip = Integer.parseInt(stateZipParts[1]);

            // Create an AddressEntry object and add it to the list
            AddressEntry entry = new AddressEntry(firstName, lastName, street, city, state, zip, email,phone);
            add(entry);
        }
        br.close();
    }


    /**
     * Finds and prints address entries with last names starting with the given string.
     * @param startOfLastName Starting substring of the last name to find
     */
    public void find(String startOfLastName){
        List<AddressEntry> foundEntries = new ArrayList<>();
        for (AddressEntry entry : addressEntryList) {
            if (entry.getLastName().toLowerCase().startsWith(startOfLastName.toLowerCase())) {
                foundEntries.add(entry);
            }
        }

        if (foundEntries.isEmpty()) {
            System.out.println("No entries found for a last name starting with \"" + startOfLastName + "\"");
        } else {
            System.out.println("The following " + foundEntries.size() + " entries were found in the address book for a last name starting with \"" + startOfLastName + "\":\n");
            int i = 1;
            for (AddressEntry entry : foundEntries) {
                entry.index = i;
                System.out.println(entry);
                System.out.println();
                i++;
            }
        }
    }
}