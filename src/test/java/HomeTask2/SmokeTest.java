package HomeTask2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Step;

import static org.testng.internal.PropertyUtils.setProperty;

/**
 * Created by X240 on 9/14/2017.
 */
public class SmokeTest {

    @Test(groups = "Smoke")
    @Step("Open home page")
    public void test1() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.epam.com");
        Assert.assertEquals(driver.getTitle(),
                "EPAM | Software Product Development Services");
        driver.close();
    }

    @Test(groups = "Smoke")
    public void test2() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.epam.com");
        Assert.assertEquals(driver.getTitle(),
                "EPAM | Software Product Development Services");
        driver.close();
    }

}
