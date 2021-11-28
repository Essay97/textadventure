package entities.people;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import setup.NPCDeserializer;

/**
 * Basic implementation of a NPC. This class just gives minimal functionality such as name and description, but leaves
 * to the concrete implementation the due to implement the actions that a specific NPC can make.
 * <p>When deserialized from JSON/YAML this class resolves to its concrete implementations.</p>
 *
 * @see Fighter
 * @see FighterTalkerNPC
 * @see Talker
 * @see TalkerNPC
 * @see Character
 */
@JsonDeserialize(using = NPCDeserializer.class)
public abstract class NPC extends Character {
    private static final long serialVersionUID = 321937186749263636L;

    protected NPC(String name, String description) {
        super(name, description);
    }

    protected NPC() {}
}
