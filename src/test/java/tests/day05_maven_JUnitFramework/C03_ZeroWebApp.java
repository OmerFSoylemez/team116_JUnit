package tests.day05_maven_JUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_ZeroWebApp {

    public static void main(String[] args) throws InterruptedException {


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));




        // 1. http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");


        // 2. Signin buttonuna tiklayin
        driver.findElement(By.xpath("//button[@id='signin_button']")).click();


        // 3. Login alanine  “username” yazdirin
        WebElement loginkutusu = driver.findElement(By.id("user_login"));
        loginkutusu.sendKeys("username");

        // 4. Password alanina “password” yazdirin
        WebElement password = driver.findElement(By.id("user_password"));
        password.sendKeys("password");


        // 5. Sign in buttonuna tiklayin
        driver.findElement(By.xpath("//input[@type = 'submit']")).click();


        // 6. Back tusu ile sayfaya donun
        driver.navigate().back();


        // 7. Online Banking menusunden Pay Bills sayfasina gidin
        driver.findElement(By.xpath("//strong[text()='Online Banking']")).click();
        driver.findElement(By.xpath("//span[@id='pay_bills_link']")).click();


        // 8. amount kismina yatirmak istediginiz herhangi bir miktari yazin
        driver.findElement(By.xpath("//input[@id='sp_amount']")).sendKeys("5000");


        // 9. tarih kismina “2020-09-10” yazdirin
        driver.findElement(By.xpath("//input[@id='sp_date']")).sendKeys("2020-09-10");


        // 10. Pay buttonuna tiklayin
        driver.findElement(By.xpath("//input[@type='submit']")).click();



        // 11. “The payment was successfully submitted.” mesajinin ciktigini test edin
        WebElement basarılıodeme = driver.findElement(By.xpath("//div[@id='alert_content']"));
        String expectedmesaj = "The payment was successfully submitted.";
        String actualMesaj = basarılıodeme.getText();

        if(expectedmesaj.contains(actualMesaj)){
            System.out.println("PASSED");
        }else {
            System.out.println("FAİLED");
        }

        //12.driver close
        driver.close();

    }

    }
