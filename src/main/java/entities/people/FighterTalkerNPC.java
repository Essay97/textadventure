package entities.people;

import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import utils.FighterUtil;

/**
 * The concrete implementation of a NPC that can both fight and talk. This makes such NPC able to be passed as an argument
 * for both <code>fight</code> and <code>talk</code> commands.
 * @see Fighter
 * @see FighterTalkerNPC
 * @see Talker
 * @see TalkerNPC
 * @see Character
 */
@JsonDeserialize(using = JsonDeserializer.None.class)
public class FighterTalkerNPC extends NPC implements Fighter, Talker {
    private static final long serialVersionUID = -6215191406416244795L;
    /**
     * The whole dialogue sequence that is triggered by the <code>talk</code> command
     */
    private Dialogue dialogue;
    /**
     * The amount of damage that must be taken by the NPC in order to die
     */
    private int hp;
    /**
     * The max damage that can be delivered with a single attack
     */
    private int maxAttack;
    /**
     * When true, the character cannot suffer damage
     */
    private boolean isDefending;
    /**
     * The number of turns the player is burned
     */
    private int burned;
    /**
     * The number of turns the player is stunned
     */
    private int stunned;
    /**
     * The number of turns the player is poisoned
     */
    private int poisoned;

    private FighterTalkerNPC() {}

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
    public int getStunned() {
        return stunned;
    }

    @Override
    public int getPoisoned() {
        return poisoned;
    }

    @Override
    public int getBurned() {
        return burned;
    }

    @Override
    public void setStunned(int stun) {
        this.stunned = stun;
    }

    @Override
    public void setPoisoned(int poison) {
        this.poisoned = poison;
    }

    @Override
    public void setBurned(int burn) {
        this.burned = burn;
    }

    @Override
    public int getMaxAttack() {
        return maxAttack;
    }

    @Override
    public void setMaxAttack(int newMax) {
        maxAttack = newMax;
    }

}
