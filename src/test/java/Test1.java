import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import pages.BaseSelenideTest;

import static com.codeborne.selenide.Selenide.$x;

public class Test1 extends BaseSelenideTest {

    private final String URL_MAIN = "https://auto.drom.ru/";


    @Test
    public void dromTest() {
        Selenide.open(URL_MAIN);
        Selenide.$x("//input[@placeholder='Марка']").click();
        $x("//form[@data-ftid='sales__filter']//*[contains(text(),'Toyota (')]").click();
        $x("//form//input[@placeholder='Модель']").click();
        $x("//form//input[@placeholder='Модель']").setValue("Harrier").sendKeys(Keys.ENTER);
        int a = 4;


    }


}
