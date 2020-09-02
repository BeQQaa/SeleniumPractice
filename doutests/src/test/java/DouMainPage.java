import Service.WebDriverSettings;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class DouMainPage extends WebDriverSettings {

    @Test
    void checkSalaryInDecember2017ForJava() throws InterruptedException {

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://dou.ua/");

        driver.findElement(By.xpath("/html/body/div/header/ul/li[5]/a")).click();

        element = driver.findElement(By.name("city"));
        select = new Select(element);
        elementList = select.getOptions();
        random = new Random();
        elementList.get(random.nextInt(elementList.size())).click();

        element = driver.findElement(By.name("period"));
        select = new Select(element);
        select.selectByValue("dec2017");

        Thread.sleep(10000);
    }

}
