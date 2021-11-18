package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import entities.people.NPC;
import utils.MatchableUtil;

public class Room implements Examinable, Serializable {
    private static final long serialVersionUID = -8007406889019398847L;

    private String name;
    private String description;
    private Set<String> matchers = new HashSet<>();
    private Set<Item> items = new HashSet<>();
    private List<NPC> npcs = new ArrayList<>();

    public Room() {}

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

    public void setItems(Set<Item> items) {
        this.items = items;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public List<NPC> getNpcs() {
        return npcs;
    }

    public void setNpcs(List<NPC> npcs) {
        this.npcs = npcs;
    }
}
