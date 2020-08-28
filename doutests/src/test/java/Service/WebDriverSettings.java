package Service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverSettings {

    protected WebDriver driver;

    @BeforeAll
    public void init(){

    }

    @BeforeEach
    public void initDriver(){
        driver = new ChromeDriver();
    }

}
