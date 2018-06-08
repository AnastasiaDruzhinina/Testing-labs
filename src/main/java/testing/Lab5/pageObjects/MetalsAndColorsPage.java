package testing.Lab5.pageObjects;

import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.complex.*;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JFindBy;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.objects.JComboBox;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.objects.JDropdown;
import com.epam.web.matcher.testng.Assert;
import org.openqa.selenium.support.FindBy;
import testing.Lab5.dataProvider.DataSet;

@JPage(url = "/page2.htm", title = "Metal and Colors")
public class MetalsAndColorsPage extends WebPage {
    @JComboBox(root = @FindBy(css = "#salad-dropdown"),
            expand = @FindBy(css = ".caret"),
            list = @FindBy(css = "li"),
            value = @FindBy(css = "button"))
    public ComboBox components;

    @FindBy(css = ".radio")
    private RadioButtons radios;

    @JFindBy(css = "#elements-checklist .checkbox label")
    private CheckList elements;

    @JDropdown(root = @FindBy(css = ".colors"),
            list = @FindBy(tagName = "li"))
    private Dropdown colors;

    @JComboBox(root = @FindBy(css = ".metals"),
            expand = @FindBy(css = ".caret"),
            list = @FindBy(css = "li"),
            value = @FindBy(css = "input[type='text']"))
    private ComboBox metals;

    @FindBy(css = ".panel-body-list.results li")
    private TextList resultLog;

    @FindBy(css = "#submit-button")
    private Button submit;

    public void setValues(DataSet dataSet) {
        //Установка значений двух цифр
        radios.select(String.valueOf(dataSet.getSummary()[0]));
        radios.select(String.valueOf(dataSet.getSummary()[1]));

        //Выбор стихий
        elements.select(dataSet.getElements());

        //Выбор цвета
        colors.select(dataSet.getColor());

        //Выбор металлов
        metals.select(dataSet.getMetal());

        //Выбор овощей
        for (String component : dataSet.getVegetables()) {
            components.select(component);
        }

        //Подтверждение
        submit.click();
    }

    public void checkValues(DataSet dataSet) {
        //Проверка суммы
        StringBuilder value = new StringBuilder("Summary: " + String.valueOf(dataSet.getSummary()[0] + dataSet.getSummary()[1]));
        Assert.assertContains(resultLog.getValue(), value.toString());

        //Проверка стихий
        value = new StringBuilder("Elements: ");
        for (String element : dataSet.getElements())
            value.append(element).append(", ");
        value = new StringBuilder(value.substring(0, value.length() - 2));
        Assert.assertContains(resultLog.getValue(), value.toString());

        //Проверка цвета
        value = new StringBuilder("Color: " + dataSet.getColor());
        Assert.assertContains(resultLog.getValue(), value.toString());

        //Проверка металла
        value = new StringBuilder("Metal: " + dataSet.getMetal());
        Assert.assertContains(resultLog.getValue(), value.toString());

        //Проверка овощей
        value = new StringBuilder("Vegetables: ");
        for (String component : dataSet.getVegetables())
            value.append(component).append(", ");
        value = new StringBuilder(value.substring(0, value.length() - 2));
        Assert.assertContains(resultLog.getValue(), value.toString());
    }

    //Убрать все галочки
    public void unsetValues(DataSet dataSet) {
        for (String component : dataSet.getVegetables()) {
            components.select(component);
        }
        elements.select(dataSet.getElements());
    }
}
