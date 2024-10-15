package POs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePagePO {
    
    protected WebDriver driver;

    public BasePagePO(WebDriver driver) {
        this.driver = driver;
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

    public boolean isDisplayed(By locator) {
        return find(locator).isDisplayed();
    }

    public String getUrl(){
        return driver.getCurrentUrl();
    }
}
