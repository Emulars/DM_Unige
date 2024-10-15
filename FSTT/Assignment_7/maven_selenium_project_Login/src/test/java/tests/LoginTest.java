package tests;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import POs.*;

/**
 * Unit test for simple App.
 */
public class LoginTest extends DriverLifeCycleSettings
{
    private LoginFormPO login;

    @Test
    public void testLoginOk()
    {
        login = new LoginFormPO(driver);
        login.with("user", "user");
        assertTrue(login.successBoxIsPresent());
    }

    @Test
    public void testLoginNotOk()
    {
        login = new LoginFormPO(driver);
        login.with("bad-user", "bad-password");
        assertTrue(login.invalidBoxIsPresent());
    }

}
