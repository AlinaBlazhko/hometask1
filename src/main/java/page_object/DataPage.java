package page_object;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import enums.SliderHandle;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.actions;
import static com.codeborne.selenide.Selenide.screenshot;
import static enums.SliderHandle.*;

/**
 * Created by X240 on 9/23/2017.
 */
public class DataPage {

    @FindBy(css = ".uui-slider.blue.range.ui-slider.ui-slider-horizontal.ui-widget.ui-widget-content.ui-corner-all")
    private WebElement sliderTracker;

    @FindBy(css = ".ui-slider-handle")
    private ElementsCollection sliders;

    public Double getStep() {
        return Double.parseDouble(String.valueOf(sliderTracker.getSize().width/100.0));
    }

    public Double getCurrentPosition(SliderHandle handle) {
        Double sliderCenterPx = Double.parseDouble(sliders.get(handle.getHandle()).getCssValue("left").replaceAll("px", "")) + sliders.get(handle.getHandle()).getSize().width/2.0;
        return sliderCenterPx/getStep();
    }


    public void setSliderHandle(SliderHandle handle, Integer position) {
        int extraOffset = 10;
        Double xOffset = (position - getCurrentPosition(handle)) * getStep();
        actions().clickAndHold(sliders.get(handle.getHandle()))
                .moveByOffset((int) Math.round(xOffset) + extraOffset, 0)
                .release()
                .build()
                .perform();
        sliders.get(handle.getHandle()).shouldHave(exactText(position.toString()));
    }
}


