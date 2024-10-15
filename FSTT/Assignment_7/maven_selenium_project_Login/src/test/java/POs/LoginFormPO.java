package POs;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginFormPO extends BasePagePO{
    
    private WebDriver driver;
    
    private By usernameLocator = By.id("username");
    private By passwordLocator = By.id("password");
    private By submitLocator = By.className("mt-2");
    private By invalidLocator = By.id("invalid");
    private By successLocator = By.id("success");

    public LoginFormPO(WebDriver driver) {
        super(driver);
        visit("https://bonigarcia.dev/selenium-webdriver-java/login-form.html");
    }

    public void with(String username, String password) {
        type(usernameLocator, username);
        type(passwordLocator, password);
        click(submitLocator);

        if (getUrl().equals("https://bonigarcia.dev/selenium-webdriver-java/login-form.html")) {
            System.out.println("Login failed");
        } else {
            System.out.println("Login success");
        }
    }

    public boolean invalidBoxIsPresent() {
        return isDisplayed(invalidLocator);
    }

    public boolean successBoxIsPresent() {
        return isDisplayed(successLocator);
    }
}
