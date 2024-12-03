import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;


public class LoginTests extends BaseTest {

    @Test
    public void successfulLoginTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLoginLink();
        loginPage.enterEmail("yasso.test@test.com");
        loginPage.enterPassword("Sweetgirl@10");
        loginPage.clickLoginBtn();
        assertTrue(loginPage.isLogoutLinkVisible());
    }

    @Test
    public void invalidUsernameLoginTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLoginLink();
        loginPage.enterEmail("nourhan.test@test.com");
        loginPage.enterPassword("Sweetgirl@10");
        loginPage.clickLoginBtn();
        assertTrue(loginPage.isUnsuccessfulLoginMsgVisible());
    }

    @Test
    public void invalidPasswordLoginTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLoginLink();
        loginPage.enterEmail("yasso.test@test.com");
        loginPage.enterPassword("test@10");
        loginPage.clickLoginBtn();
        assertTrue(loginPage.isUnsuccessfulLoginMsgVisible());
    }
}

