package testing.Lab5;

import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.testng.testRunner.TestNGBase;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import testing.Lab5.constants.BaseConstants;
import testing.Lab5.constants.IndexConstants;
import testing.Lab5.dataProvider.DataSet;
import testing.Lab5.dataProvider.Provider;
import testing.Lab5.pageObjects.IndexPage.User;

import static com.epam.jdi.uitests.core.settings.JDISettings.driverFactory;
import static testing.Lab5.Site.indexPage;
import static testing.Lab5.Site.metalsAndColorsPage;

public class TestingLab5 extends TestNGBase {

    @BeforeSuite
    public void beforeSuite() {
        driverFactory.setDriverPath(BaseConstants.DRIVER_PATH.strValue);
        WebSite.init(Site.class);
        driverFactory.getDriver();
        WebSite.open();

        //Логинимся
        indexPage.login(new User(IndexConstants.LOGIN.strValue, IndexConstants.PASSWORD.strValue));
        //Переходим на страницу с металлами
        indexPage.openMetalsAndColorsPage();
        //Отменяем галочку на "Salad"
        metalsAndColorsPage.components.select("Salad");
    }

    @Test(dataProvider = "provider", dataProviderClass = Provider.class)
    public void Task(DataSet testValues) {
        metalsAndColorsPage.setValues(testValues);
        metalsAndColorsPage.checkValues(testValues);
        metalsAndColorsPage.unsetValues(testValues);
    }
}
