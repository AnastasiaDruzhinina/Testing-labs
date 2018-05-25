package testing.Lab2;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class TestingLab2{

        private static WebDriver driver;

        @BeforeSuite
        public void beforeSuite() {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized");
            driver = new ChromeDriver(options);
            Config.init(driver);
        }

        @AfterSuite
        public void afterSuite() {
            driver.close();
        }

        @Test
        public void Lab2Test() {
            Config.testSite.open(TestConstants.url);

            Assert.assertEquals(Config.testSite.getUrl(), TestConstants.url);

            Assert.assertEquals(Config.testSite.getTitle(), TestConstants.title);

            Config.testSite.login(TestConstants.login, TestConstants.password);
            Assert.assertEquals(Config.testSite.getUsername(), TestConstants.username);

            Assert.assertEquals(Config.testSite.getPictureNumber(), 4);

            ArrayList<String> texts = Config.testSite.getPictureTexts();

            for (int i = 0; i < texts.size(); i++)
                Assert.assertEquals(texts.get(i), TestConstants.pictureTexts[i]);

            Assert.assertEquals(Config.testSite.getMainHeader(), TestConstants.mainHeader);
            Assert.assertEquals(Config.testSite.getMainText(), TestConstants.mainText);
        }
}
