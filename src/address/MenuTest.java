package address;
import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
class MenuTest {

    @Test
    public void testDisplayMenu() {
        // Redirect System.out to capture printed output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Call the displayMenu() method
        Menu.displayMenu();

        // Restore System.out
        System.setOut(System.out);

        // Define expected lines of output
        List<String> expectedOutputLines = Arrays.asList(
                "*************************",
                "Please enter your menu selection",
                "a) Loading of entries from a file.",
                "b) Addition - prompting user for information to be used to create a new AddressEntry",
                "c) Removal - removing of an AddressEntry from the AddressBook.",
                "d) Find - prompts users for the beginning of the user's last name.",
                "e) Listing - listing (a 'dump') of the addresses in alphabetic order by the person's last name.",
                "f) Quit",
                "*************************"
        );

        // Get the actual lines of output
        String[] actualOutputLines = outContent.toString().split(System.lineSeparator());

        // Compare actual and expected output lines using assertLinesMatch()
        assertLinesMatch(expectedOutputLines.stream(), Arrays.stream(actualOutputLines));
    }

    @Test
    public void testPromptFirstName() {
        String input = "John\n"; // 사용자 입력 시뮬레이션
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        String firstName = Menu.prompt_FirstName(); // 메서드 호출 및 반환값 저장
        // Assert
        assertEquals("John", firstName);

    }

    @Test
    public void testpromptLastName() {
        String input = "Kim\n"; // 사용자 입력 시뮬레이션
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        String lastName = Menu.prompt_LastName(); // 메서드 호출 및 반환값 저장
        // Assert
        assertEquals("Kim", lastName);
    }

    @Test
    void testpromptStreet() {
        String input = "1231 Fun St.\n"; // 사용자 입력 시뮬레이션
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        String street = Menu.prompt_Street(); // 메서드 호출 및 반환값 저장
        // Assert
        assertEquals("1231 Fun St.", street);

    }

    @Test
    void testpromptCity() {
        String input = "Oakland\n"; // 사용자 입력 시뮬레이션
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        String city = Menu.prompt_City(); // 메서드 호출 및 반환값 저장
        // Assert
        assertEquals("Oakland", city);
    }

    @Test
    void prompt_State() {
        String input = "CA\n"; // 사용자 입력 시뮬레이션
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        String state = Menu.prompt_State(); // 메서드 호출 및 반환값 저장
        // Assert
        assertEquals("CA", state);
    }

    @Test
    void prompt_Zip() {
        String input = "12345\n"; // 사용자 입력 시뮬레이션
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Integer zip = Menu.prompt_Zip(); // 메서드 호출 및 반환값 저장
        // Assert
        assertEquals(12345, zip.intValue());
    }

    @Test
    void prompt_Phone() {
        String input = "323-234-5623\n"; // 사용자 입력 시뮬레이션
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        String phone = Menu.prompt_Phone(); // 메서드 호출 및 반환값 저장
        // Assert
        assertEquals("323-234-5623", phone);
    }

    @Test
    void prompt_Email() {
        String input = "fun@gmail.com\n"; // 사용자 입력 시뮬레이션
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        String email = Menu.prompt_Email(); // 메서드 호출 및 반환값 저장
        // Assert
        assertEquals("fun@gmail.com", email);
    }
}