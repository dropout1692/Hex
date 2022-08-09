package wtf.dpt.hex.enums;

import lombok.Getter;

public enum Direction {

    TOP(0),
    TOP_RIGHT(1),
    BOTTOM_RIGHT(2),
    BOTTOM(3),
    BOTTOM_LEFT(4),
    TOP_LEFT(5);

    @Getter
    private final int position;

    Direction(int position){
        this.position = position;
    }
}
