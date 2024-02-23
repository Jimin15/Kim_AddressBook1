package address;

import address.data.AddressBook;
import address.data.AddressEntry;

import java.io.IOException;
import java.util.Scanner;


public class AddressBookApplication {

    static AddressBook address = new AddressBook();

    public static void main(String args[]) throws IOException {

        Scanner scanner = new Scanner(System.in);
        String button;

        while(true){

            Menu.displayMenu();
            button = scanner.nextLine(); // 위에서 읽은 버튼 값으로 루프를 계속합니다.

            if("a".equals(button)){
                System.out.print("Enter in FileName:");
                String file = scanner.nextLine();
                address.readFromFile(file);

            }else if("b".equals(button)){
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
                System.out.print("Enter in Last Name of contact to remove:");
                String last = scanner.nextLine();
                address.remove(last);

            }else if("d".equals(button)){
                System.out.print("Enter in all or beginning of last name you wish to find:");
                String lastname = scanner.nextLine();
                address.find(lastname);

            }else if("e".equals(button)){
                address.list();

            }else if("f".equals(button)){
                break;
            }
            else{
                System.out.println("Invalid selection. Please enter a valid option (a, b, c, d, e, or f).");
                break;
            }
        }
    }

}
