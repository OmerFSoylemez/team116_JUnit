package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P03 {

    static WebDriver driver;
    WebElement searcbox;
    WebElement result;
    /*
        BeforeClass ile driver'i oluşturun ve class icinde static yapin
        Maximize edin ve 10 sn bekletin
        http://www.qooqle.com adresine gidin
        1-arama kutusuna "12 Angry Men" yaz ip, cikan sonuc şayisini yazdinin
        2-arama kutusuna "Vizontele" yaz ip, cikan sonuc şayisini yazdirin
        3-arama kutusuna "Saving Private Ryan" yaz4p, cikan sonuc şayisini yazdirin
        AfterClass ile kapatin.
     */

    @BeforeClass
    public static void setup () {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterClass
    public static void tearDown () {
        driver.quit();
    }
    @Before
    public void before () {
        driver.get("https://www.google.com");
        searcbox = driver.findElement(By.xpath("//*[@id=APjFqb'"));
    }
    @After
    public void after () {
        result = driver.findElement(By.xpath("//div[@id='result-stats']"));
        System.out.println(result.getText());
    }

    @Test
    public void test01() {
        searcbox.sendKeys("12 Angry Men" + Keys.ENTER);
    }

    @Test
    public void test02() {
        searcbox.sendKeys("Vizontele" + Keys.ENTER);
    }
    @Test
    public void test03() {
        searcbox.sendKeys("Saving Private Ryan" + Keys.ENTER);
    }


}

