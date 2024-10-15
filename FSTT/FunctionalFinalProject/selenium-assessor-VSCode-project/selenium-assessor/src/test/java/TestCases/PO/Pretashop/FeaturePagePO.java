package TestCases.PO.Pretashop;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class FeaturePagePO extends PretashopUtilityPO{

    // Locators
    By catalogLocator = By.xpath("/html/body/div[1]/div[1]/nav/ul/li[3]/a/span");
    By productFeatureLocator = By.xpath("/html/body/div[1]/div[1]/nav/ul/li[3]/ul/li[5]/a");
    By addNewFeatureButtonLocator = By.id("page-header-desc-feature-new_feature");
    By featureNameLocator = By.id("name_1");
    By saveButtonLocator = By.id("feature_form_submit_btn");
    By featureCreationMsgLocator = By.xpath("/html/body/div[1]/div[2]/div[4]/div");

    public FeaturePagePO(WebDriver driver) {super(driver);}
    
    public String addNewFeature(String user, String password, String featureName){
        // Login
        login(loginEmailLocator, loginPasswordLocator, loginSubmitButtonLocator, user, password);
        // Hover over Catalog and click on Products
        hoverAndClick(catalogLocator, productFeatureLocator);
        // Click the Add new product button
        click(addNewFeatureButtonLocator);
        // Fill in the product name
        type(featureNameLocator, featureName);
          // Scroll into view
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", find(saveButtonLocator));
        // Click the save button
        waitAndClick(saveButtonLocator);
        // Return the successful message
        return getText(featureCreationMsgLocator).replace("×", "").trim();
    }

    public String addEmptyFeature(String user, String password){
        // Login
        login(loginEmailLocator, loginPasswordLocator, loginSubmitButtonLocator, user, password);
        // Hover over Catalog and click on Products
        hoverAndClick(catalogLocator, productFeatureLocator);
        // Click the Add new product button
        click(addNewFeatureButtonLocator);
        // Scroll into view
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", find(saveButtonLocator));
        // Click the save button
        waitAndClick(saveButtonLocator);
        // Return the successful message
        return getText(featureCreationMsgLocator).replace("×", "").trim();
    }
}
