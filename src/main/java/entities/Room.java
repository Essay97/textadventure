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

@JsonIgnoreProperties(ignoreUnknown = true)
public class Room implements Examinable, Serializable {
    private static final long serialVersionUID = -8007406889019398847L;

    private String name;
    private String description;
    @JsonIgnore
    private Set<String> matchers = new HashSet<>();
    private Set<Item> items = new HashSet<>();

    private ArrayList<NPC> npcs = new ArrayList<>();

    // For Jackson
    private Room() {}

    public Room(String name, String description) {
        this.name = name;
        this.description = description;
        matchers.add("this room");
        matchers.add("room");
        matchers.add("this place");
        matchers.add("place");
        matchers.add(name);
    }

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

    public Set<Item> getItems() {
        return items;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public List<NPC> getNpcs() {
        return npcs;
    }
}
