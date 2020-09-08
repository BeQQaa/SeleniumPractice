package settings;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Date;

public class WebDriverSettings {
    protected static WebDriver driver;
    protected static Data data;
    protected static WebDriverWait wait;
    private static int timeSecondsForWebDriverWait = 5;

    @BeforeEach
    public void initEach(){
        driver = new ChromeDriver();
        data = new Data();
        wait = new WebDriverWait(driver, timeSecondsForWebDriverWait);
    }
    @BeforeAll
    public static void init(){
        System.setProperty("webdriver.chrome.driver","chromedriver_85.04.exe");
    }



    @AfterAll
    public static void drop(){
        driver.quit();
    }
}
