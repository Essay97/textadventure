package entities.people;

import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import entities.ItemEffect;
import utils.FighterUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * The concrete implementation of a NPC that has the only ability to fight. This means that he can be called as an argument
 * for the <code>fight</code> command.
 * <p>By implementing the {@link Fighter} interface, it has everything is needed to take part in a fight: attack, defense,
 * attack sequence and so on.</p>
 * <p>Another similar implementation is the {@link FighterTalkerNPC}, that has also the ability to talk</p>
 *
 * @see Fighter
 * @see FighterTalkerNPC
 * @see Talker
 * @see TalkerNPC
 * @see Character
 */
@JsonDeserialize(using = JsonDeserializer.None.class)
public class FighterNPC extends NPC implements Fighter {
    private static final long serialVersionUID = -1520671022154836530L;
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
    private boolean isDefending = false;
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
    /**
     * The equipment of the fighter
     */
    private List<ItemEffect> equip = new ArrayList<>();

    private FighterNPC() {}

    public FighterNPC(String name, String description, int maxAttack, int hp) {
        super(name, description);
        this.maxAttack = maxAttack;
        this.hp = hp;
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

    @Override
    public List<ItemEffect> getEquip() {
        return equip;
    }
}
