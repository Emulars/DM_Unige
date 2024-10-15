package POs;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WebFormPO extends BasePagePO{
    
    private By inputTextLocator = By.id("my-text-id");
    private By disabledInputLocator = By.name("my-disabled");
    private By readOnlyLocator = By.name("my-readonly");
    
    private By dropdownLocator = By.name("my-select");

    private By dataListClickLocator = By.name("my-datalist");
    private By dataListElementLocator = By.xpath("//datalist/option[2]");

    private By checkboxLocator = By.id("my-check-1");

    private By fileLocator = By.name("my-file");
    private By submitLocator = By.tagName("form");

    public WebFormPO(WebDriver driver) {
        super(driver);
        visit("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
    }

    public String insertTextInput(String text) {
        type(inputTextLocator, text);
        return getAttribute(inputTextLocator, "value");
    }

    // Throws exception: org.openqa.selenium.ElementNotInteractableException: element not interactable
    public String insertDisabledInput(String text) {
        type(disabledInputLocator, text);
        return getAttribute(disabledInputLocator, "value");
    }

    // 
    public String insertReadOnlyInput(String text) {
        type(readOnlyLocator, text);
        return getAttribute(readOnlyLocator, "value");
    }

    // Select dropdown by text
    public String selectDropdown(String text) {
        dropdown(dropdownLocator).selectByVisibleText(text);
        return dropdown(dropdownLocator).getFirstSelectedOption().getText();
    }

    // Select dropdown by index
    public String selectDropdown(int index) {
        dropdown(dropdownLocator).selectByIndex(index);
        return dropdown(dropdownLocator).getFirstSelectedOption().getText();
    }

    // Select dropdown by value
    public String selectDropdownByValue(String value) {
        dropdown(dropdownLocator).selectByValue(value);
        return dropdown(dropdownLocator).getFirstSelectedOption().getText();
    }

    // Select data list
    public String selectDataList() {
        return dataList(dataListClickLocator, dataListElementLocator);
    }

    // Select a checkbox
    public boolean toggleOnCheckbox() {
        return toggleOnCheckbox(checkboxLocator);
    }

    // Select a checkbox
    public boolean toggleOffCheckbox() {
        return toggleOffCheckbox(checkboxLocator);
    }

    public String uploadFile() throws IOException{
        return uploadFile(fileLocator, submitLocator);
    }
}
