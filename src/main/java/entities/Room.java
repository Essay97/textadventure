package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import entities.people.NPC;
import utils.MatchableUtil;

/**
 * Represents a room in the world of the game. Each room belongs to a {@link GameMap} and is an abstraction for a generic
 * place in the world: it does not have to be an actual closed place inside a building or something. In the game domain,
 * a room is just a place connected to other places and that can contain items (both grabbable and not, everything the player
 * can interact with is an item) and NPCs.
 *
 * @see GameMap
 * @see NPC
 * @see Item
 * @see Movable
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Room implements Examinable, Serializable {
    private static final long serialVersionUID = -8007406889019398847L;

    /**
     * The name that identifies the room
     */
    private String name;
    /**
     * The description that the user receives when trying to get information about this character
     */
    private String description;
    /**
     * Every word in this set can be used in order to target this character as command argument
     */
    @JsonIgnore
    private final Set<String> matchers = new HashSet<>();
    /**
     * The items that can be examined and grabbed in this room
     */
    private final Set<Item> items = new HashSet<>();

    /**
     * The NPCs that can be found in this room
     */
    private final ArrayList<NPC> npcs = new ArrayList<>();

    // For Jackson
    private Room() {
        matchers.add("this room");
        matchers.add("room");
        matchers.add("this place");
        matchers.add("place");
    }

    public Room(String name, String description) {
        this.name = name;
        this.description = description;
    }

    /**
     * @return the value of {@link #name}
     */
    public String getName() {
        return this.name;
    }

    @Override
    public String examine() {
        return description;
    }

    @Override
    public void setDescription(String descr) {
        this.description = descr;
    }

    @Override
    public boolean matches(String id) {
        return MatchableUtil.matches(this, id);
    }

    @Override
    public String toString() {
        return "Room [name=" + name + ", description=" + description + "]";
    }

    @Override
    public Set<String> getMatchers() {
        return matchers;
    }

    /**
     * @return the value of {@link #items}
     */
    public Set<Item> getItems() {
        return items;
    }

    /**
     * Adds a new item to the {@link #items} set
     * @param item the item to be added
     */
    public void addItem(Item item) {
        items.add(item);
    }

    /**
     * @return the value of {@link #npcs}
     */
    public List<NPC> getNpcs() {
        return npcs;
    }
}
