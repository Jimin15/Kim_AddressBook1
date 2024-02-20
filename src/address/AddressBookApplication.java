package address;

import address.data.AddressBook;
import address.data.AddressEntry;



public class AddressBookApplication {

    public static void main(String args[]) {

        // Menu is a class with a bunch of static methods --so we do not
        // need to create an instance to invoke those methods
        //Call ALL of the Menu prompts
        AddressBook addressBook = new AddressBook();
        initAddressBookExercise(addressBook);
    }

    public static void initAddressBookExercise(AddressBook ab) {
        // AddressEntry 인스턴스 2개 생성
        AddressEntry entry1 = new AddressEntry("John", "Doe", "123 Main St", "Anytown", "CA", 12345, "555-1234", "john@example.com");
        AddressEntry entry2 = new AddressEntry("Jane", "Smith", "456 Oak St", "Othertown", "NY", 67890, "555-5678", "jane@example.com");

        // 주소록에 추가
        ab.add(entry1);
        ab.add(entry2);

        // 주소록 출력
        ab.list();
    }
}
