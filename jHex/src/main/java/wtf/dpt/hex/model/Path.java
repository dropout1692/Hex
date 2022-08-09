package wtf.dpt.hex.model;

import lombok.Getter;
import wtf.dpt.hex.Hex;

import java.util.List;

@Getter
public class Path {

    private Hex fromHex;
    private Hex toHex;

    List<Hex> hexes;
}
