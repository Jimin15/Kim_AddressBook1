package address;

import address.data.AddressBook;
import address.data.AddressEntry;

import java.io.IOException;
import java.util.Scanner;

/**
 * The AddressBookApplication class represents an application for managing address book entries.
 * It provides a command-line interface for users to interact with the address book functionalities.
 *  @author [Jimin Kim]
 *  @since [2024-02-16]
 */
public class AddressBookApplication {

    /** The address book instance used for managing address entries. */
    static AddressBook address = new AddressBook();

    /**
     * The main method of the application.
     * @param args Command-line arguments.
     * @throws IOException If an I/O error occurs.
     */
    public static void main(String args[]) throws IOException {

        Scanner scanner = new Scanner(System.in);
        String button;

        while(true){

            Menu.displayMenu();
            button = scanner.nextLine();

            // Perform actions based on user input
            if("a".equals(button)){
                System.out.print("Enter in FileName:");
                String file = scanner.nextLine();
                address.readFromFile(file);

            }else if("b".equals(button)){
                // Add a new address entry
                String firstname = Menu.prompt_FirstName();
                String lastname = Menu.prompt_LastName();
                String street = Menu.prompt_Street();
                String city = Menu.prompt_City();
                String state = Menu.prompt_State();
                int zip = Menu.prompt_Zip();
                String email = Menu.prompt_Email();
                String phone = Menu.prompt_Phone();

                AddressEntry entry = new AddressEntry(firstname,lastname,street,city,state,zip,email, phone);
                address.add(entry);

            }else if("c".equals(button)){
                // Remove an address entry
                System.out.print("Enter in Last Name of contact to remove:");
                String last = scanner.nextLine();
                address.remove(last);

            }else if("d".equals(button)){
                // Find address entries by last name
                System.out.print("Enter in all or beginning of last name you wish to find:");
                String lastname = scanner.nextLine();
                address.find(lastname);

            }else if("e".equals(button)){
                // List all address entries

                address.list();

            }else if("f".equals(button)){
                // Exit the application
                break;
            }
            else{
                System.out.println("Invalid selection. Please enter a valid option (a, b, c, d, e, or f).");
                break;
            }
        }
    }

}
