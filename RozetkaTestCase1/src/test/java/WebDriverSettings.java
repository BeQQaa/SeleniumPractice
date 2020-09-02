import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverSettings {
    protected static WebDriver driver;
    protected WebDriverWait wait;
    protected WebElement elementFirst;

    @BeforeAll
    public static void init(){
        System.setProperty("webdriver.chrome.driver", "chromedriver_85_0_4.exe");

    }

    @AfterAll
    public static void drop(){
        driver.quit();
    }
}
