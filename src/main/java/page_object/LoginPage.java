package page_object;

import enums.TestNames;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static enums.TestNames.*;
import static org.testng.Assert.assertEquals;

/**
 * Created by X240 on 9/20/2017.
 */
public class LoginPage {

    @FindBy(xpath = "//div[contains(@class, 'profile-photo')]")
    private WebElement loginForm;

    @FindBy(css = "#Login")
    private WebElement login;

    @FindBy(css = "#Password")
    private WebElement password;

    @FindBy(css = ".fa-sign-in")
    private WebElement submit;

    @FindBy(css = ".profile-photo")
    private WebElement userName;

    public void login(String user, String pass){
        loginForm.click();
        login.sendKeys(user);
        password.sendKeys(pass);
        submit.click();
    }

    public void assertUserName(){
        assertEquals(userName.getText(), PITER_CHAILOVSKII.name);
    }

}
