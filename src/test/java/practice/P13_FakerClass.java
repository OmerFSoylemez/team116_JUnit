package practice;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class P13_FakerClass extends TestBase {

    @Test
    public void faker () throws InterruptedException {
        driver.get("https://automationexercise.com/");
        driver.findElement(By.xpath("//i[@class='fa fa-lock']")).click();
        WebElement isimKutusu = driver.findElement(By.xpath("//input[@data-qa='signup-name']"));
        WebElement emailKutusu = driver.findElement(By.xpath("//input[@data-qa='signup-email']"));

        Faker faker = new Faker();
        String isim = faker.name().fullName();
        String email = faker.internet().emailAddress();
        Actions actions= new Actions(driver);
        actions.click(isimKutusu).sendKeys(isim).sendKeys(Keys.TAB).sendKeys(email).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
        Thread.sleep(2000);
        driver.findElement(By.id("id_gender1")).click();
        WebElement passwordKutusu = driver.findElement(By.xpath("//label[@for='password']"));
        actions.click(passwordKutusu).sendKeys(faker.internet().password()).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(isim).sendKeys(Keys.TAB).sendKeys(isim).sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys(faker.address().fullAddress()).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(faker.address().state()).sendKeys(Keys.TAB)
                .sendKeys(faker.address().city()).sendKeys(Keys.TAB).sendKeys(faker.address().zipCode()).sendKeys(Keys.TAB)
                .sendKeys(faker.phoneNumber().phoneNumber()).perform();
        driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();

        WebElement accountControl = driver.findElement(By.xpath("//b[text()='Account Created!']"));
        String expectedword = "CREATED";
        String actualword = accountControl.getText();
        Assert.assertTrue(actualword.contains(expectedword));







    }
}
