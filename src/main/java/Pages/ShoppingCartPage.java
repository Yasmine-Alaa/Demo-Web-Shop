package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ShoppingCartPage {
    private WebDriver driver;
    private WebDriverWait wait;


    //WebElements
    private By addToCartBtn = By.cssSelector("input[value='Add to cart']");
    private By productAddedMsg =By.xpath("//p[contains(text(),'The product has been added to your')]");
    private By shoppingCartLink = By.xpath("//*[@id=\"topcartlink\"]/a");
    private By removeBtn =By.cssSelector("input[name='removefromcart']");
    private By updateCartBtn = By.cssSelector("input[name='updatecart']");
    private By shoppingCartEmptyMsg = By.xpath("//div[contains(text(),'Your Shopping Cart is empty!')]");


    public ShoppingCartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    //Methods
    public void clickAddProductToCart ()
    {
        List<WebElement> elementList =driver.findElements(addToCartBtn);
        elementList.get(1).click();
    }

    public boolean isProductAddedMsgVisible ()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(productAddedMsg));
        return driver.findElement(productAddedMsg).isDisplayed();
    }

     public void clickShoppingCartLink ()

    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(shoppingCartLink));
        driver.findElement(shoppingCartLink).click();

    }

     public void removeItemFromCart ()
     {
         driver.findElement(removeBtn).click();
     }
     public void clickUpdateShoppingCart ()
     {
         driver.findElement(updateCartBtn).click();
     }
     public boolean isShoppingCartEmptyMsgVisible ()
     {
         return driver.findElement(shoppingCartEmptyMsg).isDisplayed();
     }
}
