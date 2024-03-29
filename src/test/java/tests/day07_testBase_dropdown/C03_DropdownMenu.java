package tests.day07_testBase_dropdown;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;


public class C03_DropdownMenu extends TestBase {

            // ● https://the-internet.herokuapp.com/dropdown adresine gidin.
            // 1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
            // 2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
            // 3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
            // 4.Tüm dropdown değerleri(value) yazdırın
            // 5. Dropdown’un boyutunun 4 olduğunu test edin

    @Test
    public void test01 () {

        // ● https://the-internet.herokuapp.com/dropdown adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dropdown");


        // 1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        WebElement dropdownElementi = driver.findElement(By.id("dropdown"));
        Select select = new Select(dropdownElementi);

        select.selectByIndex(1);
        System.out.println("index ile seçilen option1 : "+select.getFirstSelectedOption().getText());
        bekle(3);


        // 2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        bekle(3);
        select.selectByValue("2");
        System.out.println("index ile seçilen option2 : "+select.getFirstSelectedOption().getText());


        // 3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        bekle(3);
        select.selectByVisibleText("Option 1");
        System.out.println("visible text ile seçilen option1 : "+select.getFirstSelectedOption().getText());



        // 4.Tüm dropdown değerleri(value) yazdırın
            // dropdown'daki elementleri bir liste olarak alabiliriz

        List<WebElement> optionElementleriList = select.getOptions();
        System.out.println("=======================");
        for (WebElement eachElement: optionElementleriList
             ) {
            System.out.println(eachElement.getText());
        }


        // 5. Dropdown’un boyutunun 4 olduğunu test edin

        int expectedOptionSayisi = 4;
        int actualOptionSayisi = optionElementleriList.size();
        Assert.assertEquals(expectedOptionSayisi,actualOptionSayisi);

        bekle(3);

    }
}


