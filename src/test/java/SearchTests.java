import Pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;
public class SearchTests extends BaseTest

{
    @Test
    public void validSearchResults()
    {
        HomePage homePage= new HomePage(driver);
        homePage.searchForProduct("Phone");
        homePage.clickSearchBtn();
        assertTrue(homePage.ExpectedProducts());
    }

    @Test
    public void invalidSearchResults()
    {
        HomePage homePage= new HomePage(driver);
        homePage.clearSearchBar();
        homePage.searchForProduct("abcdefg");
        homePage.clickSearchBtn();
        assertTrue(homePage.isNoProductsMsgVisible());

    }

    @Test
    public void verifySortingOptionsInSearchResults()
    {
        HomePage homePage= new HomePage(driver);
        homePage.clearSearchBar();
        homePage.searchForProduct("Computer");
        homePage.clickSearchBtn();
        homePage.selectOrderBy();
        assertTrue(homePage.arePriceOrderedCorrectly());

    }
}
