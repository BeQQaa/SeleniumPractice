import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import settings.Data;
import settings.WebDriverSettings;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestPrivate extends WebDriverSettings {
    @Test
    public void testYoutube(){

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
//      go to the page https://www.youtube.com/
        driver.get("https://www.youtube.com/");
//      check that the browser tab is called “YouTube”
        String title = driver.getTitle();
        assertEquals("YouTube",title);
//          entering a query into the search bar (the query should consist of 2-4 digits, random each time the test is started)
        driver.findElement(By.xpath("//div[@id='search-input']")).click();
        driver.findElement(By.xpath("//input[@id='search']")).sendKeys(data.getRandNumber());
//         in the list of search results, select the second position from the top
        driver.findElement(By.xpath("//ul[@class='sbsb_b']/li[2]")).click();
//         make the browser full screen
        driver.manage().window().maximize();

//         in the list of search results, select the second position from the top
        wait
                .until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//div[@id='contents']/ytd-video-renderer[4]")))
                .click();
//         click on the avatar of the video sender
        wait
                .until(ExpectedConditions
                        .elementToBeClickable(
                                By.xpath("//a[@class='yt-simple-endpoint style-scope ytd-video-owner-renderer']")))
                .click();
//         click on the button with the text "SUBSCRIBE"
        wait
                .until(ExpectedConditions
                        .elementToBeClickable(
                                By.xpath("//div[@id='buttons']/div[@id='subscribe-button']")))
                .click();
//        checking that the text "LOG IN" (exact match) is displayed in the appeared container
        String element = driver
                .findElement(
                        By.xpath("//yt-formatted-string[@class='style-scope ytd-button-renderer style-blue-text size-default']"))
                .getAttribute("innerHTML");

        assertEquals("Войти", element);
//        close browser tab
        driver.close();
    }


}
