package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class RegisterPage
{
    private WebDriver driver;
    private WebDriverWait wait;


    //Webelements
    private By registerLink = By.cssSelector("a[href='/register']");
    private By genderFemale =By.xpath("//*[text()='Female']");
    private By firstNameField = By.cssSelector("input[id='FirstName']");
    private By lastNameField  = By.cssSelector("input[id='LastName']");
    private By emailField = By.cssSelector("input[id='Email']");
    private By passwordField =By.cssSelector("input[name='Password']");
    private By confirmPasswordField =By.cssSelector("input[name='ConfirmPassword']");
    private By registerBtn = By.cssSelector("input[id='register-button']");
    private By registrationMsg =By.xpath("//*[contains (text(),'Your registration completed')]");
    private By logoutLink = By.cssSelector("a[href='/logout']");
    private By loginLink = By.cssSelector("a[href='/login']");

    public  RegisterPage(WebDriver driver){
        this.driver =driver;
        this.wait= new WebDriverWait(driver, Duration.ofSeconds(5));

    }

    //Methods
   public void clickRegisterLink ()
   {
       driver.findElement(registerLink).click();
   }
   public void chooseGenderFemale ()
   {
       wait.until(ExpectedConditions.visibilityOfElementLocated(genderFemale));
       driver.findElement(genderFemale).click();
   }
   public void addFirstName (String firstName)
   {
       driver.findElement(firstNameField).sendKeys(firstName);
   }
   public void addLastName (String lastName)
   {
       driver.findElement(lastNameField).sendKeys(lastName);
   }
   public void addEmail (String email)
   {
       driver.findElement(emailField).sendKeys(email);
   }
   public void addPassword (String password)
   {
       driver.findElement(passwordField).sendKeys(password);
   }
   public void addConfirmPassword(String password)
   {
        driver.findElement(confirmPasswordField).sendKeys(password);
   }
    public void clickRegisterBtn ()
    {
        driver.findElement(registerBtn).click();
    }
    public boolean isSuccessfulRegistrationVisible  ()
    {
       wait.until(ExpectedConditions.visibilityOfElementLocated(registrationMsg));
      return driver.findElement(registrationMsg).isDisplayed();

    }
    public void  clickLogoutLink ()
    {
        driver.findElement(logoutLink).click();
    }

    public boolean isLoginLinkVisible ()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginLink));
       return driver.findElement(loginLink).isDisplayed();

    }

}
