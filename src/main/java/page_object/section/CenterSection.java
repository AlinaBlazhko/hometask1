package page_object.section;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Condition.visible;

/**
 * Created by X240 on 9/21/2017.
 */
public class CenterSection {

    @FindBy(css = ".main-title")
    private SelenideElement title;

    @FindBy(css = ".main-txt")
    private SelenideElement txt;

    @Step("Check center text")
    public void checkCenterText(){
        title.shouldBe(visible);
        txt.shouldBe(visible);
    }

    @FindBy(css = ".icons-benefit")
    private ElementsCollection icons;

    @Step("Check icons")
    public void checkIcons(){
        for (SelenideElement i: icons) {
            i.shouldBe(visible);
        }
    }

    @FindBy(css = ".benefit-txt")
    private ElementsCollection texts;

    @Step("Check text below icons")
    public void checkTextsUnderIcons(){
        for (SelenideElement i: texts) {
            i.shouldBe(visible);
        }
    }

}
