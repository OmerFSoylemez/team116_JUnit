package tests.day10_waits_cookies_webTables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C04_WebTables extends TestBase {

    @Test
    public void test01() {


        // 1. “https://demoqa.com/webtables” sayfasina gidin
        driver.get("https://demoqa.com/webtables");


        // 2. Headers da bulunan basliklari yazdirin
        List<WebElement> headerElementleriList = driver.findElements(By.xpath("//div[@role='columnheader']"));

        for (int i = 0; i <headerElementleriList.size() ; i++) {
            System.out.println(i+1 + ".sutun baslıgı : " + headerElementleriList.get(i).getText());
        }


        // 3. 3.sutunun basligini yazdirin
        System.out.println("3.sutun baslıgı : " + headerElementleriList.get(2).getText());


        // 4. Tablodaki tum datalari yazdirin
        List<WebElement> tablodakiTumDataList = driver.findElements(By.xpath("//div[@role='gridcell']"));

        int sayac=0;
        for (WebElement eachData: tablodakiTumDataList
             ) {
            if(!eachData.getText().isBlank());
            System.out.println(eachData.getText());
            sayac++;
        }


        // 5. Tabloda kac tane bos olmayan cell (data) oldugunu yazdirin
        System.out.println("Listede bos olmayan hücre sayisi : " +sayac);



        // 6. Tablodaki satir sayisini yazdirin
        List<WebElement> satirlarListesi = driver.findElements(By.xpath("//div[@role='row']"));
        System.out.println("Tablodaki satir sayisi : " + satirlarListesi.size());


        // 7. Tablodaki sutun sayisini yazdirin
        System.out.println("Tablodaki Sutun Sayisi : " + headerElementleriList.size());


        // 8. Tablodaki 3.kolonu yazdirin
        List<WebElement> ucuncuSutunElementleri=
                driver.findElements(By.xpath("//div[@role='row']/div[@role='gridcell'][3]"));
        System.out.println("========3.Sutun Elementleri=========");

        for (WebElement eachData: ucuncuSutunElementleri
             ) {
            if(!eachData.getText().isBlank()){
                System.out.println(eachData.getText());
            }
        }


        // 9. Tabloda “First Name” i Kierra olan kisinin Salary’sini yazdirin
        WebElement isimElementi;
        WebElement maasElementi;

        for (int i = 2; i < satirlarListesi.size(); i++) {

            isimElementi =
                    driver.findElement(By.xpath("(//div[@role='row'])["+i+"]/div[@role='gridcell'][1]"));
            maasElementi =
                    driver.findElement(By.xpath("(//div[@role='row'])["+i+"]/div[@role='gridcell'][5]"));

            if (isimElementi.equals("Kierra")){
                System.out.println("Kierra'nın maası : " + maasElementi.getText());
            }

        }
        
        //10. bir method olusturun,satir ve sutun sayisini girdigimde bana datayi yazdirsin
        hucreBilgisiYazdir(3,5);

    }
    public void hucreBilgisiYazdir(int satirNo, int SutunNo) {
        // (//div[@role=‘row’])["+i+"]/div[@role=‘gridcell’][1]")
        String dinamikXpat = "(//div[@role='row'])[" + satirNo + "]/div[@role='gridcell']["+SutunNo+"]";
        WebElement istenenElement = driver.findElement(By.xpath(dinamikXpat));
        System.out.println("İstenen hucredeki yazi : " +istenenElement.getText());
    }

}
