package HomeTask3;

import init_classes.SelenideExtension;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page_object.*;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
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
        differentElementsPage.selectCheckboxes(3);

    }
}
