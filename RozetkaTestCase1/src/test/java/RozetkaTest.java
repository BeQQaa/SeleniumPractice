import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


public class RozetkaTest extends WebDriverSettings{

    final String URlAddress = "https://rozetka.com.ua";
    final String MAX_PRICE_TEST_CELL_1 = "23000";
    final int waitTimer = 5;
    final int implicitlyWait = 3;

    @Test
    public void filterCellsByModelsPriceAndMemory(){
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, waitTimer);
        driver.navigate().to(URlAddress);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(implicitlyWait, TimeUnit.SECONDS);

        wait
                .until(ExpectedConditions
                        .elementToBeClickable(
        By.xpath("//*[@class='header-bottomline']//*[@class='menu-toggler']")))
                .click();


        wait
                .until(ExpectedConditions
                        .elementToBeClickable(
        By.xpath("//*[@class='menu-categories']/li[2]/a")))
                .click();


        wait
                .until(ExpectedConditions
                        .elementToBeClickable(
        By.xpath("//*[@class='portal-grid portal-grid_type_1_3']/li[1]")))
                .click();


        wait
                .until(ExpectedConditions
                        .elementToBeClickable(
        By.xpath("//*[@class= 'portal-navigation']/li[1]/a")))
                .click();

        wait
                .until(
                        ExpectedConditions
                                .elementToBeClickable(
        By.xpath("//*[@id='Apple']/parent::a")))
                .click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='4G (LTE)']/parent::a"))).click();

        elementFirst = wait
                .until(ExpectedConditions
                        .elementToBeClickable(
         By.cssSelector("input[formControlName=max]")));

        elementFirst.clear();
        elementFirst.sendKeys(MAX_PRICE_TEST_CELL_1);

        wait
                .until(ExpectedConditions
                        .elementToBeClickable(
                                By.xpath("//button[@class='button button_color_gray button_size_small slider-filter__button']")))
                .click();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
