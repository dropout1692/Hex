package wtf.dpt.hex.testapi;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import wtf.dpt.hex.HexMap;
import wtf.dpt.hex.enums.MapMode;

@SpringBootTest
class TestApiApplicationTests {

    @Test
    void initializeNormalHexMap() {

        int width = 10;
        int height = 8;
        HexMap hexMap = new HexMap(width, height);

        assert hexMap.getHex(0, 0) != null;
        assert hexMap.getHex(width - 1, 0) != null;
        assert hexMap.getHex(0, 1) != null;
        assert hexMap.getHex(width - 1, 1) != null;
        assert hexMap.getHex(0, height - 1) != null;
        assert hexMap.getHex(width - 1, height - 1) != null;

        int idCount = width * height - 1;
        assert hexMap.getHex(width - 1, height - 1).getId() == idCount;
    }

    @Test
    void initializeOuterHexMap() {

        int width = 10;
        int height = 8;
        HexMap hexMap = new HexMap(width, height, MapMode.OUTER);

        assert hexMap.getHex(0, 0) != null;
        assert hexMap.getHex(hexMap.getMaxWidth() - 1, 0) != null;
        assert hexMap.getHex(0, 1) == null;
        assert hexMap.getHex(hexMap.getMaxWidth() - 1, 1) == null;
        assert hexMap.getHex(1, 1) != null;
        assert hexMap.getHex(hexMap.getMaxWidth() - 2, 1) != null;
        assert hexMap.getHex(0, height - 1) != null;
        assert hexMap.getHex(hexMap.getMaxWidth() - 1, height - 1) != null;

        int idCount = (width * height) - 5;
        assert hexMap.getHex(hexMap.getMaxWidth() -1, height - 1).getId() == idCount;
    }

    @Test
    void initializeInnerHexMap() {

        int width = 10;
        int height = 8;
        HexMap hexMap = new HexMap(width, height, MapMode.INNER);

        assert hexMap.getHex(0, 0) == null;
        assert hexMap.getHex(width - 1, 0) == null;
        assert hexMap.getHex(0, 1) != null;
        assert hexMap.getHex(width - 1, 1) != null;
        assert hexMap.getHex(0, height - 1) == null;
        assert hexMap.getHex(width - 1, height - 1) == null;
        assert hexMap.getHex(1, height - 1) != null;
        assert hexMap.getHex(width - 2, height - 1) != null;

        int idCount = (width * height) - 5;
        assert hexMap.getHex(hexMap.getMinWidth() -1, height - 1).getId() == idCount;
    }

}
