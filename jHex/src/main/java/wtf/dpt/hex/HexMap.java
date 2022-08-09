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
        this(width, height, MapMode.LEFT);
    }

    public HexMap(
            int width,
            int height,
            MapMode mode
    ) {
        this.width = width;
        this.height = height;
        this.mode = mode;

        initializeMap();
    }

    public Hex getHex(int x, int y) {
        return hexes[x][y];
    }

    public void printMap() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < maxWidth; x++) {
                String coordX = hexes[x][y] == null ? "X" : String.valueOf(hexes[x][y].getCoordinates().getX());
                String coordY = hexes[x][y] == null ? "Y" : String.valueOf(hexes[x][y].getCoordinates().getY());
                System.out.printf("[%s,%s]",
                        coordX,
                        coordY
                );
            }
            System.out.print("\n");
        }
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

    //todo: refactor when sober
    private void initializeHexesInner() {

        int id = 0;

        for (int h = 0; h < height; h++) {
            for (int w = 0; w < maxWidth; w++) {
                if ((h == 0 || h == height - 1) && (w != 0 || w != maxWidth - 1)) {
                    if (w == 0 || w == maxWidth - 1) {
                        hexes[w][h] = null;
                    } else {
                        hexes[w][h] = new Hex(id++, new Coordinates(w, h));
                    }
                } else {
                    hexes[w][h] = new Hex(id++, new Coordinates(w, h));
                }
            }
        }
    }

    //todo: refactor when sober
    private void initializeHexesOuter() {

        int id = 0;

        for (int h = 0; h < height; h++) {
            for (int w = 0; w < maxWidth; w++) {
                if ((h == 0 || h == height - 1) && (w == 0 || w == maxWidth - 1)) {
                    if (w == 0 || w == maxWidth - 1) {
                        hexes[w][h] = new Hex(id++, new Coordinates(w, h));
                    } else {
                        hexes[w][h] = null;
                    }
                } else {
                    if (w != 0 && w != maxWidth - 1) {
                        hexes[w][h] = new Hex(id++, new Coordinates(w, h));
                    } else {
                        hexes[w][h] = null;
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
