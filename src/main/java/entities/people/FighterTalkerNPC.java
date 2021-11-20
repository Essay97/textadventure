package entities.people;

import utils.FighterUtil;

public class FighterTalkerNPC extends NPC implements Fighter, Talker {
    private static final long serialVersionUID = -6215191406416244795L;

    private Dialogue dialogue;
    private int hp;
    private int maxAttack;
    private boolean isDefending;

    protected FighterTalkerNPC(String name, String description, int maxAttack, int hp) {
        super(name, description);
        this.maxAttack = maxAttack;
        this.hp = hp;
    }

    @Override
    public void talk() {
        dialogue.doDialogue(getName());
    }

    @Override
    public void setDialogue(Dialogue dialogue) {
        this.dialogue = dialogue;
    }

    @Override
    public int getHP() {
        return hp;
    }

    @Override
    public int getAttack() {
        return FighterUtil.getAttack(this);
    }

    @Override
    public void setHP(int hp) {
        this.hp = hp;
    }

    @Override
    public boolean isDefending() {
        return isDefending;
    }

    @Override
    public void setDefending(boolean def) {
        isDefending = def;
    }

    @Override
    public int getMaxAttack() {
        return maxAttack;
    }
}
