package testing.Lab2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class TestingLab2 {

    private static WebDriver driver;
    public static TestPage testPage;

    public static void init(WebDriver driver) {
        testPage = PageFactory.initElements(driver, TestPage.class);
    }

    @BeforeClass
    public void beforeTest() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        init(driver);
    }

    @AfterClass
    public void afterClass() {
        driver.close();
    }

    @Test
    public void Lab2Test() {
        testPage.open(TestConstants.URL);

        Assert.assertEquals(testPage.getUrl(), TestConstants.URL);

        Assert.assertEquals(testPage.getTitle(), TestConstants.TITLE);

        testPage.login(TestConstants.LOGIN, TestConstants.PASSWORD);
        Assert.assertEquals(testPage.getUsername(), TestConstants.USERNAME);

        Assert.assertEquals(testPage.getPictureNumber(), 4);

        ArrayList<String> texts = testPage.getPictureTexts();

        for (int i = 0; i < texts.size(); i++)
            Assert.assertEquals(texts.get(i), TestConstants.PICTURE_TEXTS[i]);

        Assert.assertEquals(testPage.getMainHeader(), TestConstants.MAIN_HEADER);
        Assert.assertEquals(testPage.getMainText(), TestConstants.MAIN_TEXT);
    }
}
