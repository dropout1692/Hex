package wtf.dpt.hex;

import lombok.Getter;
import wtf.dpt.hex.helper.Coordinates;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Getter
public class Hex {

    private final UUID uuid;
    private final long id;
    private final Coordinates coordinates;

    private Map<Integer, Hex> neighbourMap;

    public Hex(long id, Coordinates coordinates){

        this.uuid = UUID.randomUUID();
        this.id = id;
        this.coordinates = coordinates;

//        initEmptyNeighbourMap();
    }

    public List<Hex> getNeighbours(){
        return new ArrayList<>(neighbourMap.values());
    }

    private void initEmptyNeighbourMap(){
        for(int i=0; i<6; i++){
            this.neighbourMap.put(i, null);
        }
    }
}
