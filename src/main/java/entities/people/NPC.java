package entities.people;

public abstract class NPC extends Character {
    private static final long serialVersionUID = 321937186749263636L;

    protected NPC(String name, String description) {
        super(name, description);
    }

}
