package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;

    //Webelements

    private By loginLink = By.cssSelector("a[href='/login']");
    private By emailField = By.cssSelector("input[id='Email']");
    private By passwordFiled = By.cssSelector("input[class='password']");
    private By loginBtn = By.cssSelector("input[value='Log in']");
    private By logoutLink = By.cssSelector("a[href='/logout']");
    private By unsuccessfulLoginMsg= By.xpath("//span[contains(text(),'Login was unsuccessful')]");



    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }


    //Methods

    public void clickLoginLink ()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginLink));
        driver.findElement(loginLink).click();
    }
    public void enterEmail (String email){
        driver.findElement(emailField).sendKeys(email);
    }
    public void enterPassword (String password)
    {
        driver.findElement(passwordFiled).sendKeys(password);
    }
    public void clickLoginBtn ()
    {
        driver.findElement(loginBtn).click();
    }
    public boolean isLogoutLinkVisible ()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(logoutLink));
        return driver.findElement(logoutLink).isDisplayed();
    }
    public boolean isUnsuccessfulLoginMsgVisible ()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(unsuccessfulLoginMsg));
        return driver.findElement(unsuccessfulLoginMsg).isDisplayed();
    }
}