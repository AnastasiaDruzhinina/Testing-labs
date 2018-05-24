package testing.Lab2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class Config {
    public static TestSite testSite;

    public static void init(WebDriver driver) {
        testSite = PageFactory.initElements(driver, TestSite.class);
    }
}