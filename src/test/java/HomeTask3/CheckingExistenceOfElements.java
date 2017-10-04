package HomeTask3;

import init_classes.SelenideExtension;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import page_object.DifferentElementsPage;
import page_object.Header;
import page_object.LoginPage;
import page_object.section.CenterSection;
import page_object.section.LeftSection;
import ru.yandex.qatools.allure.testng.AllureTestListener;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static enums.CheckBoxElements.WATER;
import static enums.CheckBoxElements.WIND;
import static enums.Colors.YELLOW;
import static enums.RadioElements.SELEN;
import static enums.Status.*;
import static enums.TestNames.*;

/**
 * Created by X240 on 9/19/2017.
 */
@Listeners(AllureTestListener.class)
public class CheckingExistenceOfElements extends SelenideExtension{

    private LoginPage log = page(LoginPage.class);
    private CenterSection center = page(CenterSection.class);
    private Header header = page(Header.class);
    private LeftSection leftSection = page(LeftSection.class);
    private DifferentElementsPage differentElementsPage = page(DifferentElementsPage.class);




    @Test(groups = "Smoke")

    public void existenceElement() {
        open(TEST_URL.name);

        //Perform login
        log.login(LOGIN.name, PASSWORD.name);

        //Assert username
        log.assertUserName();

        //Check existence of elements in center section
        center.checkIcons();
        center.checkTextsUnderIcons();
        center.checkCenterText();

        //Check existence of elements in header section
        header.click();
        header.checkElements();

        //Check existence of elements in left section
        leftSection.click();
        leftSection.checkElements();

        //Check existence of elements in dropdown menu
        header.click();
        header.clickOnDifferentElement();
        differentElementsPage.checkElements();

        //Select checkboxes
        differentElementsPage.selectAndCheckCheckboxes(WATER);
        differentElementsPage.selectAndCheckCheckboxes(WIND);

        //Select radio
        differentElementsPage.selectAndCheckRadio(SELEN);

        //Select color
        differentElementsPage.selectInDropdown(YELLOW);

        //Check in logs section selected values and status
        differentElementsPage.checkLogSection(WATER.element, TRUE.status);
        differentElementsPage.checkLogSection(WIND.element, TRUE.status);

        differentElementsPage.checkLogSection(SELEN.element, METAL.status);
        differentElementsPage.checkLogSection(YELLOW.color, COLORS.status);

        //Unselect and assert checkboxes
        differentElementsPage.unselectCheckbox(WATER);
        differentElementsPage.unselectCheckbox(WIND);

        //Check in logs
        differentElementsPage.checkLogSection(WATER.element, FALSE.status);
        differentElementsPage.checkLogSection(WATER.element, FALSE.status);

    }
}
