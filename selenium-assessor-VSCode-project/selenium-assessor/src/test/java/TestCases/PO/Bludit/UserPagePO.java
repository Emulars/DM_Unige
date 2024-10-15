package TestCases.PO.Bludit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class UserPagePO extends BluditUtilityPO{

    // Link Locators
    By usersLocator = By.xpath("/html/body/div[4]/div/div[1]/ul/li[8]/a");
    By addUserLocator = By.xpath("/html/body/div[4]/div/div[2]/a");

    // New user fields locators
    By usernameLocator = By.id("jsnew_username");
    By passwordLocator = By.id("jsnew_password");
    By confirmPasswordLocator = By.id("jsconfirm_password");
    By emailLocator = By.id("jsemail");
    By roleLocator = By.id("jsrole");
    By facebookLocator = By.id("jsfacebook");
    By instagramLocator = By.id("jsinstagram");
    By saveButtonLocator = By.xpath("/html/body/div[4]/div/div[2]/form/div[6]/div/button");

    // Change password fields locators
    By changePasswordLocator = By.xpath("/html/body/div[4]/div/div[2]/div/div[1]/form/div[4]/div/a");
    By changePswSaveBtnLocator = By.xpath("/html/body/div[4]/div/div[2]/form/div[4]/div/button");

    // Change social fields locators
    By saveSocialButtonLocator = By.xpath("/html/body/div[4]/div/div[2]/div/div[1]/form/div[12]/div/button");

    // Return values locators
    By userSecondRowLocator = By.xpath("/html/body/div[4]/div/div[2]/table/tbody/tr[2]/td[1]");
    By confirmationAlertLocator = By.id("alert");

    public UserPagePO(WebDriver driver) {super(driver);}
    
    public String addUser(String user, String password, String username, String psw, String email, String role){
        // Login
        login(loginUserLocator, loginPasswordLocator, loginButtonLocator, user, password);
        // Click the Users link
        click(usersLocator);
        // Click the Add a new user link
        click(addUserLocator);
        // Fill in the username
        type(usernameLocator, username);
        // Fill in the password
        type(passwordLocator, psw);
        // Fill in the confirm password
        type(confirmPasswordLocator, psw);
        // Fill in the email
        type(emailLocator, email);
        // Select the role from the dropdown
        selectDropdown(roleLocator, role);
        // Scroll into view
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", find(saveButtonLocator));
        // Click the save button
        waitAndClick(saveButtonLocator);
        // Return the username
        return getText(userSecondRowLocator);
    }

    public String changePassword(String user, String password, String username, String psw){
        // Login
        login(loginUserLocator, loginPasswordLocator, loginButtonLocator, user, password);
        // Click the Users link
        click(usersLocator);
        // Click the given username
        By usernameLocator = By.linkText(username);
        click(usernameLocator);
        // Click the change password link
        click(changePasswordLocator);
        // Inser the new password
        type(passwordLocator, psw);
        // Insert the confirm password
        type(confirmPasswordLocator, psw);
        // Click the save button
        waitAndClick(changePswSaveBtnLocator);
        // message contained in the alert popup
        String msg = getText(confirmationAlertLocator);
        // Wait for the alert to disappear
        waitAlertNonVisible(confirmationAlertLocator);
        // Return the message contained in the alert popup
        return msg;
    }

    public String[] addSocial(String user, String password, String username, String facebookbUrl, String instagramUrl){
        // Login
        login(loginUserLocator, loginPasswordLocator, loginButtonLocator, user, password);
        // Click the Users link
        click(usersLocator);
        // Click the given username
        By usernameLocator = By.linkText(username);
        click(usernameLocator);
        // Fill in the facebook url
        type(facebookLocator, facebookbUrl);
        // Fill in the instagram url
        type(instagramLocator, instagramUrl);
        // Click the save button
        waitAndClick(saveSocialButtonLocator);
        // Click the Users link
        click(usersLocator);
        // Click the given username
        click(usernameLocator);
        // Return the facebook and instagram urls
        return new String[]{getAttribute(facebookLocator, "value"), getAttribute(instagramLocator, "value")};
    }
}
