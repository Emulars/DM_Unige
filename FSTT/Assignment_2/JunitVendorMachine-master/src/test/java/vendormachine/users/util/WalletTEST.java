package vendormachine.users.util;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class WalletTEST {

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
