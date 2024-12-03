import Pages.ShoppingCartPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class ShoppingCartTests extends BaseTest
{

    @Test
    public void addProductToShoppingCart() {

        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        shoppingCartPage.clickAddProductToCart();
        assertTrue(shoppingCartPage.isProductAddedMsgVisible());
    }


    @Test
    public void removeProductFromCart() throws InterruptedException {
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        shoppingCartPage.clickAddProductToCart();
        Thread.sleep(5000);
        shoppingCartPage.clickShoppingCartLink();
        shoppingCartPage.removeItemFromCart();
        shoppingCartPage.clickUpdateShoppingCart();
        assertTrue(shoppingCartPage.isShoppingCartEmptyMsgVisible());

    }
}
