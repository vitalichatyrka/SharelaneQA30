import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class ShoppingCartTest {
    @Test
    public void checkDiscount0() {
        SoftAssert softAssert = new SoftAssert();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.sharelane.com/cgi-bin/register.py?page=2&zip_code=12345" +
                "&first_name=adsas&last_name=sdsdd&email=dsdsd%40ddd.com&password1=12345&password2=12345");
        String email = driver.findElement(By.xpath(
                "//table/tbody/tr[6]/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/b")).getText();
        String password = driver.findElement(By.xpath(
                "//table/tbody/tr[6]/td/table/tbody/tr[4]/td/table/tbody/tr[2]/td[2]")).getText();

        driver.get("https://www.sharelane.com/cgi-bin/main.py");
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.cssSelector("[value=Login]")).click();

        driver.get("https://www.sharelane.com/cgi-bin/add_to_cart.py?book_id=6");
        driver.get("https://www.sharelane.com/cgi-bin/shopping_cart.py");

        driver.findElement(By.name("q")).clear();
        driver.findElement(By.name("q")).sendKeys("19");

        driver.findElement(By.cssSelector("[value=Update]")).click();
        softAssert.assertEquals(driver.findElement(By.xpath(
                        "//table/tbody/tr[6]/td/table/tbody/tr[2]/td[5]/p/b")).getText(),
                "0");
        softAssert.assertEquals(driver.findElement(By.xpath(
                        "//table/tbody/tr[6]/td/table/tbody/tr[2]/td[6]")).getText(),
                "0");
        softAssert.assertEquals(driver.findElement(By.xpath(
                        "//table/tbody/tr[6]/td/table/tbody/tr[2]/td[7]")).getText(),
                "190.00");
        driver.quit();
        softAssert.assertAll();
    }

    @Test
    public void checkDiscount2() {
        SoftAssert softAssert = new SoftAssert();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.sharelane.com/cgi-bin/register.py?page=2&zip_code=12345" +
                "&first_name=adsas&last_name=sdsdd&email=dsdsd%40ddd.com&password1=12345&password2=12345");
        String email = driver.findElement(By.xpath(
                "//table/tbody/tr[6]/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/b")).getText();
        String password = driver.findElement(By.xpath(
                "//table/tbody/tr[6]/td/table/tbody/tr[4]/td/table/tbody/tr[2]/td[2]")).getText();

        driver.get("https://www.sharelane.com/cgi-bin/main.py");
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.cssSelector("[value=Login]")).click();

        driver.get("https://www.sharelane.com/cgi-bin/add_to_cart.py?book_id=6");
        driver.get("https://www.sharelane.com/cgi-bin/shopping_cart.py");

        driver.findElement(By.name("q")).clear();
        driver.findElement(By.name("q")).sendKeys("30");

        driver.findElement(By.cssSelector("[value=Update]")).click();
        softAssert.assertEquals(driver.findElement(By.xpath(
                        "//table/tbody/tr[6]/td/table/tbody/tr[2]/td[5]/p/b")).getText(),
                "2");
        softAssert.assertEquals(driver.findElement(By.xpath(
                        "//table/tbody/tr[6]/td/table/tbody/tr[2]/td[6]")).getText(),
                "6.0");
        softAssert.assertEquals(driver.findElement(By.xpath(
                        "//table/tbody/tr[6]/td/table/tbody/tr[2]/td[7]")).getText(),
                "294.00");
        driver.quit();
        softAssert.assertAll();
    }

    @Test
    public void checkDiscount3() {
        SoftAssert softAssert = new SoftAssert();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.sharelane.com/cgi-bin/register.py?page=2&zip_code=12345" +
                "&first_name=adsas&last_name=sdsdd&email=dsdsd%40ddd.com&password1=12345&password2=12345");
        String email = driver.findElement(By.xpath(
                "//table/tbody/tr[6]/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/b")).getText();
        String password = driver.findElement(By.xpath(
                "//table/tbody/tr[6]/td/table/tbody/tr[4]/td/table/tbody/tr[2]/td[2]")).getText();

        driver.get("https://www.sharelane.com/cgi-bin/main.py");
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.cssSelector("[value=Login]")).click();

        driver.get("https://www.sharelane.com/cgi-bin/add_to_cart.py?book_id=6");
        driver.get("https://www.sharelane.com/cgi-bin/shopping_cart.py");

        driver.findElement(By.name("q")).clear();
        driver.findElement(By.name("q")).sendKeys("60");

        driver.findElement(By.cssSelector("[value=Update]")).click();
        softAssert.assertEquals(driver.findElement(By.xpath(
                        "//table/tbody/tr[6]/td/table/tbody/tr[2]/td[5]/p/b")).getText(),
                "3");
        softAssert.assertEquals(driver.findElement(By.xpath(
                        "//table/tbody/tr[6]/td/table/tbody/tr[2]/td[6]")).getText(),
                "18.0");
        softAssert.assertEquals(driver.findElement(By.xpath(
                        "//table/tbody/tr[6]/td/table/tbody/tr[2]/td[7]")).getText(),
                "582.00");
        driver.quit();
        softAssert.assertAll();
    }
}
