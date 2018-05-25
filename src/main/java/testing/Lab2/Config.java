package testing.Lab2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


class Config {
    static TestSite testSite;

    static void init(WebDriver driver) {
        testSite = PageFactory.initElements(driver, TestSite.class);
    }
}