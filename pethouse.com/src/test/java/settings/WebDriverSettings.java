package settings;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;

public class WebDriverSettings {
    protected static WebDriver driver;
    protected Data data;

    @BeforeAll
    public static void init() {
        System.setProperty("webdriver.chrome.driver", "chrome_driver_v_85.0.4.exe");
    }

    @AfterAll
    public static void drop() {
        driver.quit();
    }
}
