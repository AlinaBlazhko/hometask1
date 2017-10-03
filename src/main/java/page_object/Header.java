package page_object;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Condition.visible;

/**
 * Created by X240 on 9/21/2017.
 */
public class Header {

    @FindBy(xpath = "//ul[contains(@class, 'uui-navigation nav navbar-nav m-l8')]/li[3]/a")
    private SelenideElement service;

    @FindBy(xpath = "//ul[contains(@class, 'uui-navigation nav navbar-nav m-l8')]/li[contains(@class, 'dropdown')]/a[contains(@class, 'dropdown-toggle')]")
    private SelenideElement dropDownMenu;

    public void click(){
        dropDownMenu.click();
    }

    @FindBy(xpath = "//ul[contains(@class, 'dropdown-menu')]/li[1]/a")
    private SelenideElement support;

    @FindBy(xpath = "//ul[contains(@class, 'dropdown-menu')]/li[2]/a")
    private SelenideElement dates;

    @FindBy(xpath = "//ul[contains(@class, 'dropdown-menu')]/li[3]/a")
    private SelenideElement complexTable;

    @FindBy(xpath = "//ul[contains(@class, 'dropdown-menu')]/li[4]/a")
    private SelenideElement simpleTable;

    @FindBy(xpath = "//ul[contains(@class, 'dropdown-menu')]/li[5]/a")
    private SelenideElement tableWithPage;

    @FindBy(xpath = "//ul[contains(@class, 'dropdown-menu')]/li[6]/a")
    private SelenideElement differentElements;

    @Step
    public void checkElements(){
        support.should(visible);
        dates.should(visible);
        complexTable.should(visible);
        simpleTable.should(visible);
        tableWithPage.should(visible);
        differentElements.should(visible);
    }

    @Step()
    public void clickOnDifferentElement(){
        differentElements.click();
    }
}
