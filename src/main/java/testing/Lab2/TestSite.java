package testing.Lab2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class TestSite {
    private final WebDriver driver;

    @FindBy(css = ".dropdown-toggle[href='#']")
    private WebElement loginMenu;

    @FindBy(css = "#Login")
    private WebElement loginInput;

    @FindBy(css = "#Password")
    private WebElement passwordInput;

    @FindBy(css = "button[type='submit']")
    private WebElement submitButton;

    @FindBy(xpath = "//div[@class='profile-photo']//span")
    private WebElement userName;

    @FindBy(css = ".benefit-icon")
    private List<WebElement> pictures;

    @FindBy(css = ".benefit-txt")
    private List<WebElement> pictureTexts;

    @FindBy(css = ".main-title")
    private WebElement mainHeader;

    @FindBy(css = ".main-txt")
    private WebElement mainText;

    public TestSite(WebDriver driver) {
        this.driver = driver;
    }

    void open(String Url) {
        driver.navigate().to(Url);
    }

    String getUrl() {
        return driver.getCurrentUrl();
    }

    String getTitle() {
        return driver.getTitle();
    }

    void login(String login, String password) {
        loginMenu.click();
        loginInput.sendKeys(login);
        passwordInput.sendKeys(password);
        submitButton.click();
    }

    String getUsername() {
        return userName.getText();
    }

    String getMainHeader() {
        return mainHeader.getText();
    }

    String getMainText() {
        return mainText.getText();
    }

    ArrayList<String> getPictureTexts() {
        ArrayList<String> al = new ArrayList<>();

        for (WebElement pictureText : pictureTexts)
            al.add(pictureText.getText());

        return al;
    }

    int getPictureNumber() {
        return pictures.size();
    }
}
