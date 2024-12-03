package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;

    //Webelements
private By searchBar =By.cssSelector("input[id='small-searchterms']");
private By searchBtn =By.cssSelector("input[value='Search']");
private By products =By.cssSelector("div[class='product-item']");
private By noProductsMsg = By.xpath("//*[contains(text(),'No products were found')]");
private By sortingOptions = By.cssSelector("select[id='products-orderby']");
private By price= By.cssSelector(".prices .price");


    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    //Methods

    public void searchForProduct (String product)
    {
        driver.findElement(searchBar).sendKeys(product);

    }
    public void clickSearchBtn ()
    {
        driver.findElement(searchBtn).click();
    }

   public boolean ExpectedProducts () {
       wait.until(ExpectedConditions.visibilityOfElementLocated(products));
       List<WebElement> searchResults = driver.findElements(products);
       if (searchResults.size() > 0)
       {
           return true;
       }
       return false;
    }
    public void clearSearchBar ()
    {
        driver.findElement(searchBar).clear();
    }
    public boolean  isNoProductsMsgVisible (){
       return driver.findElement(noProductsMsg).isDisplayed();
    }
    public void selectOrderBy (){
        Select select=new Select(driver.findElement(sortingOptions));
        select.selectByVisibleText("Price: Low to High");
    }
    public boolean arePriceOrderedCorrectly ()
    {
        List<WebElement> priceElements = driver.findElements(price);
        // Extract prices into a list of doubles
        List<Double> actualPrices = new ArrayList<>();
        for (WebElement priceElement : priceElements) {
            String priceText = priceElement.getText().replace("$", "").trim(); // Adjust for currency symbol
            actualPrices.add(Double.parseDouble(priceText));
        }

        // Create a copy of the list and sort it
        List<Double> sortedPrices = new ArrayList<>(actualPrices);
        Collections.sort(sortedPrices);

        // Verify if the actual prices are sorted
        if (actualPrices.equals(sortedPrices)) {
            return true;
        }
        return false;
    }

}
