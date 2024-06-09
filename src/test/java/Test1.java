import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import pages.BaseSelenideTest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class Test1 extends BaseSelenideTest {

    private final String URL_MAIN = "https://auto.drom.ru/";


    @Test
    public void dromTest() {
        Selenide.open(URL_MAIN);
        $x("//input[@placeholder='Марка']").click();
        $x("//form[@data-ftid='sales__filter']//*[contains(text(),'Toyota (')]").click();
        $x("//form//input[@placeholder='Модель']").click();
        $x("//form//input[@placeholder='Модель']").setValue("Harrier");
        $x("//form//input[@placeholder='Модель']/../following-sibling::div//*[contains(text(), 'Harrier')]").click();
        $x("//div[@aria-label='Топливо']").click();
        $x("//div[@aria-label='Топливо']/../parent::div/div//*[contains(text(), 'Гибрид')]").click(); //!!!!
        $x("//label[@for='sales__filter_unsold']").click();
        $x("//button[@data-ftid='sales__filter_advanced-button']").click();
        $x("//input[@placeholder='от, км']").click();
        $x("//input[@placeholder='от, км']").sendKeys(Keys.NUMPAD1, Keys.NUMPAD0, Keys.NUMPAD0, Keys.NUMPAD0);
        $x("//div[@aria-label='Год от']").click();
        $x("//div[@aria-label='Год от']/div/div[contains(text(), '2007')]").click();   //!!!OK
        $x("//button[@data-ftid='sales__filter_submit-button']").click();


        List<String> listCarHarrierAfter2007 = $$x("//div[@data-ftid='bull_title']").texts();
        ArrayList<String> getYearCars = new ArrayList<>();
        for (String s : listCarHarrierAfter2007) {
            String tameVal = s;
            String valYearsCar = tameVal.substring(tameVal.length() - 4);
            getYearCars.add(valYearsCar);
        }
        ArrayList<Integer> yearsCarInt = new ArrayList<>();
        for (String s : getYearCars) {
            Integer i = Integer.parseInt(s);
            yearsCarInt.add(i);
        }
        for (Integer i : yearsCarInt) {
            Assertions.assertTrue(2007 <= i);
        }


        List<Integer> wdwd123 = listCarHarrierAfter2007.stream().map(Element -> Integer.parseInt(Element.substring(Element.length() - 4)))
                .collect(Collectors.toList());
        System.out.println(wdwd123);


//        List<String> text1 = $$x("//div[@data-ftid='bull_title']").texts();
//        ArrayList<Integer> sss = new ArrayList<>();
//        for (int i = 0; i < text1.size(); i++) {
//
//            String indexText = text1.get(i);
//            String formatString = indexText.substring(text1.get(i).length() - 4);
//            Integer stringToInteger = Integer.valueOf(formatString);
//            sss.add(stringToInteger);
//        }
//
//        for (int i = 0; i < sss.size(); i++) {
//            Assertions.assertTrue(sss.get(i) >= 2007);
//        }


    }


}
