package testing.Lab4.pageObjects;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.text;

public class DatesPage {
    @FindBy(xpath = "(//div[@jdi-type='IRange']/a[@href='#'])[1]")
    private SelenideElement leftSlider;

    @FindBy(xpath = "(//div[@jdi-type='IRange']/a[@href='#'])[2]")
    private SelenideElement rightSlider;

    public DatesPage() {
        Selenide.page(this);
    }

    @Step
    private void dragAndDropSlider(SelenideElement slider, int value) {
        Selenide.actions().clickAndHold(slider).build().perform();

        while (value > Integer.parseInt(slider.getText()))
            Selenide.actions().moveByOffset(1, 0).build().perform();

        while (value < Integer.parseInt(slider.getText()))
            Selenide.actions().moveByOffset(-1, 0).build().perform();

        Selenide.actions().release().build().perform();
    }

    @Step
    public void dragAndDropSliders(int leftValue, int rightValue) {
        if (leftValue > Integer.parseInt(rightSlider.getText())) {
            dragAndDropSlider(rightSlider, rightValue);
            dragAndDropSlider(leftSlider, leftValue);
        } else {
            dragAndDropSlider(leftSlider, leftValue);
            dragAndDropSlider(rightSlider, rightValue);
        }

        leftSlider.shouldHave(text(String.valueOf(leftValue)));
        rightSlider.shouldHave(text(String.valueOf(rightValue)));
    }
}
