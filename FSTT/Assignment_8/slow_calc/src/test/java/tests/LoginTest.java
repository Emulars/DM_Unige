package tests;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import POs.*;

/**
 * Unit test for simple App.
 */
public class LoginTest extends DriverLifeCycleSettings
{
    private CalculatorPO login;

    @Test
    @Disabled
    public void testSum()
    {
        // Without wait
        login = new CalculatorPO(driver);
        assertEquals("4", login.sum());
    }

    // AS the above but with thread.sleep
    @Test
    public void testSumWithSleep() throws InterruptedException
    {
        // With wait
        login = new CalculatorPO(driver);
        assertEquals("4", login.sumWithSleep());
    }

    // AS the above but with implicit wait
    // This test will fail because the implicit wait works only if the findElement method does not find the element
    @Test
    @Disabled
    public void testSumWithImplicitWait()
    {
        // With wait
        login = new CalculatorPO(driver);
        assertEquals("4", login.sumWithImplicitWait());
    }

    // AS the above but with explicit wait
    @Test
    public void testSumWithExplicitWait()
    {
        // With wait
        login = new CalculatorPO(driver, 7);
        assertEquals("4", login.sumWithExplicitWait());
    }
}
