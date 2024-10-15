package TestCases.PO.Pretashop;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AttributePagePO extends PretashopUtilityPO{

    // Locators
    By catalogLocator = By.xpath("/html/body/div[1]/div[1]/nav/ul/li[3]/a/span");
    By productAttributeLocator = By.xpath("/html/body/div[1]/div[1]/nav/ul/li[3]/ul/li[4]/a");
    By addNewAttributeButtonLocator = By.id("page-header-desc-attribute_group-new_attribute_group");
    By attributeNameLocator = By.id("name_1");
    By publicNameLocator = By.id("public_name_1");
    By saveButtonLocator = By.id("attribute_group_form_submit_btn");
    By attributeCreationMsgLocator = By.xpath("/html/body/div[1]/div[2]/div[4]/div");

    public AttributePagePO(WebDriver driver) {super(driver);}

    public String addNewAttribute(String user, String password, String attributeName, String publicName){
        // Login
        login(loginEmailLocator, loginPasswordLocator, loginSubmitButtonLocator, user, password);
        // Hover over Catalog and click on Products
        hoverAndClick(catalogLocator, productAttributeLocator);
        // Click the Add new product button
        click(addNewAttributeButtonLocator);
        // Fill in the product name
        type(attributeNameLocator, attributeName);
        // Fill in the product name
        type(publicNameLocator, publicName);
        // Click the save button
        waitAndClick(saveButtonLocator);
        // Return the successful message
        return getText(attributeCreationMsgLocator).replace("×", "").trim();
    }
}
