import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class SignUpTest {
    //валид зип код
    //проверить чот на форме реги
    //заполнить форму реги
    //нажать кнопку реги
    //


    @Test
    public void checkSignUpValidData(){
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.sharelane.com/cgi-bin/register.py"); //взаимодейтсвие с экзамеляром классса

        //<input type="text" name="zip_code" value="">
        driver.findElement(By.name("zip_code")).sendKeys("12345"); //ищем элемент по атрибуту name  и вводим значениe

        //<input type="submit" value="Continue">
        driver.findElement(By.cssSelector("[value='Continue']")).click();

        driver.findElement(By.name("first_name")).sendKeys("test");
        driver.findElement(By.name("last_name")).sendKeys("test");
        driver.findElement(By.name("email")).sendKeys("ab@a.com");
        driver.findElement(By.name("password1")).sendKeys("12345");
        driver.findElement(By.name("password2")).sendKeys("12345");

        driver.findElement(By.cssSelector("[value='Register']")).click();
        //<span class="error_message">Oops, error on page. ZIP code should have 5 digits</span>
        //String actualErrorMessage = driver.findElement(By.className("error_message")).getText();
        //Assert.assertEquals(actualErrorMessage, "Oops, error on page. ZIP code should have 5 digits");
        driver.quit(); //
    }
}
