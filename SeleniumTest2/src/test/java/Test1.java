import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test1 extends WebDriverSettings {

    @Test
    public void test1() {
        driver = new ChromeDriver();
        driver.get("https://google.com");
        String tittle = driver.getTitle();
        Assert.assertEquals(tittle, "Google");
    }

    @Test
    public void test2() {
        driver = new ChromeDriver();
        driver.get("https://google.com");
        driver.findElement(By.xpath("/html/body/div/div[3]/form/div[2]/div[1]/div[3]/center/input[2]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void test3(){

//        Init Chrome Driver
        driver = new ChromeDriver();

//        Go to google.com
        driver.get("https://google.com");

//        Find Search Form
        driver.findElement(By.name("q")).sendKeys("dou");

//       (For practice) init the web element button, then wait up to 10 sec. while load button and click on it
        WebElement elementFindButt = driver.findElement(By.xpath("/html/body/div/div[3]/form/div[2]/div[1]/div[2]/div[2]/div[2]/center/input[1]"));
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(elementFindButt));
        driver.findElement(By.xpath("/html/body/div/div[3]/form/div[2]/div[1]/div[2]/div[2]/div[2]/center/input[1]")).click();

//        Wait until the page load
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div[1]/a/h3")));
//        Click on Dou site
        driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div[1]/a/h3")).click();



    }
}
