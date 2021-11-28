package entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import setup.ItemDeserializer;
import utils.MatchableUtil;

/**
 * This class represents a generic item. Anything that the player can interact with is an <code>Item</code> (except
 * from the characters that are represented by the {@link Character} class. This class implements {@link Examinable},
 * menaing that you can use this class to represent everything that needs to be examined by the player
 */
@JsonDeserialize(using = ItemDeserializer.class)
public class Item implements Examinable, Serializable {
    private static final long serialVersionUID = -4921108410630112665L;

    private Set<String> matchers = new HashSet<>();
    private String name;
    private String description;

    public Item(String name, String description) {
        super();
        this.name = name;
        this.description = description;
        matchers.add(name);
    }

    @Override
    public boolean matches(String id) {
        return MatchableUtil.matches(this, id);
    }

    @Override
    public Set<String> getMatchers() {
        return matchers;
    }

    @Override
    public String examine() {
        return description;
    }

    @Override
    public void setDescription(String descr) {
        description = descr;
    }

    public String getName() {
        return name;
    }

    public void setMatchers(Set<String> matchers) {
        this.matchers = matchers;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }
}
