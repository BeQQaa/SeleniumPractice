import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import settings.Data;
import settings.WebDriverSettings;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginFormTest extends WebDriverSettings {

    @Test
    public void testConnect() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://pethouse.ua/");
        String title = driver.getTitle();
        assertEquals("Зоомагазин Pethouse.ua Киев - купить зоотовары в Украине", title);
    }

    @Test
    public void goToRegisterForm() {
        driver = new ChromeDriver();
        data = new Data();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://pethouse.ua/");

        WebDriverWait wait = new WebDriverWait(driver, 3);

        wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//*[@id=\"header-main\"]/section[2]/div/div[1]/div[5]/ul[1]/li/a/span[1]"))));
        driver.findElement(By.xpath("//*[@id=\"header-main\"]/section[2]/div/div[1]/div[5]/ul[1]/li/a/span[1]")).click();


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Зарегистрируйтесь!")));
        driver.findElement(By.linkText("Зарегистрируйтесь!")).click();

        driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);
        driver.findElement(By.name("firstname")).sendKeys(data.getName());
        driver.findElement(By.name("surname")).sendKeys(data.getLastName());
        driver.findElement(By.name("username")).sendKeys(data.getMail());
        driver.findElement(By.name("password")).sendKeys(data.getPassword());

        driver.findElement(By.xpath("//*[@id=\"wlpeSaveRegisterButton\"]")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mobilephone-error")));

        assertEquals("Введите телефон", driver.findElement(By.id("mobilephone-error")).getText());

    }
}
