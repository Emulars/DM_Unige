package TestCases.PO.Pretashop;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class ProductPagePO extends PretashopUtilityPO{

    // Locators
    By catalogLocator = By.xpath("/html/body/div[1]/div[1]/nav/ul/li[3]/a/span");
    By productsLocator = By.xpath("/html/body/div[1]/div[1]/nav/ul/li[3]/ul/li[1]/a");

    By addNewProductButtonLocator = By.id("page-header-desc-product-new_product");
    By productNameLocator = By.id("name_1");
    By saveButtonLocator = By.name("submitAddproduct");
    By successfulMsgLocator = By.xpath("/html/body/div[1]/div[2]/div[4]/div"); 
    By emptyProductError1Locator = By.xpath("/html/body/div[1]/div[2]/div[4]/div/ol/li[1]");
    By emptyProductError2Locator = By.xpath("/html/body/div[1]/div[2]/div[4]/div/ol/li[2]");
    By editProductButtonLocator = By.xpath("/html/body/div[1]/div[2]/div[6]/div/form[2]/div/div[2]/table/tbody/tr[8]/td[11]/div/div/a");

    By priceTabLocator = By.xpath("//*[@id=\"link-Prices\"]");
    By preTaxPriceLocator = By.xpath("//*[@id=\"priceTE\"]");
    By retailPriceWithTaxLocator = By.xpath("//*[@id=\"priceTI\"]");
    By taxRuleGroupLocator = By.id("id_tax_rules_group");

    public ProductPagePO(WebDriver driver) {super(driver);}

    public String addNewProduct(String user, String password, String productName){
        // Login
        login(loginEmailLocator, loginPasswordLocator, loginSubmitButtonLocator, user, password);
        // Hover over Catalog and click on Products
        hoverAndClick(catalogLocator, productsLocator);
        // Click the Add new product button
        click(addNewProductButtonLocator);
        // Fill in the product name
        type(productNameLocator, productName);
          // Scroll into view
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", find(saveButtonLocator));
        // Click the save button
        waitAndClick(saveButtonLocator);
        // Return the successful message
        return getText(successfulMsgLocator).replace("×", "").trim();
    }

    public String[] addEmptyProduct(String user, String password){
        // Login
        login(loginEmailLocator, loginPasswordLocator, loginSubmitButtonLocator, user, password);
        // Hover over Catalog and click on Products
        hoverAndClick(catalogLocator, productsLocator);
        // Click the Add new product button
        click(addNewProductButtonLocator);
        // Scroll into view
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", find(saveButtonLocator));
        // Click the save button
        waitAndClick(saveButtonLocator);
        // Return the successful message list
        return new String[]{getText(emptyProductError1Locator).replace("×", "").trim(), getText(emptyProductError2Locator).replace("×", "").trim()};
    }
    
    public String editProduct(String user, String password, String productName){
        // Login
        login(loginEmailLocator, loginPasswordLocator, loginSubmitButtonLocator, user, password);
        // Hover over Catalog and click on Products
        hoverAndClick(catalogLocator, productsLocator);
        // Click the Edit product button
        click(editProductButtonLocator);
        // Fill in the product name
        type(productNameLocator, productName);
        // Scroll into view
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", find(saveButtonLocator));
        // Click the save button
        waitAndClick(saveButtonLocator);
        // Return the successful message
        return getText(successfulMsgLocator).replace("×", "").trim();
    }

    public Float addNewProductWithTax(String user, String password, Float productPrice){
        // Login
        login(loginEmailLocator, loginPasswordLocator, loginSubmitButtonLocator, user, password);
        // Hover over Catalog and click on Products
        hoverAndClick(catalogLocator, productsLocator);
        // Click the Add new product button
        click(addNewProductButtonLocator);
        // Click the Prices tab
        click(priceTabLocator);
        // Fill the pre-tax retail price
        type(preTaxPriceLocator, productPrice.toString());
        // Return the reail price with tax value
        return Float.parseFloat(getAttribute(retailPriceWithTaxLocator, "value"));
    }

    public Float addNewProductWithTaxReducedRate(String user, String password, Float productPrice, String taxRuleGroup){
        // Login
        login(loginEmailLocator, loginPasswordLocator, loginSubmitButtonLocator, user, password);
        // Hover over Catalog and click on Products
        hoverAndClick(catalogLocator, productsLocator);
        // Click the Add new product button
        click(addNewProductButtonLocator);
        // Click the Prices tab
        click(priceTabLocator);
        // Fill the pre-tax retail price
        type(preTaxPriceLocator, productPrice.toString());
        // Select the reduced rate from the dropdown
        selectDropdown(taxRuleGroupLocator, taxRuleGroup);
        // Return the reail price with tax value
        return Float.parseFloat(getAttribute(retailPriceWithTaxLocator, "value"));
    }
}
