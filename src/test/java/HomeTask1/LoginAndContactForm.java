package HomeTask1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Created by X240 on 9/12/2017.
 */
public class LoginAndContactForm {
    @Test(groups = "Smoke")
    public void test1(){

        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://jdi-framework.github.io/tests");
        Assert.assertEquals(driver.getTitle(), "Index Page");

        //Open drop menu
        WebElement dropMenu = driver.findElement(By.xpath("//li[contains(@class, 'dropdown uui-profile-menu')]/a[contains(@class, 'dropdown-toggle')]/span[contains(@class, 'caret')]"));
        dropMenu.click();

        //Type login
        WebElement login = driver.findElement(By.xpath("//input[@id='Login']"));
        login.click();
        login.sendKeys("epam");

        //Type password
        WebElement password = driver.findElement(By.xpath("//input[@id='Password']"));
        password.click();
        password.sendKeys("1234");

        //Click Enter Button
        WebElement enter = driver.findElement(By.xpath("//form/button[contains(@class, 'uui-button dark-blue btn-login')]"));
        enter.click();

        WebElement name = driver.findElement(By.xpath("//div[contains(@class, 'profile-photo')]/span"));
        assertTrue(name.isDisplayed());
        assertEquals(name.getText(), "PITER CHAILOVSKII");

        //Open Contact Form
        WebElement contactForm = driver.findElement(By.xpath("//ul[contains(@class, 'sidebar-menu')]/li[2]/a"));
        contactForm.click();
        Assert.assertEquals(driver.getTitle(), "Contact Form");

        //Type First name
        WebElement firstName = driver.findElement(By.xpath("//input[@id='Name']"));
        firstName.click();
        firstName.sendKeys("First name");
        //Type Last name
        WebElement lastName = driver.findElement(By.xpath("//input[@id='LastName']"));
        lastName.click();
        lastName.sendKeys("Last name");

        //Click Submit button
        WebElement submitButton = driver.findElement(By.xpath("//div[contains(@class, 'col-sm-6 text-right')]" +
                "/button[contains(@class, 'uui-button dark-blue')]"));
        submitButton.click();

        //Close Browser
        driver.close();
    }
}
