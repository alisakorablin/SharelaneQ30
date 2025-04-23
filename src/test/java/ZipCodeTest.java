import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class ZipCodeTest {

    @Test
    public void checkZipCode4Digits(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");//указали путь к драйверу
        WebDriver browser = new ChromeDriver(); //класс селениума
        browser.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
        browser.get("https://www.sharelane.com/cgi-bin/register.py"); //взаимодейтсвие с экзамеляром классса

        //<input type="text" name="zip_code" value="">
        browser.findElement(By.name("zip_code")).sendKeys("1234"); //ищем элемент по атрибуту name  и вводим значениe

        //<input type="submit" value="Continue">
        browser.findElement(By.cssSelector("[value='Continue']")).click();

        //<span class="error_message">Oops, error on page. ZIP code should have 5 digits</span>
        String actualErrorMessage = browser.findElement(By.className("error_message")).getText();

        Assert.assertEquals(actualErrorMessage, "Oops, error on page. ZIP code should have 5 digits");
        browser.quit(); //
    }
}
