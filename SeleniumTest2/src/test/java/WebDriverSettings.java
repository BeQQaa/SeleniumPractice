import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

public class WebDriverSettings {

    WebDriver driver;

    @Before
    public void init() {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver83.exe");
    }

    @After
    public void Drop() {
        driver.quit();
    }
}
