package entities.people;

import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = JsonDeserializer.None.class)
public class TalkerNPC extends NPC implements Talker {
    private static final long serialVersionUID = -875679717601197894L;

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
