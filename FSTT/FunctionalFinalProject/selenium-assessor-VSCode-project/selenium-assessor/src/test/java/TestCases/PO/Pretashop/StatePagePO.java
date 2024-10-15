package TestCases.PO.Pretashop;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class StatePagePO extends PretashopUtilityPO{

    // Locators
    By localizationLocator = By.xpath("/html/body/div[1]/div[1]/nav/ul/li[9]/a/span");
    By statesLocator = By.xpath("/html/body/div[1]/div[1]/nav/ul/li[9]/ul/li[5]/a");
    By addNewStateButtonLocator = By.id("page-header-desc-state-new_state");

    By stateNameLocator = By.id("name");
    By isoCodeLocator = By.id("iso_code");
    By countryLocator = By.id("id_country");
    By zoneLocator = By.id("id_zone");
    By saveButtonLocator = By.id("state_form_submit_btn");
    By successfulMsgLocator = By.xpath("/html/body/div[1]/div[2]/div[4]/div"); 
    By emptyStateError1Locator = By.xpath("/html/body/div[1]/div[2]/div[4]/div/ol/li[1]"); 
    By emptyStateError2Locator = By.xpath("/html/body/div[1]/div[2]/div[4]/div/ol/li[2]");

    public StatePagePO(WebDriver driver) {super(driver);}

    public String addNewState(String user, String password, String stateName, String isoCode, String country, String zone) {
        // Login
        login(loginEmailLocator, loginPasswordLocator, loginSubmitButtonLocator, user, password);
        // Hover over Localization and click on States
        hoverAndClick(localizationLocator, statesLocator);
        // Click the Add new state button
        click(addNewStateButtonLocator);
        // Enters the name
        type(stateNameLocator, stateName);
        // Enters the ISO code
        type(isoCodeLocator, isoCode);
        // Select in the Country dropdown
        selectDropdown(countryLocator, country);
        // Select in the Zone dropdown
        selectDropdown(zoneLocator, zone);
        // Scroll into view
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", find(saveButtonLocator));
        // Click the save button
        waitAndClick(saveButtonLocator);
        // Return the successful message
        return getText(successfulMsgLocator).replace("×", "").trim();
    }

    public String[] addEmptyState(String user, String password) {
        // Login
        login(loginEmailLocator, loginPasswordLocator, loginSubmitButtonLocator, user, password);
        // Hover over Localization and click on States
        hoverAndClick(localizationLocator, statesLocator);
        // Click the Add new state button
        click(addNewStateButtonLocator);
        // Scroll into view
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", find(saveButtonLocator));
        // Click the save button
        waitAndClick(saveButtonLocator);
        // Return the successful message list
        return new String[]{getText(emptyStateError1Locator).replace("×", "").trim(), getText(emptyStateError2Locator).replace("×", "").trim()};
    }
}
