package enums;

/**
 * Created by X240 on 9/23/2017.
 */
public enum Status {
    TRUE("true"),
    FALSE("false"),
    METAL("metal"),
    COLORS("Colors");

    public String status;

    Status(String status){
        this.status = status;
    }
}
