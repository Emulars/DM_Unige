package TestCases.PO;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePagePO {
    
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePagePO(WebDriver driver) {
        this.driver = driver;
    }

    public void visit(String url) {
        driver.get(url);
    }

    public WebElement find(By locator) {
        return driver.findElement(locator);
    }

    public Boolean isElementPresent(By locator) {
        try {
            find(locator);
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public void click(By locator) {
        find(locator).click();
    }

    public void waitAndClick(By locator) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        click(locator);
    }

    public void type(By locator, String text) {
        find(locator).clear();
        find(locator).sendKeys(text);
    }

    public String getAttribute(By locator, String attribute) {
        return find(locator).getAttribute(attribute);
    }

    public boolean isDisplayed(By locator) {
        return find(locator).isDisplayed();
    }

    public String getUrl(){
        return driver.getCurrentUrl();
    }

    public String getText(By locator){
        return find(locator).getText().trim();
    }

    public void selectDropdown(By locator, String value){
        Select dropdown = new Select(find(locator));
        dropdown.selectByVisibleText(value);
    }

    public String getSelectedDropdownOption(By locator){
        Select dropdown = new Select(find(locator));
        return dropdown.getFirstSelectedOption().getText().trim();
    }

    public void login(By loginEmailLocator, By loginPasswordLocator, By loginSubmitButtonLocator, String username, String password){
        type(loginEmailLocator, username);
        type(loginPasswordLocator, password);
        click(loginSubmitButtonLocator);
    }

    public void logout(By logoutLocator){
        // wait till element is visible
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        //wait.until(ExpectedConditions.invisibilityOfElementLocated(blockingVisibilityLocator));
        wait.until(ExpectedConditions.visibilityOfElementLocated(logoutLocator));
        waitAndClick(logoutLocator);
    }

    public void logout(By userIconLocator, By logoutLocator){
        click(userIconLocator);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(logoutLocator));
        click(logoutLocator);
    }

    public void hoverAndClick(By hoverLocator, By clickLocator){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(hoverLocator));
        Actions action = new Actions(driver);
        action.moveToElement(find(hoverLocator)).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(clickLocator));
        click(clickLocator);
    }

}
