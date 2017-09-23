package enums;

/**
 * Created by X240 on 9/19/2017.
 */
public enum TestNames {
    PITER_CHAILOVSKII("PITER CHAILOVSKII"),
    LOGIN("epam"),
    PASSWORD("1234"),
    PROPERTY1("webdriver.chrome.driver"),
    PROPERTY2("chromedriver.exe"),
    TEST_URL("https://jdi-framework.github.io/tests/index.htm");

    public String name;

    TestNames(String name){
        this.name = name;
    }

}
