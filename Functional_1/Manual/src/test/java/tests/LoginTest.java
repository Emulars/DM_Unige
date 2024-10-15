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
    private WebFormPO login;

    @Test
    public void testTextInput()
    {
        login = new WebFormPO(driver);
        assertEquals("ciao", login.insertTextInput("ciao"));
    }

    @Test
    @Disabled
    public void testDisabledInput()
    {
        login = new WebFormPO(driver);
        assertEquals("disabled", login.insertDisabledInput("disabled"));
    }
    @Test
    public void testReadOnlyInput()
    {
        login = new WebFormPO(driver);
        assertEquals("Readonly input", login.insertReadOnlyInput("readonly"));
    }

    @Test
    public void testDropdownByVisbleText()
    {
        login = new WebFormPO(driver);
        assertEquals("One", login.selectDropdown("One"));
    }

    @Test
    public void testDropdownByIndex()
    {
        login = new WebFormPO(driver);
        assertEquals("Two", login.selectDropdown(2));
    }

    @Test
    public void testDropdownByValue()
    {
        login = new WebFormPO(driver);
        assertEquals("Three", login.selectDropdownByValue("3"));
    }

    @Test
    public void testDataList()
    {
        login = new WebFormPO(driver);
        assertEquals("New York", login.selectDataList());
    }

    @Test
    public void testToggledCheckbox()
    {
        login = new WebFormPO(driver);
        assertTrue(login.toggleOnCheckbox());
    }

    @Test
    public void testUntoggledCheckbox()
    {
        login = new WebFormPO(driver);
        assertFalse(login.toggleOffCheckbox());
    }

    @Test
    public void testFileUpload() throws IOException
    {
        login = new WebFormPO(driver);
        assertEquals("https://bonigarcia.dev/selenium-webdriver-java/web-form.html", login.uploadFile());
    }
}
