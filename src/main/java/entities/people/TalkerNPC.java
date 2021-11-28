package entities.people;

import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * The concrete implementation of a NPC that has the only ability to talk. This means that he can be called as an argument
 * for the <code>talk</code> command.
 * <p>By implementing the {@link Talker} interface, it can start a dialogue sequence and process player answers</p>
 * <p>Another similar implementation is the {@link FighterTalkerNPC}, that has also the ability to fight</p>
 *
 * @see Fighter
 * @see FighterTalkerNPC
 * @see Talker
 * @see FighterNPC
 * @see Character
 */
@JsonDeserialize(using = JsonDeserializer.None.class)
public class TalkerNPC extends NPC implements Talker {
    private static final long serialVersionUID = -875679717601197894L;
    /**
     * The whole dialogue sequence that is triggered by the <code>talk</code> command
     */
    private Dialogue dialogue;

    private TalkerNPC() {}

    public TalkerNPC(String name, String description) {
        super(name, description);
    }

    @Override
    public void talk() {
        dialogue.doDialogue(getName());
    }

    @Override
    public void setDialogue(Dialogue dialogue) {
        this.dialogue = dialogue;
    }

}
