package wtf.dpt.hex;

import lombok.Getter;
import wtf.dpt.hex.enums.MapMode;

@Getter
public class HexMap {

    private int width;
    private int height;

    private MapMode mode;

    public HexMap(int width, int height) {
        new HexMap(width, height, MapMode.NORMAL);
    }

    public HexMap(
            int width,
            int height,
            MapMode mode
    ) {
        this.width = width;
        this.height = height;
        this.mode = mode;
    }
}
