package TestCases.PO.Bludit;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import TestCases.PO.BasePagePO;

public class BluditUtilityPO extends BasePagePO{

    // Login and Logout Locators
    By loginUserLocator = By.xpath("/html/body/div[1]/div/div/form/div[1]/input");
    By loginPasswordLocator = By.xpath("/html/body/div[1]/div/div/form/div[2]/input");
    By loginButtonLocator = By.xpath("/html/body/div[1]/div/div/form/div[4]/button");
    By logoutLocator = By.xpath("/html/body/div[3]/nav/div/a");


    public BluditUtilityPO(WebDriver driver) {
        super(driver);
        visit("http://localhost:8080/admin");
    }

    public void logout(){ super.logout(logoutLocator); }
 
    public void waitAlertNonVisible(By creationAlertLocator){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(creationAlertLocator));
    }
}
