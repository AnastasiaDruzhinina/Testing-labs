package testing.Lab2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


// TODO what is the reason fo this file ? It has no relations with  PO, actually...
// TODO why dont you create BaseTest or smth like that ?
class Config {
    public static TestSite testSite;

    public static void init(WebDriver driver) {
        testSite = PageFactory.initElements(driver, TestSite.class);
    }
}