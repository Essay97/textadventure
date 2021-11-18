package entities;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import utils.Directions;

public class GameMap implements Serializable {
    private static final long serialVersionUID = 7661736730763800493L;

    private Map<Room, Map<Directions, Room>> map = new HashMap<>();
    private Room entry;

    public void addRoom(Room room) {
        if (map.isEmpty()) {
            entry = room;
        }
        map.put(room, new HashMap<>());
    }

    public Room getEntry() {
        return entry;
    }

    public Room getN(Room room) {
        return map.get(room).get(Directions.N);
    }

    public void setN(Room room, Room newRoom) {
        setDirection(room, newRoom, Directions.N);
    }

    public Room getS(Room room) {
        return map.get(room).get(Directions.S);
    }

    public void setS(Room room, Room newRoom) {
        setDirection(room, newRoom, Directions.S);
    }

    public Room getW(Room room) {
        return map.get(room).get(Directions.W);
    }

    public void setW(Room room, Room newRoom) {
        setDirection(room, newRoom, Directions.W);
    }

    public Room getE(Room room) {
        return map.get(room).get(Directions.E);
    }

    public void setE(Room room, Room newRoom) {
        setDirection(room, newRoom, Directions.E);
    }

    private void setDirection(Room r, Room nr, Directions direction) {
        map.get(r).put(direction, nr);
        if (!map.containsKey(nr)) {
            addRoom(nr);
        }
    }

}