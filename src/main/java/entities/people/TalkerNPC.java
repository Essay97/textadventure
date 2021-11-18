package entities.people;

public class TalkerNPC extends NPC implements Talker {
    private static final long serialVersionUID = -875679717601197894L;

    private Dialogue dialogue;

    public TalkerNPC(String name, String description) {
        super(name, description);
    }

    @Override
    public void talk() {
        dialogue.doDialogue();
    }

    @Override
    public void setDialogue(Dialogue dialogue) {
        this.dialogue = dialogue;
    }

}
