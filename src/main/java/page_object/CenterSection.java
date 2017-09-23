package page_object;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.visible;

/**
 * Created by X240 on 9/21/2017.
 */
public class CenterSection {

    @FindBy(css = ".main-title")
    private SelenideElement title;

    @FindBy(css = ".main-txt")
    private SelenideElement txt;

    public void checkCenterText(){
        title.shouldBe(visible);
        txt.shouldBe(visible);
    }

    @FindBy(css = ".icons-benefit")
    private ElementsCollection icons;

    public void checkIcons(){
        for (SelenideElement i: icons) {
            i.shouldBe(visible);
        }
    }

    @FindBy(css = ".benefit-txt")
    private ElementsCollection texts;

    public void checkTextsUnderIcons(){
        for (SelenideElement i: texts) {
            i.shouldBe(visible);
        }
    }

}
