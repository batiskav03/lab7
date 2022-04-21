package data;

import java.io.Serializable;

public class Coordinates implements Serializable {
    private Long x; //Поле не может быть null
    private Float y; //Значение поля должно быть больше -578, Поле не может быть null

    public Coordinates(long x, float y) {
        this.x = x;
        this.y = y;
    }




    @Override
    public String toString() {
        return "{x = " + x + ", y = " + y + "}";
    }
}
