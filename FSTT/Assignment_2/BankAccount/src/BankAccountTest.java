//import static org.hamcrest.MatcherAssert.*;
//import static org.hamcrest.Matcher.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class BankAccountTest {
    private BankAccount account;

    @BeforeEach
    void setUp() {
        account = new BankAccount("1234567890", 100.0, "John Doe", "john.doe@example.com", "1234567890");
    }

    @Test
    void testDeposit() {
        // Test deposit method
        account.deposit(50.0);
        assertEquals(150.0, account.getBalance(), 0.01);
    }

    @Test
    void testGetAccountNumber() {
        // Test getAccountNumber method
        assertEquals("1234567890", account.getAccountNumber());
    }

    @Test
    void testGetBalance() {
        // Test getBalance method
        assertEquals(100.0, account.getBalance(), 0.01);
    }

    @Test
    void testGetCustomerName() {
        // Test getCustomerName method
        assertEquals("John Doe", account.getCustomerName());
    }

    @Test
    void testGetEmail() {
        // Test getEmail method
        assertEquals("john.doe@example.com", account.getEmail());
    }

    @Test
    void testGetPhoneNumber() {
        // Test getPhoneNumber method
        assertEquals("1234567890", account.getPhoneNumber());
    }

    @Test
    void testWithdraw() {
        // Test withdraw method
        account.withdraw(50.0);
        assertEquals(50.0, account.getBalance(), 0.01);
    }

    @ParameterizedTest
    @CsvSource({
        "100.0, 50.0, 150.0",
        "200.0, 100.0, 300.0",
        "300.0, 200.0, 500.0"
    })
    void testDepositWithParameter(double initialBalance, double depositAmount, double expectedBalance) {
        // Test deposit method with parameterized values
        account = new BankAccount("1234567890", initialBalance, "John Doe", "john.doe@example.com", "1234567890");
        account.deposit(depositAmount);
        assertEquals(expectedBalance, account.getBalance(), 0.01);
    }

    @Test
    void testWithdrawWithInsufficientFunds() {
        // Test withdraw method with insufficient funds
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(200.0);
        });
        assertEquals("Insufficient funds", exception.getMessage());
    }
}