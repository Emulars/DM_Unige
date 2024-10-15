package TestCases;
import org.junit.jupiter.api.Test;

import TestCases.PO.Pretashop.AttributePagePO;
import TestCases.PO.Pretashop.FeaturePagePO;
import TestCases.PO.Pretashop.ProductPagePO;
import TestCases.PO.Pretashop.StatePagePO;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

// All the test cases for Pretashop takes into account that the web site was installed with the language setted to Italian

public class TestCasesPretashop extends DriverLifeCycleSettings{
    
    private ProductPagePO productPagePO;
    private StatePagePO statePagePO;
    private FeaturePagePO featurePagePO;
    private AttributePagePO attributePagePO;

    private String user = "admin@prestashop.com";
    private String password = "password";

    @Test
    public void addNewProductTest()
    {
        productPagePO = new ProductPagePO(driver);
        assertEquals("Creazione riuscita", productPagePO.addNewProduct(user, password, "Blue Jacket3"));
        productPagePO.logout();
    }

    @Test
    public void addEmptyProductTest()
    {
        productPagePO = new ProductPagePO(driver);

        // Expected messages
        String[] expectedMessages = {
            "Il campo link_rewrite è richiesto almeno in Italiano (Italian)",
            "Il campo name è richiesto almeno in Italiano (Italian)"
        };
        
        assertArrayEquals(expectedMessages, productPagePO.addEmptyProduct(user, password));
        productPagePO.logout();
    }

    @Test
    public void editProductTest()
    {
        productPagePO = new ProductPagePO(driver);
        assertEquals("Aggiornamento riuscito", productPagePO.editProduct(user, password, "Deep Blue Jacket"));
        productPagePO.logout();
    }

    @Test
    public void addNewStateTest()
    {
        statePagePO = new StatePagePO(driver);
        assertEquals("Creazione riuscita", statePagePO.addNewState(user, password, "Liguria", "1121", "Italia", "Europe"));
        statePagePO.logout();
    }

    @Test
    public void addEmptyStateTest()
    {
        statePagePO = new StatePagePO(driver);

        // Expected messages
        String[] expectedMessages = {
            "Il campo Codice ISO è richiesto.",
            "Il campo Nome è richiesto."
        };
        
        assertArrayEquals(expectedMessages, statePagePO.addEmptyState(user, password));
        statePagePO.logout();
    }

    @Test
    public void addNewProductWithTaxTest()
    {
        productPagePO = new ProductPagePO(driver);
        assertEquals(12.20f, productPagePO.addNewProductWithTax(user, password, 10.0f), 0.05f, "The float values are not equal within the delta tolerance.");
        productPagePO.logout();
    }

    @Test
    public void addNewProductWithTax10()
    {
        productPagePO = new ProductPagePO(driver);
        assertEquals(11.0f, productPagePO.addNewProductWithTaxReducedRate(user, password, 10.0f, "IT Reduced Rate (10%)"), 0.05f, "The float values are not equal within the delta tolerance.");
        productPagePO.logout();
    }

    @Test
    public void addNewFeaturesTest()
    {
        featurePagePO = new FeaturePagePO(driver);
        assertEquals("Creazione riuscita", featurePagePO.addNewFeature(user, password, "Strong"));
        featurePagePO.logout();
    }

    @Test
    public void addEmptyFeaturesTest()
    {
        featurePagePO = new FeaturePagePO(driver);
        assertEquals("Il campo name è richiesto almeno in Italiano (Italian).", featurePagePO.addEmptyFeature(user, password));
        featurePagePO.logout();
    }

    @Test
    public void addNewAttributeTest()
    {
        attributePagePO = new TestCases.PO.Pretashop.AttributePagePO(driver);
        assertEquals("Creazione riuscita", attributePagePO.addNewAttribute(user, password, "Quantity", "Qnt"));
        attributePagePO.logout();
    }
}
