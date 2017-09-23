package page_object;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.visible;

/**
 * Created by X240 on 9/22/2017.
 */
public class LeftSection {
    @FindBy(xpath = "//li[contains(@class, 'sub-menu')]/a")
    private SelenideElement dropDownMenu;

    public void click(){
        dropDownMenu.click();
    }

    @FindBy(xpath = "//ul[contains(@class, 'sub')]/li[1]/a")
    private SelenideElement support;

    @FindBy(xpath = "//ul[contains(@class, 'sub')]/li[2]/a")
    private SelenideElement dates;

    @FindBy(xpath = "//ul[contains(@class, 'sub')]/li[3]/a")
    private SelenideElement complexTable;

    @FindBy(xpath = "//ul[contains(@class, 'sub')]/li[4]/a")
    private SelenideElement simpleTable;

    @FindBy(xpath = "//ul[contains(@class, 'sub')]/li[5]/a")
    private SelenideElement tableWithPage;

    @FindBy(xpath = "//ul[contains(@class, 'sub')]/li[6]/a")
    private SelenideElement differentElements;

    public void checkElements(){
        support.should(visible);
        dates.should(visible);
        complexTable.should(visible);
        simpleTable.should(visible);
        tableWithPage.should(visible);
        differentElements.should(visible);
    }


}
