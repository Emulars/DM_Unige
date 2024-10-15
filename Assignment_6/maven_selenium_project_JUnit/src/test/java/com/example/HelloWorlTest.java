package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Unit test for simple App.
 */
public class HelloWorlTest 
{

    private static WebDriver driver;

    @BeforeAll
    public static void setUp() {
        // declaration and instantiation of objects/variables
        driver = new FirefoxDriver();
    }
    
    @Test
    public void HelloWorld()
    {
        String baseUrl = "https://bonigarcia.dev/selenium-webdriver-java/";
        String expectedTitle = "Hands-On Selenium WebDriver with Java";
        String actualTitle = "";

        // launch Firefox and direct it to the Base URL
        driver.get(baseUrl);

        // get the actual value of the title
        actualTitle = driver.getTitle();

        /*
         * compare the actual title of the page with the expected one and print
         * the result as "Passed" or "Failed"
         */
       assertEquals(expectedTitle, actualTitle);

        // close Firefox
        driver.close();
    }

    @Test
    public void succesfulLogin() {
        String baseUrl = "https://bonigarcia.dev/selenium-webdriver-java/login-form.html";
        driver.get(baseUrl);

        // Print the current url
        System.out.println(driver.getCurrentUrl());

        // Insert the credentials and click the login button
        driver.findElement(By.id("username")).sendKeys("user");
        driver.findElement(By.id("password")).sendKeys("user");
        driver.findElement(By.className("mt-2")).click();

        // Print the current url
        System.out.println(driver.getCurrentUrl());

        // Check if the login was successful
        assertTrue(driver.findElement(By.id("success")).isDisplayed());
        assertEquals(driver.findElement(By.id("success")).getText(), "Login successful");
    }

    @Test
    public void failedLogin() {
        String baseUrl = "https://bonigarcia.dev/selenium-webdriver-java/login-form.html";
        driver.get(baseUrl);

        // Print the current url
        System.out.println(driver.getCurrentUrl());

        // Insert the credentials and click the login button
        driver.findElement(By.id("username")).sendKeys("user");
        driver.findElement(By.id("password")).sendKeys("password");
        driver.findElement(By.className("mt-2")).click();

        // Print the current url
        System.out.println(driver.getCurrentUrl());

        // Check if the login was successful
        assertTrue(driver.findElement(By.id("invalid")).isDisplayed());
    }
}
