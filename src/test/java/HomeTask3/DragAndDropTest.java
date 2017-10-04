package HomeTask3;

import init_classes.SelenideExtension;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import page_object.DataPage;
import page_object.section.LeftSection;
import page_object.LoginPage;
import ru.yandex.qatools.allure.testng.AllureTestListener;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static enums.SliderHandle.LEFT;
import static enums.SliderHandle.RIGHT;
import static enums.TestNames.*;

/**
 * Created by X240 on 9/23/2017.
 */
@Listeners(AllureTestListener.class)
public class DragAndDropTest extends SelenideExtension{

    private LoginPage login = page(LoginPage.class);
    private DataPage slider = page(DataPage.class);
    private LeftSection leftSection = page(LeftSection.class);


    @Test(groups = "Smoke")
    public void dragAndDropTest(){

        //Open test site
        open(TEST_URL.name);

        //Perform login
        login.login("epam", "1234");

        //Assert User name
        login.assertUserName();

        //Open Service -> Dates
        leftSection.click();
        leftSection.clickDate();

        //left - 0, right - 100
        slider.setSliderHandle(LEFT, 0);
        slider.setSliderHandle(RIGHT, 100);

        //left - 0, right - 0
        slider.setSliderHandle(RIGHT, 0);
        slider.setSliderHandle(LEFT, 0);

        //left - 0, right - 0
        slider.setSliderHandle(LEFT, 0);
        slider.setSliderHandle(RIGHT, 0);

        //left - 30, right - 70
        slider.setSliderHandle(RIGHT, 70);
        slider.setSliderHandle(LEFT, 30);

    }
}
