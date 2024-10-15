package POs;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CalculatorPO extends BasePagePO{

    private By oneLocator = By.xpath("//span[text()='1']");
    private By plusLocator = By.xpath("//span[text()='+']");
    private By threeLocator = By.xpath("//span[text()='3']");
    private By equalLocator = By.xpath("//span[text()='=']");

    private By screenLocator = By.className("screen");

    public CalculatorPO(WebDriver driver) {
        super(driver);
        visit("https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html");
    }

    public CalculatorPO(WebDriver driver, int seconds) {
        super(driver, seconds);
        visit("https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html");
    }

    public String sum(){
        click(oneLocator);
        click(plusLocator);
        click(threeLocator);
        click(equalLocator);
        return getText(screenLocator);
    }

    // Sum with sleep
    public String sumWithSleep() throws InterruptedException{
        click(oneLocator);
        click(plusLocator);
        click(threeLocator);
        click(equalLocator);
        Thread.sleep(6000);
        return getText(screenLocator);
    }
    
    // Sum with implicit wait
    public String sumWithImplicitWait(){
        click(oneLocator);
        click(plusLocator);
        click(threeLocator);
        click(equalLocator);
        addImplicitWait(7);
        return getText(screenLocator);
    }

    // Sum with explicit wait
    public String sumWithExplicitWait(){
        click(oneLocator);
        click(plusLocator);
        click(threeLocator);
        click(equalLocator);
        addExplicitWait(screenLocator, 7, "4");
        return getText(screenLocator);
    }
}
