package TestCases;
import TestCases.PO.Bludit.ContentPagePO;
import TestCases.PO.Bludit.NewContentPagePO;
import TestCases.PO.Bludit.UserPagePO;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCasesBludit extends DriverLifeCycleSettings{
    
    private NewContentPagePO newContentPage;
    private ContentPagePO contentPage;
    private UserPagePO userPage;
    private String user = "admin";
    private String password = "password";

    @Test
    public void AddContentTest(){
        newContentPage = new NewContentPagePO(driver);
        assertEquals("Test Content", newContentPage.addContent(user, password, "Test Content"));
        newContentPage.logout();
    }

    @Test
    public void ChangeUrlTest(){
        contentPage = new ContentPagePO(driver);
        assertEquals("/new-post-url", contentPage.changeUrl(user, password, "new-post-url"));
        contentPage.logout();
    }

    @Test
    public void ChangePositionTest(){
        contentPage = new ContentPagePO(driver);
        assertEquals("30", contentPage.changePosition(user, password, "30"));
        contentPage.logout();
    }

    @Test
    public void ChangeParentTest(){
        contentPage = new ContentPagePO(driver);
        assertEquals("Create your own content", contentPage.changeParent(user, password, "Create your own content"));
        contentPage.logout();
    }

    @Test
    public void AddAsDraftTest(){
        newContentPage = new NewContentPagePO(driver);
        assertEquals("Draft Content", newContentPage.addAsDraft(user, password, "Draft Content"));
        newContentPage.logout();
    }

    @Test
    public void SetStickyPostTest(){
        contentPage = new ContentPagePO(driver);
        assertEquals("Set up your new site", contentPage.setStickyPost(user, password, "Set up your new site", "Sticky"));
        contentPage.logout();
    }

    @Test
    public void DeletePostTest(){
        contentPage = new ContentPagePO(driver);
        assertTrue(contentPage.deletePost(user, password, "Follow Bludit"));
        contentPage.logout();
    }

    @Test
    public void AddUserTest(){
        userPage = new UserPagePO(driver);
        assertEquals("usertest", userPage.addUser(user, password, "usertest", "usertest123", "user@test.com", "Administrator"));
        userPage.logout();
    }

    @Test
    public void ChangePasswordTest(){
        userPage = new UserPagePO(driver);
        assertEquals("The changes have been saved", userPage.changePassword(user, password, "usertest", "newpassword"));
        userPage.logout();
    }

    @Test
    public void AddSocialTest(){
        userPage = new UserPagePO(driver);
                
        // Expected messages
        String[] expectedMessages = {
            "https://www.facebook.com/some_fake_user_name_52432562135863",
            "https://instagram.com/some_fake_user_name_52432562135863"
        };
        
        assertArrayEquals(expectedMessages, userPage.addSocial(user, password, "admin", "https://www.facebook.com/some_fake_user_name_52432562135863", "https://instagram.com/some_fake_user_name_52432562135863"));

        userPage.logout();
    }
}
