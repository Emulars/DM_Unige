package vendormachine;
import vendormachine.users.util.Wallet;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WalletTEST {
	
	/** 
	 * Task 1:
	 * 	Objective:
	 * 		Test the Wallet class from:
	 * 		'vendormachine.users.util.Wallet'
	 * 
	 * 		Goal: 80% code/line coverage
	 * */
	
	// Hint: 
	// Others Tests for other classes that use Wallet may impact code coverage
	// Avoid relying on these tests, one test for one class; keep "Single Responsibility" in mind.
	private Wallet wallet;
	
	@BeforeEach
	public void setUp() {
		wallet = new Wallet();
	}
	
	@Test
	public void testaddCredit() {
		wallet.addCredit(10);
		assertEquals(10.5, wallet.getAllCredit());
	}
	
	@Test
	public void testgetCredit() {
		wallet.addCredit(20);
		wallet.getCredit(10);
		assertEquals(10.5, wallet.getAllCredit());
	}
}
