import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by X240 on 9/12/2017.
 */
public class TestForChrome {
    @Test
    public void test1(){
        System.setProperty("webdriver.gecko.driver","chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://jdi-framework.github.io/tests");
        Assert.assertEquals(driver.getTitle(), "Index Page");

        WebElement dropMenu = driver.findElement(By.xpath("//li[contains(@class, 'dropdown uui-profile-menu')]/a[contains(@class, 'dropdown-toggle')]/span[contains(@class, 'caret')]"));
        dropMenu.click();

        WebElement login = driver.findElement(By.xpath("//input[@id='Login']"));
        login.click();
        login.sendKeys("epam");

        WebElement password = driver.findElement(By.xpath("//input[@id='Password']"));
        password.click();
        password.sendKeys("1234");

        WebElement enter = driver.findElement(By.xpath("//form/button[contains(@class, 'uui-button dark-blue btn-login')]"));
        enter.click();

        WebElement contactForm = driver.findElement(By.xpath("//ul[contains(@class, 'sidebar-menu')]/li[2]/a"));
        contactForm.click();
        Assert.assertEquals(driver.getTitle(), "Contact Form");



        //WebElement firstName = driver.findElement(By.xpath(""))

        driver.close();
    }
}
