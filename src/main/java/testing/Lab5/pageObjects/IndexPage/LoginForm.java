package testing.Lab5.pageObjects.IndexPage;

import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.common.TextField;
import com.epam.jdi.uitests.web.selenium.elements.composite.Form;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JFindBy;

public class LoginForm extends Form<UserData> {
    @JFindBy(id = "Login")
    public TextField name;

    @JFindBy(id = "Password")
    public TextField password;

    @JFindBy(xpath = "(//button[@type='submit'])[1]")
    public Button submit;
}