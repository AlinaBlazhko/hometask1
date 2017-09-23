package enums;

/**
 * Created by X240 on 9/20/2017.
 */
public enum HomeElements {
    MAIN_TITLE(".main-title"),
    CENTER_TEXT(".text-center"),
    PRACTISE_ICON(".icon-practise"),
    CUSTOM_ICON(".icon-custom"),
    MULTI_ICON(".icon-multi"),
    BASE_ICON(".icon-base");

    public String name;

    HomeElements(String name) {
        this.name = name;
    }

}
