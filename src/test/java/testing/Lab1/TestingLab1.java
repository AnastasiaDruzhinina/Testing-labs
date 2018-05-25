package testing.Lab1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

// TODO your code does not match with code convention !
// TODO take a look on IDEA warnings...
// TODO PO should be in another package - src/main/...

public class TestingLab1 extends Config {
        @Test
        public void Lab1Test() {
            String TestUrl = "https://jdi-framework.github.io/tests/index.htm";

            //Переходим по ссылке в браузере
            driver.get(TestUrl);
            Assert.assertEquals(driver.getCurrentUrl(), TestUrl);

            //Проверка текста в заголовке страницы
            Assert.assertEquals(driver.getTitle(), "Index Page");

            //Данные аккаунта
            String username = "epam";
            String pass = "1234";
            String name = "PITER CHAILOVSKII";

            //Получение и заполнение форм
            driver.findElement(By.cssSelector("[href='#']")).click();
            driver.findElement(By.cssSelector("[id = 'Login']")).sendKeys(username);
            driver.findElement(By.cssSelector("[id = 'Password']")).sendKeys(pass);
            driver.findElement(By.cssSelector("[type = 'submit']")).click();

            //Проверка, что имя пользователя отображено и совпадает с нужным
            Assert.assertTrue(driver.findElement(By.cssSelector("[href = '#']")).isDisplayed());
            Assert.assertEquals(driver.findElement(By.cssSelector("[href = '#']")).getText(), name);

            //Проверка текста в заголовке страницы
            Assert.assertEquals(driver.getTitle(), "Index Page");

            //Проверка, что картинок 4
            Assert.assertEquals((driver.findElements(By.cssSelector("[class = 'benefit-icon']")).size()), 4);

            //Получаем тексты под картинками
            ArrayList<WebElement> PictureTexts =
                    (ArrayList<WebElement>) driver.findElements(By.cssSelector("[class = 'benefit-txt']"));

            //Проверить, что текстов 4
            Assert.assertEquals(PictureTexts.size(), 4);

            //Проверить, что текст под картинкой совпадает с нужным
            Assert.assertEquals(PictureTexts.get(0).getText(), "To include good practices\n" +
                    "and ideas from successful\n" +
                    "EPAM projec");
            Assert.assertEquals(PictureTexts.get(1).getText(), "To be flexible and\n" +
                    "customizable");
            Assert.assertEquals(PictureTexts.get(2).getText(), "To be multiplatform");
            Assert.assertEquals(PictureTexts.get(3).getText(), "Already have good base\n" +
                    "(about 20 internal and\n" +
                    "some external projects),\n" +
                    "wish to get more…");

            //Проверка текста в центре старницы
            String header = "EPAM FRAMEWORK WISHES…";
            String text_bellow = "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD " +
                    "TEMPOR INCIDIDUNT UT LABORE ET " +
                    "DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI " +
                    "UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN " +
                    "VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.";

            Assert.assertEquals((driver.findElement(By.cssSelector(".main-title"))).getText(), header);
            Assert.assertEquals((driver.findElement(By.cssSelector(".main-txt"))).getText(), text_bellow);
        }
}
