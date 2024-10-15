package TestCases.PO.Pretashop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import TestCases.PO.BasePagePO;

public class PretashopUtilityPO extends BasePagePO{

    // Locators
    By loginEmailLocator = By.id("email");
    By loginPasswordLocator = By.id("passwd");
    By loginSubmitButtonLocator = By.name("submitLogin");
    By userIconLocator = By.xpath("/html/body/header/nav/div/ul[3]/li[3]/a/span[2]");
    By logoutLocator = By.xpath("//*[@id=\"header_logout\"]");

    public PretashopUtilityPO(WebDriver driver) {
        super(driver);
        visit("http://localhost:8080/administrator");
    }
    
    public void logout(){ super.logout(userIconLocator, logoutLocator); }
}
