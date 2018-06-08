package testing.Lab5;

import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JSite;
import testing.Lab5.pageObjects.IndexPage.IndexPage;
import testing.Lab5.pageObjects.MetalsAndColorsPage;


@JSite("https://jdi-framework.github.io/tests/")
public class Site extends WebSite {
    public static IndexPage indexPage;
    public static MetalsAndColorsPage metalsAndColorsPage;
}


