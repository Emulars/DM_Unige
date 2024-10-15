package TestCases.PO.Bludit;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewContentPagePO extends BluditUtilityPO{

    By newContentLocator = By.xpath("/html/body/div[4]/div/div[1]/ul/li[4]/a");
    By contentTitleLocator = By.id("jstitle");
    By saveButtonLocator = By.xpath("/html/body/div[4]/div/div[2]/form/div/div[1]/div[3]/button[1]");
    By saveDraftButtonLocator = By.xpath("//*[@id=\"jsSaveDraft\"]");
    By creationAlertLocator = By.xpath("//*[@id=\"alert\"]");

    By publishedFirstRowTitleLocator = By.xpath("/html/body/div[4]/div/div[2]/table/tbody/tr[4]/td[1]");
    By draftFirstRowTitleLocator = By.xpath("/html/body/div[4]/div/div[2]/table/tbody/tr[2]/td[1]");

    public NewContentPagePO(WebDriver driver) {super(driver);}

    public String addContent(String user, String password, String contentTitle){
        // Login
        login(loginUserLocator, loginPasswordLocator, loginButtonLocator, user, password);
        // Click the New content link
        click(newContentLocator);
        // Fill in the content title
        type(contentTitleLocator, contentTitle);
        // Scroll into view
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", find(saveButtonLocator));
        // Click the save button
        waitAndClick(saveButtonLocator);
        // Wait for the alert to disappear
        waitAlertNonVisible(creationAlertLocator);
        // Return the successful message
        return getText(publishedFirstRowTitleLocator);
    }

    public String addAsDraft(String user, String password, String contentTitle){
        // Login
        login(loginUserLocator, loginPasswordLocator, loginButtonLocator, user, password);
        // Click the New content link
        click(newContentLocator);
        // Fill in the content title
        type(contentTitleLocator, contentTitle);
        // Scroll into view
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", find(saveDraftButtonLocator));
        // Click the save button
        waitAndClick(saveDraftButtonLocator);
        // Wait for the alert to disappear
        waitAlertNonVisible(creationAlertLocator);
        // Return the successful message
        return getText(draftFirstRowTitleLocator);
    }
}
