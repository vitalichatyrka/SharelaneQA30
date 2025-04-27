import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class ZipCodeTest {
    /*
1. Open a browser Chrome.
2. Enter the URl https://www.sharelane.com/cgi-bin/register.py
into the address line of browser and follow this URL.
3. Enter '1234' value into the 'ZipCode' field.
4. Click the 'Continue' button.

Expected result: The 'Oops, error on page. ZIP code should have 5 digits' error message is shown.

     */
    @Test
    public void checkZipCode4Digits() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        WebDriver browser = new ChromeDriver();
        browser.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
        browser.get("https://www.sharelane.com/cgi-bin/register.py");
        browser.findElement(By.name("zip_code")).sendKeys("1234");
        browser.findElement(By.cssSelector("[value=Continue]")).click();
        // <input type="text" name="zip_code" value="">
        // <input type="submit" value="Continue">
        String actualErrorMessage = browser.findElement(By.className("error_message")).getText();
        // <span class="error_message">Oops, error on page. ZIP code should have 5 digits</span>
        Assert.assertEquals(actualErrorMessage, "Oops, error on page. ZIP code should have 5 digits");
        browser.quit();
    }

    @Test
    public void checkZipCodeEmpty() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        WebDriver browser = new ChromeDriver();
        browser.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
        browser.get("https://www.sharelane.com/cgi-bin/register.py");
        browser.findElement(By.name("zip_code")).sendKeys("");
        browser.findElement(By.cssSelector("[value=Continue]")).click();
        // <input type="text" name="zip_code" value="">
        // <input type="submit" value="Continue">
        String actualErrorMessage = browser.findElement(By.className("error_message")).getText();
        // <span class="error_message">Oops, error on page. ZIP code should have 5 digits</span>
        Assert.assertEquals(actualErrorMessage, "Oops, error on page. ZIP code should have 5 digits");
        browser.quit();

    }
}
