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
