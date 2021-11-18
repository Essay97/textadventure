package entities.people;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import entities.Examinable;
import utils.MatchableUtil;

public abstract class Character implements Examinable, Serializable {
    private static final long serialVersionUID = -3930360722628795298L;

    private String name;
    private String description;
    private Set<String> matchers = new HashSet<>();

    protected Character(String name, String description) {
        this.name = name;
        this.description = description;
        matchers.add(name);
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

    public String getName() {
        return this.name;
    }

    public Set<String> getMatchers() {
        return matchers;
    }

}
