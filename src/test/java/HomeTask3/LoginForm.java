package HomeTask3;

import init_classes.SelenideExtension;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page_object.Header;
import page_object.LoginPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static enums.TestNames.TEST_URL;

/**
 * Created by X240 on 10/4/2017.
 */
public class LoginForm extends SelenideExtension {

    private LoginPage log;
    private Header header;

    @BeforeClass
    public void beforeClass() {
        log = page(LoginPage.class);
        header = page(Header.class);
    }

    @Test(groups = "Smoke")
    public void loginTest() {

        open(TEST_URL.name);
        header.checkElements();

    }

}
