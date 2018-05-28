package testing.Lab3;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import testing.Lab3.constants.DatesConstants;
import testing.Lab3.constants.DifferentElementsConstants;
import testing.Lab3.constants.IndexConstants;
import testing.Lab3.pageObjects.DatesPage;
import testing.Lab3.pageObjects.DifferentElementsPage;
import testing.Lab3.pageObjects.IndexPage;


public class TestingLab3 {
       private static IndexPage indexPage;
       private static DifferentElementsPage differentElementsPage;
       private static DatesPage datesPage;

        @BeforeTest
        public void beforeSuite() {
            Configuration.browser = "chrome";
            indexPage = new IndexPage();
            differentElementsPage = new DifferentElementsPage();
            datesPage = new DatesPage();
        }

        @Test
        public void Lab3Task1() {
            indexPage.open(IndexConstants.url.strValue);

            indexPage.checkTitle(IndexConstants.title.strValue);

            indexPage.checkLogin(
                    IndexConstants.login.strValue,
                    IndexConstants.password.strValue,
                    IndexConstants.username.strValue);

            indexPage.checkPictures(IndexConstants.pictureNumber.intValue);

            indexPage.checkPictureTexts(IndexConstants.pictureTexts.strArrayValue);

            indexPage.checkMainHeader(IndexConstants.mainHeader.strValue);

            indexPage.checkMainText(IndexConstants.mainText.strValue);

            indexPage.checkHeadDropdown(IndexConstants.dropdownTexts.strArrayValue);
            indexPage.checkLeftDropdown(IndexConstants.dropdownTexts.strArrayValue);

            indexPage.relocateToDifferentElements();

            differentElementsPage.checkElements(DifferentElementsConstants.checkboxNumber.intValue,
                    DifferentElementsConstants.checkboxNumber.intValue);

            differentElementsPage.selectCheckbox(DifferentElementsConstants.checkbox1Name.strValue);
            differentElementsPage.selectCheckbox(DifferentElementsConstants.checkbox3Name.strValue);

            differentElementsPage.selectRadio(DifferentElementsConstants.radio4value.strValue);

            differentElementsPage.selectDropdown(DifferentElementsConstants.dropdown4value.strValue);

            differentElementsPage.checkCheckboxInLog(DifferentElementsConstants.checkbox1Name.strValue, "true");
            differentElementsPage.checkCheckboxInLog(DifferentElementsConstants.checkbox3Name.strValue, "true");
            differentElementsPage.checkRadioInLog(DifferentElementsConstants.radio4value.strValue);
            differentElementsPage.checkDropdownInLog(DifferentElementsConstants.dropdown4value.strValue);

            differentElementsPage.unselectCheckbox(DifferentElementsConstants.checkbox1Name.strValue);
            differentElementsPage.unselectCheckbox(DifferentElementsConstants.checkbox3Name.strValue);

            differentElementsPage.checkCheckboxInLog(DifferentElementsConstants.checkbox1Name.strValue, "false");
            differentElementsPage.checkCheckboxInLog(DifferentElementsConstants.checkbox3Name.strValue, "false");
        }

        // TODO this test wont work. Tests should be independent...
        // Timeout: 4 s.
        // Caused by: NoSuchElementException: no such element: Unable to locate element: {"method":"xpath","selector":"(//div/a[@href='#'])[2]"}
        // at com.codeborne.selenide.impl.WebElementSource.createElementNotFoundError(WebElementSource.java:31)
        // at com.codeborne.selenide.impl.ElementFinder.createElementNotFoundError(ElementFinder.java:82)
        // at com.codeborne.selenide.impl.SelenideElementProxy.dispatchAndRetry(SelenideElementProxy.java:119)
        // at com.codeborne.selenide.impl.SelenideElementProxy.invoke(SelenideElementProxy.java:65)
        // at com.sun.proxy.$Proxy9.getText(Unknown Source)
        // at testing.Lab3.pageObjects.DatesPage.dragAndDropSliders(DatesPage.java:33)
        // at testing.Lab3.TestingLab3.Lab3Task2(TestingLab3.java:81)
        @Test
        public void Lab3Task2() {
            indexPage.open(IndexConstants.url.strValue);

            indexPage.checkTitle(IndexConstants.title.strValue);

            indexPage.relocateToDates();

            datesPage.dragAndDropSliders(DatesConstants.firstTest.testArray[0],DatesConstants.firstTest.testArray[1]);
            datesPage.dragAndDropSliders(DatesConstants.secondTest.testArray[0],DatesConstants.secondTest.testArray[1]);
            datesPage.dragAndDropSliders(DatesConstants.thirdTest.testArray[0],DatesConstants.thirdTest.testArray[1]);
            datesPage.dragAndDropSliders(DatesConstants.fourthTest.testArray[0],DatesConstants.fourthTest.testArray[1]);
        }
}
