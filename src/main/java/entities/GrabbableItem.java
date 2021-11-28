package entities;

/**
 * This class represents an item that can be put into the inventory. It does not have any substantial difference form
 * the {@link Item} class apart from the type itself.
 */
public class GrabbableItem extends Item {
    private static final long serialVersionUID = -5423337564059819378L;

    public GrabbableItem(String name, String description) {
        super(name, description);
    }
}
