package POs;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePagePO {
    
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePagePO(WebDriver driver) {
        this.driver = driver;
    }

    public BasePagePO(WebDriver driver, int seconds) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
    }

    public void visit(String url) {
        driver.get(url);
    }

    public WebElement find(By locator) {
        return driver.findElement(locator);
    }

    public void click(By locator) {
        find(locator).click();
    }

    public void type(By locator, String text) {
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
        return find(locator).getText();
    }

    public void addImplicitWait(int seconds){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
    }

    public void addExplicitWait(By locator, int seconds, String expectedText){
        wait.until(ExpectedConditions.textToBe(locator, expectedText));
        wait.withTimeout(Duration.ofSeconds(seconds));
    }

}
