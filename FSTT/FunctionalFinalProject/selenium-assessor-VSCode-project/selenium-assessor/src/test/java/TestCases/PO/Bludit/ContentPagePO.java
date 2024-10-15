package TestCases.PO.Bludit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ContentPagePO extends BluditUtilityPO{
    
    // Content Page Locators
    By contentLocator = By.xpath("/html/body/div[4]/div/div[1]/ul/li[6]/a");
    By contentTitleLocator = By.xpath("/html/body/div[4]/div/div[2]/table/tbody/tr[4]/td[1]/a");
    
    // Advanced Settings Locators
    By advancedLocator = By.xpath("/html/body/div[4]/div/div[2]/form/div/div[2]/ul/li[7]/h2");
    By friendlyUrlLocator = By.xpath("//*[@id=\"jsslug\"]");
    By statusLocator = By.xpath("//*[@id=\"jsstatus\"]");
    By saveButtonLocator = By.xpath("/html/body/div[4]/div/div[2]/form/div/div[1]/div[3]/button[1]");
    By deleteButtonLocator = By.xpath("//*[@id=\"jsdelete\"]");

    // Returning values Locators
    By publishedFirstRowUrlLocator = By.xpath("/html/body/div[4]/div/div[2]/table/tbody/tr[4]/td[3]/a");
    By publishedAdvancedPosLocator = By.xpath("//*[@id=\"jsposition\"]");
    By publishedAdvancedParentLocator = By.xpath("//*[@id=\"jsparent\"]");
    By stickyFirstRowTitleLocator = By.xpath("/html/body/div[4]/div/div[2]/table/tbody/tr[6]/td[1]/a");

    public ContentPagePO(WebDriver driver) {super(driver);}

    public String changeUrl(String user, String password, String friendly_url){
        // Login
        login(loginUserLocator, loginPasswordLocator, loginButtonLocator, user, password);
        // Click the Content link
        click(contentLocator);
        // Click the content title
        click(contentTitleLocator);
        // Click the advanced settings
        click(advancedLocator);
        // Scroll into view
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", find(friendlyUrlLocator));
        // Fill in the friendly url
        type(friendlyUrlLocator, friendly_url);
        // Scroll into view
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", find(saveButtonLocator));
        // Click the save button
        waitAndClick(saveButtonLocator);
        // Click the content link
        click(contentLocator);
        // return the first row url
        return getText(publishedFirstRowUrlLocator);

    }

    public String changePosition(String user, String password, String position){
        // Login
        login(loginUserLocator, loginPasswordLocator, loginButtonLocator, user, password);
        // Click the Content link
        click(contentLocator);
        // Click the content title
        click(contentTitleLocator);
        // Click the advanced settings
        click(advancedLocator);
        // Scroll into view
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", find(publishedAdvancedPosLocator));
        // Fill the POSITION field
        type(publishedAdvancedPosLocator, position);
        // Scroll into view
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", find(saveButtonLocator));
        // Click the save button
        waitAndClick(saveButtonLocator);
        // Click the content link
        click(contentLocator);
        // Click the content title
        click(contentTitleLocator);
        // Click the advanced settings
        click(advancedLocator);
        // return the POSITION field
        return getAttribute(publishedAdvancedPosLocator, "value");
    }

    public String changeParent(String user, String password, String parent){
        // Login
        login(loginUserLocator, loginPasswordLocator, loginButtonLocator, user, password);
        // Click the Content link
        click(contentLocator);
        // Click the content title
        click(contentTitleLocator);
        // Click the advanced settings
        click(advancedLocator);
        // Scroll into view
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", find(publishedAdvancedPosLocator));
        // Select from the PARENT dropdown the parent
        selectDropdown(publishedAdvancedParentLocator, parent);
        // Scroll into view
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", find(saveButtonLocator));
        // Click the save button
        waitAndClick(saveButtonLocator);
        // Click the content link
        click(contentLocator);
        // Click the content title
        click(contentTitleLocator);
        // Click the advanced settings
        click(advancedLocator);
        // Return the selected parent
        return getSelectedDropdownOption(publishedAdvancedParentLocator);
    }

    public String setStickyPost(String user, String password, String postTitle, String status){
        // Login
        login(loginUserLocator, loginPasswordLocator, loginButtonLocator, user, password);
        // Click the Content link
        click(contentLocator);
        // Click the given post title link
        By linkTextLocator = By.linkText(postTitle);
        click(linkTextLocator);
        // Click the advanced settings
        click(advancedLocator);
        // Scroll into view
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", find(publishedAdvancedPosLocator));
        // Select from the STATUS dropdown the status
        selectDropdown(statusLocator, status);
        // Scroll into view
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", find(saveButtonLocator));
        // Click the save button
        waitAndClick(saveButtonLocator);
        // Click the content link
        click(contentLocator);
        // Return the title of the sticky post
        return getText(stickyFirstRowTitleLocator);
    }

    public Boolean deletePost(String user, String password, String postTitle){
        // Login
        login(loginUserLocator, loginPasswordLocator, loginButtonLocator, user, password);
        // Click the Content link
        click(contentLocator);
        // Click the given post title link
        By linkTextLocator = By.linkText(postTitle);
        click(linkTextLocator);
        // get the current url to future check
        String currentUrl = getUrl();
        // Scroll into view
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", find(deleteButtonLocator));
        // Click the Delete button
        waitAndClick(deleteButtonLocator);
        // handle the javascript alert
        driver.switchTo().alert().accept();
        // wait until the url changes
        wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(currentUrl)));
        // return true if the element is not present, false otherwise
        return !isElementPresent(linkTextLocator);
    }
}
