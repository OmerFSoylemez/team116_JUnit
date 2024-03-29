package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;

public class ReusableMethod {

    public static String ikinciSayfaWHD(String ilkSayfaWindowHandleDegeri, WebDriver driver) {

        String ikinciSayfaWHD = "";

        Set<String> windowHandlesSeti = driver.getWindowHandles();
        for (String each : windowHandlesSeti
        ) {

            if (!each.equals(ilkSayfaWindowHandleDegeri)) {
                ikinciSayfaWHD = each;
            }
        }


        return ikinciSayfaWHD;
    }
    public static String hucredekiYaziyiGetir(int satirNo , int sutunNo, WebDriver driver){

        //               //tbody/tr[    5    ]/td[   1    ]

        String dinamikXPath = "//tbody/tr["+satirNo+"]/td["+sutunNo+"]";
        WebElement istenenHucredekiElement = driver.findElement(By.xpath(dinamikXPath));

        return istenenHucredekiElement.getText();
    }
    public static void tumSayfaFotoCek(WebDriver driver){

        TakesScreenshot tss = (TakesScreenshot) driver;
        // dosya yolunu dinamik hale getirmek için time stamp kullanalım
        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("YY/MM/dd/hh/mm");
        String dinamikDosyaYolu = "target/Screenshots/TumSayfa"+ldt.format(dtf)+".png";



        File tumSayfaFoto = new File(dinamikDosyaYolu);
        File geciciDosya = tss.getScreenshotAs(OutputType.FILE);


        try {
            FileUtils.copyFile(geciciDosya,tumSayfaFoto);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public static void webElementFotoCek(WebDriver driver, WebElement istenenWebElement) {

        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("YY/MM/dd/hh/mm");
        String dinamikDosyaYolu = "target/Screenshots/webElement"+ldt.format(dtf)+".png";

        File webElementFoto = new File(dinamikDosyaYolu);
        File geciciDosya = istenenWebElement.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(geciciDosya,webElementFoto);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}