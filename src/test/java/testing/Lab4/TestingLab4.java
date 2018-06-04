package testing.Lab4;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import testing.Lab3.constants.DatesConstants;
import testing.Lab3.constants.DifferentElementsConstants;
import testing.Lab3.constants.IndexConstants;
import testing.Lab3.pageObjects.DatesPage;
import testing.Lab3.pageObjects.DifferentElementsPage;
import testing.Lab3.pageObjects.IndexPage;

@Listeners(AllureListener.class)
public class TestingLab4 {
    private static IndexPage indexPage;
    private static DifferentElementsPage differentElementsPage;
    private static DatesPage datesPage;

    @BeforeClass(description = "Set browser and initialize pages")
    public void beforeSuite() {
        Configuration.browser = "chrome";
        indexPage = new IndexPage();
        differentElementsPage = new DifferentElementsPage();
        datesPage = new DatesPage();
    }

    @Test(description = "Test home page and elements")
    public void Task1() {
        indexPage.open(IndexConstants.URL.strValue);

        indexPage.checkTitle(IndexConstants.TITLE.strValue);

        indexPage.checkLogin(
                IndexConstants.LOGIN.strValue,
                IndexConstants.PASSWORD.strValue,
                IndexConstants.USERNAME.strValue);

        indexPage.checkPictures(IndexConstants.PICTURE_NUMBER.intValue);

        indexPage.checkPictureTexts(IndexConstants.PICTURE_TEXTS.strArrayValue);

        indexPage.checkMainHeader(IndexConstants.MAIN_HEADER.strValue);

        indexPage.checkMainText(IndexConstants.MAIN_TEXT.strValue);

        indexPage.checkHeadDropdown(IndexConstants.DROPDOWN_TEXTS.strArrayValue);
        indexPage.checkLeftDropdown(IndexConstants.DROPDOWN_TEXTS.strArrayValue);

        indexPage.relocateToDifferentElements();

        differentElementsPage.checkElements(DifferentElementsConstants.CHECKBOX_NUMBER.intValue,
                DifferentElementsConstants.CHECKBOX_NUMBER.intValue);

        differentElementsPage.selectCheckbox(DifferentElementsConstants.CHECKBOX_1_NAME.strValue);
        differentElementsPage.selectCheckbox(DifferentElementsConstants.CHECKBOX_3_NAME.strValue);

        differentElementsPage.selectRadio(DifferentElementsConstants.RADIO_4_VALUE.strValue);

        differentElementsPage.selectDropdown(DifferentElementsConstants.DROPDOWN_4_VALUE.strValue);

        differentElementsPage.checkCheckboxInLog(DifferentElementsConstants.CHECKBOX_1_NAME.strValue, "true");
        differentElementsPage.checkCheckboxInLog(DifferentElementsConstants.CHECKBOX_3_NAME.strValue, "true");
        differentElementsPage.checkRadioInLog(DifferentElementsConstants.RADIO_4_VALUE.strValue);
        differentElementsPage.checkDropdownInLog(DifferentElementsConstants.DROPDOWN_4_VALUE.strValue);

        differentElementsPage.unselectCheckbox(DifferentElementsConstants.CHECKBOX_1_NAME.strValue);
        differentElementsPage.unselectCheckbox(DifferentElementsConstants.CHECKBOX_3_NAME.strValue);

        differentElementsPage.checkCheckboxInLog(DifferentElementsConstants.CHECKBOX_1_NAME.strValue, "false");
        differentElementsPage.checkCheckboxInLog(DifferentElementsConstants.CHECKBOX_3_NAME.strValue, "false");
    }

    @Test(description = "Test sliders")
    public void Task2() {
        indexPage.open(IndexConstants.URL.strValue);

        indexPage.checkTitle(IndexConstants.TITLE.strValue);

        indexPage.relocateToDates();

        datesPage.dragAndDropSliders(DatesConstants.FIRST_TEST.values[0], DatesConstants.FIRST_TEST.values[1]);
        datesPage.dragAndDropSliders(DatesConstants.SECOND_TEST.values[0], DatesConstants.SECOND_TEST.values[1]);
        datesPage.dragAndDropSliders(DatesConstants.THIRD_TEST.values[0], DatesConstants.THIRD_TEST.values[1]);
        datesPage.dragAndDropSliders(DatesConstants.FOURTH_TEST.values[0], DatesConstants.FOURTH_TEST.values[1]);
    }
}
