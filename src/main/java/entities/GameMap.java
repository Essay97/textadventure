package entities;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import setup.GameMapDeserializer;
import utils.Directions;

/**
 * This class represents all the rooms available in the game, the NPCs and items they contain and the connections between
 * them. The map can be generated by a {@link setup.GameMapBuilder} that takes in input a {@link setup.MapBuildStrategy}.
 * By means of these instruments you can generate a map in different ways:
 * <ul>
 *     <li>By parsing a JSON file with {@link setup.JsonMapBuildStrategy}</li>
 *     <li>By parsing a YAML file with {@link setup.YamlMapBuildStrategy}</li>
 *     <li>By parsing a text file with {@link setup.FileMapBuildStrategy}</li>
 *     <li>You can get a dummy map for testing with {@link setup.DummyMapBuildStrategy}</li>
 * </ul>
 * <p>A public constructor is also available but you should really avoid using it, instead implement {@link setup.MapBuildStrategy}
 * and make your own strategy, if no other strategy fits your needs.</p>
 *
 * @see setup.GameMapBuilder
 * @see setup.MapBuildStrategy
 * @see setup.JsonMapBuildStrategy
 * @see setup.YamlMapBuildStrategy
 * @see setup.FileMapBuildStrategy
 * @see setup.DummyMapBuildStrategy
 */
@JsonDeserialize(using = GameMapDeserializer.class)
public class GameMap implements Serializable {
    private static final long serialVersionUID = 7661736730763800493L;

    /**
     * The actual map represented as a graph (adjacency list)
     */
    private Map<Room, Map<Directions, Room>> map = new HashMap<>();
    /**
     * The room where the game starts
     */
    private Room entry;

    /**
     * Adds a new room to the map. If the map is empty, the first room inserted is also the entry of the game.
     * @param room the new room to be added
     */
    public void addRoom(Room room) {
        if (map.isEmpty()) {
            entry = room;
        }
        map.put(room, new HashMap<>());
    }

    /**
     * @return the value stored in {@link #entry}
     */
    public Room getEntry() {
        return entry;
    }

    /**
     * Given a room, the method looks up the graph in order to get the room connected to this one in the North
     * @param room the room we want to lookup
     * @return the room at the North, <code>null</code> if there isn't one
     */
    public Room getN(Room room) {
        return map.get(room).get(Directions.N);
    }

    /**
     * For the specified room, a new room is added to the North. Basically changes the value returned by {@link #getN(Room)}
     * for a specific room. This method does not set anything in the opposite direction in order to give more freedom to
     * create "impossible" architectures
     * @param room the room you want to edit
     * @param newRoom the room to be connected
     */
    public void setN(Room room, Room newRoom) {
        setDirection(room, newRoom, Directions.N);
    }

    /**
     * Given a room, the method looks up the graph in order to get the room connected to this one in the South
     * @param room the room we want to lookup
     * @return the room at the South, <code>null</code> if ther isn't one
     */
    public Room getS(Room room) {
        return map.get(room).get(Directions.S);
    }

    /**
     * For the specified room, a new room is added to the South. Basically changes the value returned by {@link #getS(Room)}
     * for a specific room. This method does not set anything in the opposite direction in order to give more freedom to
     * create "impossible" architectures
     * @param room the room you want to edit
     * @param newRoom the room to be connected
     */
    public void setS(Room room, Room newRoom) {
        setDirection(room, newRoom, Directions.S);
    }

    /**
     * Given a room, the method looks up the graph in order to get the room connected to this one in the West
     * @param room the room we want to lookup
     * @return the room at the West, <code>null</code> if there isn't one
     */
    public Room getW(Room room) {
        return map.get(room).get(Directions.W);
    }


    /**
     * For the specified room, a new room is added to the West. Basically changes the value returned by {@link #getW(Room)}
     * for a specific room. This method does not set anything in the opposite direction in order to give more freedom to
     * create "impossible" architectures
     * @param room the room you want to edit
     * @param newRoom the room to be connected
     */
    public void setW(Room room, Room newRoom) {
        setDirection(room, newRoom, Directions.W);
    }

    /**
     * Given a room, the method looks up the graph in order to get the room connected to this one in the East
     * @param room the room we want to lookup
     * @return the room at the East, <code>null</code> if there isn't one
     */
    public Room getE(Room room) {
        return map.get(room).get(Directions.E);
    }


    /**
     * For the specified room, a new room is added to the East. Basically changes the value returned by {@link #getE(Room)}
     * for a specific room. This method does not set anything in the opposite direction in order to give more freedom to
     * create "impossible" architectures
     * @param room the room you want to edit
     * @param newRoom the room to be connected
     */
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