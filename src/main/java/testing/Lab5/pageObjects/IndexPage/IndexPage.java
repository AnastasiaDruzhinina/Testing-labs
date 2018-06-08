package testing.Lab5.pageObjects.IndexPage;

import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.common.Label;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import org.openqa.selenium.support.FindBy;

@JPage(url = "/index.htm", title = "Index Page")
public class IndexPage extends WebPage {
    private LoginForm loginForm;

    @FindBy(css = ".uui-profile-menu")
    private Label profileMenu;

    @FindBy(css = ".uui-navigation a[href='page2.htm']")
    private Button metalsAndColorsPageReference;

    public void login(String name, String password) {
        profileMenu.click();
        loginForm.loginAs(new UserData(name, password));
    }

    public void openMetalsAndColorsPage() {
        metalsAndColorsPageReference.click();
    }
}
