package address;
import java.util.Scanner;

public class Menu {

    public static void displayMenu() {
        System.out.println("*************************");
        System.out.println("Please enter your menu selection");
        System.out.println("a) Loading of entries from a file.");
        System.out.println("b) Addition - prompting user for information to be used to create a new AddressEntry");
        System.out.println("c) Removal - removing of an AddressEntry from the AddressBook.");
        System.out.println("d) Find - prompts users for the beginning of the user's last name.");
        System.out.println("e) Listing - listing (a 'dump') of the addresses in alphabetic order by the person's last name.");
        System.out.println("f) Quit");
        System.out.println("*************************");
    }

    public static String prompt_FirstName(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("First Name: ");
        return scanner.nextLine();
    }

    public static String prompt_LastName(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Last Name: ");
        return scanner.nextLine();
    }

    public static String prompt_Street(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Street: ");
        return scanner.nextLine();
    }

    public static String prompt_City(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("City: ");
        return scanner.nextLine();

    }

    public static String prompt_State(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("State: ");
        return scanner.nextLine();
    }

    public static int prompt_Zip() {
        Scanner scanner = new Scanner(System.in);
        int zipCode = 0;
        boolean isValid = false;

        while (!isValid) {
            System.out.print("Enter the zip code: ");
            String input = scanner.nextLine();

            // Check if the input consists of digits only
            if (input.matches("\\d+")) {
                zipCode = Integer.parseInt(input);
                isValid = true;
            } else {
                System.out.println("Invalid input. Please enter digits only.");
            }
        }
        return zipCode;
    }

    public static String prompt_Phone() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Phone: ");
        return scanner.nextLine();
    }

    public static String prompt_Email() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Email: ");
        return scanner.nextLine();
    }
}
