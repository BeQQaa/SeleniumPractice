package Service;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;

public class WebDriverSettings {

    protected static List<WebElement> elementList;
    protected static WebElement element;
    protected static Select select;
    protected static WebDriver driver;
    protected static Random random;

    @BeforeAll
    public static void init(){
        System.setProperty("webdriver.chrome.driver", "chromedriver_85_0_4.exe");
    }

    @BeforeEach
    public void initDriver(){
        driver = new ChromeDriver();
    }

    @AfterAll
    public static void drop(){
        driver.quit();
    }

}
