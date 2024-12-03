import Pages.LoginPage;
import Pages.RegisterPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class RegisterTests extends BaseTest {
    private SoftAssert softassert;
    @Test
    public void Registration() {
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.clickRegisterLink();
        registerPage.chooseGenderFemale();
        registerPage.addFirstName("Yasmine");
        registerPage.addLastName("Test");
        registerPage.addEmail("nini.test@test.com");
        registerPage.addPassword("Sweetgirl@10");
        registerPage.addConfirmPassword("Sweetgirl@10");
        registerPage.clickRegisterBtn();
        softassert= new SoftAssert();
        softassert.assertTrue(registerPage.isSuccessfulRegistrationVisible());
        registerPage.clickLogoutLink();
        softassert.assertTrue(registerPage.isLoginLinkVisible());
        softassert.assertAll();
    }
}
