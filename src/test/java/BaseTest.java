import Pages.LoginPage;
import Pages.RegisterPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

        protected WebDriver driver;

        @BeforeMethod
        public void setUp ()
        {
            driver= new EdgeDriver();
            driver.get("https://demowebshop.tricentis.com/");
            driver.manage().window().maximize();
        }

        @AfterMethod
        public void tearDown ()
        {
            driver.quit();
        }
    }


