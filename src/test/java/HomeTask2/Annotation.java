package HomeTask2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

/**
 * Created by X240 on 9/14/2017.
 */
public class Annotation {

    private static WebDriver driver;
    private long before;
    private long after;

    @BeforeSuite
    public void beforeSuite(){
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
    }

    @BeforeTest
    public void beforeTest(){
        driver = new ChromeDriver();
    }

    @BeforeClass
    public void beforeClass(){
        driver.navigate().to("https://jdi-framework.github.io/tests");
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
    }

    @BeforeMethod
    public void beforeMethod(){
        before = System.currentTimeMillis();
    }

    @Test
    public void test(){
        Assert.assertEquals(driver.getTitle(), "Index Page");
    }

    @AfterMethod
    public void afterMethod(){
        after = System.currentTimeMillis();
        System.out.println(after - before + "ms");
    }

    @AfterTest(alwaysRun = true)
    public void afterTest(){
        driver.close();
    }

    @AfterSuite
    public void afterSuite(){
        if(driver.toString().contains("null")){
            driver.quit();
        }
    }
}
