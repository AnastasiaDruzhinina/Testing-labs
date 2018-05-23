package testing;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class TestingLab2{

        WebDriver driver;

        @BeforeSuite
        public void beforeSuite() {
            System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
            this.driver = new ChromeDriver();
            this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            this.driver.manage().window().maximize();
            driver.navigate().to(TestConstants.url);
            Config.init(this.driver);
        }

        @AfterSuite
        public void afterSuite() {
            driver.close();
        }

        @Test
        public void Lab2Test() {
            Assert.assertEquals(Config.testSite.getUrl(), TestConstants.url);

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
