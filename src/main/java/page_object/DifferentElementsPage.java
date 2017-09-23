package page_object;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.visible;

/**
 * Created by X240 on 9/22/2017.
 */
public class DifferentElementsPage {
    @FindBy(css = "label.label-checkbox")
    private ElementsCollection checkboxes;

    @FindBy(css = "label.label-radio")
    private ElementsCollection radios;

    @FindBy(xpath = "//select")
    private SelenideElement dropdown;

    @FindBy(xpath = "//div[contains(@class, 'main-content-hg')]/button[contains(@class, 'uui-button')]")
    private SelenideElement defaultButton;

    @FindBy(css = "input.uui-button")
    private SelenideElement button;

    @FindBy(css = "#mCSB_1_container")
    private SelenideElement rightSection;

    @FindBy(css = "#mCSB_1_container")
    private SelenideElement leftSection;

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

    public void selectAndCheckCheckboxes(int n){

    }
}
