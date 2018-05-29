package testing.Lab2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class TestPage {
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

    public TestPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open(String Url) {
        driver.navigate().to(Url);
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public void login(String login, String password) {
        loginMenu.click();
        loginInput.sendKeys(login);
        passwordInput.sendKeys(password);
        submitButton.click();
    }

    public String getUsername() {
        return userName.getText();
    }

    public String getMainHeader() {
        return mainHeader.getText();
    }

    public String getMainText() {
        return mainText.getText();
    }

    public ArrayList<String> getPictureTexts() {
        ArrayList<String> al = new ArrayList<>();

        for (WebElement pictureText : pictureTexts)
            al.add(pictureText.getText());

        return al;
    }

    public int getPictureNumber() {
        return pictures.size();
    }
}
