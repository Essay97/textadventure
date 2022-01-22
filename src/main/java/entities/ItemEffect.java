package entities;

import entities.people.Fighter;

public class ItemEffect {
    private int HPModifier;
    private int attackModifier;
    private int burnModifier;
    private int poisonModifier;
    private int stunModifier;
    private boolean oneShot;

    public ItemEffect(int HPModifier, int attackModifier, int burnModifier, int poisonModifier, int stunModifier, boolean oneShot) {
        this.HPModifier = HPModifier;
        this.attackModifier = attackModifier;
        this.burnModifier = burnModifier;
        this.poisonModifier = poisonModifier;
        this.stunModifier = stunModifier;
        this.oneShot = oneShot;
    }

    /**
     * This function applies all the modifiers expressed by the ItemEffect.
     * @param fighter the fighter to whom the modifiers must be applied
     * @return true if the ItemEffect must be destroyed after the use, false otherwise
     */
    public void applyModifiers(Fighter fighter) {
        if(oneShot) {
            fighter.setHP(Math.max(fighter.getHP() + HPModifier, 0));
            fighter.setMaxAttack(Math.max(fighter.getHP() + attackModifier, 1));
            fighter.setPoisoned(Math.max(fighter.getPoisoned() + poisonModifier, 0));
            fighter.setStunned(Math.max(fighter.getStunned() + stunModifier, 0));
            fighter.setBurned(Math.max(fighter.getBurned() + burnModifier, 0));
        } else {
            fighter.getEquip().add(this);
        }
    }
}
