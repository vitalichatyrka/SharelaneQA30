import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class SignUpTest {
    @Test
    public void checkSignUpValidData() {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        //<input type="text" name="first_name" value="">
        driver.findElement(By.name("first_name")).isDisplayed();
        driver.findElement(By.name("first_name")).sendKeys("Vitali");
        driver.findElement(By.name("last_name")).sendKeys("Chatyrka");
        driver.findElement(By.name("email")).sendKeys("test_email@gmail.com");
        driver.findElement(By.name("password1")).sendKeys("134567Qa+");
        driver.findElement(By.name("password2")).sendKeys("134567Qa+");
        driver.findElement(By.cssSelector("[value=Register]")).click();
        String actualErrorMessage = driver.findElement(By.className("confirmation_message")).getText();
        //<span class="confirmation_message">Account is created!</span>
        Assert.assertEquals(actualErrorMessage, "Account is created!");
        driver.quit();
        //<input type="submit" value="Register">

    }
}
