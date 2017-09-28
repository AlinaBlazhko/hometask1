package HomeTask3;

import init_classes.SelenideExtension;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page_object.*;
import page_object.section.CenterSection;
import page_object.section.LeftSection;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static enums.CheckBoxElements.WATER;
import static enums.CheckBoxElements.WIND;
import static enums.Colors.*;
import static enums.RadioElements.*;
import static enums.Status.*;
import static enums.TestNames.*;

/**
 * Created by X240 on 9/19/2017.
 */
public class CheckingExistenceOfElements extends SelenideExtension{

    private LoginPage log;
    private CenterSection center;
    private Header header;
    private LeftSection leftSection;
    private DifferentElementsPage differentElementsPage;

    @BeforeClass
    public void beforeClass(){
        log = page(LoginPage.class);
        center = page(CenterSection.class);
        header = page(Header.class);
        leftSection = page(LeftSection.class);
        differentElementsPage = page(DifferentElementsPage.class);
    }


    @Test

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
