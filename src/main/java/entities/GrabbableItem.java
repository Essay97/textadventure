package entities;

import entities.people.Player;

/**
 * This class represents an item that can be put into the inventory. It does not have any substantial difference form
 * the {@link Item} class apart from the type itself.
 */
public class GrabbableItem extends Item {
    private static final long serialVersionUID = -5423337564059819378L;
    private final ItemEffect effect;

    public GrabbableItem(String name, String description, ItemEffect effect) {
        super(name, description);
        this.effect = effect;
    }

    public void useOn(Player p) {
        effect.applyModifiers(p);
    }

    protected ItemEffect getEffect() {
        return effect;
    }
}
