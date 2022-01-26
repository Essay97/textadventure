package entities.items;

import entities.people.Fighter;

import java.io.Serializable;

public class ItemEffect implements Serializable {
    private final int HPModifier;
    private final int attackModifier;
    private final int burnModifier;
    private final int poisonModifier;
    private final int stunModifier;

    public ItemEffect(int HPModifier, int attackModifier, int burnModifier, int poisonModifier, int stunModifier) {
        this.HPModifier = HPModifier;
        this.attackModifier = attackModifier;
        this.burnModifier = burnModifier;
        this.poisonModifier = poisonModifier;
        this.stunModifier = stunModifier;
    }

    /**
     * This function applies all the modifiers expressed by the ItemEffect.
     * @param fighter the fighter to whom the modifiers must be applied
     */
    public void applyModifiers(Fighter fighter) {
        modifiers(1, fighter);
    }

    /**
     * This function unapplies all the modifiers expressed by the ItemEffect.
     * @param fighter the fighter to whom the modifiers must be applied
     */
    public void unapplyModifiers(Fighter fighter) {
        modifiers(-1, fighter);
    }

    private void modifiers(int multiplier, Fighter fighter) {
        fighter.setHP(Math.max(fighter.getHP() +  multiplier * HPModifier, 0));
        fighter.setMaxAttack(Math.max(fighter.getMaxAttack() + multiplier * attackModifier, 1));
        fighter.setPoisoned(Math.max(fighter.getPoisoned() + multiplier * poisonModifier, 0));
        fighter.setStunned(Math.max(fighter.getStunned() + multiplier * stunModifier, 0));
        fighter.setBurned(Math.max(fighter.getBurned() + multiplier * burnModifier, 0));
    }
}
