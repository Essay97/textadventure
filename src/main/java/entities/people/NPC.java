package entities.people;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import setup.NPCDeserializer;

@JsonDeserialize(using = NPCDeserializer.class)
public abstract class NPC extends Character {
    private static final long serialVersionUID = 321937186749263636L;

    protected NPC(String name, String description) {
        super(name, description);
    }

    protected NPC() {}
}
