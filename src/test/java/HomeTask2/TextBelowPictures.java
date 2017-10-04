package HomeTask2;

import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.allure.annotations.Title;

/**
 * Created by X240 on 9/14/2017.
 */

@Title("Cool test")
public class TextBelowPictures {

    @DataProvider(parallel = true)
    public Object[][] correctText() {
        return new Object[][]{
                {"//div[contains(@class, 'col-sm-3')][1]/div[contains(@class, 'benefit')]/span[contains(@class, 'benefit-txt')]", "To include good practices\n" + "and ideas from successful\n" + "EPAM projec"},
                {"//div[contains(@class, 'col-sm-3')][2]/div[contains(@class, 'benefit')]/span[contains(@class, 'benefit-txt')]", "To be flexible and\n" + "customizable"},
                {"//div[contains(@class, 'col-sm-3')][3]/div[contains(@class, 'benefit')]/span[contains(@class, 'benefit-txt')]", "To be multiplatform"},
                {"//div[contains(@class, 'col-sm-3')][4]/div[contains(@class, 'benefit')]/span[contains(@class, 'benefit-txt')]", "Already have good base\n" + "(about 20 internal and\n" + "some external projects),\n" + "wish to get more…"}
        };
    }

    @Step("open Home page")
    @Test(dataProvider = "correctText", groups = "Smoke")
    public void test1(String path, String text) {
        System.setProperty("webdriver.gecko.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://jdi-framework.github.io/tests");
        driver.manage().window().maximize();

        //check text
        WebElement text1 = driver.findElement(By.xpath(path));
        Assert.assertEquals(text1.getText(), text);
        driver.close();
    }



}
