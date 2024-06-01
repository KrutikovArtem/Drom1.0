package pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class BaseSelenideTest {
    public void setUp() {

        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.headless = false;
        Configuration.timeout = 2000;
        Configuration.pageLoadStrategy = "normal";

    }

    @BeforeEach
    public void init() {
        setUp();
    }

    @AfterEach
    public void closeDriver() {
        Selenide.closeWebDriver();
    }
}
