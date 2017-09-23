package init_classes;

import com.codeborne.selenide.Configuration;
import enums.TestNames;

/**
 * Created by X240 on 9/20/2017.
 */
public abstract class SelenideExtension {

    public SelenideExtension(){
        Configuration.browser = "CHROME";
        System.setProperty(TestNames.PROPERTY1.name, TestNames.PROPERTY2.name);

    }
}

