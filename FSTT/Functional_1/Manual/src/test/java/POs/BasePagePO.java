package POs;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

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

    public String getAttribute(By locator, String attribute) {
        return find(locator).getAttribute(attribute);
    }

    public boolean isDisplayed(By locator) {
        return find(locator).isDisplayed();
    }

    public String getUrl(){
        return driver.getCurrentUrl();
    }

    public Select dropdown(By locator){
        return new Select(find(locator));
    }

    public String dataList(By clickLocator, By elementLocator){
        WebElement datalist = find(clickLocator);
        // Click, open data list
        datalist.click();

        // Select element from data list
        WebElement element = find(elementLocator);
        // Read value of selected element
        String elementValue = element.getAttribute("value");
        // Write value of selected element
        type(clickLocator, elementValue);

        return datalist.getAttribute("value");
    }

    public boolean toggleOnCheckbox(By locator){
        WebElement checkbox = find(locator);
        if (!checkbox.isSelected()){
            checkbox.click();
        }
        return checkbox.isSelected();
    }

    public boolean toggleOffCheckbox(By locator){
        WebElement checkbox = find(locator);
        if (checkbox.isSelected()){
            checkbox.click();
        }
        return checkbox.isSelected();
    }

    public String uploadFile(By fileLocator, By submitLocator) throws IOException{
        WebElement fileInput = find(fileLocator);
        Path tempFile = Files.createTempFile("temp", ".tmp");
        String filename = tempFile.toAbsolutePath().toString();
        fileInput.sendKeys(filename);
        find(submitLocator).submit();
        return getUrl();
    }
}
