package data;

import java.io.Serializable;

public class DragonHead implements Serializable {
    private long eyesCount;
    private float toothCount;

    public DragonHead(long eyesCount, float toothCount) {
        this.eyesCount = eyesCount;
        this.toothCount = toothCount;
    }

    @Override
    public String toString() {
        return "{eyes = " + eyesCount + ", tooth = " + toothCount + "}";
    }
}