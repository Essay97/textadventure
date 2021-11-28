package entities.people;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import entities.Examinable;
import utils.MatchableUtil;

/**
 * This class represents the base character of the game. Every living creature in the game, controlled or NPC, is a
 * Character.
 *
 * @see Player
 * @see NPC
 */
public abstract class Character implements Examinable, Serializable {
    private static final long serialVersionUID = -3930360722628795298L;
    /**
     * The name of the Character
     */
    private String name;
    /**
     * The description that the user receives when trying to get information about this character
     */
    private String description;
    /**
     * Every word in this set can be used in order to target this character as command argument
     */
    private Set<String> matchers = new HashSet<>();

    protected Character(String name, String description) {
        this.name = name;
        this.description = description;
        matchers.add(name);
    }

    protected Character() {
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

    /**
     * @return the name of the character
     */
    public String getName() {
        return this.name;
    }

    /**
     * @return the set of the valid target words for this character
     */
    public Set<String> getMatchers() {
        return matchers;
    }

}
