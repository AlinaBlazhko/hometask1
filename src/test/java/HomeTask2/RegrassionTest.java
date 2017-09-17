package HomeTask2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by X240 on 9/14/2017.
 */
public class RegrassionTest{
    @Test(groups = "Regression")
    public void test1() {
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://jdi-framework.github.io/tests");
        Assert.assertEquals(driver.getTitle(), "Index Page");
    }

    @Test(groups = "Regression")
    public void test2() {
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://jdi-framework.github.io/tests");
        Assert.assertEquals(driver.getTitle(), "Index Page");
    }

}
