package wtf.dpt.hex;

import lombok.Getter;
import wtf.dpt.hex.enums.MapMode;
import wtf.dpt.hex.helper.Coordinates;

@Getter
public class HexMap {

    private int width;
    private int height;
    private int maxWidth;
    private int minWidth;

    private MapMode mode;

    private Hex[][] hexes;

    public HexMap(int width, int height) {
        new HexMap(width, height, MapMode.LEFT);
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

    private void initializeMap() {

        determineOuterWidth();
        this.hexes = new Hex[maxWidth][height];
        switch (mode) {
            case OUTER:
                initializeHexesOuter();
                break;
            case INNER:
                initializeHexesInner();
                break;
            default:
                initializeHexes();
        }
    }

    private void initializeHexes() {

        int id = 0;

        for (int h = 0; h < height; h++) {
            for (int w = 0; w < width; w++) {
                hexes[w][h] = new Hex(id++, new Coordinates(w, h));
            }
        }
    }

    private void initializeHexesInner() {

        int id = 0;

        for (int h = 0; h < height; h++) {
            for (int w = 0; w < maxWidth; w++) {
                if (h == 0 || h == height - 1) {
                    if (w == 0 || w == maxWidth - 1) {
                        hexes[w][h] = null;
                    } else {
                        hexes[w][h] = new Hex(id++, new Coordinates(w, h));
                    }
                }
            }
        }
    }

    private void initializeHexesOuter() {

        int id = 0;

        for (int h = 0; h < height; h++) {
            for (int w = 0; w < maxWidth; w++) {
                if (h != 0 && h != height - 1) {
                    if (w == 0 || w == maxWidth - 1) {
                        hexes[w][h] = null;
                    } else {
                        hexes[w][h] = new Hex(id++, new Coordinates(w, h));
                    }
                }
            }
        }
    }

    private void determineOuterWidth() {

        switch (mode) {
            case INNER:
                this.minWidth = width - 1;
                this.maxWidth = width;
                break;
            case OUTER:
                this.minWidth = width;
                this.maxWidth = width + 1;
                break;
            default:
                this.minWidth = this.maxWidth = width;
        }
    }
}
