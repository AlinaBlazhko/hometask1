package page_object;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import enums.CheckBoxElements;
import enums.Colors;
import enums.RadioElements;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$$;

/**
 * Created by X240 on 9/22/2017.
 */
public class DifferentElementsPage {
    @FindBy(css = "label.label-checkbox")
    private ElementsCollection checkboxes;

    @FindBy(css = "label.label-radio")
    private ElementsCollection radios;

    @FindBy(css = "select.uui-form-element option")
    private ElementsCollection dropdownElement;

    @FindBy(css = "div.colors")
    private SelenideElement selectColors;

    @FindBy(css = "select.uui-form-element")
    private SelenideElement dropdown;

    @FindBy(xpath = "//div[contains(@class, 'main-content-hg')]/button[contains(@class, 'uui-button')]")
    private SelenideElement defaultButton;

    @FindBy(css = "input.uui-button")
    private SelenideElement button;

    @FindBy(css = "#mCSB_1_container")
    private SelenideElement rightSection;

    @FindBy(css = "#mCSB_1_container")
    private SelenideElement leftSection;

    @FindBy(css = "ul.panel-body-list.results")
    //@FindBy(xpath = "//div[contains(@class, 'info-panel-body info-panel-body-log')]/div[contains(@class, 'info-panel-section')]")
    private SelenideElement infoPanel;

    @Step("Check that element from Different element page are visible")
    public void checkElements(){

        for (SelenideElement i: checkboxes) {
            i.should(visible);
        }

        for (SelenideElement i: radios) {
            i.should(visible);
        }

        dropdown.should(visible);
        defaultButton.should(visible);
        button.should(visible);
        rightSection.should(visible);
        leftSection.should(visible);
    }

    @Step("Select checkboxes")
    public void selectAndCheckCheckboxes(CheckBoxElements element){
        checkboxes.get(element.ordinal()).click();
        checkboxes.get(element.ordinal()).isSelected();
    }

    @Step("Select radio button")
    public void selectAndCheckRadio(RadioElements element){
        radios.get(element.ordinal()).click();
        radios.get(element.ordinal()).isSelected();
    }

    @Step("Select dropdown element")
    public void selectInDropdown(Colors color){
        selectColors.click();
        dropdownElement.get(color.ordinal()).click();
        dropdownElement.get(color.ordinal()).shouldBe(checked);

    }

    @Step("Unselect checkboxes")
    public void unselectCheckbox(CheckBoxElements elements){
        checkboxes.get(elements.ordinal()).click();
        checkboxes.get(elements.ordinal()).shouldNotBe(checked);
    }

    @Step("Check logs")
    public void checkLogSection(String value, String status){
        infoPanel.should(visible);
        $$(".info-panel-body-log ul li").find(matchesText(value)).should(matchesText(status));
    }



}
