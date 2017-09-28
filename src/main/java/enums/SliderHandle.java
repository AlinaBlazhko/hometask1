package enums;

/**
 * Created by X240 on 9/24/2017.
 */
public enum SliderHandle {
    LEFT(0),
    RIGHT(1);

    private Integer handle;

    SliderHandle(Integer handle){
        this.handle = handle;
    }

    public Integer getHandle(){
        return handle;
    }
}
