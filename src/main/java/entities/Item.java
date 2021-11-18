package entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import utils.MatchableUtil;

public class Item implements Examinable, Serializable {
    private static final long serialVersionUID = -4921108410630112665L;

    private Set<String> matchers = new HashSet<>();
    private String name;
    private String description;

    public Item() {}

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

}
