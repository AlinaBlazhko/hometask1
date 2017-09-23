package enums;

import com.sun.jna.platform.win32.WinUser;

/**
 * Created by X240 on 9/23/2017.
 */
public enum  CheckBoxElements {
    WATER("Water"),
    EARTH("Earth"),
    WIND("Wind"),
    FIRE("Fire");

    public String element;

    CheckBoxElements(String element){
        this.element = element;
    }

}
