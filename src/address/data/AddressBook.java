package address.data;
import java.io.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Collections;

public class AddressBook {

    List<AddressEntry> addressEntryList;

    public AddressBook() {
        addressEntryList = new ArrayList<>();
    }

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
            System.out.println((i + 1) + ":");
            System.out.println(addressEntryList.get(i).toString());
            //System.out.println();
        }
    }

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
            int index = 1;
            for (AddressEntry entry : foundEntries) {
                System.out.println(index + ":");
                System.out.println(entry);
                index++;
            }

            Scanner scanner = new Scanner(System.in);
            int choice;
            while (true) {
                System.out.print("\nEnter the number of entry you wish to remove: ");
                if (scanner.hasNextInt()) {
                    choice = scanner.nextInt();
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
            scanner.close();

            AddressEntry entryToRemove = foundEntries.get(choice - 1); // Get entry to remove
            addressEntryList.remove(entryToRemove);

            System.out.println("Entry removed successfully.");
        } else {
            AddressEntry entryToRemove = foundEntries.get(0); // Get the only entry found
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
            scanner.close();
        }

    }

    public void add(AddressEntry Entry) {
        addressEntryList.add(Entry);
    }

    public void readFromFile(String filename) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = br.readLine()) != null) {
            String[] parts = line.split(", ");
            if (parts.length == 8) {
                String firstName = parts[0];
                String lastName = parts[1];
                String street = parts[2];
                String city = parts[3];
                String state = parts[4];
                int zip = Integer.parseInt(parts[5]);
                String phone = parts[6];
                String email = parts[7];

                AddressEntry entry = new AddressEntry(firstName, lastName, street, city, state, zip, phone, email);
                add(entry);
            } else {
                System.out.println("Invalid entry format: " + line);
            }
        }
        br.close();
    }

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
            int index = 1;
            for (AddressEntry entry : foundEntries) {
                System.out.println(index + ":");
                System.out.println(entry);
                System.out.println();
                index++;
            }
        }
    }
}